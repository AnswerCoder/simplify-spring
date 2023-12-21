/*
 * @(#) Resource.java
 *
 * Copyright ⓒ 2023 rebound
 */
package top.peng.simplifyspring.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Resource 资源加载接口定义
 *
 * @author yunpeng.zhang
 * @version 1.0 2023/12/21
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
