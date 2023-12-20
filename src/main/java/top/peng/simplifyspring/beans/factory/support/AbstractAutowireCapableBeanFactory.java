/*
 * @(#) AbstractAutowireCapableBeanFactory.java
 *
 * Copyright ⓒ 2023 rebound
 */
package top.peng.simplifyspring.beans.factory.support;

import top.peng.simplifyspring.beans.BeansException;
import top.peng.simplifyspring.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.util.Arrays;

/**
 * AbstractAutowireCapableBeanFactory
 *
 * @author yunpeng.zhang
 * @version 1.0 2023/12/19
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object creatBean(String beanName, BeanDefinition beanDefinition,Object[] args) throws BeansException {
        Object bean =  null;
        try {
            bean = createBeanInstance(beanDefinition,beanName,args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        addSingleton(beanName, bean);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?> constructorToUse = Arrays.stream(beanClass.getDeclaredConstructors())
                .filter(ctor -> args != null && ctor.getParameterTypes().length == args.length)
                .filter(ctor -> {
                    //参数args和构造函数参数的类型要匹配
                    for (int i = 0; i < args.length; i++) {
                        if (args[i] != null && !ctor.getParameterTypes()[i].isAssignableFrom(args[i].getClass())) {
                            return false;
                        }
                    }
                    return true;
                })
                .findFirst()
                .orElse(null);
        return getInstantiationStrategy().instantiate(beanDefinition,beanName,constructorToUse,args);
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
