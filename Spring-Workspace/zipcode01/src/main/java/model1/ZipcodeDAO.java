package model1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ZipcodeDAO {
	
	@Autowired
	private DataSource dataSource;
	
	public ArrayList<ZipcodeTO> zipcodeList(String strDong) {
		ArrayList<ZipcodeTO> datas = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			conn = this.dataSource.getConnection();
			
			String sql = "select zipcode, sido, gugun, dong, ri, bunji from zipcode where dong like ?";
			pstmt = conn.prepareStatement( sql );
			pstmt.setString(1, "%" + strDong + "%");
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				ZipcodeTO to = new ZipcodeTO();
				
				to.setZipcode(rs.getString("zipcode"));
				to.setSido(rs.getString("sido"));
				to.setGugun(rs.getString("gugun"));
				to.setDong(rs.getString("dong"));
				to.setRi(rs.getString("ri"));
				to.setBunji(rs.getString("bunji"));
				
				datas.add(to);
			}
			
		} catch( SQLException e ) {
			System.out.println( "[에러] " + e.getMessage() );
		} finally {
			if( pstmt != null ) try {pstmt.close(); } catch(SQLException e) {}
			if( conn != null ) try {conn.close(); } catch(SQLException e) {}
			if( rs != null ) try{rs.close();}  catch(SQLException e) {}
		}
		return datas;
	}
}
