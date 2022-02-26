/**
 * FileName: ApplicationContextAwareProcessor
 * Author:   Danny
 * Date:     2022/2/26 10:25
 * Description: 包装处理器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.bean08.context.support;

import com.demo.bean08.BeansException;
import com.demo.bean08.context.ApplicationContext;
import com.demo.bean08.context.ApplicationContextAware;
import com.demo.bean08.factory.config.BeanPostProcessor;

/**
 * 〈一句话功能简述〉<br> 
 * 〈包装处理器〉
 *
 * @author Danny
 * @create 2022/2/26
 * @since 1.0.0
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

  private final ApplicationContext applicationContext;

  public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
    this.applicationContext = applicationContext;
  }

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
    if (bean instanceof ApplicationContextAware){
      ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
    }
    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    return bean;
  }
}