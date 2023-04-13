import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetworkEx01 {

	public static void main(String[] args) {
		// IP정보 <- 도메인
		// network <- java.net
		try {
			InetAddress inetAddress1 = InetAddress.getByName("www.naver.com");
			System.out.println(inetAddress1.getHostAddress());
			System.out.println(inetAddress1.getHostName());
			
			InetAddress[] inetAddresses = InetAddress.getAllByName("www.naver.com");
			
			for(InetAddress inetAddress : inetAddresses) {
				System.out.println(inetAddress.getHostAddress());
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
