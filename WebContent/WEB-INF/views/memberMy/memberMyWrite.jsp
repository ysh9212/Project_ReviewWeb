<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 글 보기</title>
<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath }/images/Teamlogo.ico" />
<link rel="stylesheet" href="../assets/css/main.css" />
<c:import url="../temp/bootstrap.jsp" />
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<jsp:include page="./memberMyCommon/css.jsp"/>
</head>
<body>
<%@include file="../temp/header.jsp"%>
		<div id="page-wrapper">
			<div id="main">
				<div class="container">
					<jsp:include page="./memberMyCommon/navi.jsp" />
					<div id="wrap">
						<h2 class="memberinfor">내 글 보기</h2>
						<div id="h_body"></div>
						<div id="body">
							<hr>
							<div class="container">
								<table class="table table-hover">
									<thead>
									<tr>
										<td>No</td>
										<td>Title</td>
										<td>Writer</td>
										<td>Date</td>
										<td>Hit</td>
										<td>Recommand</td>
										<td>Decommand</td>
									</tr>
									</thead>
									<tbody>
										<c:forEach items="${list}" var="dto">
											<tr>
												<td>${dto.no}</td>
												<td><a
													href="../community/board/communityBoardSelect?no=${dto.no}">${dto.title}</a>
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
			<jsp:include page="../community/communityCommon/paging.jsp"/>
								
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	<%@include file="../temp/footer.jsp" %>
	<%@include file="../temp/activeweb.jsp"%>
</body>
</html>