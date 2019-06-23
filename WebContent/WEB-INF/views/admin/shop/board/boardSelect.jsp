<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shop ${board }관리자</title>
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<c:import url="../../../../../assets/css/admincss.jsp"/>
<c:import url="../../../temp/bootstrap.jsp" />
<script type="text/javascript">
	
	$(function() {
		$('#delete').click(function() {
			var check = confirm("정말 삭제하시겠습니까?");
			if (check) {
				$.get("./${board}Delete?no=${dto.no}", function(data) {
					if(data>0){
							alert("해당글이 삭제되었습니다.");
						}else{
							alert("삭제 실패");
						}
						location.href ="./{board}";
					});
				}
			});
		});	
</script>
</head>
<body>
<c:import url="../../../temp/adminsetting.jsp"/>	
	<div class="main">
	SHOP ${board } 페이지
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
			
		<a href="./${board }Delete?no=${dto.no}" class="btn" id="delete">Delete</a>
		<a href="./${board }Update?no=${dto.no}" class="btn">Update</a>
</div>

</body>
</html>