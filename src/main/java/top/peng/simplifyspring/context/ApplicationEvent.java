/*
 * @(#) ApplicationEvent.java
 *
 * Copyright ⓒ 2024 rebound
 */
package top.peng.simplifyspring.context;

import java.util.EventObject;

/**
 * ApplicationEvent
 *
 * @author yunpeng.zhang
 * @version 1.0 2024/1/30
 */
public abstract class ApplicationEvent extends EventObject {

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}
