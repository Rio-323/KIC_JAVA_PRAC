import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCEx08 {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		Connection conn = null;
		
		Statement stmt = null;
		
		ResultSet rs = null;
		
	
		try {
			// 처리로
			Class.forName("org.mariadb.jdbc.Driver");
			
			System.out.println("드라이버 로딩 완료");
			
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("연결 성공");
			
			stmt = conn.createStatement();
			
			String sql = "select * from dept2";
			rs = stmt.executeQuery(sql);
			
			rs.next(); // 처음에는 빈칸을 가리키고 있기 때문에 다음 줄 부터 데이터를 가리키기 위함.
			
			System.out.println(rs.getString("deptno"));
			System.out.println(rs.getString("dname"));
			System.out.println(rs.getString("loc"));
		} catch (ClassNotFoundException e) {
			System.out.println("[Error] : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("[Error] : " + e.getMessage());
		} finally { if(conn != null) if(stmt != null) if(rs != null) try {conn.close(); stmt.close(); rs.close();} catch(SQLException e) {System.out.println("[Error] : " + e.getMessage());}}

	}

}
