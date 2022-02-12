/**
 * FileName: AbstractRefreshableApplicationContext
 * Author:   Danny
 * Date:     2021/12/18 13:38
 * Description: 获取Bean工厂和加载资源
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.bean07.context.support;

import com.demo.bean07.BeansException;
import com.demo.bean07.factory.ConfigurableListableBeanFactory;
import com.demo.bean07.factory.support.DefaultListableBeanFactory;

/**
 * 〈一句话功能简述〉<br> 
 * 〈获取Bean工厂和加载资源〉
 *
 * @author Danny
 * @create 2021/12/18
 * @since 1.0.0
 */
public abstract class AbstractRefreshableApplicationContext
        extends AbstractApplicationContext {

  private DefaultListableBeanFactory beanFactory;

  @Override
  protected void refreshBeanFactory() throws BeansException {
    DefaultListableBeanFactory beanFactory = createBeanFactory();
    loadBeanDefinitions(beanFactory);
    this.beanFactory = beanFactory;
  }

  private DefaultListableBeanFactory createBeanFactory() {
    return new DefaultListableBeanFactory();
  }

  protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

  @Override
  protected ConfigurableListableBeanFactory getBeanFactory() {
    return beanFactory;
  }
}