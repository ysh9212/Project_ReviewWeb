<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../assets/css/main.css" />
<style type="text/css">
	#main {
    padding: 40px 0;
}
	
	button, input, select, textarea{
		border: 0;
		border-radius: 0;
		-webkit-appearance: none;
	}
	
	body, button, dd, dl, dt, fieldset, form, h1, h2, h3, h4, h5, h6, input, legend, li, ol, p, select, table, td, textarea, th, ul {
    margin: 0;
    padding: 0;
    }
    
    #content{
    	width: 460px;
    	height: 700px;
    	margin: 0 auto;
    }
    
    
	
	
	#container{
		margin: 0 auto;
    	max-width: 768px;
    	min-width: 460px;
    	
	}
	
	#wrap{
	width: 500px;
	margin: 0 auto;
}
	
	div, form {display: block;}
	
	.ipin_box, .row_group{
		overflow: hidden;
		width: 100%;
	}
	
	html{color: -internal-root-color;}
	
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
    
    .join_birthday{
		padding: 0px;    
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
    .join_birthday .ps_box {
    padding: 11px 14px;
}
	
	.bir_dd, .bir_mm, .bir_yy {
    display: table-cell;
    table-layout: fixed;
    width: 147px;
    vertical-align: middle;
    }
    
    .bir_mm+.bir_dd, .bir_yy+.bir_mm {
    padding-left: 10px;
}

.box_right_space {
    padding-right: 14px;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
}

.bir_wrap, .name_wrap {
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

</style>
</head>
<body>
<%@include file = "../temp/header.jsp" %>


<form action="./memberJoin" method="post" enctype="multipart/form-data">
<div id="page-wrapper">
	<div id="main">
		<div class="container">
		<div id = "wrap">
		
		<h2> 회원가입합시다.</h2>
		<div class="join_content">
			<div class="join_row">
				<h3 class="join_title">
				<label for="id">아이디</label>
				</h3>
			<span class="ps_box int_id">
				<input type="text" id="id" class="int" title="ID" maxlength="20">
			</span>
			<span class="error_next_box" id="idMsg" style role="alert">필수 정보입니다.</span>
			</div>
			<div class="join_row">
			<h3 class="join_title">
				<label for="pswd1">비밀번호</label>
			</h3>
			<span class="ps_box int_pass" id="pswdImg">
				<input type="password" id="pswd1" name="pswd1" class="int" title="비밀번호 입력" aria-describedby="pswd1Msg" maxlength="20">
				<span class="1b1">
					<span id="pswd1Span" class="step_txt"></span>
				</span>
			</span>
			<span class="error_next_box" id="pswd1Msg" style role="alert">필수 정보입니다.</span>
			
			<h3 class="join_title">
				<label for="pswd2">비밀번호 재확인</label>
			</h3>
			<span class="ps_box int_pass_check" id="pswd2Img">
				<input type="password" id="pswd2" name="pswd2" class="int" title="비밀번호 재확인 입력" aria-describedby="pswd2Blind" maxlength="20">
				<span id="pswd2Blind" class="wa_blind">설정하려는 비밀번호가 맞는지 확인하기 위해 다시 입력 해주세요.</span>
			</span>
			<span class="error_next_box" id="pswd2Msg" style role="alert">필수 정보입니다.</span>
			</div>
		</div>
		<div class="row_group">
			<div class="join_row">
				<h3 class="join_title">
					<label for="name">이름</label>
				</h3>
				<span class="ps_box box_right_space">
					<input type="text" id="name" name="name" title="이름" class="int" maxlength="40">
				</span>
				<span class="error_next_box" id="nameMsg" style="display:none" role="alert"></span>
			</div>
		<div class="join_row join_birthday">
			<h3 class="join_title">
				<label for="yy">생년월일</label>
			</h3>
			<div class="bir_wrap">
				<div class="bir_yy">
					<span class="ps_box">
						<input type="text" id="yy" placeholder="년(4자)" aria-label="년(4자)" class="int" maxlength="4">
					</span>
				</div>
				<div class="bir_mm">
					<span class="ps_box">
						<select id="mm" class="sel" aria-label="월">
							<option>월</option>
							<option value="01">1</option>
							<option value="02">2</option>
							<option value="03">3</option>
							<option value="04">4</option>
							<option value="05">5</option>
							<option value="06">6</option>
							<option value="07">7</option>
							<option value="08">8</option>
							<option value="09">9</option>
							<option value="10">10</option>
							<option value="11">11</option>
							<option value="12">12</option>
						</select>
					</span>
				</div>
				<div class="bir_dd">
					<span class="ps_box">
						<input type="text" id="dd" placeholder="일" class="int" maxlength="2">
						<label for="dd" class="1b1"></label>
					</span>
				</div>
			</div>
		</div>
		<span class="error_next_box" id="birthdayMsg" style="display:none: role="alert">
		</span>
		</div>
		<div class="join_row join_sex">
			<h3 class="join_title">
				<label for="gender">성별</label>
			</h3>
			<div class="ps_box gender_code">
				<select id="gender" name="gender" class="sel" aria-label="성별">
					<option value selected>성별</option>
					<option value="M">남자</option>
					<option value="W">여자</option>
				</select>
			</div>
		</div>
		<span class="error_next_box" id="genderMsg" style="display:none" role="alert"></span>
		<div class="join_row join_email">
			<h3 class="join_title">
				<label for="email">
				이메일 인증
				</label>
			</h3>
			<span class="ps_box box_right_space email ">
				<input type="text" id="email" name="email" maxlength="100" placeholder="이메일 입력" aria-label="이메일 입력" class="int">
			</span>
			
		</div>
		<span class="error_next_box" id="emailMsg" style="display:none" role="alert"></span>
		
		<div>
				<button type="button" id="btnJoin" class="btn_type">
				<span>Join</span>
				</button>
			</div>
		
		
	</div>
			</div>
		
		</div>
		
	</div>
	
</form>
<%@include file="../temp/footer.jsp" %>
</body>
</html>