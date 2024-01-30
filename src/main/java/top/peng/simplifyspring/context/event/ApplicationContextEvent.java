/*
 * @(#) ApplicationContextEvent.java
 *
 * Copyright ⓒ 2024 rebound
 */
package top.peng.simplifyspring.context.event;

import top.peng.simplifyspring.context.ApplicationContext;
import top.peng.simplifyspring.context.ApplicationEvent;

/**
 * ApplicationContextEvent
 *
 * @author yunpeng.zhang
 * @version 1.0 2024/1/30
 */
public class ApplicationContextEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    /**
     * Get the <code>ApplicationContext</code> that the event was raised for.
     */
    public final ApplicationContext getApplicationContext(){
        return (ApplicationContext) getSource();
    }
}
