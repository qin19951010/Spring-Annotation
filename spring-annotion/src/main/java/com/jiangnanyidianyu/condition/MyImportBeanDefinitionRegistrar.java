package com.jiangnanyidianyu.condition;

import com.jiangnanyidianyu.bean.RainBow;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        /*
            annotationMetadata:当前类的注解信息
            beanDefinitionRegistry:BeanDefinition注册类
                把所有需要添加到容器中的Bean;调用
                BeanDefinitionRegistry.RegistryBeanDefinition手工注册进来
        */
        boolean definition = beanDefinitionRegistry.containsBeanDefinition("com.jiangnanyidianyu.bean.Red");
        boolean definition1 = beanDefinitionRegistry.containsBeanDefinition("com.jiangnanyidianyu.bean.Blue");
        if(definition && definition1)
        {
            //指定Bean定义信息(Bean的类型和作用域)
            RootBeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
            //指定Bean名
            beanDefinitionRegistry.registerBeanDefinition("rainBow  ", beanDefinition);
        }
    }
}
