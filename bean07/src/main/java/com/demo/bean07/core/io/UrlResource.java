/**
 * FileName: UrlResource
 * Author:   Danny
 * Date:     2021/12/15 15:00
 * Description: 云资源
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.bean07.core.io;

import com.demo.bean07.BeansException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * 〈一句话功能简述〉<br> 
 * 〈云资源〉
 *
 * @author Danny
 * @create 2021/12/15
 * @since 1.0.0
 */
public class UrlResource implements Resource {
  private final URL url;

  public UrlResource(URL url) {
    if(url == null){
      throw new BeansException("URL must not be null");
    }
    this.url = url;
  }

  public InputStream getInputStream() throws IOException {
    URLConnection con = this.url.openConnection();
    try {
      return con.getInputStream();
    } catch (IOException ex){
      if (con instanceof HttpURLConnection){
        ((HttpURLConnection) con).disconnect();
      }
      throw ex;
    }
  }
}