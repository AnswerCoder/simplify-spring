/*
 * @(#) AbstractBeanFactory.java
 *
 * Copyright ⓒ 2023 rebound
 */
package top.peng.simplifyspring.beans.factory.support;

import top.peng.simplifyspring.beans.BeansException;
import top.peng.simplifyspring.beans.factory.BeanFactory;
import top.peng.simplifyspring.beans.factory.FactoryBean;
import top.peng.simplifyspring.beans.factory.config.BeanDefinition;
import top.peng.simplifyspring.beans.factory.config.BeanPostProcessor;
import top.peng.simplifyspring.beans.factory.config.ConfigurableBeanFactory;
import top.peng.simplifyspring.utils.ClassUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * AbstractBeanFactory
 *
 * @author yunpeng.zhang
 * @version 1.0 2023/12/19
 */
public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport implements ConfigurableBeanFactory {

    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    /**
     * ClassLoader to resolve bean class names with, if necessary
     */
    private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();

    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }

    protected <T> T doGetBean(final String name, final Object[] args) {
        Object sharedInstance = getSingleton(name);
        if (sharedInstance != null) {
            // 如果是 FactoryBean，则需要调用 FactoryBean#getObject
            return (T) getObjectForBeanInstance(sharedInstance, name);
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        Object bean = creatBean(name, beanDefinition, args);
        return (T) getObjectForBeanInstance(bean, name);
    }

    private Object getObjectForBeanInstance(Object beanInstance, String beanName){
        if (!(beanInstance instanceof FactoryBean)){
            return beanInstance;
        }
        Object object = getCachedObjectForFactoryBean(beanName);
        if (object == null){
            FactoryBean<?> factoryBean = (FactoryBean<?>) beanInstance;
            object = getObjectFromFactoryBean(factoryBean, beanName);
        }
        return object;
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object creatBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    public List<BeanPostProcessor> getBeanPostProcessors(){
        return this.beanPostProcessors;
    }

    public ClassLoader getBeanClassLoader(){
        return this.beanClassLoader;
    }
}
