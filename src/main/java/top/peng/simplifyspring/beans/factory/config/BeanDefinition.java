/*
 * @(#) BeanDefinition.java
 *
 * Copyright ⓒ 2023 rebound
 */
package top.peng.simplifyspring.beans.factory.config;

import top.peng.simplifyspring.beans.PropertyValues;

/**
 * BeanDefinition Bean的定义
 *
 * @author yunpeng.zhang
 * @version 1.0 2023/12/19
 */
public class BeanDefinition {
    private Class<?> beanClass;
    private PropertyValues propertyValues;

    public BeanDefinition(Class<?> beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class<?> beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    public Class<?> getBeanClass() {
        return beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setBeanClass(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
