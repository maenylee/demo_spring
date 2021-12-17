/**
 * FileName: FileSystemResource
 * Author:   Danny
 * Date:     2021/12/15 14:58
 * Description: 文件系统资源
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.bean05.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 〈一句话功能简述〉<br> 
 * 〈文件系统资源〉
 *
 * @author Danny
 * @create 2021/12/15
 * @since 1.0.0
 */
public class FileSystemResource implements Resource {
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

  public InputStream getInputStream() throws IOException {
    return new FileInputStream(this.file);
  }

  public final String getPath() {
    return this.path;
  }
}