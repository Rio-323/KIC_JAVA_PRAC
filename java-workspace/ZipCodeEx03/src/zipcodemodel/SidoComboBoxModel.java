package zipcodemodel;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

import model.ZipCodeDAO;
import model.ZipCodeDTO;

public class SidoComboBoxModel extends DefaultComboBoxModel<String> {
	private ArrayList<ZipCodeDTO> sidos;
	
	public SidoComboBoxModel() {
//		sidos = new ArrayList<>();
//		ZipCodeDTO to = new ZipCodeDTO();
//		to.setSido("시 / 도");
//		sidos.add(to);
		
		ZipCodeDAO dao = new ZipCodeDAO();
		sidos = dao.listSido();
	}

	@Override
	public int getSize() {
		return sidos.size();
	}

	@Override
	public String getElementAt(int index) {
		ZipCodeDTO to = sidos.get(index);
		return to.getSido();
	}
	
}
