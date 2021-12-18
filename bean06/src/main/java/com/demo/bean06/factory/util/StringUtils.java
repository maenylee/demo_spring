/**
 * FileName: StringUtils
 * Author:   Danny
 * Date:     2021/12/17 10:55
 * Description: 字符串工具类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.bean06.factory.util;

/**
 * 〈一句话功能简述〉<br> 
 * 〈字符串工具类〉
 *
 * @author Danny
 * @create 2021/12/17
 * @since 1.0.0
 */
public class StringUtils {
  public static boolean notBlack(String string){
    return string != null && string.trim().length() > 0;
  }
}