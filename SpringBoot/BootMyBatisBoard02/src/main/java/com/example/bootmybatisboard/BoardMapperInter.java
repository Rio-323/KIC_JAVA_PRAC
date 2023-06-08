package com.example.bootmybatisboard;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.model.BoardTO;

@Mapper
public interface BoardMapperInter {

	@Select( "select seq, subject, writer, date_format(wdate, '%Y-%m-%d') wdate, hit, datediff(now(), wdate) wgap from board1 order by seq desc" )
	public ArrayList<BoardTO> boardList();

	@Insert( "insert into board1 values (0, #{subject}, #{writer}, #{mail}, #{password}, #{content}, 0, #{wip}, now() )" )
	public int boardWriteOk(BoardTO to);
}
