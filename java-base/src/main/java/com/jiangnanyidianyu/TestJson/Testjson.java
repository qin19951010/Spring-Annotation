package com.jiangnanyidianyu.TestJson;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Testjson {

    public static void main(String[] args) {
        serialize();
        deserialize();
    }

    public static void serialize() {
        User user = new User();
        user.setId(11L);
        user.setName("西安");
        user.setCreateTime(new Date());
        String jsonString = JSON.toJSONString(user, SerializerFeature.PrettyFormat);
        System.out.println(jsonString);
    }

    public static void deserialize() {
        String jsonString = "{\"createTime\":\"2018-08-17 14:38:38\",\"id\":11,\"name\":\"西安\"}";
        User user = JSON.parseObject(jsonString, User.class);
        System.out.println(user.getName());
        System.out.println(user.getId());
        System.out.println(user.getCreateTime());
    }
}
