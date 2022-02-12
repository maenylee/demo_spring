package com.demo.bean07.factory.support;

import com.demo.bean07.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {
  void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

  boolean containsBeanDefinition(String beanName);
}
