<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="../../assets/css/main.css" />
<c:import url="../temp/bootstrap.jsp"/>
<html>
<jsp:include page="../communityCommon/css.jsp"/>
<head>
</head>
<body>

<%@include file = "../../temp/header.jsp" %>
<div id="h_body">
<jsp:include page="../communityCommon/navi.jsp"/>
</div>
<div id="body">
<hr>
	<div class="container">
	<table class="table table-hover">
		<tr>
			<td>No</td><td>Title</td><td>Writer</td><td>Date</td><td>Hit</td><td>Recommand</td><td>Decommand</td>
		</tr>
	</table>
	</div>





</div>
<%@include file="../../temp/footer.jsp" %>
		<!-- Scripts -->
			<script src="./assets/js/jquery.min.js"></script>
			<script src="./assets/js/browser.min.js"></script>
			<script src="./assets/js/breakpoints.min.js"></script>
			<script src="./assets/js/util.js"></script>
			<script src="./assets/js/main.js"></script>
</body>
</html>