/**
 * FileName: AbstractApplicationContext
 * Author:   Danny
 * Date:     2021/12/18 13:30
 * Description: 应用上下文抽象类实现
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.bean08.context.support;

import com.demo.bean08.BeansException;
import com.demo.bean08.context.ConfigurableApplicationContext;
import com.demo.bean08.core.io.DefaultResourceLoader;
import com.demo.bean08.factory.ConfigurableListableBeanFactory;
import com.demo.bean08.factory.config.BeanFactoryPostProcessor;
import com.demo.bean08.factory.config.BeanPostProcessor;

import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈应用上下文抽象类实现〉
 *
 * @author Danny
 * @create 2021/12/18
 * @since 1.0.0
 */
public abstract class AbstractApplicationContext
        extends DefaultResourceLoader implements ConfigurableApplicationContext {
  @Override
  public void registerShutdownHook() {
    Runtime.getRuntime().addShutdownHook(new Thread(this::close));
  }
  @Override
  public void close() {
    getBeanFactory().destroySingletons();
  }
  @Override
  public void refresh() throws BeansException {
    // 1. 创建 BeanFactory，并加载 BeanDefinition
    refreshBeanFactory();

    // 2. 获取 BeanFactory
    ConfigurableListableBeanFactory beanFactory = getBeanFactory();

    // 3. 添加 ApplicationContextAwareProcessor，让继承自 ApplicationContextAware 的 Bean 对象都能感知所属的 ApplicationContext
    beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this));

    // 4. 在 Bean 实例化之前，执行 BeanFactoryPostProcessor (Invoke factory processors registered as beans in the context.)
    invokeBeanFactoryPostProcessors(beanFactory);

    // 5. BeanPostProcessor 需要提前于其他 Bean 对象实例化之前执行注册操作
    registerBeanPostProcessors(beanFactory);

    // 6. 提前实例化单例Bean对象
    beanFactory.preInstantiateSingletons();
  }

  protected abstract void refreshBeanFactory() throws BeansException;

  protected abstract ConfigurableListableBeanFactory getBeanFactory();

  /**
   * bean注册之后，实例化之前的操作
   * @param beanFactory
   */
  private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
    Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap =
            beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
    for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
      beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
    }
  }

  private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
    Map<String, BeanPostProcessor> beanPostProcessorMap =
            beanFactory.getBeansOfType(BeanPostProcessor.class);
    for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
      beanFactory.addBeanPostProcessor(beanPostProcessor);
    }
  }
  @Override
  public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
    return getBeanFactory().getBeansOfType(type);
  }
  @Override
  public String[] getBeanDefinitionNames() {
    return getBeanFactory().getBeanDefinitionNames();
  }
  @Override
  public Object getBean(String name) throws BeansException {
    return getBeanFactory().getBean(name);
  }
  @Override
  public Object getBean(String name, Object... args) throws BeansException {
    return getBeanFactory().getBean(name, args);
  }
  @Override
  public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
    return getBeanFactory().getBean(name, requiredType);
  }
}