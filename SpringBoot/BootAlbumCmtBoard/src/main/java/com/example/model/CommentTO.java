package com.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentTO {
	private String seq;
	private String pseq;
	private String writer;
	private String password;
	private String content;
	private String wdate;
}
