<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>    
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:set var="message" value="ㅎㅇㅎㅇ" scope="page" /> // 스코프 안주면 페이지스코프가 기본값
<c:set var="message" value="반가워" scope="request" /> 
<c:set var="message" value="행복해" scope="session" /> 
<c:set var="message" value="돈돈돈" scope="application" /> 


<!-- <% pageContext.removeAttribute("message"); %> -->

<c:remove var="message" scope="page"/> // 스코프를 안주면 다지움

<h1>${message}</h1>

