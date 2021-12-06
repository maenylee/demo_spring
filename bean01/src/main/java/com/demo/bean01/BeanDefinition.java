/**
 * FileName: BeanDefinition
 * Author:   Danny
 * Date:     2021/12/6 14:45
 * Description: bean定义
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.bean01;

/**
 * 〈一句话功能简述〉<br> 
 * 〈bean定义〉
 *
 * @author Danny
 * @create 2021/12/6
 * @since 1.0.0
 */
public class BeanDefinition {
  private Object bean;

  public BeanDefinition(Object bean) {
    this.bean = bean;
  }

  public Object getBean(){
    return bean;
  }
}