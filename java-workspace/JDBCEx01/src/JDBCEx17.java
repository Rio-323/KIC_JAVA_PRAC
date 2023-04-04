import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCEx17 {
	public static void main(String[] args) {
		
		String url = "jdbc:mariadb://localhost:3306/project";
		String user = "project";
		String password = "1234";
		
		Connection conn = null;
		
		Statement stmt = null;
		
		BufferedReader br = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			System.out.println("드라이버 로딩 완료");
			
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("연결 성공");
			stmt = conn.createStatement();
			
			br = new BufferedReader(new FileReader("/Users/ksy/Desktop/KIC_JAVA_PRAC/java-workspace/JDBCEx01/src/subject.csv"));
			
			String str = "";
			int count = 0;
			while ((str = br.readLine()) != null) {
                String[] arrZipcode = str.split(",");
                
                String sql = String.format("insert into zipcode values('%s', '%s', '%s', '%s', '%s', '%s', '%s')", 
                		arrZipcode[0], arrZipcode[1], arrZipcode[2] ,arrZipcode[3],
                		arrZipcode[4], arrZipcode[5], arrZipcode[6]);
                
                stmt.executeUpdate(sql);
                count++;
            }
			
			System.out.println("실행완료 : " + count);
			
		
		} catch (ClassNotFoundException e) {
			System.out.println("[Error] : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("[Error] : " + e.getMessage());
		} catch (FileNotFoundException e) {
			System.out.println("[Error] : " + e.getMessage());
		} catch(IOException e) {
			System.out.println("[Error] : " + e.getMessage());
		} finally { 
			if (conn != null) { try { conn.close();} catch (SQLException e) { System.out.println("[Error] : " + e.getMessage());}}
		    if (stmt != null) { try { stmt.close();} catch (SQLException e) { System.out.println("[Error] : " + e.getMessage());}}
		    if (br != null) { try { br.close();} catch (IOException e) { System.out.println("[Error] : " + e.getMessage());}}
		}
	

	}
}



