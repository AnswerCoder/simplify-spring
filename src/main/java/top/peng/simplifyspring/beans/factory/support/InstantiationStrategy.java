/*
 * @(#) InstantiationStrategy.java
 *
 * Copyright ⓒ 2023 rebound
 */
package top.peng.simplifyspring.beans.factory.support;

import top.peng.simplifyspring.beans.BeansException;
import top.peng.simplifyspring.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * InstantiationStrategy Bean的实例化策略
 *
 * @author yunpeng.zhang
 * @version 1.0 2023/12/20
 */
public interface InstantiationStrategy {

    /**
     * 实例化bean
     * @param beanDefinition bean定义
     * @param beanName bean名称
     * @param constructor 参数构造信息
     * @param args 参数
     * @return bean
     * @throws BeansException
     */
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor<?> constructor, Object[] args) throws BeansException;
}
