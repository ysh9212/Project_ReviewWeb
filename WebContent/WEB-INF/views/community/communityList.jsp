<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="../assets/css/main.css" />
<c:import url="../temp/bootstrap.jsp" />
<!-- Scripts -->
<script src="./assets/js/jquery.min.js"></script>
<script src="./assets/js/browser.min.js"></script>
<script src="./assets/js/breakpoints.min.js"></script>
<script src="./assets/js/util.js"></script>
<script src="./assets/js/main.js"></script>
<html>
<style type="text/css">
#h_body {
	width: 1200px;
	height: 100px;
	background-color: blue;
	margin: 0 auto;
}
#h_1_body {
	width: 1200px;
	height: 50px;
	background-color: red;
	margin: 0 auto;
}
#body {
	width: 1200px;
	height: 1600px;
	background-color: white;
	margin: 0 auto;
}
.table_body {
	width: 500px;
	height: 300px;
	display: inline-block;
	margin-top: 30px;
	margin-left: 50px;
	margin-right: 47px;
	margin-bottom: 30px;
	background-color: yellow;
}
#used_body{
	width: 1100px;
	height: 800px;
	top : 30px;
	margin: 0 auto;
	background-color: yellow;
}
</style>
<head>
</head>
<body>
	<%@include file="../temp/header.jsp"%>
	<div id="h_body">
		<h1>Notice Board</h1>
	</div>
	<div id="h_1_body">
		<a href="./notice/communityNotice">공지사항</a> 
		<a href="./board/communityBoard">자유게시판</a> 
		<a href="./review/communityReview">유저리뷰</a> 
		<a href="./used/communityUsed">중고물품</a> 
		<a href="./bug/communityBug">버그리포트</a>
		<a href="./qna/communityQna">QnA</a>
	</div>
	<div id="body">
		<hr>
		<div class="table_body">
			<div class="container">
				<table class="table table-hover">
					<h1>공지사항</h1>
					<tr>
						<td>Title</td>
					</tr>
				</table>
			</div>
		</div>
		<div class="table_body">
			<div class="container">
				<table class="table table-hover">
					<h1>자유게시판</h1>
					<tr>
						<td>Title</td>
					</tr>
				</table>
			</div>
		</div>
		<div class="table_body">
			<div class="container">
				<table class="table table-hover">
					<h1>유저리뷰</h1>
					<tr>
						<td>Title</td>
					</tr>
				</table>
			</div>
		</div>
		<div class="table_body">
			<div class="container">
				<table class="table table-hover">
					<h1>버그리포트</h1>
					<tr>
						<td>Title</td>
					</tr>
				</table>
			</div>
		</div>
			<div id="used_body">
				<div class="container">
					<table class="table table-hover">
						<h1>중고게시판</h1>
							<tr>
								<td>Title</td>
							</tr>
					</table>
				</div>
			</div>
		</div>
	<%@include file="../temp/footer.jsp"%>
</body>
</html>