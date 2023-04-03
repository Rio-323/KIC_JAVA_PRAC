import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCEx09 {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		Connection conn = null;
		
		Statement stmt = null;
		
	
		try {
			// 처리로
			Class.forName("org.mariadb.jdbc.Driver");
			
			System.out.println("드라이버 로딩 완료");
			
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("연결 성공");
			
			stmt = conn.createStatement();
			
			// DDL
			// String sql = "create table dept3 ( deptno int(2), dname varchar(14), loc varchar(13))";
			
			StringBuilder sbSQL = new StringBuilder();
			sbSQL.append("create table dept3 (" );
			sbSQL.append("deptno int(2)," );
			sbSQL.append("dname varchar(14)," );
			sbSQL.append("loc varchar(13)" );
			sbSQL.append(")");
			
			int result = stmt.executeUpdate(sbSQL.toString());
			
			System.out.println("실행결과 : " + result);
		} catch (ClassNotFoundException e) {
			System.out.println("[Error] : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("[Error] : " + e.getMessage());
		} finally { if(conn != null) if(stmt != null) try {conn.close(); stmt.close();} catch(SQLException e) {System.out.println("[Error] : " + e.getMessage());}}

	}

}
