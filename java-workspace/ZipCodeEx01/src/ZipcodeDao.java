import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ZipcodeDao {
	// Data Access Object
	
	private Connection conn;
	
	public ZipcodeDao() {
		// 데이터 베이스 접속과 관련된 내용
		
		
		
		String url = "jdbc:mariadb://localhost:3306/project";
		String user = "project";
		String password = "1234";
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			this.conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("[Error] : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("[Error] : " + e.getMessage());
		}
		
	}
	
	
	public ArrayList<ZipcodeDto> searchZipcode(String dongName) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ZipcodeDto> addresses = new ArrayList<>();
		
		try {
			String sql = "select zipcode, sido, gugun, dong, ri, bunji from zipcode where dong like ?";
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, "%" + dongName + "%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ZipcodeDto dto = new ZipcodeDto();
				dto.setZipCode(rs.getString("zipcode"));
				dto.setSido(rs.getString("sido"));
				dto.setGugun(rs.getString("gugun"));
				dto.setDong(rs.getString("dong"));
				dto.setRi(rs.getString("ri"));
				dto.setBunji(rs.getString("bunji"));
				
				addresses.add(dto);
			}
		} catch (SQLException e) {
			System.out.println("[Error] : " + e.getMessage());
		} finally {
			if (conn != null) { try { conn.close();} catch (SQLException e1) { System.out.println("[Error] : " + e1.getMessage());}}
		    if (pstmt != null) { try { pstmt.close();} catch (SQLException e1) { System.out.println("[Error] : " + e1.getMessage());}}
		    if (rs != null) { try { rs.close();} catch (SQLException e1) { System.out.println("[Error] : " + e1.getMessage());}}
		}
		
		return addresses;
	}
}
