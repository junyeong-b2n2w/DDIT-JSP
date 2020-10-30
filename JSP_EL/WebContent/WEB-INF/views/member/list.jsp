<%@page import="com.jsp.dto.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<table>
	<tr>
		<td>id</td>
		<td>pwd</td>
		<td>name</td>
		<td>email</td>
		<td>phone</td>
	</tr>
	<% List<MemberVO> memberList =  (List<MemberVO>)request.getAttribute("memberList"); %>
	<% for (MemberVO member : memberList) {
		
		pageContext.setAttribute("member", member);
		%>
			<tr>
				<td>${ member.id }</td>
				<td>${ member.pwd }</td>
				<td>${ member.name }</td>
				<td>${ member.email }</td>
				<td>${ member.phone }</td>
			</tr>
		<%
		
	}%>
</table>
</body>
</html>