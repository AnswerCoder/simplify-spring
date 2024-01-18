/*
 * @(#) BeanFactoryAware.java
 *
 * Copyright ⓒ 2024 rebound
 */
package top.peng.simplifyspring.beans.factory;

import top.peng.simplifyspring.beans.BeansException;

/**
 * Interface to be implemented by beans that wish to be aware of their owning {@link BeanFactory}.
 * 实现此接口，既能感知到所属的 BeanFactory
 *
 * @author yunpeng.zhang
 * @version 1.0 2024/1/18
 */
public interface BeanFactoryAware extends Aware{

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;

}
