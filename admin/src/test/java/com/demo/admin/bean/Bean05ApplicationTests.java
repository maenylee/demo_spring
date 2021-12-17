package com.demo.admin.bean;

import com.demo.admin.bean.service.UserService;
import com.demo.bean05.core.io.DefaultResourceLoader;
import com.demo.bean05.core.io.Resource;
import com.demo.bean05.factory.support.DefaultListableBeanFactory;
import com.demo.bean05.factory.xml.XmlBeanDefinitionReader;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.util.io.IOUtil;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.InputStream;

@SpringBootTest
class Bean05ApplicationTests {

  private DefaultResourceLoader resourceLoader;

  @BeforeEach
  public void init() {
    resourceLoader = new DefaultResourceLoader();
  }

  @Test
  public void test_classpath() throws IOException {
    Resource resource = resourceLoader.getResource("classpath:important.properties");
    InputStream inputStream = resource.getInputStream();
    int length = -1;
    byte[] bytes = new byte[1024];
    String content = "";
    while ((length = inputStream.read(bytes)) > -1){
      content = content + new String(bytes,0,length);
    }
    System.err.println(content);
  }

  @Test
  public void test_file() throws IOException {
    Resource resource = resourceLoader.getResource("src/test/resources/important.properties");
    InputStream inputStream = resource.getInputStream();
    int length = -1;
    byte[] bytes = new byte[1024];
    String content = "";
    while ((length = inputStream.read(bytes)) > -1){
      content = content + new String(bytes,0,length);
    }
    System.err.println(content);
  }

  @Test
  public void test_url() throws IOException {
    Resource resource = resourceLoader
            .getResource("https://github.com/fuzhengwei/small-spring/important.properties");
    InputStream inputStream = resource.getInputStream();
    int length = -1;
    byte[] bytes = new byte[1024];
    String content = "";
    while ((length = inputStream.read(bytes)) > -1){
      content = content + new String(bytes,0,length);
    }
    System.err.println(content);
  }

  @Test
  public void test_xml() {
    // 1.初始化 BeanFactory
    DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

    // 2. 读取配置文件&注册Bean
    XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
    reader.loadBeanDefinitions("classpath:spring.xml");

    // 3. 获取Bean对象调用方法
    UserService userService = beanFactory.getBean("userService",UserService.class);
    userService.queryUserInfo();
  }

}
