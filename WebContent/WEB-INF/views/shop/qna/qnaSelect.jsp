<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../../temp/bootstrap.jsp" />
<title>${board }Select</title>

<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="../../assets/css/main.css" />
<script type="text/javascript">
	
	$(function() {
		
		$('#delete').click(function() {
			var check = confirm("정말 삭제하시겠습니까?");
			if (check) {
				$.get("./qnaDelete?no=${dto.no}", function(data) {
					$.get("./qnaList", function(data) {
						location.href ="./qnaList";
					});

				});

			}

		});
	});
</script>
</head>
<body>
	<%@include file="../../temp/header.jsp"%>
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
						<td colspan="6">${dto.contents}
					</tr>
				</table>


			<a href="./qnaDelete?no=${dto.no}" class="btn" id="delete">Delete</a>
			<a href="./qnaUpdate?no=${dto.no}" class="btn">Update</a>
			</div>
			
		</div>
	</div>

	<%@include file="../../temp/footer.jsp"%>
	<%@include file="../../temp/activeweb.jsp"%>
</body>
</html>