/*
 * @(#) SingletonBeanRegistry.java
 *
 * Copyright ⓒ 2023 rebound
 */
package top.peng.simplifyspring.beans.factory.config;

/**
 * SingletonBeanRegistry 单例注册表
 *
 * @author yunpeng.zhang
 * @version 1.0 2023/12/19
 */
public interface SingletonBeanRegistry {

    /**
     * 获取单例bean
     * @param beanName
     * @return
     */
    Object getSingleton(String beanName);

    /**
     * 销毁单例对象
     */
    void destroySingletons();
}
