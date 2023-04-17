package pack6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerEx01 {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		
		try {
			//1포트는 1개의 프로그램만 사용가능
			serverSocket = new ServerSocket(7777);
			
			while(true) {
				try {
					System.out.println("서버가 준비되었습니다.");
					
					//프로그램 대기
					socket = serverSocket.accept();
					System.out.println("클라이언트가 연결되었습니다.");
				
				} catch (IOException e) {
					System.out.println("[Error] : " + e.getMessage());
				} finally {
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
