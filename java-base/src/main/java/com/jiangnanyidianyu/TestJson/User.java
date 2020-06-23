package com.jiangnanyidianyu.TestJson;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
/*
*   1.JSONField可以配置在属性上面进行key值命名
*   2.JSONField可以配置在setter/getter方法上为key值命名
*/
public class User {
    //@JSONField(name = "myid")
    //指定属性不序列化
    @JSONField(serialize=false,deserialize = false)
    private Long id;

    private String name;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    //@JSONField(name = "myid")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JSONField(name = "myname")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
