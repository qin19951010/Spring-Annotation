package com.jiangnanyidianyu.config;

import com.jiangnanyidianyu.bean.Car;
import com.jiangnanyidianyu.bean.Color;
import com.jiangnanyidianyu.dao.BookDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.awt.print.Book;

/*
    自动装配;
        Spring利用依赖注入,完成对IOC容器中各个组件的依赖关系赋值;

    1).@Autowired:自动注入
        1.优先按照类型去找容器中对应的组件:applicationContext.getBean(BookDao.class);
        2.如果找到多个相同类型的组件,再将属性的名称作为组件的ID去容器中查找
        *** 测试发现 Spring会报异常NoUniqueBeanDefinitionException
        3.@Qualifier("bookDao"):使用Qualifier指定需要装配的组件的id,而不是使用属性名
        4.自动装配,默认一定要将属性赋值好,没有就会报错  可以使用@Autowired(required = false) 设置为能装配的装配,没有就为NUll
        BookService{
            @Autowired
            BookDao bookdao;
        }
        5.@Primary:让Spring进行自动装配的时候默认使用首选的Bean
    2).Spring还支持使用@Resource(JSR250)和@Inject(JSR330)[JAVA规范注解]
        @Resource:
            可以和@Autowired一样实现自动装配功能;默认是按照组件名称进行装配的;
            没有能支持@Primary,没有支持@Autowired(required = false)
        @Inject:(需要引入依赖Inject的包,和Autowired的功能一样),没有支持@Autowired(required = false)
        @Autowired:Spring定义的;
        @Resource,@Inject:JAVA规范

        @AutowiredAnnotationBeanPostProcessor:解析完成自动装配功能

    3).@Autowired:可以使用在构造器,参数,方法,属性;都是从容器中获取参数组件的值
      1.[标注在方法的位置](比如set方法) 最经常使用的@Bean+方法参数,参数从容器中获取;默认不写@Autowired
      2.标在构造器上:如果组件只有一个有参构造器,这个有参构造器的@Autowired可以省略,参数位置的组件还是可以自动从容器中获取
      3.放在参数位置;

    4).自定义组件想要使用Spring容器底层的一些组件(ApplicationContext,BeanFactory,xxx)
        自定义组件实现xxxAware即可;在创建对象的时候会调用接口规定的方法注入相关组件;Aware接口
        把Spring底层一些组件注入到自定义的Bean中
        xxxAware:功能使用xxxProcessor;
            ApplicationContextAware ==> ApplicationContextAwareProcessor;



 */

@Configuration
@ComponentScan({"com.jiangnanyidianyu.controller","com.jiangnanyidianyu.dao","com.jiangnanyidianyu.service","com.jiangnanyidianyu.bean"})
public class MainConfigOfAutowired {

    @Bean("bookDao")
    public BookDao bookDao()
    {
        BookDao bookDao = new BookDao();
        bookDao.setLabel("1");
        return bookDao;
    }

    /*
        @Bean标注的方法创建对象的时候,方法参数的值从容器中获取
     */
    @Bean
    public Color color(Car car)
    {
        Color color = new Color();
        color.setCar(car);
        return color;
    }
}
