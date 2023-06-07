package com.example.ex07;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.model.ZipcodeDAO;
import com.example.model.ZipcodeTO;

@SpringBootApplication
@ComponentScan({"com.example.model"})
public class Ex07Application implements CommandLineRunner{
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private ZipcodeDAO dao;

	public static void main(String[] args) {
		SpringApplication.run(Ex07Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<ZipcodeTO> lists = dao.zipcodeLists("대치");
		
		System.out.println(lists.size());
	}

}
