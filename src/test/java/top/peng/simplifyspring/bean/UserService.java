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

    private final String name;

    public UserService(String name) {
        this.name = name;
    }

    public void getUserInfo(){
        System.out.println("获取用户信息" + name);
    }
}
