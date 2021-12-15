/**
 * FileName: AbstractAutowireCapableBeanFactory
 * Author:   Danny
 * Date:     2021/12/6 20:51
 * Description: 实例化Bean类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.bean04.factory.support;

import com.demo.bean04.BeansException;
import com.demo.bean04.PropertyValue;
import com.demo.bean04.PropertyValues;
import com.demo.bean04.factory.config.BeanDefinition;
import com.demo.bean04.factory.config.BeanReference;
import com.demo.bean04.factory.util.BeanUtil;

import java.lang.reflect.Constructor;

/**
 * 〈一句话功能简述〉<br> 
 * 〈实例化Bean类〉
 *
 * @author Danny
 * @create 2021/12/6
 * @since 1.0.0
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

  private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

  @Override
  protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
    Object bean = null;
    try {
      bean = createBeanInstance(beanDefinition, beanName, args);
    } catch (Exception e) {
      throw new BeansException("Instantiation of bean failed", e);
    }
    addSingleton(beanName, bean);
    return bean;
  }

  @Override
  protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
    Object bean = null;
    try {
      bean = beanDefinition.getBeanClass().newInstance();
      // 给 Bean 填充属性
      applyPropertyValues(beanName, bean, beanDefinition);
    } catch (Exception e) {
      throw new BeansException("Instantiation of bean failed", e);
    }
    addSingleton(beanName, bean);
    return bean;
  }

  protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
    Constructor constructorToUse = null;
    Class<?> beanClass = beanDefinition.getBeanClass();
    Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
    for (Constructor ctor : declaredConstructors) {
      if (null != args && ctor.getParameterTypes().length == args.length) {
        constructorToUse = ctor;
        break;
      }
    }
    return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
  }

  /**
   * Bean 属性填充
   */
  protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
    try {
      PropertyValues propertyValues = beanDefinition.getPropertyValues();
      for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {

        String name = propertyValue.getName();
        Object value = propertyValue.getValue();

        if (value instanceof BeanReference) {
          // A 依赖 B，获取 B 的实例化
          BeanReference beanReference = (BeanReference) value;
          value = getBean(beanReference.getBeanName());
        }
        // 属性填充
        BeanUtil.setFieldValue(bean, name, value);
      }
    } catch (Exception e) {
      throw new BeansException("Error setting property values：" + beanName);
    }
  }

  public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
    this.instantiationStrategy = instantiationStrategy;
  }

  protected InstantiationStrategy getInstantiationStrategy(){
    return instantiationStrategy;
  }
}