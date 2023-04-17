package pack3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClientEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket socket = null;		
		BufferedWriter bw = null;
		
		
		try {
			System.out.println("서버와 연결을 시작합니다.");			
			socket = new Socket("localhost", 7777);
			System.out.println("서버와 연결되었습니다.");
			
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"));
			//bw.write("안녕 서버 1" + System.lineSeparator());
			//bw.write("안녕 서버 2" + System.lineSeparator());
			//bw.write("안녕 서버 3" + System.lineSeparator());
			
			bw.write("안녕 서버1: 안녕서버2: 안녕서버3" +System.lineSeparator());
			
			System.out.println("전송 완료");
		
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(bw != null) try {bw.close();} catch(IOException e) {}
			if(socket != null) try {socket.close();} catch(IOException e) {}
		}

	}

}
