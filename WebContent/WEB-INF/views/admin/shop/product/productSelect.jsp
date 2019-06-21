<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UDK 관리자</title>
<c:import url="../../../../../assets/css/admincss.jsp"/>
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
</head>
<body>
<c:import url="../../../temp/adminsetting.jsp"/>
<div class ="main">
<table class="table table-hover">
	<thead>
		<tr>
			<th>번호</th>
			<th>상품 명</th>
			<th>카테고리</th>
			<th>가격</th>
			<th>재고</th>
			<th>등록날짜</th>
		</tr>
	</thead>
	<tbody>
			<tr>
				<td>${dto.pno }</td>
				<td>${dto.title }</td>
				<td>${dto.cno }</td>
				<td>${dto.price }</td>
				<td>${dto.stock }</td>
				<td>${dto.reg_date }</td>
			</tr>
			<tr>
				<td colspan="6">${dto.detail }</td>
			</tr>
			<tr>
				<td colspan="6"><img alt="썸네일" src="${pageContext.request.contextPath }/upload/${upload.fname}"></td>
			</tr>
	</tbody>
</table>
<a href="./productUpdate?pno=${dto.pno }" class="btn btn-primary">상품수정</a>
<a href="./productDelete?pno=${dto.pno }" class="btn btn-primary">상품삭제</a>
</div>
</body>
</html>