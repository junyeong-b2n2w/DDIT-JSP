

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>

  
<head>
	<title></title>
</head>

<body>
	<div class="content-wrapper">
		<div class="content-header">
		<h1 >
          ${loginUser.name } 님 환영합니다
        </h1>
		</div>
			<div class="content">
				  <button type="button" onclick="list_go();" class="btn action-1 xl text-center bg-danger mt-20 w-600"">리스트보기 </button>
		
				<button type="button" onclick="logout_go();" class="btn action-1 xl text-center bg-danger mt-20 w-600">로그아웃 </button>
					</div>
	</div>
	
	<script>
	function logout_go(){
		if(confirm("로그아웃합니다.")){
			location.href="<%=request.getContextPath()%>/common/logout"
		}
	}
	
	function list_go(){
		
			location.href="<%=request.getContextPath()%>/member/list"
		
	}
	</script>
</body>
  
  
  
  		

       
		
        

   

	