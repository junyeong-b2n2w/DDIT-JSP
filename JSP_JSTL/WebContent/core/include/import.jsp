<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

      <c:import url="/core/include/header.jsp" var="head">
         <c:param name="message" value="안녕"/>
         <c:param name="title" value="회원가입"/>
      </c:import>
      
      <h1>Google.com</h1>
      <div id="google">
         
      </div>
      
      ${head }
      <h1>naver.com</h1>
      <div id="naver">
         
      </div>
      <c:import url="/core/include/footer.jsp"/>
      
      ${head }