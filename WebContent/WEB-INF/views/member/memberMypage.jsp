<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../assets/css/main.css" />
</head>
<body>

<%@include file = "../temp/header.jsp" %>
<div id="page-wrapper">
	<div id="main">
		<div class="container">
			<form action="${pageContext.request.contextPath}member/memberMypage" method="post">
				<h2> 마이페이지 </h2>
			<form action="./memberMyPage">
				<h1> my page</h1>
			
			
			</form>
		</div>
	</div>
</div>
<%@include file="../temp/footer.jsp" %>
</body>
</html>