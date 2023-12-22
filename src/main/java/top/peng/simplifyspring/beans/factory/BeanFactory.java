/*
 * @(#) BeanFactory.java
 *
 * Copyright ⓒ 2023 rebound
 */
package top.peng.simplifyspring.beans.factory;

import top.peng.simplifyspring.beans.BeansException;
import top.peng.simplifyspring.beans.factory.config.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * BeanFactory Bean工厂
 *
 * @author yunpeng.zhang
 * @version 1.0 2023/12/19
 */
public interface BeanFactory {

    /**
     * 获取Bean
     * @param name
     * @return
     * @throws BeansException
     */
    Object getBean(String name) throws BeansException;

    /**
     * 获取Bean
     * @param name
     * @param args
     * @return
     * @throws BeansException
     */
    Object getBean(String name, Object ...args) throws BeansException;

    /**
     * 按照类型获取bean
     * @param name
     * @param requiredType
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}