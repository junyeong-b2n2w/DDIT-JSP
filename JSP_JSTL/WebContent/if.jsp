<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>    
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% int k =11;
	if (k > 10){
	out.println("<h1>k는 10보다 큽니다</h1>");
	}
%>

<c:set var="k" value="11" />
<c:if test="${k>10 }" >
	<h1>k는 10보다 큽니다.</h1>
</c:if>

<% int y =11;
	if (y > 10){
	out.println("<h1>y는 10보다 큽니다</h1>");
	}else{
	out.println("<h1>y는 10보다 작습니다</h1>");
	}
%>

<c:set var="y" value="10" />
<c:choose>
	<c:when test="${y >10 }">
		<h1>y는 10보다 큽니다</h1>
	</c:when>
	<c:otherwise>
		<h1>y는 10보다 작습니다</h1>
	</c:otherwise>
</c:choose>

