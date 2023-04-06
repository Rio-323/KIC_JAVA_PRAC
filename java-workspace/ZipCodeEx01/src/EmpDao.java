import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpDao {
	// Data Access Object
	
	private Connection conn;
	
	public EmpDao() {
		
		String url = "jdbc:mariadb://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			this.conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("[Error] : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("[Error] : " + e.getMessage());
		}
		
	}
	
	
	public ArrayList<EmpDto> searchEmpcode(String dName) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<EmpDto> employees = new ArrayList<>();
		
		try {
			String sql = "select e.deptno, d.loc, e.empno, e.ename, e.job, e.sal from emp e inner join dept d on d.deptno = e.deptno where d.dname like ? order by e.deptno";
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, "%" + dName + "%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				EmpDto dto = new EmpDto();
				dto.setDeptno(rs.getString("e.deptno"));
				dto.setLoc(rs.getString("d.loc"));
				dto.setEmpno(rs.getString("e.empno"));
				dto.setEname(rs.getString("e.ename"));
				dto.setJob(rs.getString("e.job"));
				dto.setSal(rs.getString("e.sal"));
				
				employees.add(dto);
			}
		} catch (SQLException e) {
			System.out.println("[Error] : " + e.getMessage());
		} finally {
			if (conn != null) { try { conn.close();} catch (SQLException e1) { System.out.println("[Error] : " + e1.getMessage());}}
		    if (pstmt != null) { try { pstmt.close();} catch (SQLException e1) { System.out.println("[Error] : " + e1.getMessage());}}
		    if (rs != null) { try { rs.close();} catch (SQLException e1) { System.out.println("[Error] : " + e1.getMessage());}}
		}
		
		return employees;
	}
}
