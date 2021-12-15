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

import com.demo.admin.bean.dao.UserDao;

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

  private String uId;

  private UserDao userDao;

  public UserService() {
  }

  public UserService(String name) {
    this.name = name;
  }

  public void service(){
    String s = this.toString();
    System.err.println(s);
  }

  public void queryUserInfo() {
    System.out.println("查询用户信息：" + userDao.queryUserName(uId));
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("");
    sb.append("").append(name);
    return sb.toString();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getuId() {
    return uId;
  }

  public void setuId(String uId) {
    this.uId = uId;
  }

  public UserDao getUserDao() {
    return userDao;
  }

  public void setUserDao(UserDao userDao) {
    this.userDao = userDao;
  }
}