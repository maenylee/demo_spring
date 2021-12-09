package com.demo.bean02.factory.config;

/**
 * 单例注册接口
 */
public interface SingletonBeanRegistry {
  Object getSingleton(String beanName);
}
