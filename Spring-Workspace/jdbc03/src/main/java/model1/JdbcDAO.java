package model1;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public String selectNow() {
		return sqlSession.selectOne("selectNow");
	}
}
