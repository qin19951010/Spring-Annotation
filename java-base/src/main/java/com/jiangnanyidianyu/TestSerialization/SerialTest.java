package com.jiangnanyidianyu.TestSerialization;

import java.io.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SerialTest {
    public static void main(String[] args) throws InterruptedException {

        /**
         * 基本步骤：
         * ① 对象实体类实现Serializable 标记接口
         * ② 创建序列化输出流对象ObjectOutputStream，该对象的创建依赖于其它输出流对象，通常我们将对象序列化为文件存储，所以这里用文件相关的输出流对象 FileOutputStream
         * ③ 通过ObjectOutputStream 的 writeObject()方法将对象序列化为文件
         * ④ 关闭流 这里采用1.7开始的新语法  try-with-resources  而不用自己控制流的关闭
         */
        User user = new User("陈本布衣", "123456", 100);
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("D:\\user"))) {
            os.writeObject(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //先睡5秒
        TimeUnit.SECONDS.sleep(5);

        /**
         * 基本步骤：
         * ① 创建输入流对象ObjectOutputStream。同样依赖于其它输入流对象，这里是文件输入流 FileInputStream
         * ② 通过 ObjectInputStream 的 readObject()方法，将文件中的对象读取到内存
         * ③ 关闭流 同上
         */
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("D:\\user"))) {
            User o = (User) is.readObject();
            System.out.println(o);
            System.out.println("当前时间："+new Date());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
