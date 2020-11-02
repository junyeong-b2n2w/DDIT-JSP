<%@page import="java.util.List"%>
<%@page import="com.jsp.dto.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h1>회원 리스트</h1>
<table class = "table table-bordered">
	<tr>
		<th>id</th>
		<th>pwd</th>
		<th>name</th>
		<th>email</th>
		<th>phone</th>
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
</div>
</body>
</html>