/*
 * @(#) UserService.java
 *
 * Copyright ⓒ 2023 rebound
 */
package top.peng.simplifyspring.bean;

import top.peng.simplifyspring.beans.BeansException;
import top.peng.simplifyspring.beans.factory.*;
import top.peng.simplifyspring.context.ApplicationContext;
import top.peng.simplifyspring.context.ApplicationContextAware;

/**
 * UserService
 *
 * @author yunpeng.zhang
 * @version 1.0 2023/12/19
 */
public class UserService
        //implements BeanFactoryAware, BeanClassLoaderAware, BeanNameAware, ApplicationContextAware
{

    /*private BeanFactory beanFactory;
    private ApplicationContext applicationContext;*/

    private String uId;
    private String company;
    private String location;

    private IUserDao userDao;

    /*@Override
    public void setClassLoader(ClassLoader classLoader) {
        System.out.println("ClassLoader: " + classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean Name is：" + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }*/

    public String getUserInfo(){
        return userDao.queryUserName(uId) + ", company: " + company + ", location:" + location;
    }

    /*public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }*/

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public IUserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }
}
