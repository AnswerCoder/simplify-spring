/*
 * @(#) BeanFactory.java
 *
 * Copyright ⓒ 2023 rebound
 */
package top.peng.simplifyspring;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * BeanFactory Bean工厂
 *
 * @author yunpeng.zhang
 * @version 1.0 2023/12/19
 */
public class BeanFactory {
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    /**
     * 获取Bean
     * @param name
     * @return
     */
    public Object getBean(String name){
        return beanDefinitionMap.get(name).getBean();
    }

    /**
     * 注册Bean
     * @param name
     * @param beanDefinition
     */
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition){
        beanDefinitionMap.put(name, beanDefinition);
    }
}