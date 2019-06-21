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
<title>QnA</title>

</head>
<body>
<%@include file = "../../temp/header.jsp" %>
<div id="h_body">
</div>
<div id="body">
<jsp:include page="../communityCommon/navi.jsp"/>
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
</body>
</html>