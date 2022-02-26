package com.demo.bean08.factory;

import com.demo.bean08.BeansException;

/**
 * Bean工厂
 */
public interface BeanFactory {
  /**
   * 无参
   * @param name
   * @return
   */
  Object getBean(String name);

  /**
   * 有参
   * @param name
   * @param args
   * @return
   * @throws BeansException
   */
  Object getBean(String name, Object... args) throws BeansException;

  /**
   * 根据bean类型获取bean
   * @param name
   * @param requiredType
   * @param <T>
   * @return
   * @throws BeansException
   */
  <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}
