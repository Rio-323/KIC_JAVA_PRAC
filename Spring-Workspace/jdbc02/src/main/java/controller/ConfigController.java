package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import model1.DeptTO;
import model1.EmpTO;
import model1.ExampleDAO;

@Controller
public class ConfigController {
	
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private ExampleDAO dao;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@RequestMapping("/write1.do")
	public String write1() {
		// System.out.println("write1 : " + jdbcTemplate);
		
		// MyBatis와 유사
		// insert, update, delete -> update
		// select 개수에 따라
		// 		1개 - queryForXX() / 여러개 query(), queryForList(); 
		
		// 1행 1열
//		String result = jdbcTemplate.queryForObject("select now() as now", String.class);
//		
//		System.out.println("결과 : " + result);
		
		System.out.println("결과 : " + dao.selectNow());
		
		
		return "writeview1";
	}
	
	@RequestMapping("/write2.do")
	public String write2() {
		// 1행 data = DTO
		
		// Statement
		// DeptTO to = jdbcTemplate.queryForObject("select * from dept where deptno = 10", new BeanPropertyRowMapper<DeptTO>(DeptTO.class));
		
		// PreparedStatement
		// DeptTO to = jdbcTemplate.queryForObject("select * from dept where deptno = ?", new BeanPropertyRowMapper<DeptTO>(DeptTO.class), "20");
		
		// DeptTO to = jdbcTemplate.queryForObject("select * from dept where deptno = ?", new Object[] {"30"}, new BeanPropertyRowMapper<DeptTO>(DeptTO.class));
		
		DeptTO to = jdbcTemplate.queryForObject("select * from dept where deptno = ?", new Object[] {"30"}, new RowMapper<DeptTO>() {
			@Override
			public DeptTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				DeptTO to = new DeptTO();
				to.setDeptno(rs.getString("deptno"));
				to.setDname(rs.getString("dname"));
				to.setLoc(rs.getString("loc"));
				return to;
			}
		});
		
		System.out.println(to.getDeptno() + " / " + to.getDname() + " / " + to.getLoc());
		
		return "writeview1";
	}
	
	
	@RequestMapping("/write3.do")
	public String write3() {
		// 여러행 data
		List<DeptTO> lists = jdbcTemplate.query("select * from dept", new BeanPropertyRowMapper<DeptTO>(DeptTO.class));
		
		for(DeptTO to : lists) {
			System.out.println(to.getDeptno() + " / " + to.getDname() + " / " + to.getLoc());
		}
		
		return "writeview1";
	}
	
	@RequestMapping("/write4.do")
	public String write4() {
		// 여러행 data
		
		/*
		List<EmpTO> lists = jdbcTemplate.query("select * from emp where deptno = ? and job = ?", new BeanPropertyRowMapper<EmpTO>(EmpTO.class), "30", "salesman");
		
		for(EmpTO to : lists) {
			System.out.println(to.getEmpno() + " / " + to.getEname() + " / " + to.getJob() + " / " + to.getMgr() + " / " + to.getHiredate() + " / " + to.getSal() + " / " + to.getComm() + " / " + to.getDeptno());
		}
		*/
		
		List<EmpTO> lists = jdbcTemplate.query("select * from emp where ename like ?", new BeanPropertyRowMapper<EmpTO>(EmpTO.class), "s%");
		for(EmpTO to : lists) {
			System.out.println(to.getEmpno() + " / " + to.getEname() + " / " + to.getJob() + " / " + to.getMgr() + " / " + to.getHiredate() + " / " + to.getSal() + " / " + to.getComm() + " / " + to.getDeptno());
		}
		
		return "writeview1";
	}
	
	@RequestMapping("/write5.do")
	public String write5() {
		
		// int result = jdbcTemplate.update("insert into dept2 values(11, '연구부', '서울')");
		int result = jdbcTemplate.update("insert into dept2 values(?, ?, ?)", "11", "연구부", "서울");
		
		System.out.println("결과 : " + result);
		
		return "writeview1";
	}
	
}
