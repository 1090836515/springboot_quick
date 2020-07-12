package com.atguigu;

import com.atguigu.bean.Person;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
class SpringBoot01HelloworldQuickApplicationTests {

    @Resource
    Person person;

    @Autowired
    ApplicationContext ioc;

    @Test
    void contextLoads() {
        System.out.println(person);
    }

    @Test
    public void testHelloService(){
        boolean b=ioc.containsBean("helloService");
        System.out.println(b);
    }
}
