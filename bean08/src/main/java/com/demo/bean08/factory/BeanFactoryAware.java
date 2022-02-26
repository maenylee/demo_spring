package com.demo.bean08.factory;

import com.demo.bean08.BeansException;

public interface BeanFactoryAware extends Aware {
  void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
