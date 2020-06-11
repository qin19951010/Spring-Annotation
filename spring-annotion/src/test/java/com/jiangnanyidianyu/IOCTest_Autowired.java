package com.jiangnanyidianyu;

import com.jiangnanyidianyu.bean.Boss;
import com.jiangnanyidianyu.bean.Car;
import com.jiangnanyidianyu.bean.Color;
import com.jiangnanyidianyu.config.MainConfigOfAutowired;
import com.jiangnanyidianyu.dao.BookDao;
import com.jiangnanyidianyu.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_Autowired {

    @Test
    public void test01()
    {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class );
//        BookService bookService = applicationContext.getBean(BookService.class);
//        System.out.println(bookService);  //输出结果 ==> BookService{bookDao=com.jiangnanyidianyu.dao.BookDao@12d3a4e9}

//        BookDao bookDao = applicationContext.getBean(BookDao.class);
//        System.out.println(bookDao);    //输出结果 ==> com.jiangnanyidianyu.dao.BookDao@12d3a4e9

        //打印bookService中输出的bookdao和容器中的bookdao是同一个对象

        Boss boss = applicationContext.getBean(Boss.class);
        System.out.println(boss);

        Car car = applicationContext.getBean(Car.class);
        System.out.println(car);

        Color color = applicationContext.getBean(Color.class);
        System.out.println(color);
        applicationContext.close();
    }
}
