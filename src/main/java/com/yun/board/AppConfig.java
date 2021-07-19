package com.yun.board;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@MapperScan("com.yun.board.dao")
@PropertySource("classpath:/com/yun/board/conf/security.properties")
public class AppConfig {
    
    @Autowired
    Environment env;

    public AppConfig(){
        System.out.println("AppConfig 실행");
    }
    
    @Bean(destroyMethod="close")
    public DataSource dataSource() {
      System.out.println("DataSource 객체 생성!");

      BasicDataSource ds = new BasicDataSource();
      ds.setDriverClassName(env.getProperty("jdbc.driver"));
      ds.setUrl(env.getProperty("jdbc.url"));
      ds.setUsername(env.getProperty("jdbc.username"));
      ds.setPassword(env.getProperty("jdbc.password"));
      ds.setDefaultAutoCommit(false);

      return ds;
    }
    
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource,ApplicationContext applicationContext) {
        System.out.println("sqlSessionFactory 객체 생성.");
        
        try {
            SqlSessionFactoryBean factory= new SqlSessionFactoryBean();
            factory.setDataSource(dataSource);
            
            factory.setTypeAliasesPackage("com.yun.board.domain");
            
            factory.setMapperLocations(applicationContext.getResources("classpath://com/yun/board/mapper/**/*.xml") );
            
            return factory.getObject();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        
    }
}
