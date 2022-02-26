package com.demo.bean08.factory;

public interface BeanClassLoaderAware extends Aware {
  void setBeanClassLoader(ClassLoader classLoader);
}
