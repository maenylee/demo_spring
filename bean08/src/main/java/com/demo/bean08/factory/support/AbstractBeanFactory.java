/**
 * FileName: AbstractBeanFactory
 * Author:   Danny
 * Date:     2021/12/6 20:47
 * Description: 抽象类定义模板方法
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.bean08.factory.support;

import com.demo.bean08.BeansException;
import com.demo.bean08.factory.BeanFactory;
import com.demo.bean08.factory.config.BeanDefinition;
import com.demo.bean08.factory.util.ClassUtil;

/**
 * 〈一句话功能简述〉<br> 
 * 〈抽象类定义模板方法〉
 *
 * @author Danny
 * @create 2021/12/6
 * @since 1.0.0
 */
public abstract class AbstractBeanFactory
        extends DefaultSingletonBeanRegistry implements BeanFactory {

  /** ClassLoader to resolve bean class names with, if necessary */
  private ClassLoader beanClassLoader = ClassUtil.getDefaultClassLoader();

  @Override
  public Object getBean(String name) throws BeansException {
    return doGetBean(name, null);
  }
  @Override
  public Object getBean(String name, Object... args) throws BeansException {
    return doGetBean(name, args);
  }
  @Override
  public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
    return (T)getBean(name);
  }

  protected <T> T doGetBean(final String name, final Object[] args) {
    Object bean = getSingleton(name);
    if (bean != null) {
      return (T) bean;
    }

    BeanDefinition beanDefinition = getBeanDefinition(name);
    return (T) createBean(name, beanDefinition, args);
  }

  protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

  protected abstract Object createBean(String beanName, BeanDefinition beanDefinition,Object[] args) throws BeansException;

  public ClassLoader getBeanClassLoader() {
    return beanClassLoader;
  }
}