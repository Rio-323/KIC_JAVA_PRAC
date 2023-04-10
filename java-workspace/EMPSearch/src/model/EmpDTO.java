package model;

public class EmpDTO {
	private String empno;
	private String ename;
	private String deptno;
	private String sal;
	private String hiredate;
	private String mgr;
	
	public String getEmpno() {
		return empno;
	}
	
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	
	public String getEname() {
		return ename;
	}
	
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	public String getDeptno() {
		return deptno;
	}
	
	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}
	
	public String getSal() {
		return sal;
	}
	
	public void setSal(String sal) {
		this.sal = sal;
	}
	
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public String getMgr() {
		return mgr;
	}
	public void setMgr(String mgr) {
		this.mgr = mgr;
	}
}
