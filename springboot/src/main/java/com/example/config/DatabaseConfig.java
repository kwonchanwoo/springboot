package com.example.config;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan(basePackages = "com.example.dao",
			sqlSessionFactoryRef = "sqlSessionFactory"
)
@EnableTransactionManagement
public class DatabaseConfig {

	
	  @Bean 
	  public SqlSessionFactory sqlSessionFactory (DataSource dataSource,ApplicationContext applicationContext) throws Exception { 
		  SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
		 
		  factory.setDataSource(dataSource);
			/*
			 * factory.setMapperLocations(applicationContext.getResources(
			 * "classpath:mapper/*.xml"));
			 */
			/* sqlSessionFactory.setTypeAliasesPackage("com.example.vo"); */
		  org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
		  configuration.setMapUnderscoreToCamelCase(true);
		  configuration.setJdbcTypeForNull(null);
		  return factory.getObject(); 
	  }
	  
	  @Bean public SqlSessionTemplate sqlSession (SqlSessionFactory sqlSessionFactory) {
	  
	  return new SqlSessionTemplate(sqlSessionFactory); }
	 
}
