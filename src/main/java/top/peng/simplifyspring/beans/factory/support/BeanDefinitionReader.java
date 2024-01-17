/*
 * @(#) BeanDefinitionReader.java
 *
 * Copyright ⓒ 2023 rebound
 */
package top.peng.simplifyspring.beans.factory.support;

import top.peng.simplifyspring.beans.BeansException;
import top.peng.simplifyspring.beans.factory.config.BeanDefinition;
import top.peng.simplifyspring.core.io.Resource;
import top.peng.simplifyspring.core.io.ResourceLoader;

/**
 * BeanDefinitionReader 读取bean定义信息(BeanDefinition)的接口
 *
 * @author yunpeng.zhang
 * @version 1.0 2023/12/21
 */
public interface BeanDefinitionReader {
    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

    void loadBeanDefinitions(String... location) throws BeansException;
}
