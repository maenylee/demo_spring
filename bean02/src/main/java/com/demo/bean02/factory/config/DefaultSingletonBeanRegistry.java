/**
 * FileName: DefaultSingletonBeanRegistry
 * Author:   Danny
 * Date:     2021/12/6 20:45
 * Description: 默认单例注册实现
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.bean02.factory.config;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈默认单例注册实现〉
 *
 * @author Danny
 * @create 2021/12/6
 * @since 1.0.0
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
  private Map<String, Object> singletonObjects = new HashMap<String,Object>();

  public Object getSingleton(String beanName) {
    return singletonObjects.get(beanName);
  }

  protected void addSingleton(String beanName, Object singletonObject) {
    singletonObjects.put(beanName, singletonObject);
  }
}