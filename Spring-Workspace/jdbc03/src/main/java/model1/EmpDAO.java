package model1;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<EmpTO> selectEname() {
		List<EmpTO> lists = sqlSession.selectList("selectEname");
		return lists;
	}
}
