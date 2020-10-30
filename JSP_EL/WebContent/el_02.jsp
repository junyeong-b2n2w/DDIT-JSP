<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.jsp.dto.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>    

<%
	MemberVO member = new MemberVO("jun","jun","jun","010-1234-1234","jun@jun.jun");
	pageContext.setAttribute("member", member);
	Map<String, MemberVO> memberMap = new HashMap<String, MemberVO>();
	memberMap.put("member", member);
	session.setAttribute("memberMap", memberMap);
	
%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<ul>
		<li>아이디 : <% out.print(((MemberVO)pageContext.getAttribute("member")).getId()); %></li>
		<li>아이디 : ${ member.id }</li>
		<li>아이디 : ${ memberMap.member.id.substring(0,2) }</li>
		<li>아이디 : ${ memberMapp.member.id }</li>
		<li>아이디 : ${ memberMap.memberr.id }</li>
		<li>아이디 : ${ memberMap.member.id }</li>
		
		
		<li>패스워드 : ${ member.pwd }</li>
		<li>이름 : ${ member.name }</li>
	</ul>

</body>
</html>