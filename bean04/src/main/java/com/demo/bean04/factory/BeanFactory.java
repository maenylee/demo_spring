package com.demo.bean04.factory;

import com.demo.bean03.BeansException;

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
}
