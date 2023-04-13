
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkEx02 {

	public static void main(String[] args) {
		// URL
		String strUrl = "https://search.naver.com/search.naver?where=nexearch&sm=top_sug.mbk&fbm=1&acr=1&acq=%EB%A3%A8%EC%9D%B4%EC%8A%A4+%ED%8F%B4%EC%84%BC+%EC%8A%A4%ED%85%90%EB%93%9C&qdt=0&ie=utf8&query=%EB%A3%A8%EC%9D%B4%EC%8A%A4%ED%8F%B4%EC%84%BC+%EC%8A%A4%ED%83%A0%EB%93%9C";
		
		try {
			URL url = new URL(strUrl);
			System.out.println(url.getProtocol());
			System.out.println(url.getHost());
			System.out.println(url.getPort());
			System.out.println(url.getPath());
			System.out.println(url.getQuery());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
