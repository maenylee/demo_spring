/**
 * FileName: BeansException
 * Author:   Danny
 * Date:     2021/12/6 20:40
 * Description: bean异常类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.bean04;

/**
 * 〈一句话功能简述〉<br> 
 * 〈bean异常类〉
 *
 * @author Danny
 * @create 2021/12/6
 * @since 1.0.0
 */
public class BeansException extends RuntimeException {
  public BeansException(String message,Exception e) {
    super(message,e);
  }

  public BeansException(String message) {
    super(message);
  }
}