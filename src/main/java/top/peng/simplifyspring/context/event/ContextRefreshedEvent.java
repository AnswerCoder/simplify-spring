/*
 * @(#) ContextRefreshedEvent.java
 *
 * Copyright ⓒ 2024 rebound
 */
package top.peng.simplifyspring.context.event;

/**
 * ContextRefreshedEvent
 *
 * @author yunpeng.zhang
 * @version 1.0 2024/1/30
 */
public class ContextRefreshedEvent extends ApplicationContextEvent{
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ContextRefreshedEvent(Object source) {
        super(source);
    }
}
