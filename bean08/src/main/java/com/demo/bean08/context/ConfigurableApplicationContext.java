package com.demo.bean08.context;

import com.demo.bean08.BeansException;

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

  /**
   * 虚拟机关闭钩子注册
   */
  void registerShutdownHook();

  /**
   * 关闭销毁方法
   */
  void close();
}
