package com.gzticc.ssmspringbootdemo.config.dao;

import com.gzticc.ssmspringbootdemo.properties.JdbcProperty;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;

@Configuration
//配置mybatis mapper的扫描路径
@MapperScan("com.gzticc.ssmspringbootdemo.mapper")
public class DataSourceConfiguration {
    @Autowired
    private JdbcProperty jdbcProperty;

    @Bean(name = "dataSource")
    public ComboPooledDataSource createDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(jdbcProperty.getDriver());
        dataSource.setJdbcUrl(jdbcProperty.getUrl());
        dataSource.setUser(jdbcProperty.getUserName());
        dataSource.setPassword(jdbcProperty.getPassword());
        //关闭连接后不自动自动提交(commit)
        dataSource.setAutoCommitOnClose(false);
        //其他设置以后设置如最大连接数
        return dataSource;
    }
}
