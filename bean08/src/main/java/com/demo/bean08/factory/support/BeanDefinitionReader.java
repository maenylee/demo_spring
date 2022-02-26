package com.demo.bean08.factory.support;

import com.demo.bean08.BeansException;
import com.demo.bean08.core.io.Resource;
import com.demo.bean08.core.io.ResourceLoader;

/**
 * bean定义读取接口
 */
public interface BeanDefinitionReader {
  BeanDefinitionRegistry getRegistry();

  ResourceLoader getResourceLoader();

  void loadBeanDefinitions(Resource resource) throws BeansException;

  void loadBeanDefinitions(Resource... resources) throws BeansException;

  void loadBeanDefinitions(String location) throws BeansException;

  void loadBeanDefinitions(String[] configLocations) throws BeansException;
}
