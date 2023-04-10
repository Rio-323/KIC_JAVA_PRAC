package model;
import java.util.ArrayList;
import javax.swing.AbstractListModel;


public class EmpListModel extends AbstractListModel<String> {
	private ArrayList<EmpDTO> items;
	
	public EmpListModel(String eName) {
		EmpDAO dao = new EmpDAO(); // 데이터베이스 connection
		this.items = dao.searchEmp(eName);
	}

	@Override
	public int getSize() {
		return items.size();
	}

	@Override
	public String getElementAt(int index) {
		EmpDTO to = items.get(index);
		
		String employee = String.format("[%s] %s %s %s %s %s",
						to.getEmpno(), to.getEname(), to.getDeptno(), to.getSal(), to.getHiredate(), to.getMgr());
		return employee;
	}
	

}
