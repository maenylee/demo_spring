/**
 * FileName: CglibSubclassingInstantiationStrategy
 * Author:   Danny
 * Date:     2021/12/13 17:35
 * Description: Cglib简单实例化策略
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.bean06.factory.support;

import com.demo.bean06.BeansException;
import com.demo.bean06.factory.config.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * 〈一句话功能简述〉<br> 
 * 〈Cglib简单实例化策略〉
 *
 * @author Danny
 * @create 2021/12/13
 * @since 1.0.0
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {
  public Object instantiate(BeanDefinition beanDefinition,
                            String beanName, Constructor ctor, Object[] args) throws BeansException {
    // 创建增强器
    Enhancer enhancer = new Enhancer();
    // 设置超类，即被代理类
    enhancer.setSuperclass(beanDefinition.getBeanClass());
    // 设置回调方法
    enhancer.setCallback(new NoOp() {
      @Override
      public int hashCode() {
        return super.hashCode();
      }
    });
    // 无参构造函数
    if (null == ctor) {
      return enhancer.create();
    }
    // 有参构造函数
    return enhancer.create(ctor.getParameterTypes(), args);
  }
}