/*
 * @(#) ApplicationEventPublisher.java
 *
 * Copyright ⓒ 2024 rebound
 */
package top.peng.simplifyspring.context;

/**
 * ApplicationEventPublisher 事件发布者
 *
 * @author yunpeng.zhang
 * @version 1.0 2024/1/30
 */
public interface ApplicationEventPublisher {
    /**
     * 发布事件
     * @param event
     */
    void publishEvent(ApplicationEvent event);
}
