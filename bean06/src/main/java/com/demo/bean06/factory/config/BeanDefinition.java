/**
 * FileName: BeanDefinition
 * Author:   Danny
 * Date:     2021/12/6 20:42
 * Description: bean定义
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.bean06.factory.config;

import com.demo.bean06.PropertyValues;

/**
 * 〈一句话功能简述〉<br> 
 * 〈BeanDefinition 定义〉
 *
 * @author Danny
 * @create 2021/12/6
 * @since 1.0.0
 */
public class BeanDefinition {
  private Class beanClass;

  private PropertyValues propertyValues;

  public BeanDefinition(Class beanClass) {
    this.beanClass = beanClass;
    this.propertyValues = new PropertyValues();
  }

  public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
    this.beanClass = beanClass;
    this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
  }

  public Class getBeanClass() {
    return beanClass;
  }

  public void setBeanClass(Class beanClass) {
    this.beanClass = beanClass;
  }

  public PropertyValues getPropertyValues() {
    return propertyValues;
  }

  public void setPropertyValues(PropertyValues propertyValues) {
    this.propertyValues = propertyValues;
  }
}