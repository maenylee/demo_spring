package com.demo.bean06.context;

import com.demo.bean06.BeansException;

/**
 * 配置上下文容器
 */
public interface ConfigurableApplicationContext extends ApplicationContext {
  /**
   * 刷新容器
   *
   * @throws BeansException
   */
  void refresh() throws BeansException;
}
