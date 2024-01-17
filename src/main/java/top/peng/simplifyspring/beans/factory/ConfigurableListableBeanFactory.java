/*
 * @(#) ConfigurableListableBeanFactory.java
 *
 * Copyright ⓒ 2023 rebound
 */
package top.peng.simplifyspring.beans.factory;

import top.peng.simplifyspring.beans.BeansException;
import top.peng.simplifyspring.beans.factory.config.AutowireCapableBeanFactory;
import top.peng.simplifyspring.beans.factory.config.BeanDefinition;
import top.peng.simplifyspring.beans.factory.config.ConfigurableBeanFactory;

/**
 * ConfigurableListableBeanFactory
 * 提供分析和修改Bean以及预先实例化的操作接口
 *
 * @author yunpeng.zhang
 * @version 1.0 2023/12/22
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, ConfigurableBeanFactory, AutowireCapableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;
}
