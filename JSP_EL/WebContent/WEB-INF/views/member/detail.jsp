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

	<ul>
		<li>아이디 : ${member.id }</li>
		<li>패스워드 : ${member.pwd }</li>
		<li>이름 : ${member.name }</li>
		<li>이메일 : ${member.email }</li>
		<li>전화번호 : ${member.phone }</li>
		
	</ul>

</body>
</html>