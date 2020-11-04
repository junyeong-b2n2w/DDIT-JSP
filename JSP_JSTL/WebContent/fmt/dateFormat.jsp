<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:set var="today" value="<%=new Date() %>" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>

	

<body>
	<h1 id="time"></h1>
	<h1 id="current"></h1>
	<h1>server Request time : <fmt:formatDate value="${today }" pattern="yyyy-MM-dd HH:mm:ss"/></h1>
</body>

<script>
var today = new Date(${today.time}); // 서버시간 작동으로 됨
	
	var time = setInterval(function() {
		
		today.setTime(today.getTime()+1000);
		
		
		var todayStr = today.getFullYear() + "-" + (today.getMonth()+1) +"-" + today.getDate()+
		" " + today.getHours() + ":"  + today.getMinutes() + ":"  + today.getSeconds();
		document.getElementById('time').innerHTML = todayStr;
	}, 1000);
	
	var selftime = setInterval(function() {
		var currentTime = new Date();
		var currentStr = today.getFullYear() + "-" + (today.getMonth()+1) +"-" + today.getDate()+
		" " + today.getHours() + ":"  + today.getMinutes() + ":"  + today.getSeconds();
		document.getElementById('current').innerHTML = currentStr;
	},1000);

</script>
</html>