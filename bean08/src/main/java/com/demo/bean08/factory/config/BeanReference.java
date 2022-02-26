/**
 * FileName: BeanReference
 * Author:   Danny
 * Date:     2021/12/14 19:45
 * Description: 引用类型bean
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.bean08.factory.config;

/**
 * 〈一句话功能简述〉<br> 
 * 〈引用类型bean〉
 *
 * @author Danny
 * @create 2021/12/14
 * @since 1.0.0
 */
public class BeanReference {
  private String beanName;

  public BeanReference() {
  }

  public BeanReference(String beanName) {
    this.beanName = beanName;
  }

  public String getBeanName() {
    return beanName;
  }

  public void setBeanName(String beanName) {
    this.beanName = beanName;
  }
}