/**
 * FileName: AbstractAutowireCapableBeanFactory
 * Author:   Danny
 * Date:     2021/12/6 20:51
 * Description: 实例化Bean类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.bean02.factory.support;

import com.demo.bean02.BeansException;
import com.demo.bean02.factory.config.BeanDefinition;

/**
 * 〈一句话功能简述〉<br> 
 * 〈实例化Bean类〉
 *
 * @author Danny
 * @create 2021/12/6
 * @since 1.0.0
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
  @Override
  protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
    Object bean = null;
    try {
      bean = beanDefinition.getBeanClass().newInstance();
    } catch (Exception e) {
      throw new BeansException("Instantiation of bean failed", e);
    }
    addSingleton(beanName, bean);
    return bean;
  }
}