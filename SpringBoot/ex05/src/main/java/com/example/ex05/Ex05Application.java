package com.example.ex05;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Ex05Application implements CommandLineRunner {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(Ex05Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mappers/mapper.xml"));
		
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		
		System.out.println(sqlSession);
		
		String result = sqlSession.selectOne("select");
		System.out.println("result : " + result);
	}

}
