/*
 * @(#) ApplicationEventMulticaster.java
 *
 * Copyright ⓒ 2024 rebound
 */
package top.peng.simplifyspring.context.event;

import top.peng.simplifyspring.context.ApplicationEvent;
import top.peng.simplifyspring.context.ApplicationListener;

/**
 * 事件广播器
 *
 * @author yunpeng.zhang
 * @version 1.0 2024/1/30
 */
public interface ApplicationEventMulticaster {
    /**
     * Add a listener to be notified of all events.
     * @param listener the listener to add
     */
    void addApplicationListener(ApplicationListener<?> listener);

    /**
     * Remove a listener from the notification list.
     * @param listener the listener to remove
     */
    void removeApplicationListener(ApplicationListener<?> listener);

    /**
     * Multicast the given application event to appropriate listeners.
     * @param event the event to multicast
     */
    void multicastEvent(ApplicationEvent event);
}
