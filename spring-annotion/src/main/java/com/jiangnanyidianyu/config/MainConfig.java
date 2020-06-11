package com.jiangnanyidianyu.config;
import com.jiangnanyidianyu.bean.Person;
import com.jiangnanyidianyu.service.BookService;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.activation.FileTypeMap;

/*
   注解通过配置类替换配置文件
   配置类 = 配置文件
*/

//@Configuration //告诉Spring这是一个配置类
//@ComponentScan(value = "com.jiangnanyidianyu",excludeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class, Service.class}) //按照注解排除
//
//})

//@ComponentScan(value = "com.jiangnanyidianyu",
//        includeFilters = {
//                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {Controller.class})
//        },
//        useDefaultFilters = false)

//@ComponentScans(
//        value = {
//                @ComponentScan(value = "com.jiangnanyidianyu",
//        includeFilters = {
                        //指定注解
                //omponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class}),
                        //指定类型
                //@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {BookService.class}),
                        //指定自定义
//                @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})
//        },
//        useDefaultFilters = false)
//        }
//)

//@ComponentScan  value:指定要扫描的包
//excludeFilters = Filter[] : 指定扫描的时候按照什么规则排除哪些组件
//includeFilters = Filter[] : 指定扫描的时候只需要包含哪些组件
//FilterType.ANNOTATION : 按照注解
//FilterType.ASSIGNABLE_TYPE ：按照给定的类型
//FilterType.REGEX : 按照正则表达式
//FilterType.CUSTOM : 使用自定义规则(通过TypeFilter的实现类)
//@ComponentScan  value:指定要扫描的包
@ComponentScan(value = "com.jiangnanyidianyu")
public class MainConfig {

    //给容器中注册一个bean；类型为返回值的类型,id默认是用方法名作为id
//    @Bean("person")
//    public Person person()
//    {
//        return new Person("QIN",25);
//    }
}
