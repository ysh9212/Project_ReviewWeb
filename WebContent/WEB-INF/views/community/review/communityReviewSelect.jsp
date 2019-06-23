<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="../../assets/css/main.css" />
<c:import url="../../temp/bootstrap.jsp" />
<html>
<jsp:include page="../communityCommon/css.jsp" />
<head>
<title>${rboard}select</title>
<script type="text/javascript">
	// 게시글
	$(function() {
		// 리스트로 이동;
		$('#list').click(function() {
			location.href="./communityReview";
		});
		// 수정폼으로 이동;
		$('#update').click(function() {
			location.href="./communityReviewUpdate?no=${dto.no}";
		// 게시글 삭제;
		$('#delete').click(function() {
			var check = confirm("정말 삭제하시겠습니까?");
				if (check) {
					$.get("./communityReviewDelete?no=${dto.no}", function(data) {
						if (data > 0) {
							alert("삭제되었습니다.");
						} else {
							alert("삭제 실패하였습니다.");
						}
						location.href = "./communityReview";
					});
				}
			});
		});
	});
</script>
</head>
<body>
	<%@include file="../../temp/header.jsp"%>
	<div id="body">
		<jsp:include page="../communityCommon/navi.jsp" />
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
				</div>
			</div>
		<button id="list" class="list">목록</button>
		<button id="update" class="update">수정</button>
		<button id="delete" class="del">삭제</button>
		<button id="recommend" class="rec">추천</button>
		<button id="decommend" class="dec">비추천</button>
		</div>
	</div>
	<%@include file="../../temp/footer.jsp"%>
</body>
</html>