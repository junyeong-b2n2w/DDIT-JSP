<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<%-- <%request.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(request, response);%> --%>
<c:if test="${param.page eq 'c'}">
	<c:import url="/WEB-INF/views/main.jsp" />
</c:if>

<c:if test="${param.page eq 'action'}">
	<jsp:forward page="/WEB-INF/views/main_action.jsp" />
</c:if>

<c:if test="${param.page eq 'directive'}">
	<%@ include file="/WEB-INF/views/main_directive.jsp" %>
</c:if>