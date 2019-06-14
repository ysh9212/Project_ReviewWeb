<%@page import="com.project.member.MemberDAO"%>
<%@page import="com.project.member.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#iduse').click(function(){
			id = document.getElementById('id').value;
			opener.document.getElementById('id').value = id;
			opener.document.getElementById('idConfirm').value = '1';
			close();
		});
		$('#id').change(function(){
			$('#iduse').remove();
		});
	});
</script>
</head>
<body>
<div class="container">
  <h2>아이디를 입력하세요</h2>
  <form action="${pageContext.request.contextPath}/member/memberIdCheck" method="post">
    <div class="form-group">
      <label for="id">Id:</label>
      <input type="text" class="form-control" id="id" value='${id}' name="id">
      <button>중복확인</button>
    </div>
	<div id="idcheck" class="check">
      <input type="button" value="사용하기" id="iduse">
  	</div>
  </form>
  </div>
</body>
</html>