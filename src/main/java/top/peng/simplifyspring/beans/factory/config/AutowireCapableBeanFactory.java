/*
 * @(#) AutowireCapableBeanFactory.java
 *
 * Copyright ⓒ 2023 rebound
 */
package top.peng.simplifyspring.beans.factory.config;

import top.peng.simplifyspring.beans.BeansException;
import top.peng.simplifyspring.beans.factory.BeanFactory;

/**
 * AutowireCapableBeanFactory
 * 自动化处理Bean工厂配置的接口
 *
 * @author yunpeng.zhang
 * @version 1.0 2023/12/22
 */
public interface AutowireCapableBeanFactory extends BeanFactory {
    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessBeforeInitialization 方法
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessBeforeInitialization(Object existingBean, String beanName) throws BeansException;

    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessAfterInitialization 方法
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessAfterInitialization(Object existingBean, String beanName) throws BeansException;
}
