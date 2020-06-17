package com.jiangnanyidianyu.bean;

import org.springframework.beans.factory.annotation.Value;

public class Person {

    //使用@Value赋值;
    //1.基本数值
    //2.SpEL;#{}
    //3.写${};取出配置文件[properties]中的值(在运行环境变量的值)
    @Value("小秦")
    private String name;
    @Value("#{20-2}")
    private Integer age;
    @Value("${person.nickName}")
    private String nickName;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    public Person(String name, Integer age) {
        super();
        this.name = name;
        this.age = age;
    }

    public Person() {
        super();
    }
}