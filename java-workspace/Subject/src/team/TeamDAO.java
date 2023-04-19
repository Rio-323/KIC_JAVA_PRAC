package team;

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

public class TeamDAO {
	private Connection conn;
	private ArrayList<TeamDTO> teams = new ArrayList<TeamDTO>();
	
	public TeamDAO() {
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
	
	public void insertTeam() {
		try {
			BufferedReader br = new BufferedReader( new FileReader( "/Users/ksy/Desktop/KIC_JAVA_PRAC/java-workspace/Subject/src/team.csv" ) );
			String team = null;
			
			String sql = "insert into team values(?, ?, ?, ?, ?)";
			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			
			while((team = br.readLine()) != null) {
				String[] teams = team.split(",");
				pstmt.setString(1, teams[0]);
				pstmt.setString(2, teams[1]);
				pstmt.setString(3, teams[2]);
				pstmt.setString(4, teams[3]);
				pstmt.setString(5, teams[4]);
				
				ResultSet rs = pstmt.executeQuery();
				if ( rs != null ) rs.close();
			}
			
			if ( pstmt != null ) pstmt.close();
			if ( conn != null ) conn.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("[Error] : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("[Error] : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("[Error] : " + e.getMessage());
		} 
	}
	
	public ArrayList<TeamDTO> selectTeam() {
		String sql = "select teamCode, teamName from team order by teamCode asc";
		
		try {
			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				TeamDTO to = new TeamDTO();
				to.setTeamCode(rs.getString(1));
				to.setTeamName(rs.getString(2));
				
				teams.add(to);
			}
			if ( rs != null ) rs.close();
			if ( pstmt != null ) pstmt.close();
			if ( conn != null ) conn.close();
		} catch (SQLException e) {
			System.out.println("[Error] : " + e.getMessage());
		}
		
		return teams;
	}
}


