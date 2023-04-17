package pack7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerEx01 {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		BufferedWriter bw = null;
		BufferedReader br = null;
		
		
		try {
			//1포트는 1개의 프로그램만 사용가능
			serverSocket = new ServerSocket(7777);
			
			while(true) {
				try {
					System.out.println("서버가 준비되었습니다.");
					
					//프로그램 대기
					socket = serverSocket.accept();
					System.out.println("클라이언트가 연결되었습니다.");
					br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
					bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));
					
					String msg = br.readLine();
					System.out.println("메시지 : " + msg);
					
					bw.write(msg + System.lineSeparator());
					
					// 전송완료라는 뜻
					bw.flush();
					System.out.println("전송이 완료되었습니다.");
				
				} catch (IOException e) {
					System.out.println("[Error] : " + e.getMessage());
				} finally {
					if(br != null) try { br.close();} catch (Exception e) { System.out.println("[Error] : " + e.getMessage());}
					if(bw != null) try { bw.close();} catch (Exception e) { System.out.println("[Error] : " + e.getMessage());}
					if(socket != null) try { socket.close();} catch (Exception e) { System.out.println("[Error] : " + e.getMessage());}
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(socket != null) try {socket.close();} catch(IOException e) {}
			if(serverSocket != null) try {serverSocket.close();} catch(IOException e) {}
		}

	}

}
