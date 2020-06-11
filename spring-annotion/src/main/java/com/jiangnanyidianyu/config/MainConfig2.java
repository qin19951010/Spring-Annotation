package com.jiangnanyidianyu.config;

import com.jiangnanyidianyu.bean.Color;
import com.jiangnanyidianyu.bean.ColorFactoryBean;
import com.jiangnanyidianyu.bean.Person;
import com.jiangnanyidianyu.bean.Red;
import com.jiangnanyidianyu.condition.MyImportBeanDefinitionRegistrar;
import com.jiangnanyidianyu.condition.MyImportSelector;
import com.jiangnanyidianyu.condition.WindowsCondition;
import org.springframework.context.annotation.*;

//类中组件统一设置。满足当前条件,这个类内配置的所有bean注册才会生效
@Conditional({WindowsCondition.class})
@Configuration
//导入组件,id默认是组件的全类名
@Import({Color.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class MainConfig2 {

    //默认是单实例的
    /*
        prototype:多实例的 IOC容器启动不会调用方法创建对象放在容器中。
                  每次获取的时候才会调用方法创建对象
        singleton:单例(默认值) IOC容器启动会调用方法创建对象放到IOC容器中。
                  以后每次获取就是直接丛容器(map.get())中拿,
        request:同一次请求创建一个实例
        session:同一个session创建一个实例

        @Scope：调整作用域

        懒加载@Lazy：
              单实例bean：默认在容器启动的时候创建对象；
              懒加载：容器启动先不创建对象。第一次使用(获取)Bean创建对象,并初始化
     */
    //@Scope(value = "prototype")
    @Lazy
    @Bean(value = "person")
    public Person person()
    {
        System.out.println("给容器中添加person.....");
        return new Person("QZL",18);
    }

    /*
      @Conditional({Condition}) ：按照一定的条件进行判断,满足条件给容器中注册bean
       ** Springboot中底层大量使用
       如果是Windows系统,给容器中注册("bill")
       如果是linux系统,给容器中注册("linus")
     */
    //@Conditional({WindowsCondition.class})
    @Bean("bill")
    public Person person01()
    {
        return new Person("BillGates",62);
    }

    //@Conditional({LinuxCondition.class})
    @Bean("linus")
    public Person person02()
    {
        return new Person("linus",48);

    }

   /*
     给容器中注册组件
     1.包扫描+组件标注注解(@Controller/@Service/@Repository/@Component)[具有局限性,自己写的类]
     2.@Bean[导入的第三方包里面的组件]
     3.@Import[快速给容器中导入一个组件]
        1).@Import(要导入到容器中的组件)；容器中就会自动注册这个组件,id默认是全类名
     ***2).ImportSelector:返回需要导入的组件的全类名数组
        3).ImportBeanDefinitionRegistrar:手动注册Bean到容器中
     4.使用Spring提供的FactoryBean(工厂Bean);
        1).默认获取到的是工厂bean调用getObject创建的对象
        2).要获取Bean本身,我们需要给id前面加一个&标识
           &colorFactoryBean
   */

   @Bean
   public ColorFactoryBean colorFactoryBean()
   {
       return new ColorFactoryBean();
   }
}
