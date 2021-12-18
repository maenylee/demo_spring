/**
 * FileName: PropertyValues
 * Author:   Danny
 * Date:     2021/12/14 19:34
 * Description: 属性值对象的集合
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.bean06;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈属性值对象的集合〉
 *
 * @author Danny
 * @create 2021/12/14
 * @since 1.0.0
 */
public class PropertyValues {
  private final List<PropertyValue> propertyValueList = new ArrayList<PropertyValue>();

  public void addPropertyValue(PropertyValue pv) {
    this.propertyValueList.add(pv);
  }

  public PropertyValue[] getPropertyValues() {
    return this.propertyValueList.toArray(new PropertyValue[0]);
  }

  public PropertyValue getPropertyValue(String propertyName) {
    for (PropertyValue pv : this.propertyValueList) {
      if (pv.getName().equals(propertyName)) {
        return pv;
      }
    }
    return null;
  }
}