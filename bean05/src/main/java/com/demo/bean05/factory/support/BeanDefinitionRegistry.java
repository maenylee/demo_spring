package com.demo.bean05.factory.support;

import com.demo.bean05.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {
  void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

  boolean containsBeanDefinition(String beanName);
}
