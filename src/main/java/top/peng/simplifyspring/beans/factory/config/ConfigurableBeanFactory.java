/*
 * @(#) ConfigurableBeanFactory.java
 *
 * Copyright ⓒ 2023 rebound
 */
package top.peng.simplifyspring.beans.factory.config;

import top.peng.simplifyspring.beans.factory.HierarchicalBeanFactory;

/**
 * ConfigurableBeanFactory
 * 获取 BeanPostProcessor、BeanClassLoader等的一个配置化接口
 *
 * @author yunpeng.zhang
 * @version 1.0 2023/12/22
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
