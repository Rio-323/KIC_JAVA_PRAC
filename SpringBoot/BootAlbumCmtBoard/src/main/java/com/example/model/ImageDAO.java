package com.example.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Update;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.config.ImageMapperInter;

@Repository
@MapperScan( basePackages = { "com.example.config" } )
public class ImageDAO {
	
	@Autowired
	private ImageMapperInter mapper;
	
	public ArrayList<ImageTO> imageLatestList() {
		ArrayList<ImageTO> imageLists = (ArrayList)mapper.imageLatestList();
		return imageLists;
	}
	
	public ImageTO getImage(int seq) {
		ImageTO image = mapper.getImage(seq);
		return image;
	}
	
	public int updateImage(ImageTO imageTO) {
		int result = mapper.updateImage(imageTO);
		return result;
	}

	public ArrayList<ImageTO> imageAllList() {
		ArrayList<ImageTO> imageLists = (ArrayList)mapper.imageAllList();
		return imageLists;
	}

	
	public int imageWriteOk(ImageTO to) {
		int flag = 1;
		
		int result = mapper.imageWriteOk( to );
		
		if( result == 1 ) {
			flag = 0;
		}
       
		return flag;
	}
}
