package controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import model1.EmpDAO;
import model1.EmpTO;
import model1.JdbcDAO;


@Controller
public class ConfigController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private JdbcDAO dao;
	
	@Autowired
	private EmpDAO dao1;
	
	@RequestMapping("/jdbc1.do")
	public String jdbc1() {
		
//		System.out.println("jdbc1() 호출 : " + sqlSession);
//		String result = sqlSession.selectOne("selectNow");
//		System.out.println("현재시간1 : " + result);
		
		System.out.println("현재시간2 : " + dao.selectNow());
		
		return "jdbc1";
	}
	
	@RequestMapping("/jdbc2.do")
	public String jdbc2() {
		
		List<EmpTO> lists = dao1.selectEname();
		for(EmpTO to : lists) {
			System.out.println(to.getEmpno() + " / " + to.getEname() + " / " + to.getJob() + " / " + to.getMgr() + " / " + to.getHiredate() + " / " + to.getSal() + " / " + to.getComm() + " / " + to.getDeptno());
		}
	
		
		return "jdbc2";
	}
	
}
