package com.jiangnanyidianyu;

import com.jiangnanyidianyu.bean.Blue;
import com.jiangnanyidianyu.bean.Person;
import com.jiangnanyidianyu.config.MainConfig;
import com.jiangnanyidianyu.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

public class IOCTest {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);

    private void printBeans(AnnotationConfigApplicationContext applicationContext)
    {
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String names : definitionNames)
        {
            System.out.println(names);
        }
    }

    @Test
    public void testImport()
    {
//        printBeans(applicationContext);
//        Blue blue = applicationContext.getBean(Blue.class);
//        System.out.println(blue);

        //工厂Bean获取的是调用getObject创建的对象
        Object bean2 = applicationContext.getBean("colorFactoryBean");
        System.out.println("bean的类型:" + bean2.getClass());

        //&+创建对象名 -> 获取工厂类对象
        Object bean3 = applicationContext.getBean("&colorFactoryBean");
        System.out.println(bean3.getClass());
    }


    @SuppressWarnings("resource")
    @Test
    public void test01()
    {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        //查看容器中所有的bean
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : definitionNames)
        {
            System.out.println(name);
        }
    }

    @Test
    public void test02()
    {
          AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
//        String[] definitionNames = applicationContext.getBeanDefinitionNames();
//        for (String name : definitionNames)
//        {
//            System.out.println(name);
//        }

          System.out.println("IOC容器创建完成。。。");
          //获取bean
          Object bean = applicationContext.getBean("person");
          Object bean2 = applicationContext.getBean("person");
//        System.out.println(bean == bean2);
    }

    @Test
    public void test03()
    {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);

        //获取运行的环境
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        //动态获取环境变量的值
        String property = environment.getProperty("os.name");
        System.out.println(property);

        String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String name : namesForType)
        {
            System.out.println(name);
        }

        Map<String, Person> persons = applicationContext.getBeansOfType(Person.class);
        System.out.println(persons);
    }

}
