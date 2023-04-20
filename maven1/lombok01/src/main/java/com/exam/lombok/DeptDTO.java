package com.exam.lombok;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter

// Default 생성자
@NoArgsConstructor
@AllArgsConstructor

@ToString(exclude = {"deptno"})
@EqualsAndHashCode
public class DeptDTO {
	private String deptno;
	private String dname;
	private String loc;
	
//	// Default 생성자
//	public DeptDTO() {
//		System.out.println("생성자 호출");
//	}
}
