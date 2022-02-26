package com.demo.bean08.factory;

import com.demo.bean08.BeansException;
import com.demo.bean08.factory.config.AutowireCapableBeanFactory;
import com.demo.bean08.factory.config.BeanDefinition;
import com.demo.bean08.factory.config.BeanPostProcessor;
import com.demo.bean08.factory.config.ConfigurableBeanFactory;

/**
 * 提供分析和修改Bean以及预先实例化的操作接口
 */
public interface ConfigurableListableBeanFactory
        extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {
  /**
   * 根据名称获取bean定义对象
   * @param beanName
   * @return
   * @throws BeansException
   */
  BeanDefinition getBeanDefinition(String beanName) throws BeansException;

  /**
   * 实例化单例对象bean
   */
  void preInstantiateSingletons();

  /**
   * 添加bean实例化前后的操作对象
   * @param beanPostProcessor
   */
  void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
