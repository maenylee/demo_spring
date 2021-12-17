package com.demo.bean05.factory.support;

import com.demo.bean05.BeansException;
import com.demo.bean05.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 实例化策略接口
 */
public interface InstantiationStrategy {
  Object instantiate(BeanDefinition beanDefinition,
                     String beanName, Constructor ctor, Object[] args) throws BeansException;
}
