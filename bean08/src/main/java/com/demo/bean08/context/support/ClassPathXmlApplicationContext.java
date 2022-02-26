/**
 * FileName: ClassPathXmlApplicationContext
 * Author:   Danny
 * Date:     2021/12/18 14:19
 * Description: 应用上下文实现类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.bean08.context.support;

import com.demo.bean08.BeansException;

/**
 * 〈一句话功能简述〉<br> 
 * 〈应用上下文实现类〉
 *
 * @author Danny
 * @create 2021/12/18
 * @since 1.0.0
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {

  private String[] configLocations;

  public ClassPathXmlApplicationContext() {
  }

  /**
   * 从 XML 中加载 BeanDefinition，并刷新上下文
   * @param configLocations
   * @throws BeansException
   */
  public ClassPathXmlApplicationContext(String[] configLocations) throws BeansException {
    this.configLocations = configLocations;
    refresh();
  }

  /**
   * 从 XML 中加载 BeanDefinition，并刷新上下文
   *
   * @param configLocations
   * @throws BeansException
   */
  public ClassPathXmlApplicationContext(String configLocations) throws BeansException {
    this(new String[]{configLocations});
  }

  @Override
  protected String[] getConfigLocations() {
    return configLocations;
  }
}