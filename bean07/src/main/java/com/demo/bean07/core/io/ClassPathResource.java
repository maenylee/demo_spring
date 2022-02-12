/**
 * FileName: ClassPathResource
 * Author:   Danny
 * Date:     2021/12/15 14:49
 * Description: 类路径资源
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.bean07.core.io;

import com.demo.bean07.BeansException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 〈一句话功能简述〉<br> 
 * 〈类路径资源〉
 *
 * @author Danny
 * @create 2021/12/15
 * @since 1.0.0
 */
public class ClassPathResource implements Resource {
  /**
   * 资源类路径
   */
  private final String path;
  /**
   * 类加载器
   */
  private ClassLoader classLoader;

  public ClassPathResource(String path) {
    this(path, (ClassLoader) null);
  }

  public ClassPathResource(String path, ClassLoader classLoader) {
    if(path == null){
      new BeansException("Path must not be null");
    }
    this.path = path;
    this.classLoader = (classLoader != null ? classLoader : ClassLoader.getSystemClassLoader());
  }

  public InputStream getInputStream() throws IOException {
    InputStream is = classLoader.getResourceAsStream(path);
    if (is == null) {
      throw new FileNotFoundException(
              this.path + " cannot be opened because it does not exist");
    }
    return is;
  }
}