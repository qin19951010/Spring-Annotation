package com.jiangnanyidianyu.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

//名字默认是类名首字母小写的方式
@Repository
public class BookDao {
    private String label = "1";

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "BookDao{" +
                "label='" + label + '\'' +
                '}';
    }
}
