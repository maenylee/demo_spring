package com.demo.bean05.factory;

import com.demo.bean05.BeansException;
import com.demo.bean05.factory.config.AutowireCapableBeanFactory;
import com.demo.bean05.factory.config.BeanDefinition;
import com.demo.bean05.factory.config.ConfigurableBeanFactory;

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
}
