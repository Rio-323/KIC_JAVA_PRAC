import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCEx10 {
	public static void main(String[] args) {
		
		// 10번 부서의 사원번호, 사원이름, 급여, 연봉을 출력하는 프로그램 작
		String url = "jdbc:mysql://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		Connection conn = null;
		
		Statement stmt = null;
		
		ResultSet rs = null;
		

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			System.out.println("드라이버 로딩 완료");
			
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("연결 성공");
			
			stmt = conn.createStatement();
			
			String sql = "select empno, ename, sal, sal * 12 + ifnull(comm, 0) annsal from emp";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				// System.out.println(rs.getShort(1));
				// System.out.println(rs.getShort(2));
				// System.out.println(rs.getShort(3));
				// System.out.println(rs.getShort(4));
				
				System.out.println(rs.getString("empno"));
				System.out.println(rs.getString("ename"));
				System.out.println(rs.getString("sal"));
				System.out.println(rs.getString("annsal"));
				System.out.println();
			}
		} catch (ClassNotFoundException e) {
			System.out.println("[Error] : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("[Error] : " + e.getMessage());
		} finally { if(conn != null) if(stmt != null) if(rs != null) try {conn.close(); stmt.close(); rs.close();} catch(SQLException e) {System.out.println("[Error] : " + e.getMessage());}}
	

	}
}



