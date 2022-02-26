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
import com.demo.bean08.factory.DisposableBean;
import com.demo.bean08.factory.InitializingBean;
import com.demo.bean08.BeansException;
import com.demo.bean08.context.ApplicationContext;
import com.demo.bean08.context.ApplicationContextAware;
import com.demo.bean08.factory.BeanClassLoaderAware;
import com.demo.bean08.factory.BeanFactory;
import com.demo.bean08.factory.BeanFactoryAware;
import com.demo.bean08.factory.BeanNameAware;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈工具类〉
 *
 * @author Danny
 * @create 2021/12/6
 * @since 1.0.0
 */
public class UserService implements Serializable, InitializingBean, DisposableBean, BeanNameAware,
        BeanClassLoaderAware, ApplicationContextAware, BeanFactoryAware {

  private ApplicationContext applicationContext;
  private BeanFactory beanFactory;

  public void destroy() {
    System.err.println("执行：UserService.destroy");
  }

  public void afterPropertiesSet(){
    System.err.println("执行：UserService.afterPropertiesSet");
  }

  private String name;

  private String uId;

  private UserDao userDao;

  private String company;
  private String location;

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
    System.err.println("查询用户信息："
            + userDao.queryUserName(uId)
            + "-" + company
            + "-" + location);
  }

  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.applicationContext = applicationContext;
  }

  public void setBeanClassLoader(ClassLoader classLoader) {
    System.out.println("ClassLoader：" + classLoader);
  }

  public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
    this.beanFactory = beanFactory;
  }

  public void setBeanName(String name) {
    System.out.println("Bean Name is：" + name);
  }

  public ApplicationContext getApplicationContext() {
    return applicationContext;
  }

  public BeanFactory getBeanFactory() {
    return beanFactory;
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

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }
}