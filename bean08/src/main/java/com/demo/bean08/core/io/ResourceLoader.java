/**
 * FileName: ResourceLoader
 * Author:   Danny
 * Date:     2021/12/15 15:05
 * Description: 资源加载器接口
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.bean08.core.io;

/**
 * 〈一句话功能简述〉<br> 
 * 〈资源加载器接口〉
 *
 * @author Danny
 * @create 2021/12/15
 * @since 1.0.0
 */
public interface ResourceLoader {
  /**
   * Pseudo URL prefix for loading from the class path: "classpath:"
   */
  String CLASSPATH_URL_PREFIX = "classpath:";

  Resource getResource(String location);
}