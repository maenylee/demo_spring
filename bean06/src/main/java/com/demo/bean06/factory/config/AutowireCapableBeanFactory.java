package com.demo.bean06.factory.config;

import com.demo.bean06.BeansException;
import com.demo.bean06.factory.BeanFactory;

public interface AutowireCapableBeanFactory extends BeanFactory {
  Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;

  Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;
}
