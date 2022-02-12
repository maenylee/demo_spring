/**
 * FileName: SimpleInstantiationStrategy
 * Author:   Danny
 * Date:     2021/12/13 17:27
 * Description: JDK简单实例化
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.bean07.factory.support;

import com.demo.bean07.BeansException;
import com.demo.bean07.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 〈一句话功能简述〉<br> 
 * 〈JDK反射实例化策略〉
 *
 * @author Danny
 * @create 2021/12/13
 * @since 1.0.0
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {
  public Object instantiate(BeanDefinition beanDefinition,
                            String beanName, Constructor ctor, Object[] args) throws BeansException {
    Class clazz = beanDefinition.getBeanClass();
    try {
      /**
       * Class类的getDeclaredConstructor()方法,可获取到类的私有构造器(包括带有其他修饰符的构造器）
       * 但在使用private的构造器时，必须设置setAccessible()为true,才可以获取并操作该Constructor对象。
       */
      if (null != ctor) {
        // 有参构造器
        return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
      } else {
        // 无参构造器
        return clazz.getDeclaredConstructor().newInstance();
      }
    } catch (Exception e) {
      throw new BeansException("Failed to instantiate [" + clazz.getName() + "]", e);
    }
  }
}