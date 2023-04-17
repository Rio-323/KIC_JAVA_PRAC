package pack9;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ZipcodeServerEx01 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		ServerSocket serverSocket = null;
		Socket socket = null;

		BufferedReader br = null;
		BufferedWriter bw = null;
		
		String url = "jdbc:mariadb://localhost:3306/project";
		String user = "project";
		String password = "1234";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
        
		try {
			serverSocket = new ServerSocket( 7777 );
			while( true ) {
				try {
					System.out.println( "서버 준비되었습니다." );
					socket = serverSocket.accept();
					System.out.println( "클라이언트와 연결되었습니다." );
                        
					br = new BufferedReader( new InputStreamReader( socket.getInputStream(), "utf-8" ) );
					bw = new BufferedWriter( new OutputStreamWriter( socket.getOutputStream(), "utf-8" ) );

					String strDong = br.readLine();

					Class.forName( "org.mariadb.jdbc.Driver" );
					conn = DriverManager.getConnection( url, user, password );
                        
					String sql = "select zipcode, sido, gugun, dong, ri, bunji from zipcode where dong like ?";    
					pstmt = conn.prepareStatement( sql );
					pstmt.setString( 1, strDong+ "%" );
                        
					rs = pstmt.executeQuery();
					StringBuilder addresses = new StringBuilder();
					while( rs.next() ) {
						addresses.append( String.format( "[%s] %s %s %s %s %s", rs.getString( "zipcode" ), rs.getString( "sido" ), rs.getString( "gugun" ), rs.getString( "dong" ), rs.getString( "ri" ), rs.getString( "bunji" ) + ":" ) );
					}
					bw.write( addresses.toString() + System.lineSeparator() );
					bw.flush();
					
					System.out.println( "전송이 완료되었습니다." );
				} catch( ClassNotFoundException e ) {
					// TODO Auto-generated catch block
					System.out.println( "[에러] : " + e.getMessage() );
				} catch( SQLException e ) {
					// TODO Auto-generated catch block
					System.out.println( "[에러] : " + e.getMessage() );
				} catch( NumberFormatException e ) {
					// TODO Auto-generated catch block
					System.out.println( "[에러] : " + e.getMessage() );
				} catch( UnsupportedEncodingException e ) {
					// TODO Auto-generated catch block
					System.out.println( "[에러] : " + e.getMessage() );
				} catch( IOException e ) {
					// TODO Auto-generated catch block
					System.out.println( "[에러] : " + e.getMessage() );
				} finally {
					if( rs != null ) try { rs.close(); } catch( SQLException e ) {}
					if( pstmt != null ) try { pstmt.close(); } catch( SQLException e ) {}
					if( conn != null ) try { conn.close(); } catch( SQLException e ) {}
               
					if( br != null) try { br.close(); } catch( IOException e ) {}
					if( bw != null) try { bw.close(); } catch( IOException e ) {}
					
					if( socket != null) try { socket.close(); } catch( IOException e ) {}
				}
			}
		} catch( IOException e ) {
			System.out.println( "[에러] : " + e.getMessage() );
		} finally {
			if( serverSocket != null ) try { serverSocket.close(); } catch( IOException e ) {}
		}
	}
}

