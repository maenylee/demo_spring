/**
 * FileName: XmlBeanDefinitionReader
 * Author:   Danny
 * Date:     2021/12/15 15:16
 * Description: 解析XML处理Bean注册
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.bean08.factory.xml;

import com.demo.bean08.BeansException;
import com.demo.bean08.PropertyValue;
import com.demo.bean08.core.io.Resource;
import com.demo.bean08.core.io.ResourceLoader;
import com.demo.bean08.factory.config.BeanDefinition;
import com.demo.bean08.factory.config.BeanReference;
import com.demo.bean08.factory.support.AbstractBeanDefinitionReader;
import com.demo.bean08.factory.support.BeanDefinitionRegistry;
import com.demo.bean08.factory.util.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

/**
 * 〈一句话功能简述〉<br> 
 * 〈解析XML处理Bean注册〉
 *
 * @author Danny
 * @create 2021/12/15
 * @since 1.0.0
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

  public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
    super(registry);
  }

  public XmlBeanDefinitionReader(BeanDefinitionRegistry registry
          , ResourceLoader resourceLoader) {
    super(registry, resourceLoader);
  }
  @Override
  public void loadBeanDefinitions(Resource resource) throws BeansException {
    try {
      InputStream inputStream = resource.getInputStream();
      doLoadBeanDefinitions(inputStream);
    } catch (Exception e) {
      throw new BeansException("IOException parsing XML document from " + resource, e);
    }
  }
  @Override
  public void loadBeanDefinitions(Resource... resources) throws BeansException {
    for (Resource resource : resources) {
      loadBeanDefinitions(resource);
    }
  }
  @Override
  public void loadBeanDefinitions(String location) throws BeansException {
    ResourceLoader resourceLoader = getResourceLoader();
    Resource resource = resourceLoader.getResource(location);
    loadBeanDefinitions(resource);
  }

  @Override
  public void loadBeanDefinitions(String[] configLocations) throws BeansException {
    for (String location : configLocations) {
      loadBeanDefinitions(location);
    }
  }

  protected void doLoadBeanDefinitions(InputStream inputStream) throws Exception {
    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
    Document document = documentBuilder.parse(inputStream);
    Element root = document.getDocumentElement();
    NodeList childNodes = root.getChildNodes();
    for (int i = 0; i < childNodes.getLength(); i++) {
      Node node = childNodes.item(i);
      // 判断元素
      if (!(node instanceof Element)) {
        continue;
      }
      // 判断对象
      if (!"bean".equals(node.getNodeName())) {
        continue;
      }
      // 解析标签
      Element bean = (Element) node;
      String id = bean.getAttribute("id");
      String name = bean.getAttribute("name");
      String className = bean.getAttribute("class");
      // 获取 Class，方便获取类中的名称
      Class<?> clazz = Class.forName(className);
      // 优先级 id > name
      String beanName = StringUtils.notBlack(id) ? id : name;
      if (beanName == null || beanName.trim().length() == 0) {
        beanName = clazz.getSimpleName();
      }

      // 定义Bean
      BeanDefinition beanDefinition = new BeanDefinition(clazz);
      // 读取属性并填充
      NodeList propNodes = bean.getChildNodes();
      for (int j = 0; j < propNodes.getLength(); j++) {
        Node propNode = propNodes.item(j);
        if (!(propNode instanceof Element)){
          continue;
        }
        if (!"property".equals(propNode.getNodeName())){
          continue;
        }
        // 解析标签：property
        Element property = (Element) propNode;
        String attrName = property.getAttribute("name");
        String attrValue = property.getAttribute("value");
        String attrRef = property.getAttribute("ref");
        // 获取属性值：引入对象、值对象
        Object value = StringUtils.notBlack(attrRef) ? new BeanReference(attrRef) : attrValue;
        // 创建属性信息
        PropertyValue propertyValue = new PropertyValue(attrName, value);
        beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
      }
      // 初始化方法
      String initMethod = bean.getAttribute("init-method");
      if(StringUtils.notBlack(initMethod)){
        beanDefinition.setInitMethodName(initMethod);
      }
      // 销毁方法
      String destroyMethod = bean.getAttribute("destroy-method");
      if(StringUtils.notBlack(destroyMethod)){
        beanDefinition.setDestroyMethodName(destroyMethod);
      }
      if (getRegistry().containsBeanDefinition(beanName)) {
        throw new BeansException("Duplicate beanName[" + beanName + "] is not allowed");
      }
      // 注册 BeanDefinition
      getRegistry().registerBeanDefinition(beanName, beanDefinition);
    }
  }
}