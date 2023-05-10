package model1;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DeptDAO {
	private SqlSession sqlSession;
	
	public DeptDAO() {
		String resource = "myBatisConfig.xml";
		
		InputStream is = null;
		
		try {
			
			is = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
			
			this.sqlSession = sqlSessionFactory.openSession(true);
			
			
		} catch (IOException e) {
			System.out.println("[Error] : " + e.getMessage());
		} finally {
			if(is != null) { try { is.close(); } catch (IOException e) { System.out.println("[Error] : " + e.getMessage()); } }
		}
	}
	
	public List<DeptTO> selectList() {
		List<DeptTO> lists = sqlSession.selectList("selectlist");
		if(sqlSession != null) {
			sqlSession.close();
		}
		
		return lists;
	}
}
