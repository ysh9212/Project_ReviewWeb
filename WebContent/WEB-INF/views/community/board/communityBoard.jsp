<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>${list}</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="../../assets/css/main.css" />
<c:import url="../../temp/bootstrap.jsp" />
<jsp:include page="../communityCommon/css.jsp" />
</head>
<body>
	<%@include file="../../temp/header.jsp"%>
	<div id="body">
		<jsp:include page="../communityCommon/navi.jsp" />
		<hr>
		<div id="main">
			<div class="container">
				<table class="table table-hover">
					<thead>
						<tr>
							<td>번호</td>
							<td>제목</td>
							<td>글쓴이</td>
							<td>날짜</td>
							<td>조회수</td>
							<td>추천</td>
							<td>비추천</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="dto">
							<tr>
								<td>${dto.no}</td>
								<td><a href="./communityBoardSelect?no=${dto.no}">${dto.title}</a>
								</td>
								<td>${dto.writer}</td>
								<td>${dto.reg_date}</td>
								<td>${dto.hit}</td>
								<td>${dto.recommend}</td>
								<td>${dto.decommend}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			<jsp:include page="../communityCommon/paging.jsp"/>
			</div> <!-- end of container -->
			<a href="./communityBoardWrite" class="btn btn-primary">Write</a>
		</div> <!-- end of main  -->
	</div><!-- end of body -->
		<%@include file="../../temp/footer.jsp"%>
		<%@include file="../../temp/activeweb.jsp"%>
</body>
</html>
