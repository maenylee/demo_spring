package com.demo.admin.bean;

import com.demo.admin.bean.dao.UserDao;
import com.demo.admin.bean.service.UserService;
import com.demo.bean04.PropertyValue;
import com.demo.bean04.PropertyValues;
import com.demo.bean04.factory.config.BeanDefinition;
import com.demo.bean04.factory.config.BeanReference;
import com.demo.bean04.factory.support.DefaultListableBeanFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Bean04ApplicationTests {

  @Test
  public void testBean() {
    // 1.初始化 BeanFactory
    DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

    // 2. UserDao 注册
    BeanDefinition beanDefinition1 = new BeanDefinition(UserDao.class);
    beanFactory.registerBeanDefinition("userDao", beanDefinition1);

    // 3. UserService 设置属性[uId、userDao]
    PropertyValues propertyValues = new PropertyValues();
    propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
    propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));

    // 4. UserService 注入bean
    BeanDefinition beanDefinition2 = new BeanDefinition(UserService.class, propertyValues);
    beanFactory.registerBeanDefinition("userService", beanDefinition2);

    // 5. UserService 获取bean
    UserService userService = (UserService) beanFactory.getBean("userService");
    userService.queryUserInfo();
  }

}
