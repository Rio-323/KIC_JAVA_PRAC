package com.example.ex06;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfiguration {
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Bean
	SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		System.out.println("sqlSessionFactory(DataSource dataSource) 호출");
		
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mappers/mapper.xml"));
		
		return sqlSessionFactoryBean.getObject();
	}
	
	@Bean
	SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		System.out.println("sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) 호출");
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
