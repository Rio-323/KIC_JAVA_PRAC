package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import player.SoccerDAO;
import player.SoccerDTO;

public class _5_PlayerTableNodel extends AbstractTableModel {
	private String[] columnNames = {"선수번호", "팀코드", "선수명", "키", "생년월일", "몸무게", "포지션", "등번호"};
	private ArrayList<SoccerDTO> players;
	
	public _5_PlayerTableNodel(String playerName) {
		SoccerDAO dao = new SoccerDAO();
		players = dao.searchPlayer(playerName);
	}
	
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}
	
	@Override
	public int getRowCount() {
		return players.size();
	}

	@Override
	public int getColumnCount() {
		return 8;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		String result = "";
		SoccerDTO to = players.get( rowIndex );
		switch ( columnIndex ) {
		case 0 : result = to.getPlayerNo(); break;
		case 1 : result = to.getTeamCode(); break;
		case 2 : result = to.getPlayerName(); break;
		case 3 : result = to.getPlayerHeight(); break;
		case 4 : result = to.getPlayerBirth(); break;
		case 5 : result = to.getPlayerWeight(); break;
		case 6 : result = to.getPlayerPosition(); break;
		case 7 : result = to.getPlayerBackNo(); break;
		}
		
		return result;
	}

}
