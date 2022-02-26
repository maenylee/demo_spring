package com.demo.bean08.factory.support;

import com.demo.bean08.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {
  void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

  boolean containsBeanDefinition(String beanName);
}
