<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UDK 관리자</title>
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<c:import url="../../../../../assets/css/admincss.jsp"/>
</head>
<body>
<c:import url="../../../temp/adminsetting.jsp"/>
<div class ="main">
SHOP ${board } 페이지
<table class="table table-hover">
	<thead>
		<tr>
			<th>번호</th>
			<th>상품 명</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list }" var = "dto">
			<tr>
				<td>${dto.pno }</td>
				<td><a href="./productSelect?pno=${dto.pno}">${dto.title }</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<div class="container">
		<form action="./productList">
			<select name="kind">
				<option value="t">상품명</option>
			</select>
			<input type="text" name="search">
			<button class="btn1 blue rounded">Search</button>	
		</form>
		<ul class="pager center">
			<c:if test="${pager.curBlock gt 1 }">
				<li class="previous"><a href="./productList?curPage=${pager.startNum-1}&kind=${pager.search.kind}&search=${pager.search.search}">Previous</a></li>
			</c:if>
			<li>
				<ul class="pagination center">
					<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" step="1" var="i">
					<li class="center"><a href="./productList?curPage=${i}&kind=${pager.search.kind}&search=${pager.search.search}">${i}</a></li>
					
					</c:forEach>
				</ul>

			</li>
			<c:if test="${pager.curBlock lt pager.totalBlock }">
				<li class="next"><a href="./productList?curPage=${pager.lastNum+1}&kind=${pager.search.kind}&search=${pager.search.search}">Next</a></li>
			</c:if>
		</ul>
	</div>
	<a href="./productWrite" class="btn btn-primary">상품추가</a>
</div>
</body>
</html>