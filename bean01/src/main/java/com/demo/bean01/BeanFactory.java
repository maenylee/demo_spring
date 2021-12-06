/**
 * FileName: BeanFactory
 * Author:   Danny
 * Date:     2021/12/6 14:47
 * Description: bean工厂
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.bean01;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 〈一句话功能简述〉<br> 
 * 〈bean工厂〉
 *
 * @author Danny
 * @create 2021/12/6
 * @since 1.0.0
 */
public class BeanFactory {
  private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

  public Object getBean(String name) {
    return beanDefinitionMap.get(name).getBean();
  }

  public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
    beanDefinitionMap.put(name, beanDefinition);
  }
}