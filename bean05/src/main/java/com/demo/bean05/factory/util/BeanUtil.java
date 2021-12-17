/**
 * FileName: BeanUtil
 * Author:   Danny
 * Date:     2021/12/14 19:48
 * Description: Bean工具类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.bean05.factory.util;

import com.demo.bean05.BeansException;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;

/**
 * 〈一句话功能简述〉<br> 
 * 〈Bean工具类〉
 *
 * @author Danny
 * @create 2021/12/14
 * @since 1.0.0
 */
public class BeanUtil {
  /**
   * 设置对象属性的值
   * @param bean
   * @param fieldName
   * @param fieldValue
   */
  public static void setFieldValue(Object bean,String fieldName,Object fieldValue)
          throws NoSuchFieldException,IllegalAccessException{
    if(bean == null){
      throw new BeansException("设置bean字段值，bean对象不能为null");
    }
    if(fieldName == null){
      throw new BeansException("设置bean字段值，fieldName字段名称不能为null");
    }
    // 获取对象的字段信息
    Class<?> classObj = bean instanceof Class ? (Class)bean : bean.getClass();
    Field field = null;
    System.err.println("cccccccc=" + Proxy.isProxyClass(classObj));
    if(isProxyObj(classObj)){
      Field[] fields = classObj.getFields();
      field = classObj.getSuperclass().getDeclaredField(fieldName);
    }else {
      field = classObj.getDeclaredField(fieldName);
    }
    field.setAccessible(true);
    field.set(bean, fieldValue);
  }

  public static boolean isProxyObj(Class<?> classObj){
    return isEnhancer(classObj) || Proxy.isProxyClass(classObj);
  }

  /**
   * 判断对象是否是cjlib代理对象
   * @param classObj
   * @return
   */
  private static boolean isEnhancer(Class<?> classObj){
    if(classObj == null){
      throw new BeansException("class_obj is null");
    }
    String simpleName = classObj.getSimpleName();
    if(simpleName.contains("Enhancer")){
      return true;
    }
    return false;
  }
}