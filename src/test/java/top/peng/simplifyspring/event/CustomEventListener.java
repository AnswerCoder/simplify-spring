/*
 * @(#) CustomEventListener.java
 *
 * Copyright ⓒ 2024 rebound
 */
package top.peng.simplifyspring.event;

import top.peng.simplifyspring.context.ApplicationListener;

import java.util.Date;

/**
 * CustomEventListener
 *
 * @author yunpeng.zhang
 * @version 1.0 2024/1/30
 */
public class CustomEventListener implements ApplicationListener<CustomEvent> {
    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("收到：" + event.getSource() + "消息;时间：" + new Date());
        System.out.println("消息：" + event.getId() + ":" + event.getMessage());
    }
}
