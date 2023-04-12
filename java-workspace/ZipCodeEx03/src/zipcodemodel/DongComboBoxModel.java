package zipcodemodel;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

import model.ZipCodeDAO;
import model.ZipCodeDTO;

public class DongComboBoxModel extends DefaultComboBoxModel<String> {

	private ArrayList<ZipCodeDTO> dongs;
	
	public DongComboBoxModel() {
		dongs = new ArrayList<>();
		
		ZipCodeDTO to = new ZipCodeDTO();
		to.setDong("동");
		dongs.add(to);
	}
	
	public DongComboBoxModel(String strSido, String strGugun) {
		ZipCodeDAO dao = new ZipCodeDAO();
		dongs = dao.listDong(strSido, strGugun);
	}

	@Override
	public int getSize() {
		return dongs.size();
	}

	@Override
	public String getElementAt(int index) {
		ZipCodeDTO to = dongs.get(index);
		return to.getDong();
	}
	
}
