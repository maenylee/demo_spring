/**
 * FileName: UserService
 * Author:   Danny
 * Date:     2021/12/6 14:48
 * Description: 工具类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.admin.bean.service;

/**
 * 〈一句话功能简述〉<br> 
 * 〈工具类〉
 *
 * @author Danny
 * @create 2021/12/6
 * @since 1.0.0
 */
public class UserService {

  private String name;

  public UserService() {
  }

  public UserService(String name) {
    this.name = name;
  }

  public void service(){
    String s = this.toString();
    System.err.println(s);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("");
    sb.append("").append(name);
    return sb.toString();
  }
}