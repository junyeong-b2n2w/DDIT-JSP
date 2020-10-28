<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
	body{
		background:<%=request.getParameter("color")%>
	}
	
</style>
</head>

<body>
	<h1><%=request.getAttribute("message") %></h1>
	<form action="gugudan.html" method="post">
		<label for="dan"> 단수를 선택하세요.</label>
		<select name="dan" id="dan">
			<option value="2">2단</option>
			<option value="3">3단</option>
			<option value="4">4단</option>
			<option value="5">5단</option>
			<option value="6">6단</option>
			<option value="7">7단</option>
			<option value="8">8단</option>
			<option value="9">9단</option>
		</select>
		
		<input type="submit" value="전송">
	</form>
</body>
</html>