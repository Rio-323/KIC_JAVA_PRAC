import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class CustomTableModel3 extends AbstractTableModel {
	private ArrayList<DataDto> items;
	
	public CustomTableModel3() {
		DataDto to1 = new DataDto();
		to1.setNum1("11");
		to1.setNum2("12");
		to1.setNum3("13");
		to1.setNum4("14");
		to1.setNum5("15");
		
		DataDto to2 = new DataDto();
		to2.setNum1("21");
		to2.setNum2("22");
		to2.setNum3("23");
		to2.setNum4("24");
		to2.setNum5("25");
		
		DataDto to3 = new DataDto();
		to3.setNum1("31");
		to3.setNum2("32");
		to3.setNum3("33");
		to3.setNum4("34");
		to3.setNum5("35");
		
		items = new ArrayList<>();
		items.add(to1);
		items.add(to2);
		items.add(to3);
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
		return 5;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		String result = "";
		DataDto to = items.get(rowIndex);
		switch(columnIndex) {
		case 0 : result = to.getNum1(); break;
		case 1 : result = to.getNum2(); break;
		case 2 : result = to.getNum3(); break;
		case 3 : result = to.getNum4(); break;
		case 4 : result = to.getNum5(); break;
		}
		return result;
	}

}
