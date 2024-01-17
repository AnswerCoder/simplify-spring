/*
 * @(#) ConfigurableApplicationContext.java
 *
 * Copyright ⓒ 2024 rebound
 */
package top.peng.simplifyspring.context;

import top.peng.simplifyspring.beans.BeansException;

/**
 * SPI interface to be implemented by most if not all application contexts.
 * Provides facilities to configure an application context in addition
 * to the application context client methods in the
 * {@link top.peng.simplifyspring.context.ApplicationContext} interface.
 *
 * @author yunpeng.zhang
 * @version 1.0 2024/1/16
 */
public interface ConfigurableApplicationContext extends ApplicationContext{
    /**
     * 刷新容器
     *
     * @throws BeansException
     */
    void refresh() throws BeansException;
}
