package com.demo.bean06.factory.config;

import com.demo.bean06.BeansException;
import com.demo.bean06.factory.ConfigurableListableBeanFactory;

/**
 * 定义 BeanFactoryPostProcessor
 */
public interface BeanFactoryPostProcessor {
  /**
   * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
   *
   * @param beanFactory
   * @throws BeansException
   */
  void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
