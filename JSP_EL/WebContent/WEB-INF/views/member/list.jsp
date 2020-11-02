<%@page import="com.jsp.dto.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
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
		<c:forEach var="member" items="${memberList }">
			<tr>
				<td> 
					<a href="detail?id=${member.id}">${ member.id }</a>
				</td>
				<td>${ member.pwd }</td>
				<td>${ member.name }</td>
				<td>${ member.email }</td>
				<td>${ member.phone }</td>
			</tr>
		</c:forEach>
		
</table>
</body>
</html>