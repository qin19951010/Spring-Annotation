package com.jiangnanyidianyu.bean;

import org.springframework.beans.factory.FactoryBean;

//创建一个Spring定义的FactoryBean
public class ColorFactoryBean implements FactoryBean<Color> {
    //返回一个Color对象,这个对象会添加到容器中
    public Color getObject() throws Exception {
        return new Color();
    }

    public Class<?> getObjectType() {
        return Color.class;
    }

    //是不是单例
    //返回true:这个bean是单实例,容器中只会保存一份
    //如果是false:多实例,每次获取都会创建一个新的Bean
    public boolean isSingleton() {
        return false;
    }
}
