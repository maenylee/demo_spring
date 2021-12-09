package com.demo.bean02.factory.support;

import com.demo.bean02.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {
  void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
