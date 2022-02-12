/**
 * FileName: DefaultSingletonBeanRegistry
 * Author:   Danny
 * Date:     2021/12/6 20:45
 * Description: 默认单例注册实现
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.bean07.factory.support;

import com.demo.bean07.BeansException;
import com.demo.bean07.factory.DisposableBean;
import com.demo.bean07.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 〈一句话功能简述〉<br> 
 * 〈默认单例注册实现〉
 *
 * @author Danny
 * @create 2021/12/6
 * @since 1.0.0
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry{
  private Map<String, Object> singletonObjects = new HashMap<String,Object>();

  private Map<String, DisposableBean> disposableBeans = new ConcurrentHashMap<String, DisposableBean>(16);
  @Override
  public Object getSingleton(String beanName) {
    return singletonObjects.get(beanName);
  }

  protected void addSingleton(String beanName, Object singletonObject) {
    singletonObjects.put(beanName, singletonObject);
  }

  public void registerDisposableBean(String beanName, DisposableBean bean) {
    disposableBeans.put(beanName, bean);
  }

  public void destroySingletons(){
    Set<String> keySet = this.disposableBeans.keySet();
    Object[] disposableBeanNames = keySet.toArray();

    for (int i = disposableBeanNames.length - 1; i >= 0; i--) {
      Object beanName = disposableBeanNames[i];
      DisposableBean disposableBean = disposableBeans.remove(beanName);
      try {
        disposableBean.destroy();
      } catch (Exception e) {
        throw new BeansException("Destroy method on bean with name '" + beanName + "' threw an exception", e);
      }
    }
  }


}