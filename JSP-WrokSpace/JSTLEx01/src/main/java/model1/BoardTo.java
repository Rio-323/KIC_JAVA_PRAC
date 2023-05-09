package model1;

public class BoardTo {
	private String subject;
	private String writer;
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		System.out.println("setSubject");
		this.subject = subject;
	}
	
	public String getWriter() {
		return writer;
	}
	
	public void setWriter(String writer) {
		System.out.println("setWriter");
		this.writer = writer;
	}
}
