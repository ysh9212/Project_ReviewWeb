<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="../assets/css/main.css" />
		<!-- Scripts -->
			<script src="./assets/js/jquery.min.js"></script>
			<script src="./assets/js/browser.min.js"></script>
			<script src="./assets/js/breakpoints.min.js"></script>
			<script src="./assets/js/util.js"></script>
			<script src="./assets/js/main.js"></script>
</head>
<body>
	<%@include file = "../temp/header.jsp" %>
	
	<a href="./notice/communityNotice">Notice</a>
	<a href="./bug/communityBug">Bug</a>
	<a href="./board/communityBoard">Board</a>
	<a href="./qna/communityQna">Qna</a>
	<a href="./used/communityUsed">used</a>
	<a href="./review/communityReview">review</a>

	
	
	
	<%@include file="../temp/footer.jsp" %>
	
</body>
</html>