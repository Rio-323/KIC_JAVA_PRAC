import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkEx07 {

	public static void main(String[] args) {
		// 바이트 단위를 가져올 수 없음 -> BufferedInputStream / BufferedOutputStream
		// https://img1.daumcdn.net/thumb/S308x188a.q80/?fname=https%3A%2F%2Ft1.daumcdn.net%2Fnews%2F202304%2F13%2Fyonhap%2F20230413121550523sdkr.jpg
		 BufferedInputStream bis = null;
		 BufferedOutputStream bos = null;
		
		try {

			HttpURLConnection conn = (HttpURLConnection)new URL("https://img1.daumcdn.net/thumb/S308x188a.q80/?fname=https%3A%2F%2Ft1.daumcdn.net%2Fnews%2F202304%2F13%2Fyonhap%2F20230413121550523sdkr.jpg").openConnection();
			
			bis = new BufferedInputStream(conn.getInputStream());
			bos = new BufferedOutputStream(new FileOutputStream("./daum.png"));
			int data = 0;

			while((data = bis.read()) != -1) {
				bos.write(data);
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally { 
			if(bis != null) { try { bis.close(); } catch (IOException e) { e.printStackTrace(); }}
			if(bos != null) { try { bos.close(); } catch (IOException e) { e.printStackTrace(); }}
		}
	}
}
