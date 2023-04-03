import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCEx05 {

	public static void main(String[] args) {
		
		
		String url = "jdbc:mysql://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		Connection conn = null;
		
		Statement stmt = null;
		
	
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			System.out.println("드라이버 로딩 완료");
			
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("연결 성공");
			
			stmt = conn.createStatement();
			
			String deptno = "10";
			String dname = "생산";
			
			String sql = String.format("update dept2 set dname = '%s' where deptno = %s", dname, deptno);
			int result = stmt.executeUpdate(sql);
			
			System.out.println("실행결과 : " + result);
		} catch (ClassNotFoundException e) {
			System.out.println("[Error] : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("[Error] : " + e.getMessage());
		} finally { if(conn != null) if(stmt != null) try {conn.close(); stmt.close();} catch(SQLException e) {System.out.println("[Error] : " + e.getMessage());}}

	}

}
