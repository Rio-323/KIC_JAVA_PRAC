import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCEx19 {
	public static void main(String[] args) {
		
		String url = "jdbc:mariadb://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		Connection conn = null;
		
		// 사용 DB이름과 버전 알아내는 코드
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			conn = DriverManager.getConnection(url, user, password);
			
			DatabaseMetaData dmd = conn.getMetaData();
			
			System.out.println(dmd.getDatabaseProductName());
			System.out.println(dmd.getDatabaseProductVersion());
		} catch (ClassNotFoundException e) {
			System.out.println("[Error] : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("[Error] : " + e.getMessage());
		} finally { if (conn != null) { try { conn.close(); } catch (SQLException e) { System.out.println("[Error] : " + e.getMessage());  }}}
	}
}



