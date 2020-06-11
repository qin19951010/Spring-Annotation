package com.jiangnanyidianyu.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//默认加在ioc的容器中的组件,容器启动会调用无参构造器创建对象,再进行初始化赋值操作
@Component
public class Boss {

    private Car car;

    public Car getCar() {
        return car;
    }

    //@Autowired
    public Boss(@Autowired Car car)
    {
        this.car = car;
        System.out.println("Boss的有参构造器.....");
    }

    //标注在方法上,Spring容器创建当前对象的时候,就会调用方法,完成赋值;
    //方法使用的参数,自定义类型的值丛ioc容器中进行获取
    //@Autowired
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }
}
