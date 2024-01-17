/*
 * @(#) BeanFactoryPostProcessor.java
 *
 * Copyright ⓒ 2024 rebound
 */
package top.peng.simplifyspring.beans.factory.config;

import top.peng.simplifyspring.beans.BeansException;
import top.peng.simplifyspring.beans.factory.ConfigurableListableBeanFactory;

/**
 * BeanFactoryPostProcessor
 * 允许自定义修改 BeanDefinition 属性信息
 *
 * @author yunpeng.zhang
 * @version 1.0 2024/1/16
 */
public interface BeanFactoryPostProcessor {
    /**
     * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
