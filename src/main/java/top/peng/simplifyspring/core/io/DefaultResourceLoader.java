/*
 * @(#) DefaultResourceLoader.java
 *
 * Copyright ⓒ 2023 rebound
 */
package top.peng.simplifyspring.core.io;

import cn.hutool.core.lang.Assert;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * DefaultResourceLoader 包资源加载器默认实现
 *
 * @author yunpeng.zhang
 * @version 1.0 2023/12/21
 */
public class DefaultResourceLoader implements ResourceLoader{
    @Override
    public Resource getResource(String location) {
        Assert.notNull(location, "Location must not be null");
        if (location.startsWith(CLASSPATH_URL_PREFIX)){
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        }else {
            try {
                URL url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                return new FileSystemResource(location);
            }
        }
    }
}
