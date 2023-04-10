package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class EmpTableModel extends AbstractTableModel {
	private ArrayList<EmpDTO> items;
	private String[] columnNames = new String[] {
			"사원번호", "사원이름", "관리자 번호", "입사일자", "급여", "보너스", "부서"
	};
	
	public EmpTableModel(String eName) {
		EmpDAO dao = new EmpDAO();
		this.items = dao.listEmp(eName);
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return items.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}
	
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		String result = "";
		EmpDTO to = items.get(rowIndex);
		switch(columnIndex) {
		case 0 : result = to.getEmpno(); break;
		case 1 : result = to.getEname(); break;
		case 2 : result = to.getMgr(); break;
		case 3 : result = to.getHiredate(); break;
		case 4 : result = to.getSal(); break;
		case 5 : result = to.getComm(); break;
		default : result = to.getDname(); break;
		}
		return result;
	}

}
