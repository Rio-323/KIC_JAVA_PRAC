package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ZipcodeTableModel extends AbstractTableModel {
	private ArrayList<ZipcodeDTO> items;
	private String[] columnNames = new String[] {
			"번호", "우편번호", "시도", "구군", "동", "리", "번지"
	};
	
	public ZipcodeTableModel(String sido, String gugun, String dong) {
		ZipcodeDAO dao = new ZipcodeDAO();
		this.items = dao.searchZipcode(sido, gugun, dong);
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return items.size();
	}
	
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		String result = "";
		ZipcodeDTO to = items.get(rowIndex);
		switch(columnIndex) {
			case 0 : result = to.getSeq(); break;
			case 1 : result = to.getZipcode(); break;
			case 2 : result = to.getSido(); break;
			case 3 : result = to.getGugun(); break;
			case 4 : result = to.getDong(); break;
			case 5 : result = to.getRi(); break;
			default : result = to.getBunji(); break;
		}
		return result;
	}

}
