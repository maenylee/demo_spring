/**
 * FileName: AbstractBeanFactory
 * Author:   Danny
 * Date:     2021/12/6 20:47
 * Description: 抽象类定义模板方法
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.bean02.factory.support;

import com.demo.bean02.BeansException;
import com.demo.bean02.factory.BeanFactory;
import com.demo.bean02.factory.config.BeanDefinition;
import com.demo.bean02.factory.config.DefaultSingletonBeanRegistry;

/**
 * 〈一句话功能简述〉<br> 
 * 〈抽象类定义模板方法〉
 *
 * @author Danny
 * @create 2021/12/6
 * @since 1.0.0
 */
public abstract class AbstractBeanFactory
        extends DefaultSingletonBeanRegistry implements BeanFactory {

  public Object getBean(String name) throws BeansException {
    Object bean = getSingleton(name);
    if (bean != null) {
      return bean;
    }

    BeanDefinition beanDefinition = getBeanDefinition(name);
    return createBean(name, beanDefinition);
  }

  protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

  protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;
}