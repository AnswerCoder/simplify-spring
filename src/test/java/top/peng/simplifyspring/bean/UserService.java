/*
 * @(#) UserService.java
 *
 * Copyright ⓒ 2023 rebound
 */
package top.peng.simplifyspring.bean;

import top.peng.simplifyspring.beans.factory.DisposableBean;
import top.peng.simplifyspring.beans.factory.InitializingBean;

/**
 * UserService
 *
 * @author yunpeng.zhang
 * @version 1.0 2023/12/19
 */
public class UserService implements InitializingBean, DisposableBean {


    private String uId;
    private String company;
    private String location;

    private UserDao userDao;

    @Override
    public void destroy() throws Exception {
        System.out.println("执行：UserService.destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("执行：UserService.afterPropertiesSet");
    }

    public String getUserInfo(){
        return userDao.queryUserName(uId) + ", company: " + company + ", location:" + location;
    }

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

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
