package com.exam.spring.model1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDAO {
	private Connection conn;
	
	public BoardDAO() {
		String url = "jdbc:mariadb://localhost:3306/board";
		String user = "board";
		String password = "1234";
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			this.conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("[Error] : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("[Error] : " + e.getMessage());
		}
	}
	
	public ArrayList<String> boardList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<String> lists = new ArrayList();
		
		try {
			String sql = "select * from board limit 0,5";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String data = String.format("%s [%s] %s", rs.getString("seq"), rs.getString("writer"), rs.getString("subject"));
				lists.add(data);
			}
		} catch (SQLException e) {
			System.out.println("[Error] : " + e.getMessage());
		} finally {
			if( rs != null) try {rs.close();} catch(SQLException e) {}
			if( conn != null) try {conn.close();} catch(SQLException e) {}
			if( pstmt != null) try {pstmt.close();} catch(SQLException e) {}
		}
		
		return lists;
	}
}
