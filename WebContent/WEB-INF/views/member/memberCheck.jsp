<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Check</title>
<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="../assets/css/main.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
		$(function(){
			$('#checkAll').click(function(){
				var c = $(this).prop('checked');
				$('.check').prop('checked', c);
			}); 
			
			$('.check').click(function(){
				var c = true;
				$('.check').each(function(){ 
					if(!$(this).prop('checked')){
						c=false;
					}
				});
				$('#checkAll').prop('checked',c);
			});
			
			$('#join').click(function(){
				var c = $('#checkAll').prop('checked');
				if(c){
					location.href = "./memberJoin";
				}else {
					alert('약관에 동의하세요');
				}
			});
			
		});
	
</script>
</head>
<body>
<%@include file = "../temp/header.jsp" %>

<div id="page-wrapper">
	<div id="main">
		<div class="container">
		
		<h2>약관동의</h2>
		
			<div class="checkbox">
				<label><input type="checkbox" id="checkAll"> 전체동의</label>
			</div>
			<div class="checkbox">
				<label><input type="checkbox" class="check"> 동의A</label>
			</div>
			<div class="checkbox">
				<label><input type="checkbox" class="check"> 동의B</label>
			</div>
			<div class="checkbox">
				<label><input type="checkbox" class="check"> 동의C</label>
			</div>
			<input type="button" class="btn btn-default" value="Join" id="join">
		</div>
	</div>
</div>
		<%@include file="../temp/footer.jsp" %>
</body>
</html>