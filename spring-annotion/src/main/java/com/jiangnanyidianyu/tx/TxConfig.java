package com.jiangnanyidianyu.tx;

/*
    声明式事务:
    环境搭建:
    1.导入相关依赖
        数据源、数据库驱动、Spring-jdbc模块
    2.配置数据源和JdbcTemplate(Spring提供简化数据库操作的工具)操作数据
    3.给方法上标注@Transactional,表示当前方法是一个事务方法;
    4.@EnableTransactionManagement开启基于注解的事务管理功能
        @EnableXXX
    5.配置事务管理器来控制事务
 */

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.awt.dnd.DropTarget;
import java.beans.PropertyVetoException;

@EnableTransactionManagement
@ComponentScan("com.jiangnanyidianyu.tx")
@Configuration
public class TxConfig {

    //数据源
    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("qzl19950819..");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() throws PropertyVetoException {
        //Spring对@Configuration类会特殊处理;给容器中加组件的方法,多次调用都只是丛容器中找组件
        JdbcTemplate template = new JdbcTemplate(dataSource());
        return template;
    }

    //注册事务管理器在容器中
    @Bean
    public PlatformTransactionManager transactionManager() throws PropertyVetoException {
        //事务管理器一定要先控制数据源
        return new DataSourceTransactionManager(dataSource());
    }
}
