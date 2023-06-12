package com.example.model;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.config.AlbumMapperInter;

@Repository
@MapperScan( basePackages = { "com.example.config" } )
public class AlbumDAO {

	@Autowired
	private AlbumMapperInter mapper;
	
	public void hitUpdate(int seq) {
		mapper.hitUpdate(seq);
	}
	
	public ArrayList<AlbumTO> albumList() {
		ArrayList<AlbumTO> albumLists = (ArrayList)mapper.albumList();
		return albumLists;
	}
	
	public AlbumTO getAlbum(int seq) {
		AlbumTO album = mapper.getAlbum(seq);
		return album;
	}
	
	public int updateAlbum(AlbumTO album) {
		int result = mapper.updateAlbum(album);
		return result;
	}
	
	public int albumWriteOk(AlbumTO to) {
		int flag = 1;
		
		int result = mapper.albumWriteOk( to );
		
		if( result == 1 ) {
			flag = 0;
		}
       
		return flag;
	}
	
}
