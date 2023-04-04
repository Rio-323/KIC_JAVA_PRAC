import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCEx13 {
	public static void main(String[] args) {
		
		String url = "jdbc:mariadb://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		Connection conn = null;
		
		PreparedStatement pstmt = null;
		

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			System.out.println("드라이버 로딩 완료");
			
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("연결 성공");
			
			String sql = "delete from dept2 where deptno = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "10");
			
			int result = pstmt.executeUpdate();
			System.out.println("실행 완료 : " + result);
			
		
		} catch (ClassNotFoundException e) {
			System.out.println("[Error] : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("[Error] : " + e.getMessage());
		} finally { 
			if (conn != null) { try { conn.close();} catch (SQLException e) { System.out.println("[Error] : " + e.getMessage());}}
		    if (pstmt != null) { try { pstmt.close();} catch (SQLException e) { System.out.println("[Error] : " + e.getMessage());}}
		}
	

	}
}



