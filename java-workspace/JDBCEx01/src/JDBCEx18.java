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

public class JDBCEx18 {
    public static void main(String[] args) {

    	String url = "jdbc:mariadb://localhost:3306/project";
        String user = "project";
        String password = "1234";

        Connection conn = null;

        PreparedStatement pstmt = null;

        ResultSet rs = null;

        BufferedReader br = null;
        BufferedReader br1 = null;

        try {
            Class.forName("org.mariadb.jdbc.Driver");

            System.out.println("드라이버 로딩 완료");

            conn = DriverManager.getConnection(url, user, password);
            System.out.println("연결 성공");

            br = new BufferedReader(new FileReader("/Users/ksy/Desktop/KIC_JAVA_PRAC/java-workspace/JDBCEx01/src/subject.csv"));
            br1 = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("찾고 싶은 동이름 : ");

            String dongName = br1.readLine();

            String str = "";
            while ((str = br.readLine()) != null) {

                if (str.contains(dongName)) {

                    String sql = "select zipcode, sido, gugun, dong, ri, bunji, seq from zipcode where dong like ?";
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, "%" + dongName + "%");
                    rs = pstmt.executeQuery();

                    while (rs.next()) {
                        System.out.printf("%s %s %s %s %s %s %s%n", rs.getString("zipcode"), rs.getString("sido"),
                                rs.getString("gugun"), rs.getString("dong"), rs.getString("ri"), rs.getString("bunji"),
                                rs.getString("seq"));
                    }

                    break; // 동명이 있는 경우 찾았으면 루프 중단

                } else if (dongName.equals("exit")) {
                    System.out.println("프로그램 종료");
                    System.exit(0);
                }
            }

        } catch (ClassNotFoundException e) {
            System.out.println("[Error] : " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("[Error] : " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("[Error] : " + e.getMessage());
        } catch (IOException e) {
            System.out.println("[Error] : " + e.getMessage());
        } finally {
            if (conn != null) {try {conn.close();} catch (SQLException e) {System.out.println("[Error] : " + e.getMessage());}}
            if (pstmt != null) try {pstmt.close();} catch (SQLException e) {System.out.println("[Error] : " + e.getMessage());}}
            if (br != null) {try {br.close();} catch (IOException e) {System.out.println("[Error] : " + e.getMessage());}}
            if (br1 != null) {try {br1.close();} catch (IOException e) {System.out.println("[Error] : " + e.getMessage());}
    	}
    	
	}
}
            
