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



<%
	int dan=2;
		
		dan = Integer.parseInt(request.getParameter("dan"));
		
		%>
		<h1><%=dan%>단  입니다</h1><br>
	
		
		
		
		<%for(int num = 1; num <= 9 ; num++){%>


			<%=dan%> * <%=num %> = <%=dan*num %><br>
	
			<%	
			
		}
			%>
			
			
			
			<br>
			
		
		
</body>
</html>