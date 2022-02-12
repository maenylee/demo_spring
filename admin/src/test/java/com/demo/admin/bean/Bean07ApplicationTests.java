package com.demo.admin.bean;

import com.demo.admin.bean.processor.MyBeanFactoryPostProcessor;
import com.demo.admin.bean.processor.MyBeanPostProcessor;
import com.demo.admin.bean.service.UserService;
import com.demo.bean07.context.support.ClassPathXmlApplicationContext;
import com.demo.bean06.factory.support.DefaultListableBeanFactory;
import com.demo.bean06.factory.xml.XmlBeanDefinitionReader;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class Bean07ApplicationTests {

  @Test
  public void test_BeanFactoryPostProcessorAndBeanPostProcessor(){
    // 1.初始化 BeanFactory
    DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

    // 2. 读取配置文件&注册Bean
    XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
    reader.loadBeanDefinitions("classpath:spring_05.xml");

    // 3. BeanDefinition 加载完成 & Bean实例化之前，修改 BeanDefinition 的属性值
    MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
    beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

    // 4. Bean实例化之后，修改 Bean 属性信息
    MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
    beanFactory.addBeanPostProcessor(beanPostProcessor);

    // 5. 获取Bean对象调用方法
    UserService userService = beanFactory.getBean("userService", UserService.class);
    userService.queryUserInfo();
  }

  @Test
  public void test_xml() {
    // 1.初始化 BeanFactory
    ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring_07.xml");
    applicationContext.registerShutdownHook();

    // 2. 获取Bean对象调用方法
    UserService userService = applicationContext.getBean("userService", UserService.class);
    userService.queryUserInfo();
  }

}
