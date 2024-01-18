/*
 * @(#) BeanClassLoaderAware.java
 *
 * Copyright ⓒ 2024 rebound
 */
package top.peng.simplifyspring.beans.factory;

/**
 * Callback that allows a bean to be aware of the bean{@link ClassLoader class loader}; that is, the class loader used by the present bean factory to load bean classes.
 * 实现此接口，既能感知到所属的 ClassLoader
 *
 * @author yunpeng.zhang
 * @version 1.0 2024/1/18
 */
public interface BeanClassLoaderAware extends Aware{
    void setClassLoader(ClassLoader classLoader);
}
