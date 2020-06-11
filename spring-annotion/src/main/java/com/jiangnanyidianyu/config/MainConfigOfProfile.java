package com.jiangnanyidianyu.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/*
    Profile:
        Spring为我们提供的可以根据当前环境,动态的激活和切换一系列组件的功能

        开发环境,测试环境,生产环境;
        例如数据源:开发连(A数据库),测试连(B数据库),生产连(C数据库);

 */
@Configuration
public class MainConfigOfProfile {
    public DataSource dataSource()
    {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser("");
        dataSource.setPassword("");
        //dataSource.getJdbcUrl("jdbc//:3306");
        return null;
    }
}
