<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../assets/css/main.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


<style type="text/css">
	#container{
		margin: 0 auto;
    	max-width: 768px;
    	min-width: 460px;
    	
	}
	
	#main {
    padding: 40px 0;
}

#wrap{
	width: 500px;
	margin: 0 auto;
}
.int {
    display: block;
    position: relative;
    width: 100%;
    height: 29px;
    padding-right: 25px;
    line-height: 29px;
    border: none;
    background: #fff;
    font-size: 15px;
    box-sizing: border-box;
    z-index: 10;
    }


 .btn_type{
    width: 100%;
    padding: 21px 0 17px;
    font-size: 25px;
    font-weight: 700;
    text-align: center;
    cursor: pointer;
    box-sizing: border-box;
    color: #fff;
    background-color: #007294;
    margin-top : 20px;
    
    }
    
    .search_title{
		margin : 19px 0 8px;
		font-size: 14px;
		font-weight: 700;
	}
    
    label{cursor: default;}
    .ps_box.int_id{padding-right: 110px;}
    
    .ps_box, .ps_box_disable {
    display: block;
    position: relative;
    width: 100%;
    height: 51px;
    border: solid 1px #dadada;
    padding: 10px 14px 10px 14px;
    background: #fff;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
    vertical-align: top;
}
	#btnsearch {
		width : 100%;
	}
</style>
<script type="text/javascript">
	$(function(){
		var frm = document.frm;
		$('#btnsearch').click(function(){
			var name = document.getElementById('name').value;
			var email = document.getElementById('email').value; // id가 id인 객체를 id라는 변수에 저장
			if(!name){
				alert("이름을 입력하세요");
				f.name.focus();
				return false;
			}
			
			if(!email){
				alert("이메일을 입력하세요");
				f.email.focus();
				return false;
			}
			
			location.href = "./memberSearchId.jsp";
		});
		
	});

</script>
</head>
<body>
<%@include file = "../temp/header.jsp" %>
<div id="page-wrapper">
	<div id="main">
		<div class="container">
		<div id = "wrap">
			<form action="${pageContext.request.contextPath}/member/memberSearchId" id="form1" method="post">
			<h2> 아이디  찾기</h2>
			<div class="search_content">
				
				<div class="search_row">
					<h3 class="search_title"><label for="name">이름</label></h3>
					<span class="ps_box">
						<input type="text" id="name" class="int" name="name" title="이름입력" maxlength="20" placeholder="이름을 입력하세요">
					</span>
				</div>
				<div class="search_row">
					<h3 class="search_title"><label for="email">이메일</label></h3>
					<span class="ps_box int_pass">
						<input type="text" id="email" name="email" class="int" title="이메일 입력" maxlength="20" placeholder="이메일을 입력하세요">
					</span>
				</div>
				
				<div class="btn_search">
					<div class="btn_wrap">
							<input type="submit" id="btnsearch" class="btn_type" name="btnsearch" value="아이디 찾기">
					</div>
				</div>
		
			</div>

			</form>
			</div>
			
			
			
		</div>
	</div>
</div>
<%@include file="../temp/footer.jsp" %>

</body>
</html>