/*
 * @(#) ListableBeanFactory.java
 *
 * Copyright ⓒ 2023 rebound
 */
package top.peng.simplifyspring.beans.factory;

import top.peng.simplifyspring.beans.BeansException;

import java.util.Map;

/**
 * ListableBeanFactory
 * 扩展 Bean 工厂接口的接口，一种扩展工厂的层次子接口
 *
 * @author yunpeng.zhang
 * @version 1.0 2023/12/22
 */
public interface ListableBeanFactory extends BeanFactory{
    /**
     * 按照类型返回 Bean 实例
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * 返回注册表中所有Bean名称
     * @return
     */
    String[] getBeanDefinitionNames();
}
