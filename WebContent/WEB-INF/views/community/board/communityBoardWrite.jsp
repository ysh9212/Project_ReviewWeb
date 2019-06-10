<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="../../assets/css/main.css" />
<c:import url="../temp/bootstrap.jsp"/>

<html>
<jsp:include page="../communityCommon/css.jsp"/>
</style>
<head>
<title>공지사항 작성</title>
</head>
<body>
<%@include file = "../../temp/header.jsp" %>
<div id="body">
	<div class="container">
		<h1>자유게시판 작성</h1>
	</div>
<label/>작성자<input type="text">
<br>
<label/>제목<input type="text">
<br>
<label/>내용<textarea rows="" cols=""></textarea>
</div>
<%@include file="../../temp/footer.jsp" %>
</body>
</html>