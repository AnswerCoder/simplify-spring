/*
 * @(#) XmlBeanDefinitionReader.java
 *
 * Copyright ⓒ 2023 rebound
 */
package top.peng.simplifyspring.beans.factory.xml;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import top.peng.simplifyspring.beans.BeansException;
import top.peng.simplifyspring.beans.PropertyValue;
import top.peng.simplifyspring.beans.factory.config.BeanDefinition;
import top.peng.simplifyspring.beans.factory.config.BeanReference;
import top.peng.simplifyspring.beans.factory.support.AbstractBeanDefinitionReader;
import top.peng.simplifyspring.beans.factory.support.BeanDefinitionRegistry;
import top.peng.simplifyspring.core.io.Resource;
import top.peng.simplifyspring.core.io.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * XmlBeanDefinitionReader 解析xml注册bean
 *
 * @author yunpeng.zhang
 * @version 1.0 2023/12/21
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {
        try {
            try (InputStream inputStream = resource.getInputStream()) {
                doLoadBeanDefinitions(inputStream);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadBeanDefinitions(Resource... resources) throws BeansException {
        Arrays.stream(resources).forEach(this::loadBeanDefinitions);
    }

    @Override
    public void loadBeanDefinitions(String location) throws BeansException {
        ResourceLoader resourceLoader = getResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        loadBeanDefinitions(resource);
    }

    @Override
    public void loadBeanDefinitions(String... location) throws BeansException {
        Arrays.stream(location).forEach(this::loadBeanDefinitions);
    }

    protected void doLoadBeanDefinitions(InputStream inputStream) throws ClassNotFoundException {
        Document document = XmlUtil.readXML(inputStream);
        Element documentElement = document.getDocumentElement();
        NodeList childNodes = documentElement.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++){
            //判断元素 判断对象
            Node node = childNodes.item(i);
            if (!(node instanceof Element) || !"bean".equals(node.getNodeName())){
                continue;
            }
            //解析标签 bean
            Element bean = (Element) childNodes.item(i);
            String id = bean.getAttribute("id");
            String name = bean.getAttribute("name");
            String className = bean.getAttribute("class");

            //获取Class
            Class<?> clazz = Class.forName(className);
            // 优先级 id > name
            String beanName = StrUtil.isNotEmpty(id) ? id : name;
            if (StrUtil.isEmpty(beanName)){
                beanName = StrUtil.lowerFirst(clazz.getSimpleName());
            }

            BeanDefinition beanDefinition = buildBeanDefinition(bean, clazz);
            if (getRegistry().containsBeanDefinition(beanName)){
                throw new BeansException("Duplicate beanName[" + beanName + "] is not allowed");
            }
            // 注册 BeanDefinition
            getRegistry().registerBeanDefinition(beanName,beanDefinition);
        }
    }

    private BeanDefinition buildBeanDefinition(Element bean, Class<?> clazz) {
        //定义bean
        BeanDefinition beanDefinition = new BeanDefinition(clazz);
        // 读取属性并填充
        for (int j = 0; j < bean.getChildNodes().getLength(); j++){
            //解析标签 property
            Node item = bean.getChildNodes().item(j);
            if (!(item instanceof Element) || !"property".equals(item.getNodeName())){
                continue;
            }
            Element property = (Element) bean.getChildNodes().item(j);
            String attrName = property.getAttribute("name");
            String attrValue = property.getAttribute("value");
            String attrRef = property.getAttribute("ref");
            // 获取属性值：引入对象、值对象
            Object value = StrUtil.isNotEmpty(attrRef) ? new BeanReference(attrRef) : attrValue;
            // 添加属性信息
            beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(attrName, value));
        }
        return beanDefinition;
    }
}
