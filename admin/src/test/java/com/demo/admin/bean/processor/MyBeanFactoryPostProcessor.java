/**
 * FileName: MyBeanFactoryPostProcessor
 * Author:   Danny
 * Date:     2021/12/18 14:43
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.admin.bean.processor;

import com.demo.bean06.BeansException;
import com.demo.bean06.PropertyValue;
import com.demo.bean06.PropertyValues;
import com.demo.bean06.factory.ConfigurableListableBeanFactory;
import com.demo.bean06.factory.config.BeanDefinition;
import com.demo.bean06.factory.config.BeanFactoryPostProcessor;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Danny
 * @create 2021/12/18
 * @since 1.0.0
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
    BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
    PropertyValues propertyValues = beanDefinition.getPropertyValues();

    propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
  }
}