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
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan("com.yun.board.dao")
@PropertySource("classpath:/com/yun/board/conf/security.properties")
@EnableTransactionManagement
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
    @Bean
    public PlatformTransactionManager transactionManager(
        DataSource dataSource) {
      // 트랜잭션 관리자가 하는 일은 DB 커넥션의 commit과 rollback을 다루는 것이다.
      // 따라서 트랜잭션 관리자는 DB 커넥션을 제공해주는 
      // DataSource(DB 커넥션 풀)가 필요하다.
      // 그래서 트랜잭션 관리자를 만들 때 반드시 DataSource 객체를 넘겨줘야 한다.
      // 물론 관리자 객체를 만든 후에 세터를 호출해서 넘겨줘도 된다.
      return new DataSourceTransactionManager(dataSource);
    }
}
