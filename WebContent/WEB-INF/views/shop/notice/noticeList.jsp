<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>{shop}List</title>
<link rel="stylesheet" href="../../assets/css/main.css" />
</head>
<body>
<%@include file="../../temp/header.jsp" %>
<div class="page=wrapper">
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
			<tbody>
			<c:forEach items="${list }" var="dto">
			<tr>
				<td>${dto.SHOP_NOTICE_NO }</td>
				<td>[속보]쌍용교육센터 강북지점...</td>
				<td>관리자</td>
				<td>2019-06-03</td>
				<td>842</td>
			</tr>
			
			</c:forEach>
			</tbody>
		</table>
		
		
		</div>
	</div>
</div>



<%@include file="../../temp/footer.jsp" %>
<%@include file="../../temp/activeweb.jsp" %>
</body>
</html>