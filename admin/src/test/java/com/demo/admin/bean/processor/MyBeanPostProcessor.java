/**
 * FileName: MyBeanPostProcessor
 * Author:   Danny
 * Date:     2021/12/18 15:21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.admin.bean.processor;

import com.demo.admin.bean.service.UserService;
import com.demo.bean06.BeansException;
import com.demo.bean06.factory.config.BeanPostProcessor;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Danny
 * @create 2021/12/18
 * @since 1.0.0
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

  public Object postProcessBeforeInitialization(Object bean, String beanName)
          throws BeansException {
    if ("userService".equals(beanName)) {
      UserService userService = (UserService) bean;
      userService.setLocation("改为：北京");
    }
    return bean;
  }

  public Object postProcessAfterInitialization(Object bean, String beanName)
          throws BeansException {
    return bean;
  }
}