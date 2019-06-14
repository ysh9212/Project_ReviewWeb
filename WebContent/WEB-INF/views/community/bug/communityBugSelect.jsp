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
<title>${bugboard}select</title>
</head>
<body>
<%@include file = "../../temp/header.jsp" %>
<div id="body">
<jsp:include page="../communityCommon/navi.jsp"/>
	<div class="page-wrapper">
		<div id="main">
			<div class="container">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>글쓴이</th>
							<th>날짜</th>
							<th>조회수</th>
						</tr>
					</thead>
					<tr>
						<td>${bugdto.no}</td>
						<td>${bugdto.title}</td>
						<td>${bugdto.writer}</td>
						<td>${bugdto.reg_date}</td>
						<td>${bugdto.hit}</td>
					</tr>
					<tr>
						<td colspan="6">${bugdto.contents}
					</tr>
				</table>
			</div>
		</div>
		<a href="./communityBug">목록</a>
	</div>
</div>
<%@include file="../../temp/footer.jsp" %>
</body>
</html>