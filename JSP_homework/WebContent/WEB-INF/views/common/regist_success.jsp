<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>    
    
 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<script>
	alert('<%=request.getAttribute("message")%>');
	//location.href="<%=request.getContextPath()%>/common/login";
</script>
</head>
<body>

<h1 class="text-center">가입된 정보입니다</h1>
<div class="container row text-center">
	<table class="table table-bordered">
		<tr>
			<td>아이디</td><td>${member.getId()}</td>
		</tr>
		<tr>
			<td>비밀번호</td><td>${member.getPwd()}</td>
		</tr>
		<tr>
			<td>이름</td><td>${member.getName()}</td>
		</tr>
		<tr>
			<td>이메일</td><td>${member.getEmail()}</td>
		</tr>
		<tr>
			<td>전화번호</td><td>${member.getPhone()}</td>
		</tr>
	</table>
</div>




</body>
</html>