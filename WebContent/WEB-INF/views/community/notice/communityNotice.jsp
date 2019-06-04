<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="../../assets/css/main.css" />
<c:import url="../temp/bootstrap.jsp"/>
		<!-- Scripts -->
			<script src="./assets/js/jquery.min.js"></script>
			<script src="./assets/js/browser.min.js"></script>
			<script src="./assets/js/breakpoints.min.js"></script>
			<script src="./assets/js/util.js"></script>
			<script src="./assets/js/main.js"></script>
<html>
<head>
</head>
<body>

<%@include file = "../../temp/header.jsp" %>
	<div class="container">
	<table class="table table-hover">
		<tr>
			<td>No</td><td>Title</td><td>Writer</td><td>Date</td><td>hit</td><td>추천</td><td>비추천</td>
		</tr>
	</table>
	</div>





<%@include file="../../temp/footer.jsp" %>
</body>
</html>