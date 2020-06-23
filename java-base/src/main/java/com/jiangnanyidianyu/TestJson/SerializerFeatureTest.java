package com.jiangnanyidianyu.TestJson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.Date;

//fastjson通过SerializerFeature对生成的json格式的数据进行一些定制
/*
*   1.QuoteFieldNames  == > 输出key时是否使用双引号,默认为true
*   2.UseSingleQuotes  == > 使用单引号而不是双引号,默认为false
*   3.WriteMapNullValue == > WriteMapNullValue
*   4.WriteEnumUsingToString == > Enum输出name()或者original,默认为false
*   5.UseISO8601DateFormat == > Date使用ISO8601格式输出，默认为false
*   6.WriteNullListAsEmpty == > WriteNullStringAsEmpty
*   7.WriteNullNumberAsZero == > 数值字段如果为null,输出为0,而非null
*   8.WriteNullBooleanAsFalse == > Boolean字段如果为null,输出为false,而非null
*   9.SkipTransientField == > 如果是true，类中的Get方法对应的Field是transient，序列化时将会被忽略。默认为true
*   10.SortField == > 按字段名称排序后输出。默认为false
*   11.PrettyFormat == > 结果是否格式化,默认为false
*   12.WriteClassName == > 序列化时写入类型信息，默认为false。反序列化是需用到
*/

public class SerializerFeatureTest {
    public static void main(String[] args) {
        User user = new User();
        user.setId(11L);
        user.setCreateTime(new Date());
        String jsonString = JSON.toJSONString(user,SerializerFeature.PrettyFormat);
//        String jsonString = JSON.toJSONString(user, SerializerFeature.PrettyFormat,
//                SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.UseSingleQuotes);
        System.out.println(jsonString);

    }
}
