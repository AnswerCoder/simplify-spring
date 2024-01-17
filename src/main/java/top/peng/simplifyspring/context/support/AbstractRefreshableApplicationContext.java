/*
 * @(#) AbstractRefreshableApplicationContext.java
 *
 * Copyright ⓒ 2024 rebound
 */
package top.peng.simplifyspring.context.support;

import top.peng.simplifyspring.beans.BeansException;
import top.peng.simplifyspring.beans.factory.ConfigurableListableBeanFactory;
import top.peng.simplifyspring.beans.factory.support.DefaultListableBeanFactory;

/**
 * AbstractRefreshableApplicationContext
 *
 * @author yunpeng.zhang
 * @version 1.0 2024/1/16
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext{
    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
