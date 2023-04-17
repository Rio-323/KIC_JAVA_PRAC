package pack2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClientEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket socket = null;
		BufferedReader br = null;
		
		try {
			System.out.println("서버와 연결을 시작합니다.");
			
			socket = new Socket("localhost", 7777);
			System.out.println("서버와 연결되었습니다.");
			
			br= new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println("메시지 :" + br.readLine());
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(br != null) try {br.close();} catch(IOException e) {}
			if(socket != null) try {socket.close();} catch(IOException e) {}
		}

	}

}
