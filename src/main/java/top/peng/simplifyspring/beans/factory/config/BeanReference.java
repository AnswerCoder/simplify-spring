/*
 * @(#) BeanReference.java
 *
 * Copyright ⓒ 2023 rebound
 */
package top.peng.simplifyspring.beans.factory.config;

/**
 * BeanReference 一个bean对另一个bean的引用
 *
 * @author yunpeng.zhang
 * @version 1.0 2023/12/21
 */
public class BeanReference {
    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
