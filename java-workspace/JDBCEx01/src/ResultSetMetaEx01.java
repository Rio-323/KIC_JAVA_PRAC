import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ResultSetMetaEx01 {
public static void main(String[] args) {
		
		String url = "jdbc:mariadb://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 사용 DB이름과 버전 알아내는 코드
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			conn = DriverManager.getConnection(url, user, password);
			
			String sql = "select * from emp";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ResultSetMetaData rsmd = rs.getMetaData();
			
			// column의 개수
			// System.out.println(rsmd.getColumnCount());
			
			for (int i = 1; i < rsmd.getColumnCount(); i++) {
				System.out.print(rsmd.getColumnName(i) + "\t");
				System.out.print(rsmd.getColumnTypeName(i) + "\t");
				System.out.println(rsmd.getPrecision(i));
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("[Error] : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("[Error] : " + e.getMessage());
		} finally { 
			if (conn != null) { try { conn.close(); } catch (SQLException e) { System.out.println("[Error] : " + e.getMessage());  }}
			if (pstmt != null) { try { pstmt.close(); } catch (SQLException e) { System.out.println("[Error] : " + e.getMessage());  }}
			if (rs != null) { try { rs.close(); } catch (SQLException e) { System.out.println("[Error] : " + e.getMessage());  }}
		}
	}
}



