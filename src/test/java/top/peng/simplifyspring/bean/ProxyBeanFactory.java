/*
 * @(#) ProxyBeanFactory.java
 *
 * Copyright ⓒ 2024 rebound
 */
package top.peng.simplifyspring.bean;

import top.peng.simplifyspring.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * ProxyBeanFactory
 *
 * @author yunpeng.zhang
 * @version 1.0 2024/1/19
 */
public class ProxyBeanFactory implements FactoryBean<IUserDao> {

    @Override
    public IUserDao getObject() throws Exception {
        InvocationHandler handler = ((proxy, method, args) -> {
            Map<String, String> hashMap = new HashMap<>();
            hashMap.put("10001", "zzzz");
            hashMap.put("10002", "aaaa");
            hashMap.put("10003", "bbbb");
            return "你被代理了 " + method.getName() + "：" + hashMap.get(args[0].toString());
        });
        return (IUserDao) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),new Class[]{IUserDao.class},handler);
    }

    @Override
    public Class<?> getObjectType() {
        return IUserDao.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
