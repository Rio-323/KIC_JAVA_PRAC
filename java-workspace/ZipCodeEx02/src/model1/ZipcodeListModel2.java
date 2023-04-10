package model1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.JOptionPane;

public class ZipcodeListModel2 extends AbstractListModel<String> {
	private ArrayList<ZipcodeDTO> items; // 검색된 우편번호가 저장될 저장소
	
	public ZipcodeListModel2(String strDong) {
		ZipcodeDAO dao = new ZipcodeDAO(); // 데이터베이스 connection
		this.items = dao.searchZipcode(strDong);
	}

	@Override
	public int getSize() {
		return items.size();
	}

	@Override
	public String getElementAt(int index) {
		ZipcodeDTO to = items.get(index);
		
		String address = String.format("[%s] %s %s %s %s %s",
						to.getZipcode(), to.getSido(), to.getGugun(), to.getDong(), to.getRi(), to.getBunji());
		return address;
	}
	

}
