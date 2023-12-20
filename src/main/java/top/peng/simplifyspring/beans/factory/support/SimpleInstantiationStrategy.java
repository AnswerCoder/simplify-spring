/*
 * @(#) SimpleInstantiationStrategy.java
 *
 * Copyright ⓒ 2023 rebound
 */
package top.peng.simplifyspring.beans.factory.support;

import top.peng.simplifyspring.beans.BeansException;
import top.peng.simplifyspring.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * SimpleInstantiationStrategy JDK实例化bean
 *
 * @author yunpeng.zhang
 * @version 1.0 2023/12/20
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy{
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor<?> constructor, Object[] args) throws BeansException {
        Class<?> beanClass = beanDefinition.getBeanClass();
        try {
            if (constructor != null){
                return beanClass.getDeclaredConstructor(constructor.getParameterTypes()).newInstance(args);
            }else {
                return beanClass.getDeclaredConstructor().newInstance();
            }
        }catch (Exception e){
            throw new BeansException("Failed to instantiate [" + beanClass.getName() + "]", e);
        }
    }
}
