/*
 * @(#) FileSystemResource.java
 *
 * Copyright ⓒ 2023 rebound
 */
package top.peng.simplifyspring.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * FileSystemResource 文件系统资源资源加载实现
 *
 * @author yunpeng.zhang
 * @version 1.0 2023/12/21
 */
public class FileSystemResource implements Resource{

    private final File file;

    private final String path;

    public FileSystemResource(File file) {
        this.file = file;
        this.path = file.getPath();
    }

    public FileSystemResource(String path) {
        this.file = new File(path);
        this.path = path;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(this.file);
    }

    public final String getPath() {
        return path;
    }
}
