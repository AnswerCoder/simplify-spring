/*
 * @(#) DisposableBean.java
 *
 * Copyright ⓒ 2024 rebound
 */
package top.peng.simplifyspring.beans.factory;

/**
 * DisposableBean 销毁Bean
 *
 * @author yunpeng.zhang
 * @version 1.0 2024/1/17
 */
public interface DisposableBean {
    /**
     * 销毁
     *
     * @throws Exception
     */
    void destroy() throws Exception;
}
