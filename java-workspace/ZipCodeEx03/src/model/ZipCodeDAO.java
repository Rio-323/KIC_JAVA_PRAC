package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ZipCodeDAO {
	private Connection conn;
	
	public ZipCodeDAO() {
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
	
	public ArrayList<ZipCodeDTO> listSido() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<ZipCodeDTO> sidos = new ArrayList<>();
		try {
			String sql = "select distinct sido from zipcode;";
			pstmt = this.conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ZipCodeDTO to = new ZipCodeDTO();
				to.setSido(rs.getString("sido"));
				sidos.add(to);
			}
		} catch (SQLException e) {
			System.out.println("[Error] : " + e.getMessage());
		} finally {
			if(rs != null) { try { rs.close(); } catch(SQLException e) { System.out.println("[Error] : " + e.getMessage()); } }
			if(pstmt != null) { try { pstmt.close(); } catch(SQLException e) { System.out.println("[Error] : " + e.getMessage()); } }
			if(conn != null) { try { conn.close(); } catch(SQLException e) { System.out.println("[Error] : " + e.getMessage()); } }
		}
		return sidos;
	}
	
	public ArrayList<ZipCodeDTO> listGugun(String strsido) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<ZipCodeDTO> guguns = new ArrayList<>();
		try {
			String sql = "select distinct gugun from zipcode where sido = ?;";
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, strsido);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ZipCodeDTO to = new ZipCodeDTO();
				to.setGugun(rs.getString("gugun"));
				guguns.add(to);
			}
		} catch (SQLException e) {
			System.out.println("[Error] : " + e.getMessage());
		} finally {
			if(rs != null) { try { rs.close(); } catch(SQLException e) { System.out.println("[Error] : " + e.getMessage()); } }
			if(pstmt != null) { try { pstmt.close(); } catch(SQLException e) { System.out.println("[Error] : " + e.getMessage()); } }
			if(conn != null) { try { conn.close(); } catch(SQLException e) { System.out.println("[Error] : " + e.getMessage()); } }
		}
		return guguns;
	}

	public ArrayList<ZipCodeDTO> listDong(String strSido, String strGugun) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<ZipCodeDTO> dongs = new ArrayList<>();
		try {
			String sql = "select distinct dong from zipcode where sido = ? and gugun = ?;";
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, strSido);
			pstmt.setString(2, strGugun);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ZipCodeDTO to = new ZipCodeDTO();
				to.setDong(rs.getString("dong"));
				dongs.add(to);
			}
		} catch (SQLException e) {
			System.out.println("[Error] : " + e.getMessage());
		} finally {
			if(rs != null) { try { rs.close(); } catch(SQLException e) { System.out.println("[Error] : " + e.getMessage()); } }
			if(pstmt != null) { try { pstmt.close(); } catch(SQLException e) { System.out.println("[Error] : " + e.getMessage()); } }
			if(conn != null) { try { conn.close(); } catch(SQLException e) { System.out.println("[Error] : " + e.getMessage()); } }
		}
		return dongs;
	}

	public ArrayList<ZipCodeDTO> listAddress(String strSido, String strGugun, String strDong) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<ZipCodeDTO> addresses = new ArrayList<>();
		try {
			String sql = "select seq, zipcode, sido, gugun, dong, ri, bunji from zipcode where sido = ? and gugun = ? and dong = ?;";
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, strSido);
			pstmt.setString(2, strGugun);
			pstmt.setString(3, strDong);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ZipCodeDTO to = new ZipCodeDTO();
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
