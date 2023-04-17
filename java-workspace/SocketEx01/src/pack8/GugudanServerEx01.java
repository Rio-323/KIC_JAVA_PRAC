package pack8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class GugudanServerEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			serverSocket = new ServerSocket(7777);
			
			while( true ) {
				try {
					System.out.println( "서버가 준비되었습니다." );
			
					socket = serverSocket.accept();
					System.out.println( "클라이언트가 연결되었습니다." );
					
					br = new BufferedReader( new InputStreamReader( socket.getInputStream(), "utf-8" ) );
					bw = new BufferedWriter( new OutputStreamWriter( socket.getOutputStream(), "utf-8" ) );
					
					//
					String[] arrDans = br.readLine().split( ":" );

					int startDan = Integer.parseInt( arrDans[0] );
					int endDan = Integer.parseInt( arrDans[1] );
					
					StringBuilder sbResult = new StringBuilder();
					for( int i=startDan ; i<=endDan ; i++ ) {
						for( int j=1 ; j<=9 ; j++ ) {
							sbResult.append( i + "X" + j + "=" + ( i * j ) +  "\t" );
						}
						sbResult.append( ":" );
					}

					bw.write( sbResult.toString() + System.lineSeparator() );
					bw.flush();

					System.out.println( "전송이 완료되었습니다." );

					//
				} catch(IOException e ) {
					System.out.println( "[에러] " + e.getMessage() );
				} finally {
					if( br != null ) try { br.close(); } catch( IOException e ) {}
					if( bw != null ) try { bw.close(); } catch( IOException e ) {}
					
					if( socket != null ) try { socket.close(); } catch( IOException e) {}		
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] " + e.getMessage() );
		} finally {
			if( serverSocket != null ) try { serverSocket.close(); } catch( IOException e) {}
		}
	}
}



