import javax.swing.AbstractListModel;

public class CusomListModel extends AbstractListModel<String> {
	private String[] items = new String[] {"사과", "참외", "수박", "딸기"};

	@Override
	public int getSize() {
		return items.length;
	}

	@Override
	public String getElementAt(int index) {
		return items[index];
	}

}
