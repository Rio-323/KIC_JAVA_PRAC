import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

public class CustomComboBoxModel extends DefaultComboBoxModel<String> {
	private ArrayList<String> items = new ArrayList<>();
	
	public CustomComboBoxModel() {
		// 초기화
		items.add("사과");
		items.add("참외");
		items.add("수박");
		items.add("딸기");
	}
	
	public int getSize() {
		// System.out.println("getSize");
		return items.size();
	}
	
	// 데이터 내용
	@Override
	public String getElementAt(int index) {
		// System.out.println("getElementAt");
		return items.get(index);
	}
}
