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

	<form name="frm" action="login" method="post">
		아이디 : <input type="text" name="id"><br>
		패스워드 : <input type="password" name="pwd"><br>
		<input type="button" value="로그인" id="loginBtn" >
	</form>


<script>
	document.querySelector('form[action="login"] > input[type="button"]').onclick=function(event){
		//alert("btn click")
		document.frm.submit();
	}
		
	<c:if test="${!empty message}">
		alert("${message}")
	</c:if>
	
	
	
</script>
</body>
</html>