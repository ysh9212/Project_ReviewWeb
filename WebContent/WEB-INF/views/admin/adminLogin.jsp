<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지입니다</title>
</head>
<body>
<div class="container main">
		<h2>Login</h2>
		<form action="./adminLogin" method="post">
			<div class="form-group">
				<label for="id">ID:</label> 
				<input type="text" class="form-control"	name="id">
			</div>
			<div class="form-group">
				<label for="pw">Password:</label> <input type="password"
					class="form-control" name="pw">
			</div>
			<button type="submit" class="btn btn-default">Login</button>
		</form>

	</div>
</body>
</html>