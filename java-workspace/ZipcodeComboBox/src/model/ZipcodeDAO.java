package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ZipcodeDAO {
	private Connection conn = null;
	
	public ZipcodeDAO() {
		String url = "jdbc:mariadb://localhost:3306/project";
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
	
	public ArrayList<ZipcodeDTO> searchZipcode(String sido, String gugun, String dong) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<ZipcodeDTO> addresses = new ArrayList<>();
		
		try {
			String sql = "select seq, zipcode, sido, gugun, dong, ri, bunji from zipcode where sido like ? and gugun like ? and dong like ?;";
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, "%" + sido + "%");
			pstmt.setString(2, "%" + gugun + "%");
			pstmt.setString(3, "%" + dong + "%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			    ZipcodeDTO to = new ZipcodeDTO();
			    
			    to.setSeq(rs.getString("seq"));
			    to.setZipcode(rs.getString("zipcode"));
			    to.setSido(rs.getString("sido"));
			    to.setGugun(rs.getString("gugun"));
			    to.setDong(rs.getString("dong"));
			    to.setRi(rs.getString("ri"));
			    to.setBunji(rs.getString("bunji"));

			    addresses.add(to);
			    
			}
		} catch (SQLException e) {
			System.out.println("[Error] : " + e.getMessage());
		} finally {
			if(rs != null) { try { rs.close(); } catch(SQLException e) { System.out.println("[Error] : " + e.getMessage()); } }
			if(pstmt != null) { try { pstmt.close(); } catch(SQLException e) { System.out.println("[Error] : " + e.getMessage()); } }
			if(conn != null) { try { conn.close(); } catch(SQLException e) { System.out.println("[Error] : " + e.getMessage()); } }
		}
		
		return addresses;
	}
}
