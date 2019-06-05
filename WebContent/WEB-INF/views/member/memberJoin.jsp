<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../assets/css/main.css" />
</head>
<body>
<%@include file = "../temp/header.jsp" %>



<div id="page-wrapper">
	<div id="main">
		<div class="container">
		<form action="./memberJoin" method="post" enctype="multipart/form-data">
		<h2> 여기는 회원가입 하는 곳입니다.</h2>
		<div class="join_content">
			<div class="join_row">
				<h3 class="join_title">
		
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
				"본인 확인 이메일"
				</label>
			</h3>
			<span class="ps_box int email box_right_space">
				<input type="text" id="email" name="email" maxlength="100" placeholder="선택입력" aria-label="선택입력" class="int">
			</span>
		</div>
		<span class="error_next_box" id="emailMsg" style="display:none" role="alert"></span>
	</div>
			
			<div>
				<button type="button" id="btnJoin" class="btn btn-primary">
				<span>Join</span>
				</button>
			</div>
		</form>
		
	
		</div>
	</div>
	
</div>
<%@include file="../temp/footer.jsp" %>
</body>
</html>