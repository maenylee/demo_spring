package com.demo.bean07.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 获取配置文件资源
 */
public interface Resource {
  InputStream getInputStream() throws IOException;
}
