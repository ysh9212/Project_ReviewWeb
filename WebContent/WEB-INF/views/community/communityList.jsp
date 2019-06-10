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
<jsp:include page="./communityCommon/css.jsp"/>
</style>
<head>
<title>게시판</title>
</head>
<body>
	<%@include file="../temp/header.jsp"%>
	<div id="body">
<jsp:include page="./communityCommon/navi.jsp"/>
		<hr>
		<div class="table_body">
			<div class="container">
				<table class="table table-hover">
					<tr>
						<h1>공지사항</h1>
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
												<section class="tiles">
						<article class="style2">
							<span class="image"> <img src="../images/hani.jpg" alt=""
								width="400" height="300">
							</span> <a href="#">
								<h2>중고 물품</h2>
								<div class="content">
									<p>꼭사라!!!!!!!!!!!!!!!!!!</p>
								</div>
							</a>
						</article>
						<article class="style2">
							<span class="image"> <img src="../images/hani.jpg" alt=""
								width="400" height="300">
							</span> <a href="#">
								<h2>중고 물품</h2>
								<div class="content">
									<p>꼭사라!!!!!!!!!!!!!!!!!!</p>
								</div>
							</a>
						</article>
						<article class="style2">
							<span class="image"> <img src="../images/hani.jpg" alt=""
								width="400" height="300">
							</span> <a href="#">
								<h2>중고 물품</h2>
								<div class="content">
									<p>꼭사라!!!!!!!!!!!!!!!!!!</p>
								</div>
							</a>
						</article>
					</section>
					</table>
				</div>
			</div>
		</div>
		<div id = f_body>
	<%@include file="../temp/footer.jsp"%>
		</div>
</body>
</html>