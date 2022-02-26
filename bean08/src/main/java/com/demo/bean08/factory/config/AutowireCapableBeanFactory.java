package com.demo.bean08.factory.config;

import com.demo.bean08.BeansException;
import com.demo.bean08.factory.BeanFactory;

public interface AutowireCapableBeanFactory extends BeanFactory {
  Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;

  Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;
}
