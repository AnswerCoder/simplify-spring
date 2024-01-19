/*
 * @(#) FactoryBean.java
 *
 * Copyright ⓒ 2024 rebound
 */
package top.peng.simplifyspring.beans.factory;

/**
 * FactoryBean
 *
 * @author yunpeng.zhang
 * @version 1.0 2024/1/18
 */
public interface FactoryBean<T> {
    /**
     * 获取对象
     * @return
     * @throws Exception
     */
    T getObject() throws Exception;

    /**
     * 获取对象类型
     * @return
     */
    Class<?> getObjectType();

    /**
     * 是否是单例对象
     * @return
     */
    boolean isSingleton();
}
