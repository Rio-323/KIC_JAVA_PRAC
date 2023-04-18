package model;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

import team.TeamDAO;
import team.TeamDTO;

public class TeamComboModel extends DefaultComboBoxModel<Object> {
	ArrayList<TeamDTO> teams = new ArrayList<TeamDTO>();
	
	public TeamComboModel() {
		TeamDAO dao = new TeamDAO();
		teams = dao.selectTeam();
	}
	
	@Override
	public int getSize() {
		return teams.size();
	}

	@Override
	public Object getElementAt(int index) {
		String resultTeam = teams.get(index).getTeamCode() + "(" + teams.get(index).getTeamName() + ")";
		return resultTeam;
	}
}
