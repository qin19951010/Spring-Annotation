package com.jiangnanyidianyu.TestSerialization;

import java.io.Serializable;
import java.util.Date;

public class User2 implements Serializable {

    private static final long serialVersionUID = -1075318199295234057L;

    //时间标示
    private Date date = new Date();

    private String name;

    /*
        序列化的对象属性必须实现Serializable接口
        Date类和String类均已实现,查看源码可知
     */

    private Menu menu;

    private String password;

    //private transient String password;

    private int age;

    public User2() {
    }

    public User2(String name, String password, int age) {
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

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }


    @Override
    public String toString() {
        return "User{" +
                "序列化存储时间：" + date +
                ", name='" + name + '\'' +
                ", 菜单：" + menu +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}
