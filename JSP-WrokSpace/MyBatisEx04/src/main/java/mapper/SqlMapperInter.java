package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import model1.DeptTO;

public interface SqlMapperInter {
	
	@Select("select deptno, dname, loc from dept where deptno = 10")
	public DeptTO selectByDeptno();
	
	@Select("select deptno, dname, loc from dept")
	public List<DeptTO> selectList();
}
