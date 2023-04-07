import javax.swing.SpinnerListModel;

public class CustomSpinnerListModel extends SpinnerListModel {
	public CustomSpinnerListModel() {
		super(new String[] {"사과", "참외", "수박", "딸기"});
	}
}
