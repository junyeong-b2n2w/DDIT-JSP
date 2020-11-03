<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

</head>
<body>

	<div class="container">
	
		<h1>${member.id } 회원 정보</h1>
		<form name="frm" action="modify" method="post">
			<table class = "table table-bordered">
			<tr>
				<td>아이디</td>
				<td> <input id="id" type="text" value="${member.id }" readonly name="id"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input id="pwd" type="password" value="${member.pwd }" readonly name="pwd"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input id="name" type="text" value="${member.name }" readonly name="name"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input id="email" type="email" value="${member.email }" readonly name="email"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input id="phone" type="text" value="${member.phone }" readonly name="phone"></td>
			</tr>
			<tr>
				<td colspan ="2" id="btn-group"> <input type="button" id="list" class="btn btn-primary" onclick="location.href='<%=request.getContextPath()%>/member/list'" value="목록으로" >
				&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" id="del" class="btn btn-primary" value="삭제" >&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" id="modify" class="btn btn-primary" value="수정" ></td> 
			</tr>
			</table>
		</form>
	</div>

	<script>
		document.querySelector('#modify').addEventListener('click',() => {
			
			document.querySelector('#pwd').readOnly=false
			document.querySelector('#name').readOnly=false
			document.querySelector('#email').readOnly=false
			document.querySelector('#phone').readOnly=false
			
			document.querySelector('#modify').classList.add('d-none')
			
			var node = document.createElement("input");   
			node.classList.add('btn')
			node.classList.add('btn-primary')
			node.type="button"
			node.id="modify_btn"
			node.value="수정하기"
			
			document.querySelector('#btn-group').append(node)
			document.querySelector('#modify_btn').addEventListener('click',() => {
			document.frm.submit();
			})
		})
		
		
		document.querySelector('#del').addEventListener('click',() => {
			
			location.href="<%=request.getContextPath()%>/member/delete?id="+document.querySelector('#id').value
				
		})
		
	</script>
</body>
</html>