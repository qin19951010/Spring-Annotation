package com.jiangnanyidianyu;

import com.jiangnanyidianyu.aop.MathCalculator;
import com.jiangnanyidianyu.config.MainConfigOfAOP;
import com.jiangnanyidianyu.tx.TxConfig;
import com.jiangnanyidianyu.tx.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_Tx {

    @Test
    public void test01()
    {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(TxConfig.class);

        UserService userService = applicationContext.getBean(UserService.class);
        userService.insertUser();

        applicationContext.close();

    }



}
