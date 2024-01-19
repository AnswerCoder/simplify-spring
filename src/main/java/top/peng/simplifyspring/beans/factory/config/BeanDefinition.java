/*
 * @(#) BeanDefinition.java
 *
 * Copyright ⓒ 2023 rebound
 */
package top.peng.simplifyspring.beans.factory.config;

import top.peng.simplifyspring.beans.PropertyValues;

import java.lang.ref.PhantomReference;

/**
 * BeanDefinition Bean的定义
 *
 * @author yunpeng.zhang
 * @version 1.0 2023/12/19
 */
public class BeanDefinition {

    static String SCOPE_SINGLETON = ConfigurableBeanFactory.SCOPE_SINGLETON;
    static String SCOPE_PROTOTYPE = ConfigurableBeanFactory.SCOPE_PROTOTYPE;

    private Class<?> beanClass;
    private PropertyValues propertyValues;
    private String initMethodName;
    private String destroyMethodName;

    private String scope = SCOPE_SINGLETON;
    private boolean singleton = true;
    private boolean prototype = false;

    public BeanDefinition(Class<?> beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class<?> beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    /**
     * 在xml注册Bean定义时，通过scope字段来判断是单例还是原型
     * @param scope
     */
    public void setScope(String scope){
        this.scope = scope;
        this.singleton = SCOPE_SINGLETON.equals(scope);
        this.prototype = SCOPE_PROTOTYPE.equals(scope);
    }

    public boolean isSingleton() {
        return singleton;
    }

    public boolean isPrototype() {
        return prototype;
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

    public String getInitMethodName() {
        return initMethodName;
    }

    public void setInitMethodName(String initMethodName) {
        this.initMethodName = initMethodName;
    }

    public String getDestroyMethodName() {
        return destroyMethodName;
    }

    public void setDestroyMethodName(String destroyMethodName) {
        this.destroyMethodName = destroyMethodName;
    }
}
