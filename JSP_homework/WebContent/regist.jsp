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
<%request.setCharacterEncoding("UTF-8"); %>

id : <%=request.getParameter("id") %>
pwd :<%=request.getParameter("pwd") %>
name : <%=request.getParameter("name") %>
email :<%=request.getParameter("email") %>
phone :<%=request.getParameter("phone") %>
</body>
</html>