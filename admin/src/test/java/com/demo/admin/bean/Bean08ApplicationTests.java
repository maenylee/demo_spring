package com.demo.admin.bean;

import com.demo.admin.bean.service.UserService;
import com.demo.bean08.context.support.ClassPathXmlApplicationContext;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class Bean08ApplicationTests {

  @Test
  public void test_xml() {
    // 1.初始化 BeanFactory
    ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring_08.xml");
    applicationContext.registerShutdownHook();

    // 2. 获取Bean对象调用方法
    UserService userService = applicationContext.getBean("userService", UserService.class);
    userService.queryUserInfo();
    System.out.println("ApplicationContextAware："+userService.getApplicationContext());
    System.out.println("BeanFactoryAware："+userService.getBeanFactory());
  }

}
