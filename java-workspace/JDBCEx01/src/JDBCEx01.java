
public class JDBCEx01 {

	public static void main(String[] args) {
		try {
			
			// Connector 제공 업체에서 알 수 있음.
			Class.forName("org.mariadb.jdbc.Driver");
			
			System.out.println("드라이버 로딩 완료");
		} catch (ClassNotFoundException e) {
			System.out.println("[Error] : " + e.getMessage());
		}
	}

}
