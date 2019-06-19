<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${board }Select</title>
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="../assets/css/main.css" />
</head>
<body>
	<%@include file="../temp/header.jsp"%>
	<div class="page-wrapper">
		<div id="main">
			<div class="container">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>NUM</th>
							<th>TITLE</th>
							<th>WRITER</th>
							<th>DATE</th>
							<th>HIT</th>
						</tr>
					</thead>
					<tr>
						<td>${dto.no}</td>
						<td>${dto.title}</td>
						<td>${dto.writer}</td>
						<td>${dto.reg_date}</td>
						<td>${dto.hit}</td>
					</tr>
					<tr>
						<td colspan="5">${dto.contents}
					</tr>
				</table>
			</div>
		</div>
	</div>
	
	<div id ="body">
	
	<p>댓글창</p>
	
</div>
	<%@include file="../temp/footer.jsp"%>
	
</body>
</html>