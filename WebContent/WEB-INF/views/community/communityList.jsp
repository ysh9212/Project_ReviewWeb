<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="../assets/css/main.css" />
<c:import url="../temp/bootstrap.jsp" />
<html>
<jsp:include page="./communityCommon/css.jsp" />
</style>
<head>
<title>게시판</title>
</head>
<body>
	<%@include file="../temp/header.jsp"%>
	<div id="body">
		<jsp:include page="./communityCommon/navi.jsp" />
		<hr>
		<div class="table_body">
			<div class="container">
				<table class="table table-hover">
					<thead>
						<h1>${nboard}</h1>
					</thead>
					<tbody>
						<c:forEach items="${nlist}" var="ndto">
							<tr>
								<td>
									<a href="./notice/communityNoticeSelect?no=${ndto.no}">${ndto.title}</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="table_body">
			<div class="container">
				<table class="table table-hover">
					<thead>
						<h1>${bboard}</h1>
					</thead>
					<tbody>
						<c:forEach items="${blist}" var="bdto">
							<tr>
								<td>
									<a href="./board/communityBoardSelect?no=${bdto.no}">${bdto.title}</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="table_body">
			<div class="container">
				<table class="table table-hover">
					<thead>
						<h1>${rboard}</h1>
					</thead>
					<tbody>
						<c:forEach items="${rlist}" var="rdto">
							<tr>
								<td>
									<a href="./review/communityReviewSelect?no=${rdto.no}">${rdto.title}</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="table_body">
			<div class="container">
				<table class="table table-hover">
					<h1>${bugboard}</h1>
					<tbody>
						<c:forEach items="${buglist}" var="bugdto">
							<tr>
								<td>
									<a href="./bug/communityBugSelect?no=${bugdto.no}">${bugdto.title}</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div id="used_body">
			<div class="container">
				<table class="table table-hover">
					<h1>${uboard}</h1>
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
	<div id=f_body>
		<%@include file="../temp/footer.jsp"%>
	</div>
</body>
</html>