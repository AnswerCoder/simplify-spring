/*
 * @(#) MyBeanFactoryPostProcessor.java
 *
 * Copyright ⓒ 2024 rebound
 */
package top.peng.simplifyspring.common;

import top.peng.simplifyspring.beans.BeansException;
import top.peng.simplifyspring.beans.PropertyValue;
import top.peng.simplifyspring.beans.PropertyValues;
import top.peng.simplifyspring.beans.factory.ConfigurableListableBeanFactory;
import top.peng.simplifyspring.beans.factory.config.BeanDefinition;
import top.peng.simplifyspring.beans.factory.config.BeanFactoryPostProcessor;
import top.peng.simplifyspring.beans.factory.config.BeanPostProcessor;

/**
 * MyBeanFactoryPostProcessor
 *
 * @author yunpeng.zhang
 * @version 1.0 2024/1/17
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("company","mod: byte"));
    }
}
