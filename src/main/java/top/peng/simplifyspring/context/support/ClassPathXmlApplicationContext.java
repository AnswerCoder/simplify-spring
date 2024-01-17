/*
 * @(#) ClassPathXmlApplicationContext.java
 *
 * Copyright ⓒ 2024 rebound
 */
package top.peng.simplifyspring.context.support;

import top.peng.simplifyspring.beans.BeansException;

/**
 * ClassPathXmlApplicationContext
 *
 * @author yunpeng.zhang
 * @version 1.0 2024/1/17
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext{
    private String[] configLocations;

    public ClassPathXmlApplicationContext() {
    }

    /**
     * 从 XML 中加载 BeanDefinition，并刷新上下文
     *
     * @param configLocations
     * @throws BeansException
     */
    public ClassPathXmlApplicationContext(String configLocations) throws BeansException {
        this(new String[]{configLocations});
    }

    /**
     * 从 XML 中加载 BeanDefinition，并刷新上下文
     *
     * @param configLocations
     * @throws BeansException
     */
    public ClassPathXmlApplicationContext(String[] configLocations) throws BeansException {
        this.configLocations = configLocations;
        refresh();
    }

    @Override
    protected String[] getConfigLocations() {
        return configLocations;
    }
}
