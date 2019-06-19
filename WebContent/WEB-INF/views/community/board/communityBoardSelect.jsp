<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="../../temp/bootstrap.jsp"/>
<html>
<head>
<jsp:include page="../communityCommon/css.jsp"/>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="../../assets/css/main.css" />
<title>${bboard}select</title>
<script type="text/javascript">
	$(function() {
		$('#delete').click(function() {
			var check = confirm("정말 삭제하시겠습니까?");
			if (check) {
				// $.get 지금 페이지로 위 주소를 보낸뒤 값을 data로 받는다.
				$.get("./communityBoardDelete?no=${dto.no}", function(data) {
					if(data>0){
						alert("삭제 되었습니다.");
					}else{
						alert("삭제 실패하였습니다.");
					}
					location.href="./communityBoard";
				});
			}
		});
	});
</script>
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
		<a href="./communityBoard">목록</a>
		<a href="./communityBoardUpdate?no=${dto.no}">수정</a>
		<button id="list" class="list">목록</button>
		<button id="update" class="update">수정</button>
		<button id="delete" class="del">삭제</button>
		<button id="recommend" class="rec">추천</button>
		<button id="decommend" class="dec">비추천</button>
		
	</div>
</div>
<%@include file="../../temp/footer.jsp" %>
</body>
</html>