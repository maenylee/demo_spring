package com.demo.admin.bean;

import com.demo.admin.bean.service.UserService;
import com.demo.bean01.BeanDefinition;
import com.demo.bean01.BeanFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Bean01ApplicationTests {

  @Test
  public void testBean() {
    // 1.初始化 BeanFactory
    BeanFactory beanFactory = new BeanFactory();

    // 2.注册 bean
    BeanDefinition beanDefinition = new BeanDefinition(new UserService());
    beanFactory.registerBeanDefinition("userService", beanDefinition);

    // 3.获取 bean
    UserService userService = (UserService) beanFactory.getBean("userService");
    userService.service();
  }

}
