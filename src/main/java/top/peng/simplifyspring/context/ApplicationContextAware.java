/*
 * @(#) ApplicationContextAware.java
 *
 * Copyright ⓒ 2024 rebound
 */
package top.peng.simplifyspring.context;

import top.peng.simplifyspring.beans.BeansException;
import top.peng.simplifyspring.beans.factory.Aware;

/**
 * Interface to be implemented by any object that wishes to be notifiedof the {@link ApplicationContext} that it runs in.
 * 实现此接口，既能感知到所属的 ApplicationContext
 *
 * @author yunpeng.zhang
 * @version 1.0 2024/1/18
 */
public interface ApplicationContextAware extends Aware {
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
