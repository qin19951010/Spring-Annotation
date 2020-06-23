package com.jiangnanyidianyu.TestSerialization;

import java.io.Serializable;

public class Menu implements Serializable {
    private static final long serialVersionUID = -1075318199295234057L;

    private Integer id;
    private String name;
    private String url;

    public Menu() {
    }

    public Menu(Integer id,String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
