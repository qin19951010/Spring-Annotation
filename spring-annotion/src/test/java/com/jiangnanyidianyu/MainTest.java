package com.jiangnanyidianyu;

import com.jiangnanyidianyu.bean.Person;
import com.jiangnanyidianyu.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
    public static void main(String[] args) {
        //1.传统方法中通过配置文件装配Bean
        //读取XML生成容器

//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
//        String applicationName = applicationContext.getDisplayName();
//        Person bean = (Person) applicationContext.getBean("person");
//        System.out.println(bean);
//        System.out.println(applicationName);

        //2.注解方式
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
//        Person person001 = applicationContext.getBean(Person.class);
//        System.out.println(person001);

        //返回Id名称
        /*修改id方法：
        *  1.改配置类MainConfig的方法名 person -> person01
        *  2.通过注解的方法修改ID @value
        */
        String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String name : namesForType)
        {
            System.out.println(name);
        }
    }
}
