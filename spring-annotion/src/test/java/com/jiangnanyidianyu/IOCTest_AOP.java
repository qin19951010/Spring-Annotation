package com.jiangnanyidianyu;

import com.jiangnanyidianyu.aop.MathCalculator;
import com.jiangnanyidianyu.bean.Person;
import com.jiangnanyidianyu.config.MainConfig;
import com.jiangnanyidianyu.config.MainConfig2;
import com.jiangnanyidianyu.config.MainConfigOfAOP;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

public class IOCTest_AOP {

    @Test
    public void test01()
    {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);

        //1.错误的测试  == >  自己单独New的MathCalculator,不是由Spring容器创建,不要自己创建
//        MathCalculator mathCalculator = new MathCalculator();
//        mathCalculator.div(1,1);

        MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
        int i = mathCalculator.div(1, 0);
        //System.out.println(i);
        applicationContext.close();

    }



}
