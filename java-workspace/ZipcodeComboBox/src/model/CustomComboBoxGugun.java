package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

public class CustomComboBoxGugun extends DefaultComboBoxModel<String> {

    private ArrayList<String> items = new ArrayList<>();

    public CustomComboBoxGugun(String sido) {

    	String url = "jdbc:mariadb://localhost:3306/project";
		String user = "project";
		String password = "1234";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
    	
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			String sql = "select distinct(gugun) from zipcode where sido like ?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + sido + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
			    items.add(rs.getString("gugun"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			if (conn != null) { try { conn.close();} catch (SQLException e1) { System.out.println("[Error] : " + e1.getMessage());}}
		    if (pstmt != null) { try { pstmt.close();} catch (SQLException e1) { System.out.println("[Error] : " + e1.getMessage());}}
		    if (rs != null) { try { rs.close();} catch (SQLException e1) { System.out.println("[Error] : " + e1.getMessage());}}
		}
    }

    public int getSize() {
        return items.size();
    }

    @Override
    public String getElementAt(int index) {
        return items.get(index);
    }
}