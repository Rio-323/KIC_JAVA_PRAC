package model1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ExampleDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public String selectNow() {
		
		String result = jdbcTemplate.queryForObject("select now() as now", String.class);
		
		// System.out.println("결과 : " + result);
		
		return result;
	}
}
