/*
 * @(#) AbstractApplicationContext.java
 *
 * Copyright ⓒ 2024 rebound
 */
package top.peng.simplifyspring.context.support;

import top.peng.simplifyspring.beans.BeansException;
import top.peng.simplifyspring.beans.factory.ConfigurableListableBeanFactory;
import top.peng.simplifyspring.beans.factory.config.BeanFactoryPostProcessor;
import top.peng.simplifyspring.beans.factory.config.BeanPostProcessor;
import top.peng.simplifyspring.context.ApplicationEvent;
import top.peng.simplifyspring.context.ApplicationListener;
import top.peng.simplifyspring.context.ConfigurableApplicationContext;
import top.peng.simplifyspring.context.event.ApplicationEventMulticaster;
import top.peng.simplifyspring.context.event.ContextClosedEvent;
import top.peng.simplifyspring.context.event.ContextRefreshedEvent;
import top.peng.simplifyspring.context.event.SimpleApplicationEventMulticaster;
import top.peng.simplifyspring.core.io.DefaultResourceLoader;

import java.util.Collection;
import java.util.Map;

/**
 * AbstractApplicationContext 应用上下文抽象类实现
 *
 * @author yunpeng.zhang
 * @version 1.0 2024/1/16
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    public static final String APPLICATION_EVENT_MULTICASTER_BEAN_NAME = "applicationEventMulticaster";

    private ApplicationEventMulticaster applicationEventMulticaster;
    /**
     * 刷新容器
     *
     * @throws BeansException
     */
    @Override
    public void refresh() throws BeansException {
        // 1. 创建 BeanFactory，并加载 BeanDefinition
        refreshBeanFactory();
        // 2. 获取 BeanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        // 3. 添加 ApplicationContextAwareProcessor，让继承自 ApplicationContextAware 的 Bean 对象都能感知所属的 ApplicationContext
        beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this));
        // 4. 在 Bean 实例化之前，执行 BeanFactoryPostProcessor (Invoke factory processors registered as beans in the context.)
        invokeBeanFactoryPostProcessors(beanFactory);
        // 5. BeanPostProcessor 需要提前于其他 Bean 对象实例化之前执行注册操作
        registerBeanPostProcessors(beanFactory);
        // 6. 初始化事件发布者
        initApplicationEventMulticaster();
        // 7. 注册事件监听器
        registerListeners();
        // 8. 提前实例化单例Bean对象
        beanFactory.preInstantiateSingletons();
        // 9. 发布容器刷新完成事件
        finishRefresh();
    }

    protected abstract void refreshBeanFactory() throws BeansException;

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory){
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        beanFactoryPostProcessorMap.values().forEach(beanFactoryPostProcessor -> beanFactoryPostProcessor.postProcessBeanFactory(beanFactory));
    }

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory){
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        beanPostProcessorMap.values().forEach(beanFactory::addBeanPostProcessor);
    }

    private void initApplicationEventMulticaster(){
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        this.applicationEventMulticaster  = new SimpleApplicationEventMulticaster(beanFactory);
        beanFactory.registerSingleton(APPLICATION_EVENT_MULTICASTER_BEAN_NAME, applicationEventMulticaster);
    }

    private void registerListeners() {
        Collection<ApplicationListener> applicationListeners = getBeansOfType(ApplicationListener.class).values();
        for (ApplicationListener listener : applicationListeners) {
            applicationEventMulticaster.addApplicationListener(listener);
        }
    }

    private void finishRefresh() {
        publishEvent(new ContextRefreshedEvent(this));
    }

    @Override
    public void publishEvent(ApplicationEvent event) {
        applicationEventMulticaster.multicastEvent(event);
    }

    /**
     * 获取Bean
     *
     * @param name
     * @return
     * @throws BeansException
     */
    @Override
    public Object getBean(String name) throws BeansException {
        return getBeanFactory().getBean(name);
    }

    /**
     * 获取Bean
     *
     * @param name
     * @param args
     * @return
     * @throws BeansException
     */
    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return getBeanFactory().getBean(name,args);
    }

    /**
     * 按照类型获取bean
     *
     * @param name
     * @param requiredType
     * @return
     * @throws BeansException
     */
    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(name,requiredType);
    }

    /**
     * 按照类型返回 Bean 实例
     *
     * @param type
     * @return
     * @throws BeansException
     */
    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    /**
     * 返回注册表中所有Bean名称
     *
     * @return
     */
    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    /**
     * 注册虚拟机钩子
     */
    @Override
    public void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::close));
    }

    /**
     * 手动执行关闭
     */
    @Override
    public void close() {
        // 发布容器关闭事件
        publishEvent(new ContextClosedEvent(this));
        // 执行销毁单例bean的销毁方法
        getBeanFactory().destroySingletons();
    }
}
