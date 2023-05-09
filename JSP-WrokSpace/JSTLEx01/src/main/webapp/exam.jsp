<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="num" value="${ 95 }"></c:set>
점수 <c:out value="${ num }"></c:out>은

<c:if test="${ num > 60 }">
	합격입니다.
</c:if>

<br>
점수 <c:out value="${ num }"/>은
<c:choose>
	<c:when test="${ num >= 90 }">A 학점입니다.</c:when>
	<c:when test="${ num >= 80 }">B 학점입니다.</c:when>
	<c:when test="${ num >= 70 }">C 학점입니다.</c:when>
	<c:when test="${ num >= 60 }">D 학점입니다.</c:when>
	<c:otherwise>F 학점입니다.</c:otherwise>
</c:choose>