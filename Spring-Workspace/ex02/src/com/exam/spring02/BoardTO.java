package com.exam.spring02;

public class BoardTO {
	private int seq;
	private String subject;
	
	public int getSeq() {
		return seq;
	}
	
	public void setSeq(int seq) {
		System.out.println("setSeq(int seq) 호출");
		this.seq = seq;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		System.out.println("setSubject(String subject) 호출");
		this.subject = subject;
	}
	
}
