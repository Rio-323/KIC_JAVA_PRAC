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
	
	public ArrayList<EmpDTO> searchEmp(String eName) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<EmpDTO> employeees = new ArrayList<>();
		
		try {
			String sql = "select e.empno, e.ename, e.deptno, e.sal, e.hiredate, ifnull(m.ename, '관리자') from emp e left outer join emp m on(e.mgr = m.empno) where e.ename like ?;";
			
			
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, "%" + eName + "%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			    EmpDTO to = new EmpDTO();
			    
			    to.setEmpno(rs.getString("empno"));
			    to.setEname(rs.getString("ename"));
			    to.setDeptno("e.deptno");
			    to.setSal("e.sal");
			    to.setHiredate("e.hiredate");
			    to.setMgr("m.ename");
			    
			    employeees.add(to);
			}
		} catch (SQLException e) {
			System.out.println("[Error] : " + e.getMessage());
		} finally {
			if(rs != null) { try { rs.close(); } catch(SQLException e) { System.out.println("[Error] : " + e.getMessage()); } }
			if(pstmt != null) { try { pstmt.close(); } catch(SQLException e) { System.out.println("[Error] : " + e.getMessage()); } }
			if(conn != null) { try { conn.close(); } catch(SQLException e) { System.out.println("[Error] : " + e.getMessage()); } }
		}
		
		return employeees;
	}
}
