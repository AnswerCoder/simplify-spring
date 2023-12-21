/*
 * @(#) ResourceLoader.java
 *
 * Copyright ⓒ 2023 rebound
 */
package top.peng.simplifyspring.core.io;

/**
 * ResourceLoader 包资源加载器
 *
 * @author yunpeng.zhang
 * @version 1.0 2023/12/21
 */
public interface ResourceLoader {
    /**
     * Pseudo URL prefix for loading from the class path: "classpath:"
     */
    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
