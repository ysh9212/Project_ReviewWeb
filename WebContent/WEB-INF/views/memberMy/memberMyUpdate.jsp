<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../assets/css/main.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<jsp:include page="./memberMyCommon/css.jsp"/>
<style type="text/css">

	body, button, dd, dl, dt, fieldset, form, h1, h2, h3, h4, h5, h6, input, legend, li, ol, p, select, table, td, textarea, th, ul {
    margin: 0;
    padding: 0;
    }
    
    #content{
    	width: 460px;
    	height: 700px;
    	margin: 0 auto;
    }
    
	#wrap{
		width: 500px;
	}
	div, form {display: block;}
	
	.ipin_box, .row_group{
		overflow: hidden;
		width: 100%;
	}
	
	
	.join_title{
		margin : 19px 0 8px;
		font-size: 14px;
		font-weight: 700;
	}
	
	h3{
		display: block;
		margin-block-start: 1em;
    	margin-block-end: 1em;
    	margin-inline-start: 0px;
    	margin-inline-end: 0px;
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
	
	
	
	select:not(:-internal-list-box) {
    overflow: visible !important;
}
	
	input{
	-webkit-writing-mode: horizontal-tb !important;
    text-rendering: auto;
    color: initial;
    letter-spacing: normal;
    word-spacing: normal;
    text-transform: none;
    text-indent: 0px;
    text-shadow: none;
    text-align: start;
    -webkit-rtl-ordering: logical;
    cursor: text;
    font: 400 13.3333px Arial;
	}
	
	.error_next_box {
    display: block;
    margin: 9px 0 -2px;
    font-size: 12px;
    line-height: 14px;
    color: red;
    }
    
    .row_group {margin-top: 20px;}
    .box_right_space{
    	padding-right: 14px;
    	box-sizing: border-box;
    }
    
    .btn_type{
    display: block;
    width: 100%;
    padding: 21px 0 17px;
    font-size: 20px;
    font-weight: 700;
    text-align: center;
    cursor: pointer;
    box-sizing: border-box;
    color: #fff;
    background-color: #007294;
    margin-top: 40px;
    
    }
    
    .wa_blind {
    position: absolute;
    overflow: hidden;
    clip: rect(0 0 0 0);
    margin: -1px;
    width: 1px;
    height: 1px;
    font-size: 0;
}
    .ps_box {
    padding: 11px 14px;
}

.box_right_space {
    padding-right: 14px;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
}

.name_wrap {
    display: table;
    width: 100%;
}

.sel{
	width: 100%;
    height: 29px;
    font-size: 13px;
    line-height: 18px;
    color: #000;
    border: none;
    border-radius: 0;
    -webkit-appearance: none;
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
    
    .checkPwd{
    	margin-top: 15px;
    	font-size: 7px;
    }
    .check{
    	margin-top: 15px;
    	font-size: 8px;
    }
</style>
<script type="text/javascript">
	$(function(){
		$('#idoverlap2').click(function(){
			var nickname = document.getElementById('nickname').value;
			var xhttp;
			if(window.XMLHttpRequest){
				xhttp = new XMLHttpRequest();
			}else {
				xhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
			
			xhttp.open("GET","../member/nicknameCheck?nickname="+nickname, true);
			
			xhttp.send();
			
			xhttp.onreadystatechange = function(){
				if(this.readyState == 4 && this.status == 200){
					if(this.responseText.trim()=='1'){
					$('#result2').html("사용가능한 닉네임");
					$("#result2").css("color","blue");
					} else{
						$('#result2').html("사용 불가능한 닉네임");
						$("#result2").css("color","red");
						$("#nickname").val("").focus();
			
					}
				}
			}			
		});
		
	});
</script>
</head>
<body>

<%@include file = "../temp/header.jsp" %>
<form action="${pageContext.request.contextPath}/memberMy/memberMyUpdate" method="post">
<div id="page-wrapper">
	<div id="main">
		<div class="container">
		<jsp:include page="./memberMyCommon/navi.jsp"/>
		<div id = "wrap">
			<h2 class="memberinfor"> 회원 정보 수정 </h2>
				<div class="join_content">
					<div class="join_row">
						<h3 class="join_title"><label for="id">아이디</label></h3>
						<span class="ps_box int_id"  style="background-color:gray;"><input type="text" id="id" name="id" class="int"  style="background-color:gray;" title="ID" maxlength="20" value="${memberDTO.id }" readonly="readonly"></span>
						
					</div>
				</div>	
			<div class="join_row">
				<h3 class="join_title">
					<label for="nickname">닉네임</label>
				</h3>
				<span class="ps_box box_right_space"><input type="text" id="nickname" name="nickname" title="닉네임" class="int" maxlength="40" value="${memberDTO.nickname }"></span>
				<input type="hidden" id="idConfirm" value="0">
				<input type="button" value="중복확인" id="idoverlap2" >
				<div id="result2" class="check"></div>
				<div id="nicknamecheck" class ="check"></div>
			</div>
		
			<div class="join_row">
				<h3 class="join_title">
					<label for="name">이름</label>
				</h3>
				<span class="ps_box box_right_space">
					<input type="text" id="name" name="name" title="이름" class="int" maxlength="40" value="${memberDTO.name }">
				</span>
			</div>
			<div class="join_row">
				<h3 class="join_title">
					<label for="birth">생년월일</label>
				</h3>
				<span class="ps_box box_right_space" style="background-color:gray;">
					<input type="text" id="birth" style="background-color:gray;" name="birth" title="생년월일" class="int" maxlength="40" value="${memberDTO.birth }" readonly="readonly">
				</span>
		</div>
		
		<div class="join_row">
				<h3 class="join_title">
					<label for="phone">핸드폰 번호</label>
				</h3>
				<span class="ps_box box_right_space">
					<input type="text" id="phone" name="phone" title="핸드폰 번호" class="int" maxlength="40" value="${memberDTO.phone }">
				</span>
			</div>
			
		<!--  -->
		
		<div class="join_row">
				<h3 class="join_title">
					<label for="address">주소</label>
				</h3>
				<span class="ps_box box_right_space">
					<input type="text" id="address" name="address" title="주소" class="int" maxlength="40" value="${memberDTO.address }">
				</span>
			</div>
			
		<!--  -->
		<div class="join_row join_email">
			<h3 class="join_title">
				<label for="email">
				이메일
				</label>
			</h3>
			<span class="ps_box box_right_space email ">
				<input type="email" id="email" name="email" maxlength="100" placeholder="이메일 입력" aria-label="이메일 입력" class="int" value="${memberDTO.email }">
			</span>
			
		</div>
		<div>
				<input type="submit" id="btnJoin" class="btn_type" value="수정하기">
			</div>
			
		</div>
		</div>
	</div>
</div>
</form>
<%@include file="../temp/footer.jsp" %>
</body>
</html>