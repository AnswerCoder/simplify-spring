/*
 * @(#) ApplicationContextAwareProcessor.java
 *
 * Copyright ⓒ 2024 rebound
 */
package top.peng.simplifyspring.context.support;

import top.peng.simplifyspring.beans.BeansException;
import top.peng.simplifyspring.beans.factory.config.BeanPostProcessor;
import top.peng.simplifyspring.context.ApplicationContext;
import top.peng.simplifyspring.context.ApplicationContextAware;

/**
 * ApplicationContextAware 处理器
 * 由于 ApplicationContext 的获取并不能直接在创建 Bean 时候就可以拿到，
 * 所以需要在 refresh 操作时，把 ApplicationContext 写入到一个包装的 BeanPostProcessor 中去，
 * 再由 AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsBeforeInitialization 方法调用
 *
 * @author yunpeng.zhang
 * @version 1.0 2024/1/18
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {
    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    /**
     * 在Bean对象执行初始化方法之前执行
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware){
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    /**
     * 在Bean对象执行初始化方法之后执行
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
