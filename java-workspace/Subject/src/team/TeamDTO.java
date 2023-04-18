package team;

public class TeamDTO {
	private String teamCode;
	private String teamName;
	private String teamCoach;
	private String teamLoc;
	private String teamYear;
	
	public TeamDTO() { }

	public String getTeamCode() {
		return teamCode;
	}

	public void setTeamCode(String teamCode) {
		this.teamCode = teamCode;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTeamCoach() {
		return teamCoach;
	}

	public void setTeamCoach(String teamCoach) {
		this.teamCoach = teamCoach;
	}

	public String getTeamLoc() {
		return teamLoc;
	}

	public void setTeamLoc(String teamLoc) {
		this.teamLoc = teamLoc;
	}

	public String getTeamYear() {
		return teamYear;
	}

	public void setTeamYear(String teamYear) {
		this.teamYear = teamYear;
	}
}
