package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
	private boolean idCheck = false;
	private Connection conn = null;
	
	public LoginDAO() {
		String url = "jdbc:mariadb://localhost:3306/subject";
		String user = "project";
		String password = "1234";
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			this.conn = DriverManager.getConnection(url, user, password);
		} catch(ClassNotFoundException e) {
			System.out.println("[Error] : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("[Error] : " + e.getMessage());
		}
	}
	
	public boolean searchId(String id, String pw) throws SQLException {
		String sql = "select userId, userPassword from user";
		PreparedStatement pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			if(rs.getString("userId").equals(id)) {
				if(rs.getString("userPassword").equals(pw)) {
					idCheck = true;
				}
			}
		}
		if( rs != null ) rs.close();
		if( pstmt != null ) pstmt.close();
		if( conn != null ) conn.close();
		
		return idCheck;
	}
	
	public boolean checkId(String id) throws SQLException {
		String sql = "select userId from user";
		PreparedStatement pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			if(rs.getString("userId").equals(id)) {
				idCheck = true;
			}
		}
		
		if( rs != null ) rs.close();
		if( pstmt != null ) pstmt.close();
		if( conn != null ) conn.close();
		
		return idCheck;
	}
	
	public void createUser(String id, String pw, String name, String gender, String birth, String phone) throws SQLException {
		String sql = "insert into user values(?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = this.conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		pstmt.setString(3, name);
		pstmt.setString(4, gender);
		pstmt.setString(5, birth);
		pstmt.setString(6, phone);
		
		ResultSet rs = pstmt.executeQuery();
		if( rs != null ) rs.close();
		if( pstmt != null ) pstmt.close();
		if( conn != null ) conn.close();
	}
	
	public void insertPlayer(String teamCode, String playerName, String playerHeight, String playerBirth, String playerWeight, String playerPosition, String playerBackNo) throws SQLException {
		int lastNum = 0;
		String sqlNum = "select playerNo from player order by playerName desc limit 1";
		PreparedStatement pstmt = this.conn.prepareStatement(sqlNum);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			lastNum = rs.getInt(1) + 1;
		}
		rs.close();
		pstmt.close();
		
		
		String sql = "insert into player(playerNo, teamCode, playerName, playerHeight, playerBirth, playerWeight, playerPosition, playerBackNo) values(?, ?, ?, ?, ?, ?, upper(?), ?)";
		PreparedStatement pstmt1 = this.conn.prepareStatement(sql);
		pstmt1.setInt(1, lastNum);
		pstmt1.setString(2, teamCode);
		pstmt1.setString(3, playerName);
		pstmt1.setString(4, playerHeight + "cm");
		pstmt1.setString(5, playerBirth);
		pstmt1.setString(6, playerWeight + "kg");
		pstmt1.setString(7, playerPosition);
		pstmt1.setInt(8, Integer.parseInt(playerBackNo));
		
		ResultSet rs1 = pstmt1.executeQuery();
		if( rs1 != null ) rs1.close();
		pstmt1.close();
		if( conn != null ) conn.close();
	}
	
	public void updatePlayer(Integer playerNo, String teamCode, String playerName, String playerHeight, String playerBirth, String playerWeight, String playerPosition, String playerBackNo) throws SQLException {
		String sql = "update player set playerNo = ?, playerName = ?, playerHeight = ?, playerBirth = ?, playerWeight = ?, playerPosition = ?, playerBackNo = ? where playerNo = ?";
		PreparedStatement pstmt = this.conn.prepareStatement(sql);
		pstmt.setString(1, teamCode);
		pstmt.setString(2, playerName);
		pstmt.setString(3, playerHeight);
		pstmt.setString(4, playerBirth);
		pstmt.setString(5, playerWeight);
		pstmt.setString(6, playerPosition);
		pstmt.setString(7, playerBackNo);
		pstmt.setInt(8, playerNo);
		
		ResultSet rs = pstmt.executeQuery();
		if( rs != null ) rs.close();
		if( pstmt != null ) pstmt.close();
		if( conn != null ) conn.close();
	}
}
