package com.jiangnanyidianyu.config;

import com.jiangnanyidianyu.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

//使用PropertySource加载外部配置文件中的K/V保存到运行的环境变量中

//@PropertySources指定多个配置文件
@PropertySource(value = {"classpath:/person.properties"})
@Configuration
public class MainConfigOfPropertyValues {

    @Bean
    public Person person()
    {
        return new Person();
    }
}
