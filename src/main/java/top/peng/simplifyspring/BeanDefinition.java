/*
 * @(#) BeanDefinition.java
 *
 * Copyright ⓒ 2023 rebound
 */
package top.peng.simplifyspring;

/**
 * BeanDefinition Bean的定义
 *
 * @author yunpeng.zhang
 * @version 1.0 2023/12/19
 */
public class BeanDefinition {
    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
