package com.jiangnanyidianyu.TestSerialization;

import java.io.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SerialTest2 {

    public static void main(String[] args) throws InterruptedException {
        //序列化
        User2 user2 = new User2("QIN", "123123", 18);
        Menu menu = new Menu(1, "我的菜单", "/菜单1");
        user2.setMenu(menu);

        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("D:\\user2"))) {
            outputStream.writeObject(user2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //先睡5秒
        TimeUnit.SECONDS.sleep(5);

        //反序列化
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("D:\\user2"))) {
            Object o = objectInputStream.readObject();
            System.out.println( o.toString());
            System.out.println("当前时间" + new Date());
        }catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
