package com.jiangnanyidianyu;

import com.jiangnanyidianyu.bean.Boss;
import com.jiangnanyidianyu.bean.Car;
import com.jiangnanyidianyu.bean.Color;
import com.jiangnanyidianyu.bean.Yellow;
import com.jiangnanyidianyu.config.MainConfigOfAutowired;
import com.jiangnanyidianyu.config.MainConfigOfProfile;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class IOCTest_Profile {


    //1.使用命令行动态参数切换环境:在虚拟机参数位置加载-Dspring.profiles.active=test
    @Test
    public void test01()
    {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext();
        //**不可使用有参构造器,有参构造器会直接加载容器刷新,无法更改启动环境
        //1.创建一个applicationContext
        //2.设置需要激活的环境
        applicationContext.getEnvironment().setActiveProfiles(  "test");
        //3.注册主配置类
        applicationContext.register(MainConfigOfProfile.class);
        //4.启动,刷新容器
        applicationContext.refresh();

        String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);
        for (String strNames: beanNamesForType) {
            System.out.println(strNames);
        }

        Yellow yellow = applicationContext.getBean(Yellow.class);
        System.out.println(yellow);

    }
}
