package mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SqlMapperInter {
	
	@Select("select now() as now")
	public abstract String selectNow();
}
