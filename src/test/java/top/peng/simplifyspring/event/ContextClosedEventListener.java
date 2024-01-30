/*
 * @(#) ContextClosedEventListener.java
 *
 * Copyright ⓒ 2024 rebound
 */
package top.peng.simplifyspring.event;

import top.peng.simplifyspring.context.ApplicationListener;
import top.peng.simplifyspring.context.event.ContextClosedEvent;

/**
 * ContextClosedEventListener
 *
 * @author yunpeng.zhang
 * @version 1.0 2024/1/30
 */
public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {
    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("关闭事件：" + this.getClass().getName());
    }
}
