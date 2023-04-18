package player;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SoccerDAO {
	private Connection conn;
	private ArrayList<SoccerDTO> players = new ArrayList<SoccerDTO>();
	private ArrayList<SoccerDTO> players_6 = new ArrayList<SoccerDTO>();
	
	
	public SoccerDAO() {
		String url = "jdbc:mariadb://localhost:3306/subject";
		String user = "project";
		String password = "1234";
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			this.conn = DriverManager.getConnection(url, user, password);
		} catch(ClassNotFoundException e) {
			System.out.println("[Error] : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("[Error] : " + e.getMessage());
		}
	}
	
	public void insertPlayer() {
		try {
			BufferedReader br = new BufferedReader( new FileReader( "/Users/ksy/Desktop/KIC_JAVA_PRAC/java-workspace/Subject/src/player.csv" ) );
			String address;
			
			String sql = "insert into player(playerNo, teamCode, playerName, playerHeight, playerBirth, playerWeight, playerPosition, playerBackNo) values(?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			
			while((address = br.readLine()) != null) {
				String[] addresses = address.split(",");
				pstmt.setInt(1, Integer.parseInt(addresses[0]));
				pstmt.setString(2, addresses[1]);
				pstmt.setString(3, addresses[2]);
				pstmt.setString(4, addresses[3]);
				pstmt.setString(5, addresses[4]);
				pstmt.setString(6, addresses[5]);
				pstmt.setString(7, addresses[6]);
				pstmt.setInt(8, Integer.parseInt(addresses[7]));
				ResultSet rs = pstmt.executeQuery();
				if ( rs != null ) rs.close();
			}
			
			if ( pstmt != null ) pstmt.close();
			if ( conn != null ) conn.close();
		} catch (NumberFormatException e) {
			System.out.println("[Error] : " + e.getMessage());
		} catch (FileNotFoundException e) {
			System.out.println("[Error] : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("[Error] : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("[Error] : " + e.getMessage());
		}
	}
	
	public ArrayList<SoccerDTO> searchPlayer (String playerName) {
		
		try {
			String sql = "select playerNo, teamCode, playerName, playerHeight, playerBirth, playerWeight, playerPosition, playerBackNo from player where playerName like ?";
			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, "%" + playerName + "%");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				SoccerDTO to = new SoccerDTO();
				to.setPlayerNo(rs.getString("playerNo"));
				to.setTeamCode(rs.getString("teamCode"));
				to.setPlayerName(rs.getString("playerName"));
				to.setPlayerHeight(rs.getString("playerHeight"));
				to.setPlayerBirth(rs.getString("playerBirth"));
				to.setPlayerWeight(rs.getString("playerWeight"));
				to.setPlayerPosition(rs.getString("playerPosition"));
				to.setPlayerBackNo(rs.getString("playerBackNo"));
				players.add(to);
			}
			if( rs != null ) rs.close();
			if( pstmt != null ) pstmt.close();
			if( conn != null ) conn.close();
			
		} catch (SQLException e) {
			System.out.println("[Error] : " + e.getMessage());
		} catch (NullPointerException e) {
			System.out.println("[Error] : " + e.getMessage());
		}
		
		return players;
	}
	
	public void deletePlayer(int playerNum) {
		try {
			String sql = "delete from player where playerNo = ?";
			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(1, playerNum);
			ResultSet rs = pstmt.executeQuery();
			
			if( rs != null ) rs.close();
			if( pstmt != null ) pstmt.close();
			if( conn != null ) conn.close();
		} catch (SQLException e) {
			System.out.println("[Error] : " + e.getMessage());
		}
	}
	
	
	public ArrayList<SoccerDTO> searchPlayer_6(Integer pNumber) {
		try {
			String sql = "select playerNo, teamCode, playerName, playerHeight, playerBirth, playerWeight, playerPosition, playerBackNo from player where playerNo = ?";
			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(1, pNumber);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				SoccerDTO to = new SoccerDTO();
				to.setPlayerNo(rs.getString("playerNo"));
				to.setTeamCode(rs.getString("teamCode"));
				to.setPlayerName(rs.getString("playerName"));
				to.setPlayerHeight(rs.getString("playerHeight"));
				to.setPlayerBirth(rs.getString("playerBirth"));
				to.setPlayerWeight(rs.getString("playerWeight"));
				to.setPlayerPosition(rs.getString("playerPosition"));
				to.setPlayerBackNo(rs.getString("playerBackNo"));
				players_6.add(to);
			}
			if( rs != null ) rs.close();
			if( pstmt != null ) pstmt.close();
			if( conn != null ) conn.close();
		} catch (SQLException e) {
			System.out.println("[Error] : " + e.getMessage());
		}
		
		return players_6;
	}
}
