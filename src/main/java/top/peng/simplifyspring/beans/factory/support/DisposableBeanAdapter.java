/*
 * @(#) DisposableBeanAdapter.java
 *
 * Copyright ⓒ 2024 rebound
 */
package top.peng.simplifyspring.beans.factory.support;

import cn.hutool.core.util.StrUtil;
import top.peng.simplifyspring.beans.factory.DisposableBean;
import top.peng.simplifyspring.beans.factory.config.BeanDefinition;

import java.lang.reflect.Method;

/**
 * DisposableBeanAdapter 销毁方法适配器
 *
 * @author yunpeng.zhang
 * @version 1.0 2024/1/18
 */
public class DisposableBeanAdapter implements DisposableBean {
    private Object bean;
    private String beanName;
    private String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    /**
     * 销毁
     *
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        // 1. 实现接口 DisposableBean
        if(bean instanceof DisposableBean){
            ((DisposableBean) bean).destroy();
        }

        // 2. 配置信息 destroy-method {判断是为了避免二次执行销毁}
        if (StrUtil.isNotEmpty(destroyMethodName) && !(bean instanceof DisposableBean && "destroy".equals(this.destroyMethodName))){
            Method destroyMethod = bean.getClass().getMethod(destroyMethodName);
            destroyMethod.invoke(bean);
        }
    }
}
