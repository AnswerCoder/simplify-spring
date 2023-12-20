/*
 * @(#) AbstractBeanFactory.java
 *
 * Copyright ⓒ 2023 rebound
 */
package top.peng.simplifyspring.beans.factory.support;

import top.peng.simplifyspring.beans.BeansException;
import top.peng.simplifyspring.beans.factory.BeanFactory;
import top.peng.simplifyspring.beans.factory.config.BeanDefinition;

/**
 * AbstractBeanFactory
 *
 * @author yunpeng.zhang
 * @version 1.0 2023/12/19
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeansException {
        Object bean =  getSingleton(name);
        if (bean != null){
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return creatBean(name, beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object creatBean(String beanName, BeanDefinition beanDefinition) throws BeansException;
}
