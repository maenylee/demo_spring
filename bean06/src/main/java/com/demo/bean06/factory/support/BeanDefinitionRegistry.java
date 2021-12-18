package com.demo.bean06.factory.support;

import com.demo.bean06.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {
  void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

  boolean containsBeanDefinition(String beanName);
}
