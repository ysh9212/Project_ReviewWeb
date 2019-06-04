<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../../temp/bootstrap.jsp" />
<title>${board }Update</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="../../assets/css/main.css" />
</head>
<body>
	<%@include file="../../temp/header.jsp"%>
	<div id="page-wrapper">
		<div id="main">
			<div class="container">
				<form action="./qnaUpdate" method="post">
				<input type="hidden" name = "no" value="${dto.no }">
					<div class="form-group">
						<label for="title">Title:</label> <input type="text"
							class="form-control" id="title" name="title"
							value="${dto.title }">
					</div>
					<div class="form-group">
						<label for="writer">Writer:</label> <input type="text"
							class="form-control" id="writer" name="writer"
							value="${dto.writer }" readonly="readonly">
					</div>
					<div class="form-group">
						<label for="contents">Contents:</label>
						<textarea class="form-control" rows="5" id="contents"
							name="contents">${dto.contents}</textarea>
					</div>
					<input type="submit" value = "update">
				</form>
			</div>
		</div>



	</div>


	<%@include file="../../temp/footer.jsp"%>
	<%@include file="../../temp/activeweb.jsp"%>
</body>
</html>