/*
 * @(#) FactoryBeanRegistrySupport.java
 *
 * Copyright ⓒ 2024 rebound
 */
package top.peng.simplifyspring.beans.factory.support;

import top.peng.simplifyspring.beans.BeansException;
import top.peng.simplifyspring.beans.factory.FactoryBean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * FactoryBeanRegistrySupport FactoryBean 注册服务
 *
 * @author yunpeng.zhang
 * @version 1.0 2024/1/18
 */
public class FactoryBeanRegistrySupport extends DefaultSingletonBeanRegistry{
    /**
     * Cache of singleton objects created by FactoryBeans: FactoryBean name --> object
     */
    private final Map<String, Object> factoryBeanObjectCache = new ConcurrentHashMap<String, Object>();

    protected Object getCachedObjectForFactoryBean(String beanName){
        Object object = this.factoryBeanObjectCache.get(beanName);
        return object != NULL_OBJECT ? object : null;
    }

    protected Object getObjectFromFactoryBean(FactoryBean factory, String beanName){
        if (factory.isSingleton()){
            Object object = this.factoryBeanObjectCache.get(beanName);
            if (object == null){
                object = doGetObjectFromFactoryBean(factory,beanName);
                this.factoryBeanObjectCache.put(beanName,object != null ? object : NULL_OBJECT);
            }
            return object != NULL_OBJECT ? object : null;
        }else {
            return doGetObjectFromFactoryBean(factory, beanName);
        }
    }

    private Object doGetObjectFromFactoryBean(final FactoryBean<Object> factory, final String beanName) {
        try {
            return factory.getObject();
        } catch (Exception e) {
            throw new BeansException("FactoryBean threw exception on object[" + beanName + "] creation", e);
        }
    }
}
