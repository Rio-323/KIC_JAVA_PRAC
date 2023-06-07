package com.example.ex03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Ex03Application implements CommandLineRunner {
	
//	@Autowired
//	private DataSource dataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(Ex03Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println("Hello Spring Boot : " + dataSource);
	
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		try {
//			conn = this.dataSource.getConnection();
//			
//			String sql = "select now() as now";
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) {
//				System.out.println("현재시간 : " + rs.getString("now"));
//			}
//		
//		} catch (SQLException e) {
//			System.out.println("[Error] : " + e.getMessage());
//		} finally {
//			if(rs != null) try { rs.close(); } catch (SQLException e) { System.out.println("[Error] : " + e.getMessage()); }
//			if(conn != null) try { conn.close(); } catch (SQLException e) { System.out.println("[Error] : " + e.getMessage()); }
//			if(pstmt != null) try { pstmt.close(); } catch (SQLException e) { System.out.println("[Error] : " + e.getMessage()); }
//		}
		
		System.out.println("Hello Spring Boot : " + jdbcTemplate);
		
		// String result = jdbcTemplate.queryForObject("select now() as now", String.class);
		
		// System.out.println("현재시간 : " + result);
		
		List<String> lists = jdbcTemplate.queryForList("show databases", String.class);
		
		for(String data : lists) {
			System.out.println(data);
		}
	}

}
