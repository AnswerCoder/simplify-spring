/*
 * @(#) BeanDefinitionRegistry.java
 *
 * Copyright ⓒ 2023 rebound
 */
package top.peng.simplifyspring.beans.factory.support;

import top.peng.simplifyspring.beans.factory.config.BeanDefinition;

/**
 * BeanDefinitionRegistry 注册表接口
 *
 * @author yunpeng.zhang
 * @version 1.0 2023/12/19
 */
public interface BeanDefinitionRegistry {
    /**
     * 向注册表中注BeanDefinition
     *
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    boolean containsBeanDefinition(String beanName);
}
