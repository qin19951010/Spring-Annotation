package com.jiangnanyidianyu.config;

/*
    bean的生命周期:
        bean的创建---初始化---销毁的过程
    容器管理bean的生命周期;
    可以自定义初始化和销毁方法;容器在bean进行到当前生命周期的时候来调用我们自定义的初始化和销毁方法

    构造(对象创建)
        单实例:在容器启动的时候创建对象
        多实例:在每次获取的时候创建对象

    BeanPostProcessor.postProcessBeforeInitialization
    初始化:
        对象创建完成,并赋值好,调用初始化...
    BeanPostProcessor.postProcessAfterInitialization
    销毁:
        单实例:容器关闭
        多实例:容器不会管理这个Bean;容器不会调用销毁方法



    1).指定初始化和销毁方法;
        相当于XML配置中的属性init-method和destroy-method
        通过@Bean指定init-method和destroy-method
    2).通过Bean实现InitializingBean(定义初始化逻辑)
       通过Bean实现DisposableBean(定义销毁逻辑)
    3).JSR250;
        @PostConstruct:在bean创建完成并且属性赋值完成;来执行初始化方法
        @PreDestroy:在容器销毁bean之前通知清理工作
    4).BeanPostProcessor[interface]:Bean的后置处理器;
        在bean初始化前后进行一些处理工作;
        1.postProcessBeforeInitialization:在初始化之前工作
        2.postProcessAfterInitialization:在初始化之后工作

    Spring底层对BeanPostProcessor的使用
        bean赋值,注入组件,@Autowired,生命周期注解功能,@Async,xxx  BeanPostProcessor;
 */

import com.jiangnanyidianyu.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("com.jiangnanyidianyu")
@Configuration
public class MainConfigOfLifeCycle {
    @Bean(initMethod = "init",destroyMethod = "destroy")
    public Car car(){
        return new Car();
    }
}
