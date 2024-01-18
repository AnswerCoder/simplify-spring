/*
 * @(#) InitializingBean.java
 *
 * Copyright ⓒ 2024 rebound
 */
package top.peng.simplifyspring.beans.factory;

/**
 * InitializingBean 初始化Bean
 *
 * @author yunpeng.zhang
 * @version 1.0 2024/1/17
 */
public interface InitializingBean {
    /**
     * Bean 属性填充后调用
     *
     * @throws Exception
     */
    void afterPropertiesSet() throws Exception;
}
