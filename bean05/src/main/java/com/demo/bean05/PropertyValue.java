/**
 * FileName: PropertyValue
 * Author:   Danny
 * Date:     2021/12/14 19:32
 * Description: 属性值对象
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.bean05;

/**
 * 〈一句话功能简述〉<br> 
 * 〈属性值对象〉
 *
 * @author Danny
 * @create 2021/12/14
 * @since 1.0.0
 */
public class PropertyValue {
  private final String name;

  private final Object value;

  public PropertyValue(String name, Object value) {
    this.name = name;
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public Object getValue() {
    return value;
  }
}