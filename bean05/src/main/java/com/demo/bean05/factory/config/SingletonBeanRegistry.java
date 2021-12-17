package com.demo.bean05.factory.config;

/**
 * 单例注册接口
 */
public interface SingletonBeanRegistry {
  Object getSingleton(String beanName);
}