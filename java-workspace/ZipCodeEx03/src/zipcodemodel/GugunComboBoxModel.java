package zipcodemodel;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

import model.ZipCodeDAO;
import model.ZipCodeDTO;

public class GugunComboBoxModel extends DefaultComboBoxModel<String> {
	private ArrayList<ZipCodeDTO> guguns;
	
	public GugunComboBoxModel() {
		guguns = new ArrayList<>();
		
		ZipCodeDTO to = new ZipCodeDTO();
		to.setGugun("구 / 군");
		guguns.add(to);
	}
	
	public GugunComboBoxModel(String strSido) {
		ZipCodeDAO dao = new ZipCodeDAO();
		guguns = dao.listGugun(strSido);
	}

	@Override
	public int getSize() {
		return guguns.size();
	}

	@Override
	public String getElementAt(int index) {
		ZipCodeDTO to = guguns.get(index);
		return to.getGugun();
	}
}
