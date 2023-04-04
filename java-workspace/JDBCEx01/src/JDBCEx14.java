import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCEx14 {
	public static void main(String[] args) {
		
		String url = "jdbc:mariadb://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		Connection conn = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			System.out.println("드라이버 로딩 완료");
			
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("연결 성공");
			
			String sql = "select empno, ename, sal, job from emp where deptno =?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "20");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.printf("%s %s %s %s%n",
						rs.getString("empno"), rs.getString("ename"),
						rs.getString("sal"), rs.getString("job"));
			}
			
			
		
		} catch (ClassNotFoundException e) {
			System.out.println("[Error] : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("[Error] : " + e.getMessage());
		} finally { 
			if (conn != null) { try { conn.close();} catch (SQLException e) { System.out.println("[Error] : " + e.getMessage());}}
		    if (pstmt != null) { try { pstmt.close();} catch (SQLException e) { System.out.println("[Error] : " + e.getMessage());}}
		    if (rs != null) { try { rs.close();} catch (SQLException e) { System.out.println("[Error] : " + e.getMessage());}}
		}
	

	}
}



