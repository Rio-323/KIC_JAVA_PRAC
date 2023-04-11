package model;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

public class CustomComboBoxdong extends DefaultComboBoxModel<String>  {
private ArrayList<String> items = new ArrayList<>();
	
	public CustomComboBoxdong() {
		items.add("CLERK");
		items.add("SALESMAN");
		items.add("MANAGER");
		items.add("PRESIDENT");
	}
	
	public int getSize() {
		return items.size();
	}

	@Override
	public String getElementAt(int index) {
		return items.get(index);
	}
}
