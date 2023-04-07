import javax.swing.DefaultComboBoxModel;

public class CustomComboBox extends DefaultComboBoxModel<String> {
	private String[] items = new String[] {"사과", "참외", "수박", "딸기"};
	
	// 데이터의 크기
	@Override
	public int getSize() {
		// System.out.println("getSize");
		return items.length;
	}
	
	// 데이터 내용
	@Override
	public String getElementAt(int index) {
		// System.out.println("getElementAt");
		return items[index];
	}
}
