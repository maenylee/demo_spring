package com.demo.bean08.factory.config;

import com.demo.bean08.BeansException;

/**
 * 定义 BeanPostProcessor
 */
public interface BeanPostProcessor {
  /**
   * 在 Bean 对象执行初始化方法之前，执行此方法
   *
   * @param bean
   * @param beanName
   * @return
   * @throws BeansException
   */
  Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

  /**
   * 在 Bean 对象执行初始化方法之后，执行此方法
   *
   * @param bean
   * @param beanName
   * @return
   * @throws BeansException
   */
  Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
