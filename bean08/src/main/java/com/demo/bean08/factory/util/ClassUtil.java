/**
 * FileName: ClassUtil
 * Author:   Danny
 * Date:     2022/2/26 10:44
 * Description: 类工具
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.bean08.factory.util;

/**
 * 〈一句话功能简述〉<br> 
 * 〈类工具〉
 *
 * @author Danny
 * @create 2022/2/26
 * @since 1.0.0
 */
public class ClassUtil {
  public static ClassLoader getDefaultClassLoader() {
    ClassLoader cl = null;
    try {
      cl = Thread.currentThread().getContextClassLoader();
    } catch (Throwable ex) {
      // Cannot access thread context ClassLoader - falling back to system class loader...
    }
    if (cl == null) {
      // No thread context class loader -> use class loader of this class.
      cl = ClassUtil.class.getClassLoader();
    }
    return cl;
  }
}