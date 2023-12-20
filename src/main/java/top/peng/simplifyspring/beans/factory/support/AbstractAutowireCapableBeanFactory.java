/*
 * @(#) AbstractAutowireCapableBeanFactory.java
 *
 * Copyright ⓒ 2023 rebound
 */
package top.peng.simplifyspring.beans.factory.support;

import top.peng.simplifyspring.beans.BeansException;
import top.peng.simplifyspring.beans.factory.config.BeanDefinition;

import java.lang.reflect.InvocationTargetException;

/**
 * AbstractAutowireCapableBeanFactory
 *
 * @author yunpeng.zhang
 * @version 1.0 2023/12/19
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{
    @Override
    protected Object creatBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Class beanClass = beanDefinition.getBeanClass();
        Object bean =  null;
        try {
            bean = beanClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        addSingleton(beanName, bean);
        return bean;
    }
}
