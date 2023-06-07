package com.example.ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ex02Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Ex02Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String url = "jdbc:mariadb://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			
			System.out.println("연결 성공");
			
			String sql = "select now() as now";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				System.out.println(rs.getString("now"));
			}
		
		} catch (ClassNotFoundException e) {
			System.out.println("[Error] : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("[Error] : " + e.getMessage());
		} finally {
			if(rs != null) try { rs.close(); } catch (SQLException e) { System.out.println("[Error] : " + e.getMessage()); }
			if(conn != null) try { conn.close(); } catch (SQLException e) { System.out.println("[Error] : " + e.getMessage()); }
			if(pstmt != null) try { pstmt.close(); } catch (SQLException e) { System.out.println("[Error] : " + e.getMessage()); }
		}
	}

}
