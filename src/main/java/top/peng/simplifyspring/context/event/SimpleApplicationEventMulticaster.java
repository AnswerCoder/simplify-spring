/*
 * @(#) SimpleApplicationEventMulticaster.java
 *
 * Copyright ⓒ 2024 rebound
 */
package top.peng.simplifyspring.context.event;

import top.peng.simplifyspring.beans.factory.BeanFactory;
import top.peng.simplifyspring.context.ApplicationEvent;
import top.peng.simplifyspring.context.ApplicationListener;

/**
 * SimpleApplicationEventMulticaster
 *
 * @author yunpeng.zhang
 * @version 1.0 2024/1/30
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster{

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    /**
     * Multicast the given application event to appropriate listeners.
     *
     * @param event the event to multicast
     */

    @SuppressWarnings("unchecked")
    @Override
    public void multicastEvent(final ApplicationEvent event) {
        for (final ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }
}
