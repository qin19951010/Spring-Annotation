package com.jiangnanyidianyu.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Dog {
    public Dog(){
        System.out.println("dog constructor...");
    }

    //对象创建并赋值之后调用
    @PostConstruct
    public void init(){
        System.out.println("Dog...@PostConstruct...");
    }

    //移除对象之前:相当于回调通知
    @PreDestroy
    public void detory(){
        System.out.println("Dog...@PreDestroy...");
    }
}
