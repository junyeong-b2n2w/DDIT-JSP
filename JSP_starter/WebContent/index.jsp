<%@page import="java.util.Scanner"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>    

<%!
	String message="대덕개발원~~~~~~~~~~~~~~~";
%>
    
<script>
	alert("<%=getMessage()%>")
	location.href="<%=request.getContextPath()%>/gugudan.html?color=pink";
</script>

<%!
	public String getMessage(){
		return message;
}
%>