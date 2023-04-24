<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.Calendar" %>
    <%
    	request.setCharacterEncoding("utf-8");
    	
    	StringBuilder sbHtml = new StringBuilder();
    	
    	if(request.getParameter("year") == null || request.getParameter("month") == null) {
    		// 입력 데이터가 없는 경우
    	} else {
    		// 입력 데이터가 있는 경우
    		String strYear = request.getParameter("year");
        	String strMonth = request.getParameter("month");
        	
        	// 설정 날짜
        	int year = Integer.parseInt(strYear);
        	int month = Integer.parseInt(strMonth);

            Calendar sDay = Calendar.getInstance();
            Calendar eDay = Calendar.getInstance();

            sDay.set( year, month-1, 1 );
            eDay.set( year, month, 1-1 );

            int startDayOfWeek = sDay.get( Calendar.DAY_OF_WEEK );
            int endDyaOfWeek = eDay.get( Calendar.DAY_OF_WEEK );
            int endDay = eDay.get( Calendar.DATE );
    		
            sbHtml.append( "<table width='800' border='1'>" );
            sbHtml.append( "<tr>" );
            sbHtml.append( "<td colspan='7'>" + year + "년" + month + "월</td>" );
            sbHtml.append( "</tr>" );
            sbHtml.append( "<tr>" );
            sbHtml.append( "<td class='sunday'>SU</td><td>MO</td><td>TU</td><td>WE</td><td>TH</td><td>FR</td><td class='saturday'>SA</td>" );
            sbHtml.append( "</tr>" );

            sbHtml.append( "<tr>" );
            for( int i=1 ; i<startDayOfWeek ; i++ ) {
            	sbHtml.append( "<td></td>" );
            }

            for( int i=1, n=startDayOfWeek ; i<=endDay ; i++, n++ ) {
                if( n % 7 == 1 ) sbHtml.append( "<tr>" );
            
                String tdClass = "";
                if (n % 7 == 1) { // Sunday
                    tdClass = " class='sunday'";
                } else if (n % 7 == 0) { // Saturday
                    tdClass = " class='saturday'";
                }
            
                if (i == sDay.get(Calendar.DATE) && month == sDay.get(Calendar.MONTH) + 1 && year == sDay.get(Calendar.YEAR)) {
                	sbHtml.append("<td" + tdClass + "><b>" + i + "</b></td>");
                } else {
                	sbHtml.append("<td" + tdClass + ">" + i + "</td>");
                }
            
                if( n % 7 == 0 ) sbHtml.append( "</tr>" );
            }
            

            for( int i=endDyaOfWeek ; i<=6 ; i++ ) {
            	sbHtml.append( "<td></td>" );
            }

            sbHtml.append( "</tr>" );
            sbHtml.append( "</table>" );
    	}
    
    	
    %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Calendar</title>
		<style>
	        .saturday {
	            color: blue;
	        }
	        .sunday {
	            color: red;
	        }
    </style>
	</head>
	<body>
		<form action="calendar_ok2.jsp" method="post">
			년도 
			<select name="year">
				<option value="2022">2022년</option>
				<option value="2023" selected="selected">2023년</option>
				<option value="2024">2024년</option>
			</select>
			<br><br>
			
			월
			<select name="month">
				<option value="1">1월</option>
				<option value="2">2월</option>
				<option value="3">3월</option>
				<option value="4" selected="selected">4월</option>
				<option value="5">5월</option>
				<option value="6">6월</option>
				<option value="7">7월</option>
				<option value="8">8월</option>
				<option value="9">9월</option>
				<option value="10">10월</option>
				<option value="11">11월</option>
				<option value="12">12월</option>
			</select>
			
			<br><br>
			<input type="submit" value="달력 보기">
		</form>
		<br><br>
		
		<%= sbHtml.toString() %>
    	
	</body>
</html>