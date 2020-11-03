<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>    
    
<p>${loginUser.name } 님 환영합니다</p>
<h1> main page</h1>

<button type="button" onclick="list_go();">리스트보기 </button>

<button type="button" onclick="logout_go();">로그아웃 </button>



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

