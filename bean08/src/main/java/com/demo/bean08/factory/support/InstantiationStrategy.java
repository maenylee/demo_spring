package com.demo.bean08.factory.support;

import com.demo.bean08.BeansException;
import com.demo.bean08.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 实例化策略接口
 */
public interface InstantiationStrategy {
  Object instantiate(BeanDefinition beanDefinition,
                     String beanName, Constructor ctor, Object[] args) throws BeansException;
}
