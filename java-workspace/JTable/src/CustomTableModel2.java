import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class CustomTableModel2 extends AbstractTableModel {
	private ArrayList<ArrayList<String>> items;
	
	public CustomTableModel2() {
		ArrayList<String> item1 = new ArrayList<>();
		item1.add("11");
		item1.add("12");
		item1.add("13");
		item1.add("14");
		item1.add("15");
		
		ArrayList<String> item2 = new ArrayList<>();
		item2.add("21");
		item2.add("22");
		item2.add("23");
		item2.add("24");
		item2.add("25");
		
		ArrayList<String> item3 = new ArrayList<>();
		item3.add("31");
		item3.add("32");
		item3.add("33");
		item3.add("34");
		item3.add("35");
		
		items = new ArrayList<>();
		items.add(item1);
		items.add(item2);
		items.add(item3);
	}
	
	private String[] columNames = {
			"col1", "col2", "col3", "col4", "col5"
	};
	
	@Override
	public String getColumnName(int column) {
		return columNames[column];
	}
	
	@Override
	public int getRowCount() {
		return items.size();
	}

	@Override
	public int getColumnCount() {
		return items.get(0).size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return items.get(rowIndex).get(columnIndex);
	}

}
