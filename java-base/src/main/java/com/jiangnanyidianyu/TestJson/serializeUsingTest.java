package com.jiangnanyidianyu.TestJson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;

import java.io.IOException;
import java.lang.reflect.Type;

/*
* 在fastjson 1.2.16版本之后，JSONField的持新的定制化配置serializeUsing，
* 可以单独对某个类的某个属性定制序列化，例如：
*/
public class serializeUsingTest {
    public static class A {
        @JSONField(serializeUsing = AValueSerializer.class)
        public int value;
        @JSONField(serializeUsing = AValueSerializer.class)
        public String name;
    }

    public static class AValueSerializer implements ObjectSerializer {

        @Override
        public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType,
                          int features) throws IOException {
//            Integer value = (Integer) object;
//            String text = value + "元";
//            serializer.write(text);

            String name = object.toString();
            String text2 = "我是" + name;
            serializer.write(text2);
        }
    }

    public static void main(String[] args) {
        A obj = new A();
        obj.value = 100;
        obj.name = "马飞飞";
        String json = JSON.toJSONString(obj);
        System.out.println(json);
    }
}
