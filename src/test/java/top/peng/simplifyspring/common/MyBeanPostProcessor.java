/*
 * @(#) MyBeanPostProcessor.java
 *
 * Copyright ⓒ 2024 rebound
 */
package top.peng.simplifyspring.common;

import top.peng.simplifyspring.bean.UserService;
import top.peng.simplifyspring.beans.BeansException;
import top.peng.simplifyspring.beans.factory.config.BeanPostProcessor;

/**
 * MyBeanPostProcessor
 *
 * @author yunpeng.zhang
 * @version 1.0 2024/1/17
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)){
            UserService userService = (UserService) bean;
            userService.setLocation("mod: beijing");
        }
        return bean;
    }


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
