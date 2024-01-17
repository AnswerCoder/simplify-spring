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
    private String company;
    private String location;

    private UserDao userDao;

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
