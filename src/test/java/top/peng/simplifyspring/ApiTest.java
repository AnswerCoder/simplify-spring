package top.peng.simplifyspring;

import org.junit.Test;
import top.peng.simplifyspring.bean.UserDao;
import top.peng.simplifyspring.bean.UserService;
import top.peng.simplifyspring.beans.PropertyValue;
import top.peng.simplifyspring.beans.PropertyValues;
import top.peng.simplifyspring.beans.factory.config.BeanDefinition;
import top.peng.simplifyspring.beans.factory.config.BeanReference;
import top.peng.simplifyspring.beans.factory.support.DefaultListableBeanFactory;
import top.peng.simplifyspring.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * ApiTest
 *
 * @author yunpeng.zhang
 * @version 1.0 2023/12/19
 */
public class ApiTest {

    @Test
    public void testBeanFactory(){
        //初始化Bean Factory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //注册 UserDao
        beanFactory.registerBeanDefinition("userDao",new BeanDefinition(UserDao.class));

        //UserService 设置属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId","10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));

        //UserService 注入Bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class,propertyValues);
        beanFactory.registerBeanDefinition("userService",beanDefinition);

        //UserService获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.getUserInfo();
    }


    @Test
    public void testBeanByXml(){
        //初始化Bean Factory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //读取配置文件&注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        //UserService获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.getUserInfo();
    }
}