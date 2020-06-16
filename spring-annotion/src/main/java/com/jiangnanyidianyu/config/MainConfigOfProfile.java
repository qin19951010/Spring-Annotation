package com.jiangnanyidianyu.config;

import com.jiangnanyidianyu.bean.Yellow;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/*
    Profile:指定组件在哪个环境的情况下才能被注册到容器中,不指定,任何环境下都能注册这个组件
        Spring为我们提供的可以根据当前环境,动态的激活和切换一系列组件的功能

        开发环境,测试环境,生产环境;
        例如数据源:开发连(A数据库),测试连(B数据库),生产连(C数据库);

    1).加了环境标识的bean,只有这个环境被激活的时候才能注册到容器中,默认是default环境
    2).@Profile写在配置类上,只有是指定的环境的时候,整个配置类里面的所有的配置才能开始生效
    3).没有标注环境标识的bean在任何环境下都是加载的;
 */

//EmbeddedValueResolverAware 值解析器

//复习三种属性赋值方法
//@Profile("test")
@PropertySource("classpath:/dbconfig.properties")
@Configuration
public class MainConfigOfProfile implements EmbeddedValueResolverAware {

    @Value("${db.user}")
    private String user;

    private StringValueResolver valueResolver;

    private String driverClass;

    @Bean
    public Yellow yellow()
    {
        return new Yellow();
    }

    @Profile("test") //标识可以任意写
    @Bean("testDataSource")
    public DataSource dataSourceTest(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);                                 //数据库账号
        dataSource.setPassword(pwd);                    //数据库密钥
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");  //数据库连接地址

        dataSource.setDriverClass(driverClass);         //设置驱动

        return dataSource;
    }

    @Profile("dev") //标识可以任意写
    @Bean("devDataSource")
    public DataSource dataSourceDev(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);                                 //数据库账号
        dataSource.setPassword(pwd);                    //数据库密钥
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/dev");  //数据库连接地址

        dataSource.setDriverClass(driverClass);         //设置驱动

        return dataSource;
    }

    @Profile("prod") //标识可以任意写
    @Bean("prodDataSource")
    public DataSource dataSourceProd(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);                                 //数据库账号
        dataSource.setPassword(pwd);                    //数据库密钥
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/prod");  //数据库连接地址

        dataSource.setDriverClass(driverClass);         //设置驱动

        return dataSource;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        this.valueResolver = stringValueResolver;
        driverClass = valueResolver.resolveStringValue("${db.driverClass}");
    }
}
