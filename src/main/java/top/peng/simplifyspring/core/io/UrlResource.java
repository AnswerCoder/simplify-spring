/*
 * @(#) UrlResource.java
 *
 * Copyright ⓒ 2023 rebound
 */
package top.peng.simplifyspring.core.io;

import cn.hutool.core.lang.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * UrlResource 对java.net.URL进行资源定位加载的实现类
 *
 * @author yunpeng.zhang
 * @version 1.0 2023/12/21
 */
public class UrlResource implements Resource{

    private final URL url;

    public UrlResource(URL url) {
        Assert.notNull(url,"URL must not be null");
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection con = this.url.openConnection();
        try {
            return con.getInputStream();
        } catch (IOException e) {
            if (con instanceof HttpURLConnection){
                ((HttpURLConnection) con).disconnect();
            }
            throw e;
        }
    }
}
