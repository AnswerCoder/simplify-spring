/*
 * @(#) UserService.java
 *
 * Copyright ⓒ 2023 rebound
 */
package top.peng.simplifyspring.bean;

/**
 * UserService
 *
 * @author yunpeng.zhang
 * @version 1.0 2023/12/19
 */
public class UserService {

    private String uId;

    private UserDao userDao;

    public void getUserInfo(){
        System.out.println("获取用户信息" + userDao.queryUserName(uId));
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
