package com.jiangnanyidianyu.TestSerialization;

import java.io.Serializable;
import java.util.Date;

/*
    序列化:
    程序运行的时候，会产生很多对象,而对象信息也只是在程序运行的时候才在内存中保持其状态
    一旦程序停止，内存释放，对象也就不存在了,怎么能让对象永久的保存下来呢 --- 对象序列化
*/
public class User implements Serializable {
    private static final long serialVersionUID = -1075318199295234057L;

    //时间标示
    private Date date = new Date();

    private String name;

    //transient该属性不被序列化
    private transient String password;
    //private  String password;

    private int age;

    public User() {
    }

    public User(String name, String password, int age) {
        this.name = name;
        this.password = password;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "序列化存储时间：" + date +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}
