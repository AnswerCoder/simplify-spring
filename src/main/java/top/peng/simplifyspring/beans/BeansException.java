/*
 * @(#) BeansException.java
 *
 * Copyright ⓒ 2023 rebound
 */
package top.peng.simplifyspring.beans;

/**
 * BeansException
 *
 * @author yunpeng.zhang
 * @version 1.0 2023/12/19
 */
public class BeansException extends RuntimeException{

    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
