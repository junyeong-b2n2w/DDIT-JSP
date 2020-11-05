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

	<script>
		alert("구글로 이동합니다");
		location.href="https://www.google.com"
	</script>

<%-- 	<% response.sendRedirect("https://www.google.com"); %> --%>
<%-- 	<c:redirect url="https://www.google.com"/> --%>
	
</body>
</html>