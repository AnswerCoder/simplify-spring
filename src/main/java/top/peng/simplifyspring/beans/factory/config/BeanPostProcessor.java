/*
 * @(#) BeanPostProcessor.java
 *
 * Copyright ⓒ 2024 rebound
 */
package top.peng.simplifyspring.beans.factory.config;

import top.peng.simplifyspring.beans.BeansException;

/**
 * BeanPostProcessor
 * 用于修改新实例化的Bean对象
 *
 * @author yunpeng.zhang
 * @version 1.0 2024/1/16
 */
public interface BeanPostProcessor {
    /**
     * 在Bean对象执行初始化方法之前执行
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * 在Bean对象执行初始化方法之后执行
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
