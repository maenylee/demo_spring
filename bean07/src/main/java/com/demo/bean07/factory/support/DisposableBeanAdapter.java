/**
 * FileName: DisposableBeanAdapter
 * Author:   Danny
 * Date:     2022/2/12 10:56
 * Description: 销毁方法适配器(接口和配置)
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.bean07.factory.support;

import com.demo.bean07.BeansException;
import com.demo.bean07.factory.DisposableBean;
import com.demo.bean07.factory.config.BeanDefinition;
import com.demo.bean07.factory.util.StringUtils;

import java.lang.reflect.Method;

/**
 * 〈一句话功能简述〉<br> 
 * 〈销毁方法适配器(接口和配置)〉
 *
 * @author Danny
 * @create 2022/2/12
 * @since 1.0.0
 */
public class DisposableBeanAdapter implements DisposableBean {

  private final Object bean;
  private final String beanName;
  private String destroyMethodName;

  public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
    this.bean = bean;
    this.beanName = beanName;
    this.destroyMethodName = beanDefinition.getDestroyMethodName();
  }

  public void destroy() throws Exception {
    // 1. 实现接口 DisposableBean
    if (bean instanceof DisposableBean) {
      ((DisposableBean) bean).destroy();
    }
    // 如果bean对象实现了DisposableBean接口，且方法名为destroy，则直接采用配置信息 destroy-method方法执行
    if(bean instanceof DisposableBean && "destroy".equals(this.destroyMethodName)){
      return;
    }
    // 2. 配置信息 destroy-method {判断是为了避免二次执行销毁}
    if (StringUtils.notBlack(destroyMethodName)) {
      Method destroyMethod = bean.getClass().getMethod(destroyMethodName);
      if (null == destroyMethod) {
        throw new BeansException("Couldn't find a destroy method named '" + destroyMethodName + "' on bean with name '" + beanName + "'");
      }
      destroyMethod.invoke(bean);
    }
  }
}