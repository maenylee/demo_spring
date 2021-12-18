/**
 * FileName: AbstractBeanDefinitionReader
 * Author:   Danny
 * Date:     2021/12/15 15:13
 * Description: Bean定义抽象类实现
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.bean06.factory.support;

import com.demo.bean06.core.io.DefaultResourceLoader;
import com.demo.bean06.core.io.ResourceLoader;

/**
 * 〈一句话功能简述〉<br> 
 * 〈Bean定义抽象类实现〉
 *
 * @author Danny
 * @create 2021/12/15
 * @since 1.0.0
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

  private final BeanDefinitionRegistry registry;

  private ResourceLoader resourceLoader;

  protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
    this(registry, new DefaultResourceLoader());
  }

  public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry
          , ResourceLoader resourceLoader) {
    this.registry = registry;
    this.resourceLoader = resourceLoader;
  }

  public BeanDefinitionRegistry getRegistry() {
    return registry;
  }

  public ResourceLoader getResourceLoader() {
    return resourceLoader;
  }
}