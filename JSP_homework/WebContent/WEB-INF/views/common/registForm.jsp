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
<div class="container row text-center d-flex justify-content-center pt-100">
	<form name='frm' action="regist" method="post">
		<table class="table table-bordered">
			<tr>
				<td>id</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>pwd</td>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td>name</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>email</td>
				<td><input type="email" name="email"></td>
			</tr>
			<tr>
				<td>phone</td>
				<td><input type="text" name="phone"></td>
			</tr>
			<tr>
				<td colspan="2"><button class="btn btn-primary" type="button">전송</button></td>
			</tr>

		</table>
	</form>
</div>
	<script>
		document.querySelector('form[action="regist"] button[type="button"]').onclick = function(
				event) {
			//alert("btn click")
			document.frm.submit();
		}
	</script>
</body>
</html>