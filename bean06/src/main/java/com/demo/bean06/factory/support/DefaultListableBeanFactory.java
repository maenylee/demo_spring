/**
 * FileName: DefaultListableBeanFactory
 * Author:   Danny
 * Date:     2021/12/9 19:18
 * Description: 核心类实现
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.bean06.factory.support;

import com.demo.bean06.BeansException;
import com.demo.bean06.factory.ConfigurableListableBeanFactory;
import com.demo.bean06.factory.config.BeanDefinition;
import com.demo.bean06.factory.config.BeanPostProcessor;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 〈一句话功能简述〉<br> 
 * 〈核心类实现〉
 *
 * @author Danny
 * @create 2021/12/9
 * @since 1.0.0
 */
public class DefaultListableBeanFactory
        extends AbstractAutowireCapableBeanFactory
        implements BeanDefinitionRegistry, ConfigurableListableBeanFactory{
  private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

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

  public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
    Map<String, T> result = new HashMap<String, T>(16);
    for (Map.Entry<String, BeanDefinition> entry : beanDefinitionMap.entrySet()) {
      Class beanClass = entry.getValue().getBeanClass();
      String beanName = entry.getKey();
      if(type.isAssignableFrom(beanClass)){
        result.put(beanName,(T) getBean(beanName));
      }
    }
    return result;
  }

  public String[] getBeanDefinitionNames() {
    return beanDefinitionMap.keySet().toArray(new String[0]);
  }

  public void preInstantiateSingletons() {
    for (String s : beanDefinitionMap.keySet()) {
      getBean(s);
    }
  }

  public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
    getBeanPostProcessors().add(beanPostProcessor);
  }
}