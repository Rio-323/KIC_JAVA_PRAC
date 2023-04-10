package pack1;

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
	
	public ArrayList<EmpDTO> listEmp() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<EmpDTO> items = new ArrayList<>();
		
		try {
			String sql = "select empno, ename, job, mgr, hiredate, sal, ifnull(comm, 0) as comm, deptno from emp;";
			pstmt = this.conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			    EmpDTO to = new EmpDTO();
			    
			    to.setEmpno(rs.getString("empno"));
			    to.setEname(rs.getString("ename"));
			    to.setJob(rs.getString("job"));
			    to.setMgr(rs.getString("mgr"));
			    to.setHiredate(rs.getString("hiredate"));
			    to.setSal(rs.getString("sal"));
			    to.setComm(rs.getString("comm"));
			    to.setDeptno(rs.getString("deptno"));

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
