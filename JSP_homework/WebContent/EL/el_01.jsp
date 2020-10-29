<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>    
    
    
<%
	// _jsp_Service() 의 지역변수 선언
	String message = "Good day";
	
	// 내장객체의 Attribute setting
	pageContext.setAttribute("message", "배고파용1");
	request.setAttribute("message", "배고파용2");
	session.setAttribute("message", "배고파용3");
	application.setAttribute("message", "배고파용4");

%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<ul>
	<li>스크립 틀릿 : <%out.print(message); %></li>
	<li>표현식 : <%=message %></li>
	<li>EL문 : ${ message }</li>
	<li>EL문 session //  ${ sessionScope.message }</li>
	
</ul>
</body>
</html>