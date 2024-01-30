/*
 * @(#) ApplicationContext.java
 *
 * Copyright ⓒ 2024 rebound
 */
package top.peng.simplifyspring.context;

import top.peng.simplifyspring.beans.factory.HierarchicalBeanFactory;
import top.peng.simplifyspring.beans.factory.ListableBeanFactory;
import top.peng.simplifyspring.core.io.ResourceLoader;

/**
 * ApplicationContext 应用上下文
 *
 * @author yunpeng.zhang
 * @version 1.0 2024/1/16
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {

}
