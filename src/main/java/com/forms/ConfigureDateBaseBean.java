package com.forms;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.alibaba.druid.pool.DruidDataSource;
@Configuration
public class ConfigureDateBaseBean {
    @Autowired
    private Environment env;
    
    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl( env.getProperty( "spring.datasource.url" ) );
        dataSource.setUsername( env.getProperty( "spring.datasource.username" ) );//
        dataSource.setPassword( env.getProperty( "spring.datasource.password" ) );//
        dataSource.setInitialSize( 5 );
        dataSource.setMaxActive( 25 );
        dataSource.setMinIdle( 5 );
        // 配置获取连接等待超时的时
        dataSource.setMaxWait( 60000 );
        dataSource.setValidationQuery( "SELECT 1 FROM DUAL" );
        dataSource.setTestOnBorrow( true );
        dataSource.setTestWhileIdle( true );
        dataSource.setPoolPreparedStatements( false );
        // 配置间隔多久才进行一次检测，测需要关闭的空闲连接，单位是毫秒
        dataSource.setTimeBetweenEvictionRunsMillis( 60000 );
        // 配置个连接在池中小生存的时间，单位是毫秒
        dataSource.setMinEvictableIdleTimeMillis( 300000 );
        dataSource.setDriverClassName( env.getProperty( "spring.datasource.driver.className" ) );
        return dataSource;
    }
}
