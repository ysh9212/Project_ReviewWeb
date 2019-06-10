<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>login</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel="stylesheet" href="../assets/css/main.css" />
</head>
<body>
<%@include file = "../temp/header.jsp" %>
<div id="page-wrapper">
<div id ="main">
	<div class="container">
		<form method="post" action="./memberLogin">
			<h1 style="text-align: center;">로그인 화면</h1>
				<div class="form-group">
					<input type="text"  placeholder="아이디" name="id">
				</div>
				<div class="form-group">
					<input type="password" placeholder="비밀번호" name="pw">
				</div>
				<div class="checkbox">
					<label><input type="checkbox" name="check" > Remember me</label>
				</div>
					<input type="submit" class="btn btn-primary form-control" value="로그인">
		</form>
	</div>
</div>

</div>
<%@include file="../temp/footer.jsp" %>


		<!-- Scripts -->
			<script src="./assets/js/jquery.min.js"></script>
			<script src="./assets/js/browser.min.js"></script>
			<script src="./assets/js/breakpoints.min.js"></script>
			<script src="./assets/js/util.js"></script>
			<script src="./assets/js/main.js"></script>

</body>
</html>