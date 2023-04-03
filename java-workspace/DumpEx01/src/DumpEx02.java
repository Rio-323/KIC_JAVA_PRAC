import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DumpEx02 {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		Connection conn = null;
		
		Statement stmt = null;
		
		ResultSet rs = null;
		
		String tableName = "emp";
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			System.out.println("드라이버 로딩 완료");
			
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("연결 성공");
			
			stmt = conn.createStatement();
			
			String sql = String.format("desc %s", tableName);
			
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				System.out.printf("%s%n", rs.getString("Field"));
			}
		} catch (ClassNotFoundException e) {
			System.out.println("[Error] : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("[Error] : " + e.getMessage());
		} finally { if(conn != null) if(stmt != null) if(rs != null) try {conn.close(); stmt.close(); rs.close();} catch(SQLException e) {System.out.println("[Error] : " + e.getMessage());}}
	

	}

}
