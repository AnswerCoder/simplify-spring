/*
 * @(#) ContextClosedEventListener.java
 *
 * Copyright ⓒ 2024 rebound
 */
package top.peng.simplifyspring.event;

import top.peng.simplifyspring.context.ApplicationListener;
import top.peng.simplifyspring.context.event.ContextClosedEvent;
import top.peng.simplifyspring.context.event.ContextRefreshedEvent;

/**
 * ContextClosedEventListener
 *
 * @author yunpeng.zhang
 * @version 1.0 2024/1/30
 */
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {

    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("刷新事件：" + this.getClass().getName());
    }
}
