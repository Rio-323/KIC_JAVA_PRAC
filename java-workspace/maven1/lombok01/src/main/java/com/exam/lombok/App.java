package com.exam.lombok;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//       DeptDTO to = new DeptDTO();
//       to.setDeptno("10");
//       to.setDname("연구부");
//       to.setLoc("대전");
    	
    	DeptDTO to = new DeptDTO("10", "연구부", "대전");
       
       System.out.println(to.getDeptno());
       System.out.println(to.getDname());
       System.out.println(to.getLoc());
       
       System.out.println(to);
       System.out.println(to.toString());
       
    }
}
