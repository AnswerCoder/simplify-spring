/*
 * @(#) UserDao.java
 *
 * Copyright ⓒ 2023 rebound
 */
package top.peng.simplifyspring.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * UserDao
 *
 * @author yunpeng.zhang
 * @version 1.0 2023/12/21
 */
public class UserDao {
    private static final Map<String, String> hashMap = new HashMap<>();

    public void initDataMethod(){
        System.out.println("执行：init-method");
        hashMap.put("10001", "zzzz");
        hashMap.put("10002", "aaaa");
        hashMap.put("10003", "bbbb");
    }

    public void destroyDataMethod(){
        System.out.println("执行：destroy-method");
        hashMap.clear();
    }

    public String queryUserName(String uId) {
        return hashMap.getOrDefault(uId,"default");
    }
}
