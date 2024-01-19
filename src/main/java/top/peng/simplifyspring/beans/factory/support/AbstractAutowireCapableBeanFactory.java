/*
 * @(#) AbstractAutowireCapableBeanFactory.java
 *
 * Copyright ⓒ 2023 rebound
 */
package top.peng.simplifyspring.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import top.peng.simplifyspring.beans.BeansException;
import top.peng.simplifyspring.beans.PropertyValue;
import top.peng.simplifyspring.beans.PropertyValues;
import top.peng.simplifyspring.beans.factory.*;
import top.peng.simplifyspring.beans.factory.config.AutowireCapableBeanFactory;
import top.peng.simplifyspring.beans.factory.config.BeanDefinition;
import top.peng.simplifyspring.beans.factory.config.BeanPostProcessor;
import top.peng.simplifyspring.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

/**
 * AbstractAutowireCapableBeanFactory
 *
 * @author yunpeng.zhang
 * @version 1.0 2023/12/19
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory implements AutowireCapableBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object creatBean(String beanName, BeanDefinition beanDefinition,Object[] args) throws BeansException {
        Object bean =  null;
        try {
            bean = createBeanInstance(beanDefinition,beanName,args);
            //bean填充属性
            applyPropertyValues(beanName,bean,beanDefinition);
            // 执行 Bean 的初始化方法和 BeanPostProcessor 的前置和后置处理方法
            bean = initializeBean(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        // 注册实现了 DisposableBean 接口的 Bean 对象
        registerDisposableBeanIfNecessary(beanName, bean, beanDefinition);

        //只有单例模式的对象需要存放到内存中; 原型模式不会存放到内存中，每次获取都重新创建对象
        if(beanDefinition.isSingleton()){
            addSingleton(beanName, bean);
        }

        return bean;
    }

    protected void registerDisposableBeanIfNecessary(String beanName, Object bean, BeanDefinition beanDefinition){
        // 非 Singleton 类型的 Bean 不执行销毁方法
        if (!beanDefinition.isSingleton()) {
            return;
        }

        if (bean instanceof DisposableBean || StrUtil.isNotEmpty(beanDefinition.getDestroyMethodName())){
            registerDisposableBean(beanName,new DisposableBeanAdapter(bean,beanName,beanDefinition));
        }
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

    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition){
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()){
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                if (value instanceof BeanReference){
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                //填充属性
                BeanUtil.setFieldValue(bean,name,value);
            }
        } catch (BeansException e) {
            throw new BeansException("Error setting property values：" + beanName);
        }
    }


    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }

    private Object initializeBean(String beanName, Object bean, BeanDefinition beanDefinition){
        // invokeAwareMethods
        if (bean instanceof Aware){
            if (bean instanceof BeanFactoryAware){
                ((BeanFactoryAware) bean).setBeanFactory(this);
            }
            if (bean instanceof BeanClassLoaderAware){
                ((BeanClassLoaderAware) bean).setClassLoader(getBeanClassLoader());
            }
            if (bean instanceof BeanNameAware){
                ((BeanNameAware) bean).setBeanName(beanName);
            }
        }

        // 1. 执行 BeanPostProcessor Before 处理
        Object wrappedBean = applyBeanPostProcessBeforeInitialization(bean, beanName);

        try {
            invokeInitMethods(beanName, wrappedBean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Invocation of init method of bean[" + beanName + "] failed", e);
        }

        // 2. 执行 BeanPostProcessor After 处理
        wrappedBean = applyBeanPostProcessAfterInitialization(bean, beanName);
        return wrappedBean;
    }

    private void invokeInitMethods(String beanName, Object bean, BeanDefinition beanDefinition) throws Exception{
        // 1. 实现接口 InitializingBean
        if (bean instanceof InitializingBean){
            ((InitializingBean) bean).afterPropertiesSet();
        }
        // 2. 配置信息 init-method {判断是为了避免二次执行销毁}
        String initMethodName = beanDefinition.getInitMethodName();
        if (StrUtil.isNotEmpty(initMethodName)){
            Method initMethod = beanDefinition.getBeanClass().getMethod(initMethodName);
            initMethod.invoke(bean);
        }
    }

    @Override
    public Object applyBeanPostProcessBeforeInitialization(Object existingBean, String beanName) throws BeansException {
        return getBeanPostProcessors().stream()
                .map(processor -> processor.postProcessBeforeInitialization(existingBean, beanName))
                .filter(Objects::nonNull)
                .findFirst()
                .orElse(existingBean);
    }

    @Override
    public Object applyBeanPostProcessAfterInitialization(Object existingBean, String beanName) throws BeansException {
        return getBeanPostProcessors().stream()
                .map(processor -> processor.postProcessAfterInitialization(existingBean, beanName))
                .filter(Objects::nonNull)
                .findFirst()
                .orElse(existingBean);
    }
}
