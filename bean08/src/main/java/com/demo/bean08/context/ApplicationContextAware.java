package com.demo.bean08.context;

import com.demo.bean08.BeansException;
import com.demo.bean08.factory.Aware;

public interface ApplicationContextAware extends Aware {
  void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
