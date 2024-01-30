/*
 * @(#) ApplicationListener.java
 *
 * Copyright ⓒ 2024 rebound
 */
package top.peng.simplifyspring.context;

import java.util.EventListener;

/**
 * ApplicationListener
 *
 * @author yunpeng.zhang
 * @version 1.0 2024/1/30
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {
    /**
     * Handle an application event.
     * @param event the event to respond to
     */
    void onApplicationEvent(E event);
}
