/*
 * @(#) CglibSubclassingInstantiationStrategy.java
 *
 * Copyright ⓒ 2023 rebound
 */
package top.peng.simplifyspring.beans.factory.support;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import top.peng.simplifyspring.beans.BeansException;
import top.peng.simplifyspring.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * CglibSubclassingInstantiationStrategy 通过cglib实例化bean
 *
 * @author yunpeng.zhang
 * @version 1.0 2023/12/20
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy{

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor<?> constructor, Object[] args) throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if (constructor == null){
            return enhancer.create();
        }
        return enhancer.create(constructor.getParameterTypes(),args);
    }
}
