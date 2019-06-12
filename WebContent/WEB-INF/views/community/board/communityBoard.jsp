<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="../../assets/css/main.css" />
<c:import url="../../temp/bootstrap.jsp"/>

<html>
<jsp:include page="../communityCommon/css.jsp"/>
<head>
<title>자유게시판</title>
</head>
<body>
<%@include file = "../../temp/header.jsp" %>
<div id="body">
<jsp:include page="../communityCommon/navi.jsp"/>
<hr>
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
		<c:forEach items="${blist}" var="bdto">
			<tr>
				<td>${bdto.no}</td>
				<td>
				<a href="./${board}select?no=${bdto.no}">${bdto.title}</a>
				</td>
				<td>${bdto.writer}</td>
				<td>${bdto.reg_date}</td>
				<td>${bdto.hit}</td>
				<td>${bdto.recommend}</td>
				<td>${bdto.decommend}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	</div>
	<a href="./${board}communityBoardWrite" class="btn btn-primary">Write</a>
</div>
<%@include file="../../temp/footer.jsp" %>
</body>
</html>

