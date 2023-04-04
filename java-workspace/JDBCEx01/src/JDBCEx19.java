import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCEx19 {
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
			
			String sql = "select * from emp";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
//			while(rs.next()) {
//				System.out.printf("%s %s %s %s %s %s %s%n",
//						rs.getString("empno"), rs.getString("ename"),
//						rs.getString("sal"), rs.getString("job")
//						);
//			}
			
			rs.absolute(1);
			System.out.printf("%s %s %s %s%n", rs.getString("empno"), rs.getString("ename"),
					rs.getString("sal"), rs.getString("job"));
			
			System.out.println("행 번호 : " + rs.getRow());
			
			rs.absolute(10);
			System.out.printf("%s %s %s %s%n", rs.getString("empno"), rs.getString("ename"),
					rs.getString("sal"), rs.getString("job"));
			
			System.out.println("행 번호 : " + rs.getRow());
			
			// select count(*) from emp
			rs.next();
			System.out.println("행 번호 : " + rs.getRow());
			
			// 커서의 초기화 상태
			rs.beforeFirst();
			
		
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





