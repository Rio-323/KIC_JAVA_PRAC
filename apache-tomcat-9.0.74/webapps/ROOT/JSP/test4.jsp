<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <%
        out.println("<table width='800' border='1'>");
        for(int i = 0; i < 10; i++) {
            out.println("<tr>");
            for(int j = 0; j < 10; j++) {
                if(i == 0 && j == 0) {
                    out.println("<td></td>");
                } else if(i == 0) {
                    out.println("<td>X" + j + "</td>");
                } else if(j == 0) {
                    out.println("<td>" + i + "단</td>");
                } else {
                    out.println("<td>" + i + " X " + j + " = " + (i * j) + "</td>");
                }
            }
            out.println("</tr>");
        }
        out.println("</table>");
    %>
</body>
</html>