/**
 * FileName: AbstractXmlApplicationContext
 * Author:   Danny
 * Date:     2021/12/18 14:12
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.bean06.context.support;

import com.demo.bean06.factory.support.DefaultListableBeanFactory;
import com.demo.bean06.factory.xml.XmlBeanDefinitionReader;

/**
 * 〈一句话功能简述〉<br> 
 * 〈上下文中对配置信息的加载〉
 *
 * @author Danny
 * @create 2021/12/18
 * @since 1.0.0
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

  @Override
  protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
    XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
    String[] configLocations = getConfigLocations();
    if (null != configLocations){
      beanDefinitionReader.loadBeanDefinitions(configLocations);
    }
  }

  protected abstract String[] getConfigLocations();
}