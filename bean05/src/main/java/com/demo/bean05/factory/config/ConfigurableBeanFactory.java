package com.demo.bean05.factory.config;

import com.demo.bean05.factory.HierarchicalBeanFactory;

/**
 * 可获取 BeanPostProcessor、BeanClassLoader等的一个配置化接口
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory {
  /**
   * 单例
   */
  String SCOPE_SINGLETON = "singleton";
  /**
   * 多例
   */
  String SCOPE_PROTOTYPE = "prototype";
}
