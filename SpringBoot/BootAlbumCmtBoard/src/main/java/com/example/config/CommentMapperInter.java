package com.example.config;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.model.CommentTO;

public interface CommentMapperInter {
			
	@Select("select pseq, writer, content, wdate from album_cmt_comment2 where pseq = #{seq}")
	public ArrayList<CommentTO> getList(int seq);

	@Insert("insert into album_cmt_comment2 values(0, #{pseq}, #{writer}, #{password}, #{content}, now() )")
	@Options( useGeneratedKeys=true, keyProperty="seq" )
	public int commentOK(CommentTO to);
}
