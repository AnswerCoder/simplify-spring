/*
 * @(#) ContextClosedEvent.java
 *
 * Copyright ⓒ 2024 rebound
 */
package top.peng.simplifyspring.context.event;

/**
 * ContextClosedEvent
 *
 * @author yunpeng.zhang
 * @version 1.0 2024/1/30
 */
public class ContextClosedEvent extends ApplicationContextEvent{
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ContextClosedEvent(Object source) {
        super(source);
    }
}
