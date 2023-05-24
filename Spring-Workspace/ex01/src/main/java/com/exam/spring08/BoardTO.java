package com.exam.spring08;

public class BoardTO {
	private String seq;
	private String subject;
	
	public BoardTO(String seq, String subject) {
		System.out.println("BoardTO(String seq, String subject) 호출");
		this.seq = seq;
		this.subject = subject;
	}

	public String getSeq() {
		return seq;
	}

	public String getSubject() {
		return subject;
	}
}
