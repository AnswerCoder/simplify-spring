/*
 * @(#) ResourceLoaderTest.java
 *
 * Copyright ⓒ 2023 rebound
 */
package top.peng.simplifyspring;

import cn.hutool.core.io.IoUtil;
import org.junit.Before;
import org.junit.Test;
import top.peng.simplifyspring.core.io.DefaultResourceLoader;
import top.peng.simplifyspring.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

/**
 * ResourceLoaderTest
 *
 * @author yunpeng.zhang
 * @version 1.0 2023/12/21
 */
public class ResourceLoaderTest {

    private DefaultResourceLoader resourceLoader;

    @Before
    public void init(){
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void testClassPath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void testFileSystem() throws IOException {
        Resource resource = resourceLoader.getResource("src/test/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }
}
