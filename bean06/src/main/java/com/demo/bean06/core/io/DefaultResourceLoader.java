/**
 * FileName: DefaultResourceLoader
 * Author:   Danny
 * Date:     2021/12/15 15:07
 * Description: 默认资源加载器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.bean06.core.io;

import com.demo.bean06.BeansException;
import com.demo.bean06.core.io.FileSystemResource;
import com.demo.bean06.core.io.UrlResource;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 〈一句话功能简述〉<br> 
 * 〈默认资源加载器〉
 *
 * @author Danny
 * @create 2021/12/15
 * @since 1.0.0
 */
public class DefaultResourceLoader implements ResourceLoader {
  public Resource getResource(String location) {
    if(location == null){
      throw new BeansException("Location must not be null");
    }
    if (location.startsWith(CLASSPATH_URL_PREFIX)) {
      return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
    } else {
      try {
        URL url = new URL(location);
        return new UrlResource(url);
      } catch (MalformedURLException e) {
        return new FileSystemResource(location);
      }
    }
  }
}