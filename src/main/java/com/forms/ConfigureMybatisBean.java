package com.forms;

import javax.sql.DataSource;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan ( basePackages = {"com.forms.wl.mapper" } )
public class ConfigureMybatisBean {
    @Autowired
    private DataSource dataSource;
    
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource( dataSource );
//        sqlSessionFactoryBean.setPlugins( new Interceptor[] { paginationInterceptor() } );
        
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations( resolver.getResources( "classpath:/sqlmapper/*.xml" ) );
        
        return sqlSessionFactoryBean.getObject();
    }
    
    @Bean ( "sqlSessionTemplate" )
    public SqlSessionTemplate getSqlSessionTemplate() throws Exception {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate( sqlSessionFactory() , ExecutorType.SIMPLE , null );
        return sqlSessionTemplate;
    }
    
    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager( dataSource );
    }
  
}