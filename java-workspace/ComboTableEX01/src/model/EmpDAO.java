package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpDAO {
	private Connection conn = null;
	
	public EmpDAO() {
		String url = "jdbc:mariadb://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			this.conn = DriverManager.getConnection(url, user, password);
		} catch(ClassNotFoundException e) {
			System.out.println("[Error] : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("[Error] : " + e.getMessage());
		}
	}
	
	public ArrayList<EmpDTO> listEmp(String eName) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<EmpDTO> items = new ArrayList<>();
		
		try {
			String sql = "SELECT e.empno, e.ename, e.mgr, e.hiredate, e.sal, IFNULL(e.comm, 0) AS comm, d.dname FROM emp e INNER JOIN dept d ON e.deptno = d.deptno WHERE job = ?";
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, eName);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			    EmpDTO to = new EmpDTO();
			    
			    to.setEmpno(rs.getString("empno"));
			    to.setEname(rs.getString("ename"));
			    to.setMgr(rs.getString("mgr"));
			    to.setHiredate(rs.getString("hiredate"));
			    to.setSal(rs.getString("sal"));
			    to.setComm(rs.getString("comm"));
			    to.setDname(rs.getString("dname"));

			    items.add(to);
			    
			}
		} catch (SQLException e) {
			System.out.println("[Error] : " + e.getMessage());
		} finally {
			if(rs != null) { try { rs.close(); } catch(SQLException e) { System.out.println("[Error] : " + e.getMessage()); } }
			if(pstmt != null) { try { pstmt.close(); } catch(SQLException e) { System.out.println("[Error] : " + e.getMessage()); } }
			if(conn != null) { try { conn.close(); } catch(SQLException e) { System.out.println("[Error] : " + e.getMessage()); } }
		}
		
		return items;
	}
}
