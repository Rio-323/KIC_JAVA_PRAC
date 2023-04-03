import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCEx03 {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		Connection conn = null;
		
	
		try {
			// 처리로
			Class.forName("org.mariadb.jdbc.Driver");
			
			System.out.println("드라이버 로딩 완료");
			
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("[Error] : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("[Error] : " + e.getMessage());
		} finally { if(conn != null) try {conn.close();} catch(SQLException e) {System.out.println("[Error] : " + e.getMessage());}}
		
		
	}
			
			

}
