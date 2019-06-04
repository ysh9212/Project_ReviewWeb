<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="../../assets/css/main.css" />
		<!-- Scripts -->
			<script src="./assets/js/jquery.min.js"></script>
			<script src="./assets/js/browser.min.js"></script>
			<script src="./assets/js/breakpoints.min.js"></script>
			<script src="./assets/js/util.js"></script>
			<script src="./assets/js/main.js"></script>
<html>
<script type="text/javascript">
	$(function () {
		$("#click").click(function(){
			alert(t.value);
		});
	});
</script>
<head>
</head>
<body>
<%@include file = "../../temp/header.jsp" %>
	<h1>Noitce</h1>
		<div>
			<input id = "t" type="text">
			<input id = "w" type="text">
			<input id = "c" type="text">
		</div>
		<button id = "click">Update</button>
	

<%@include file="../../temp/footer.jsp" %>


</body>
</html>