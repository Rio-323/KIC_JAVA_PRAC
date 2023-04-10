import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCEx16 {
	public static void main(String[] args) {
		// 우편번호 CSV -> DB변환
		// database 명 -> project
		// user password : project / 1234
		
		// create user project@localhost identified by '1234'; -> root
		// create user project@'%' identified by '1234'; -> root
		// grant all privileges on *. * to project@localhost; -> root
		// create database project -> project
		// use project;
//		create table zipcode (
//				zipcode char(7) not null,
//				sido varchar(4) not null,
//				gugun varchar(17),
//				dong varchar(26) not null,
//				ri varchar(45) not null,
//				bunji varchar(17) not null,
//				seq int(5) unsigned not null,
//		  		PRIMARY KEY (`seq`)
//				);
		
//		LOAD DATA INFILE '/Users/ksy/Desktop/KIC_JAVA_PRAC/java-workspace/JDBCEx01/src/subject.csv'
//		INTO TABLE zipcode
//		FIELDS TERMINATED BY ','
//		ENCLOSED BY '"'
//		LINES TERMINATED BY '\n'
//		IGNORE 1 ROWS;

		
		
		
		String url = "jdbc:mariadb://localhost:3306/project";
		String user = "project";
		String password = "1234";
		
		Connection conn = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			System.out.println("드라이버 로딩 완료");
			
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("연결 성공");
			
			String sql = "select zipcode, sido, gugun, dong, ri, bunji, seq from zipcode limit 0,5";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "s%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.printf("%s %s %s %s %s %s %s%n",
						rs.getString("zipcode"), rs.getString("sido"),
						rs.getString("gugun"), rs.getString("dong"),
						rs.getString("ri"), rs.getString("bunji"),
						rs.getString("seq")
						);
			}
			
			
		
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


