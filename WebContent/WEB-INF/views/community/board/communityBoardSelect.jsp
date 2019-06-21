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
<title>${board}select</title>
<script type="text/javascript">
	$(function() {
		// 리스트로 이동;(완)
		$('#list').click(function() {
			location.href="./communityBoard";
		});
		// 수정폼으로 이동;(완)
		$('#update').click(function() {
			location.href="./communityBoardUpdate?no=${dto.no}";
		});
		// 게시글 삭제;(완)
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
		}); // end of 게시글 삭제 function;
	});// end of 게시글 function;
	// 댓글
	$(function() {
		getList();
		var curPage=1;
		// 댓글 리스트;(완)
		function getList(count) {
			$.get("../communityComments/comBoardCommentsList?no=${dto.no}&curPage="+count, function(data) {
				var data = data.trim();
				if(count==1){
					$("#comments_list").html(data);
				}else {
					$("#comments_list").append(data);
				}
			});
		}
		// 댓글 더보기;(완)
		$("#more").click(function() {
			curPage++;
			getList(curPage);
		});
		// 댓글 insert;(완)
		/*
		$("#comment_write").click(function (){
			var writer = $("#writer").val();
			var contents =$("#contents").val();
			var no ="${dto.no}";
			
			var xhttp;
			if(window.XMLHttpRequest){
				xhttp = new XMLHttpRequest();
			}else{
				xhttp = new ActionveXObject("Microsoft.XMLHTTP");	
			}
			xhttp.open("POST", "../communityComments/comBoardCommentsInsert", true);
			xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			
			xhttp.send("no="+no+"&writer="+writer+"&contents="+contents);
			
			xhttp.onreadystatechange=function(){
				if(this.readyState==4&&this.status==200){
					var result = this.responseText.trim();
					if(result=="1"){
						alert("성공");
						getList();
					}else{
						alert("실패");
					}
				}
				alert("?")
				getList();
			}
			alert("??")
		})
		*/
		$("#comment_write").click(function() {
			var writer = $("#writer").val();
			var contents = $("#contents").val();
			var no = '${dto.no}';
			$.post("../communityComments/comBoardCommentsInsert",{
				no:no,
				writer:writer,
				contents:contents
				}, 
				function(data) {
				data = data.trim();
				if(data==1){
					alert("댓글 등록에 성공하였습니다.")
					getList(1);
				}else {
					alert("댓글 등록에 실패하였습니다.");
				}
			});
		});
		//댓글 수정
		$("#comment_list").on("click", ".update", function(){
			var id=$(this).attr("title");
			var con= $("#c"+id).html();
			$("#updateContents").val(con);
			$("#cnum").val(id);
		});
		$("#updateBtn").click(function() {
			var contents= $("#updateContents").val();
			var cnum=  $("#cnum").val();
			$.post("../comments/commentsUpdate",{
				contents:contents,
				cnum:cnum
			}, function(data) {
				data = data.trim();
				if(data=="1"){
					alert("Success");
					//getList(1);
					$("#c"+cnum).html(contents);
				}else {
					alert("Fail");
				}
			});
		});
		// 댓글 삭제;
		$("#comment_list").on("click", ".delete", function (){
			var cnum = $(this).attr("id");
			var check = confirm("정말 삭제하시겠습니까?");
				if(check){
					$.get("../communityComments/comBoardCommentsDelete?cnum="+cnum, function (data){
						var data = data.trim();
						if(data=="1"){
							alert("댓글이 삭제 되었습니다.");
							getList(1);
						}else{
							alert("댓글 삭제에 실패하였습니다.")
						}
					})
				}else{
					alert("댓글 삭제가 취소되었습니다.");
				}
		}); // 끝
		/*
		if(check){
			$.get("../comments/commentsDelete?cnum="cnum, function (data) {
				var data = data.trim();
				if(data=="1"){
					alert("삭제 되었습니다.");
					$("#comment_list").html(data);
				}else {
					alert("삭제 실패하였습니다.");
					$("#comment_list").append(data);
				}
			});
		*/
		
		/*
		$("#comment_delete").on("click", ".del", function() {
			var cnum = $(this).attr("id");
			var check = confirm("삭제 할거냐?");
			if(check){
				$.get("../comments/commentsDelete?cnum="+cnum, function(data) {
					data = data.trim();
					if(data=="1"){
						alert("Delete Success");
						getList(1);
					}else {
						alert("Delete Fail");
					}
				});
			}
		});
		*/
	});//end of 댓글
	// 추천
	$(function (){
		$("#recommend").click(function () {
			var no = ${dto.no};
			var check = confirm("추천하시겠습니까?");
			if(check){
				alert("추천되었습니다.")
				$.get("./communityBoardRecommend?no="+no, function(data){
					data = data.trim();
				})
			}else{
				alert("실패하였습니다.");
			}
		})
	})
	// 비추천
	$(function (){
		$("#decommend").click(function () {
			var no = ${dto.no};
			var check = confirm("비추천하시겠습니까?");
			if(check){
				alert("비추천되었습니다.")
				$.get("./communtiyBoardDecommend?no="+no, function(data){
					data = data.trim();
				})
			}else{
				alert("실패하였습니다.");
			}
		})
	})
</script>
</head>
<body>
<%@include file = "../../temp/header.jsp" %>
<div id="body">
<jsp:include page="../communityCommon/navi.jsp"/>
	<div class="page-wrapper">
<!-- ----------------------------------게시글--------------------------------- -->
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
	</div>
		<button id="list" class="list">목록</button>
		<button id="update" class="update">수정</button>
		<button id="delete" class="del">삭제</button>
		<button id="recommend" class="rec">추천</button>
		<button id="decommend" class="dec">비추천</button>
<hr>
<!-- 댓글 시작 -->
<div class = "container">
	<div>
<!-- 댓글 입력폼 -->
			<div id = "comments_w">
				<label for="writer">작성자</label>
				<input type="text" id="writer" name="writer">
			</div>
			<div id = "comments_c">
				<label for="contents">내용</label>
				<textarea id="contents" name="contents" style="width:100%;height:100;border:1;overflow:visible;text-overflow:ellipsis;"></textarea>
			</div>
			<button class="btn btn-danger" id="comment_write">Write</button>
<!-- 댓글 입력끝 -->
	</div>
<!-- 댓글 출력폼 -->
	<div class="container">
		<table class="table table-bordered">
			<thead>
				<tr>
					<td width=50>번호</td>
					<td width=100>작성자</td>
					<td width=900>내용</td>
					<td width=100>날짜</td>
				</tr>
			</thead>
		</table>
		<table class="table table-bordered" id="comments_list" style="table-layout: fixed">
			<tbody >
			</tbody>
		</table>
		<button id="more">더보기</button>		
	</div>
<!-- 댓글 출력끝 -->
</div><!-- end of container -->
</div><!-- end of body  -->
<%@include file="../../temp/footer.jsp" %>
<%@include file="../../temp/activeweb.jsp"%>
</body>
</html>