package model1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mapper.SqlMapperInter;

@Repository
@MapperScan("mapper")
public class JdbcDAO {
	
	@Autowired
	private SqlMapperInter mapper;
	
	public String selectNow() {
		return mapper.selectNow();
	}
}
