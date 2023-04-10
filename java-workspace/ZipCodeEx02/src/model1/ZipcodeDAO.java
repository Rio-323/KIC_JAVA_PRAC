package model1;

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
	
	public ArrayList<ZipcodeDTO> searchZipcode(String strDong) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<ZipcodeDTO> addresses = new ArrayList<>();
		
		try {
			String sql = "select zipcode, sido, gugun, dong, ri, bunji from where dong like ?";
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, "%" + strDong + "%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ZipcodeDTO to = new ZipcodeDTO();
				
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
