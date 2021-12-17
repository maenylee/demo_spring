/**
 * FileName: DefaultListableBeanFactory
 * Author:   Danny
 * Date:     2021/12/9 19:18
 * Description: 核心类实现
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.bean05.factory.support;

import com.demo.bean05.BeansException;
import com.demo.bean05.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈核心类实现〉
 *
 * @author Danny
 * @create 2021/12/9
 * @since 1.0.0
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {
  private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<String, BeanDefinition>();

  public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
    beanDefinitionMap.put(beanName, beanDefinition);
  }

  @Override
  public BeanDefinition getBeanDefinition(String beanName) throws BeansException {
    BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
    if (beanDefinition == null){
      throw new BeansException("No bean named '" + beanName + "' is defined");
    }
    return beanDefinition;
  }

  public boolean containsBeanDefinition(String beanName) {
    if(beanName == null){
      throw new BeansException("null bean name");
    }
    return beanDefinitionMap.containsKey(beanName);
  }
}