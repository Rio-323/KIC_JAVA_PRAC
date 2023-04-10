import javax.swing.table.AbstractTableModel;

public class CustomTableModel1 extends AbstractTableModel {
	private String[][] items = new String[][] {
		{"11", "12", "13", "14", "15"},
		{"21", "22", "23", "24", "25"},
		{"31", "32", "33", "34", "35"},
		{null, null, null, null, null},
	};
	
	private String[] columNames = {
			"col1", "col2", "col3", "col4", "col5"
	};
	
	@Override
	public String getColumnName(int column) {
		return columNames[column];
	}
	
	@Override
	public int getRowCount() {
		return items.length;
	}

	@Override
	public int getColumnCount() {
		return items[0].length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return items[rowIndex][columnIndex];
	}

}
