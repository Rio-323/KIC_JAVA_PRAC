package com.example.ex04;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;

import com.example.model1.ZipcodeDAO;
import com.example.model1.ZipcodeTO;

@SpringBootApplication
@ComponentScan({"com.example.model1"})
public class Ex04Application implements CommandLineRunner {
	
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private ZipcodeDAO dao;

	public static void main(String[] args) {
		SpringApplication.run(Ex04Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		String strDong = "대치";
		
		String sql = "select zipcode, sido, gugun, dong, ri, bunji from zipcode where dong like ?";
		
		ArrayList<ZipcodeTO> lists = (ArrayList<ZipcodeTO>)jdbcTemplate.query(sql, new BeanPropertyRowMapper<ZipcodeTO>(ZipcodeTO.class), strDong + "%");
		
		System.out.println("갯수 : " + lists.size());
		
		for(ZipcodeTO to : lists) {
			System.out.println(to.getZipcode());
			System.out.println(to.getSido());
		}
		*/
		
		System.out.println("DAO : " + dao);
		// System.out.println("DAO : " + dao.zipcodeLists("개포"));
		
		ArrayList<ZipcodeTO> lists = dao.zipcodeLists("대치");
		
		for(ZipcodeTO to : lists) {
			System.out.println(to.getZipcode());
			System.out.println(to.getSido());
		}
		
	}

}
