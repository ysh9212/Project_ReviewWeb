<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${board}List</title>
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="../../assets/css/main.css" />
</head>
<body>
<%@include file="../../temp/header.jsp" %>
<div id="page-wrapper">
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
				<td>${dto.no}</td>
				<td>
				<a href="./${board}Select?no=${dto.no}">${dto.title }
				</a>
				</td>
				<td>${dto.writer }</td>
				<td>${dto.reg_date }</td>
				<td>${dto.hit }</td>
			</tr>
			
			</c:forEach>
			</tbody>
		</table>
		
		
		</div>
		<div class="container">
		<ul class="center">
			<c:if test="${pager.curBlock gt 1 }">
				<li class="previous"><a href="./${board}List?curPage=${pager.startNum-1}&kind=${pager.search.kind}&search=${pager.search.search}">Previous</a></li>
			</c:if>
			<li>
				<ul class="pagination">
					<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" step="1" var="i">
					<li><a href="./${board}List?curPage=${i}&kind=${pager.search.kind}&search=${pager.search.search}">${i}</a></li>
					
					</c:forEach>
				</ul>

			</li>
			<c:if test="${pager.curBlock lt pager.totalBlock }">
				<li class="next"><a href="./${board}List?curPage=${pager.lastNum+1}&kind=${pager.search.kind}&search=${pager.search.search}">Next</a></li>
			</c:if>
		</ul>
		<a href="./${board}Write" class="btn btn-primary">Write</a>
		</div>
	</div>
</div>



<%@include file="../../temp/footer.jsp" %>
<%@include file="../../temp/activeweb.jsp" %>
</body>
</html>