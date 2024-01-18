/*
 * @(#) BeanNameAware.java
 *
 * Copyright ⓒ 2024 rebound
 */
package top.peng.simplifyspring.beans.factory;

/**
 * Interface to be implemented by beans that want to be aware of their bean name in a bean factory.
 * 实现此接口，既能感知到所属的 BeanName
 *
 * @author yunpeng.zhang
 * @version 1.0 2024/1/18
 */
public interface BeanNameAware extends Aware{
    void setBeanName(String name);
}
