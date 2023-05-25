package com.exam.spring03.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.exam.spring04.model.BoardTO;

@Configuration
@Scope("prototype")
public class BeanConfig {
	
	// setter 주입
	@Bean
	public BoardTO boardTO() {
		BoardTO to = new BoardTO();
		to.setSeq(1);
		to.setSubject("제목1");
		
		return to;
	}
}
