<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath }/images/Teamlogo.ico" />
<link rel="stylesheet" href="../assets/css/main.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<style type="text/css">
	#main {
    padding: 40px 0;
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
		var frm = document.frm;
	
			var email = document.getElementById('email').value;
			var name = document.getElementById('name').value;
			var yy = document.getElementById('yy').value;
			var mm = document.getElementById('mm').value;
			var dd = document.getElementById('dd').value;
			var address = document.getElementById('address').value;
			var phone = document.getElementById('phone').value;
			var birth = yy+mm+dd;
			var id = document.getElementById('id').value;
			
			// 이메일 @ 형식 유지
			var re2 = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
			
			$('#id').keyup(function(){
				var idcheck = document.getElementById('idcheck');
				if(id.length > 9){
					idcheck.innerHTML = '아이디는 10자 미만으로 입력하세요';
			
				}else if(id.length < 10){
					idcheck.innerHTML = '';
				
				}
				
			});
			
			$('#idoverlap').click(function(){
				var id = document.getElementById('id').value;
				var xhttp;
				if(window.XMLHttpRequest){
					xhttp = new XMLHttpRequest();
				}else {
					xhttp = new ActiveXObject("Microsoft.XMLHTTP");
				}
				
				xhttp.open("GET","../member/idCheck?id="+id, true);
				
				xhttp.send();
				
				xhttp.onreadystatechange = function(){
					if(this.readyState == 4 && this.status == 200){
						if(this.responseText.trim()=='1'){
						$('#result').html("사용가능한 ID");
						$("#result").css("color","blue");
						} else{
							$('#result').html("사용 불가능한 ID");
							$("#result").css("color","red");
							$("#id").val("").focus();
				
						}
					}
				}			
			});
			
			
			// 특수문자+영문+숫자 조합 // 같은 문자 반복 x
			
			$('#pswd1').change(function(){
				checkPassword($('#pswd1').val(),$('id').val());
			});
			function checkPassword(pswd1,id){
				if(!/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,25}$/.test(pswd1)){            
			        alert('숫자+영문자+특수문자 조합으로 8자리 이상 사용해야 합니다.');
			        $('#pswd1').val('').focus();
			        return false;
			    }    
			    var checkNumber = pswd1.search(/[0-9]/g);
			    var checkEnglish = pswd1.search(/[a-z]/ig);
			    if(checkNumber <0 || checkEnglish <0){
			        alert("숫자와 영문자를 혼용하여야 합니다.");
			        $('#pswd1').val('').focus();
			        return false;
			    }
			    if(/(\w)\1\1\1/.test(pswd1)){
			        alert('같은 문자를 4번 이상 사용하실 수 없습니다.');
			        $('#pswd1').val('').focus();
			        return false;
			    }
			    
			    if(pswd1.value ==''){
			    	var pwcheck = document.getElementById('pwcheck').style.color = "red";
					pwcheck.innerHTML='필수 입력 항목입니다.';
				}
			     
			}
			$('#pswd2').blur(function() {
				var pwd1 = document.getElementById('pswd2');
				var pwdoverlap = document.getElementById('pwdoverlap');
				if (pswd2.value ==''){
					document.getElementById('pwdoverlap').style.color = "red";
					pwdoverlap.innerHTML = '필수 입력 항목입니다.';
				} else if(pswd1.value == pwd1.value) {
					document.getElementById('pwdoverlap').style.color = "blue";
					pwdoverlap.innerHTML = '비밀번호가 일치합니다';
				}
				else if(pswd1.value != pwd1.value){
					document.getElementById('pwdoverlap').style.color = "red";
					pwdoverlap.innerHTML = '비밀번호가 일치하지 않습니다';
				}
			});
			
			
			//닉네임
			$('#nickname').keyup(function(){
				
				var nicknamecheck = document.getElementById('nicknamecheck');
				if(nickname.length > 5){
					document.getElementById('nicknamecheck').style.color = "red";
					nicknamecheck.innerHTML = '닉네임은 6자 미만으로 입력하세요';
				}else if(nickname.length < 6){
					nicknamecheck.innerHTML = '';
					return false;
				}else if(nickname == ''){
					nicknamecheck.innerHTML = '닉네임을 입력해주세요.';
					return false;
				}
				
			});
			
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
			
			//이름
			
			$('#name').blur(function() {
			var name = document.getElementById('name');
			var namec = document.getElementById('namecheck');
			if (name.value == '') {
				document.getElementById('namecheck').style.color = "red";
				namec.innerHTML = '필수 입력 항목입니다';
			} else if (name.value.length > 5) {
				namec.innerHTML = '';
				return false;
			}
			});
			
			$('#yy').blur(function() {
				var yy = document.getElementById('yy');
				var yyc = document.getElementById('birthcheck');
				if (yy.value == '') {
					document.getElementById('birthcheck').style.color = "red";
					yyc.innerHTML = '필수 입력 항목입니다';
				}
			});
			
			$('#dd').blur(function() {
				var dd = document.getElementById('dd');
				var ddc = document.getElementById('birthcheck');
				if (dd.value == '') {
					document.getElementById('birthcheck').style.color = "red";
					ddc.innerHTML = '필수 입력 항목입니다';
				} 
				if(dd.value > 31){
					 $('#dd').val('').focus();
				}
				
			});
			
			$('#phone').blur(function() {
				var phone = document.getElementById('phone');
				var phonec = document.getElementById('phonecheck');
				if (phone.value == '') {
					document.getElementById('phonecheck').style.color = "red";
					phonec.innerHTML = '필수 입력 항목입니다';
				} else if (phone.value.length > 5) {
					phonec.innerHTML = '';
				}
			});
			
			$('#address').blur(function() {
				var address = document.getElementById('address');
				var addressc = document.getElementById('addresscheck');
				if (address.value == '') {
					document.getElementById('addresscheck').style.color = "red";
					addressc.innerHTML = '필수 입력 항목입니다';
				} else if (address.value.length > 5) {
					addressc.innerHTML = '';
				}
			});
			
			//이메일
			$('#email').blur(function() {
				
				var emailc = document.getElementById('emailcheck');
				if (email.value == '') {
					document.getElementById('emailcheck').style.color = "red";
					emailc.innerHTML = '필수 입력 항목입니다';
				} else if (email.value.length > 5) {
					emailc.innerHTML = '';
				}
			});
			
			
			//아이디
			//비밀번호
			//닉네임
			//이름
			//년 월 일
			//성별
			//핸드폰번호
			//주소
			//이메일
			
			$('#btnJoin').click(function(){
				
				var email = document.getElementById('email').value;
				var id = document.getElementById('id').value;
				var pswd1 = document.getElementById('pswd1').value;
				var nickname = document.getElementById('nickname').value;
				var name = document.getElementById('name').value;
				var yy = document.getElementById('yy').value;
				var mm = document.getElementById('mm').value;
				var dd = document.getElementById('dd').value;
				var address = document.getElementById('address').value;
				var phone = document.getElementById('phone').value;
				var birth = yy+mm+dd;
				
			
			if(!id || id.length>=10){
				alert("아이디를 입력하세요");
				f.id.focus();
				return false;
			}	
				
			if(!pswd1){
				alert("패스워드를 입력하세요");
				f.pswd1.focus();
				return false;
			}
			
			if(!nickname){
				alert("닉네임을 입력하세요");
				f.nickname.focus();
				return false;
			}
			
			if(!name){
				alert("이름을 입력하세요");
				f.name.focus();
				return false;
			}
			
			if(!yy){
				alert("태어난 년도를 입력하세요");
				f.yy.focus();
				return false;
			}
			if(!mm){
				alert("태어난 달을 선택하세요");
				f.mm.focus();
				return false;
			}
			if(!dd){
				alert("태어난 일을 입력하세요");
				f.dd.focus();
				return false;
			}
			if(!phone){
				alert("핸드폰 번호를 입력하세요");
				f.phone.focus();
				return false;
			}
			
			if(!address){
				alert("주소를 입력하세요");
				f.address.focus();
				return false;
			}
			
			if(!email){
				alert("이메일을 입력하세요");
				f.email.focus();
				return false;
			}
			
			if(!check(re2, email, "적합하지 않은 이메일 형식입니다.")) {
		           return false;
		       }
			
			location.href = "./memberJoin.jsp";
		});
			
	});

	
		


</script>
	
</head>
<body>
<%@include file="../temp/header.jsp" %>


<form action="${pageContext.request.contextPath}/member/memberJoin" method="post">
<div id="page-wrapper">
	<div id="main">
		<div class="container">

			<div id = "wrap">
				<h2> 회원가입합시다.</h2>
				<div class="join_content">
					<div class="join_row">
						<h3 class="join_title"><label for="id">아이디</label></h3>
						<span class="ps_box int_id"><input type="text" id="id" name="id" class="int" title="ID" maxlength="20"></span>
						<input type="hidden" id="idConfirm" value="0">
						<input type="button" value="중복확인" id="idoverlap" >
						<div id="result" class="check"></div>
						<div id="idcheck" class="check"></div>
						
					</div>
					<div class="join_row">
						<h3 class="join_title"><label for="pswd1">비밀번호</label></h3>
						<span class="ps_box int_pass" id="pswdImg">
							<input type="password" id="pswd1" name="pswd1" class="int" title="비밀번호 입력" aria-describedby="pswd1Msg" maxlength="20" >
						</span>
							<div id="pwcheck" class="check"></div>
						</div>
			
			<h3 class="join_title">
				<label for="pswd2">비밀번호 재확인</label>
			</h3>
			<span class="ps_box int_pass" id="pswd2Img">
				<input type="password" id="pswd2" name="pswd2" class="int" title="비밀번호 재확인 입력" aria-describedby="pswd2Blind" maxlength="20">
			</span>	
				<div id="pwdoverlap" class="check"></div>
			</div>
		<!--  -->
			<div class="join_row">
				<h3 class="join_title">
					<label for="nickname">닉네임</label>
				</h3>
				<span class="ps_box box_right_space"><input type="text" id="nickname" name="nickname" title="닉네임" class="int" maxlength="40"></span>
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
					<input type="text" id="name" name="name" title="이름" class="int" maxlength="40">
				</span>
				<div id="namecheck" class ="check"></div>
			</div>
		<div class="join_row join_birthday">
			<h3 class="join_title">
				<label for="yy">생년월일</label>
			</h3>
			<div class="bir_wrap">
				<div class="bir_yy">
					<span class="ps_box">
						<input type="text" id="yy" name="yy" placeholder="년(4자)" aria-label="년(4자)" class="int" maxlength="4">
					</span>
				</div>
				<div class="bir_mm">
					<span class="ps_box">
						<select id="mm" name="mm"class="sel" aria-label="월">
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
						<input type="text" id="dd" name="dd" placeholder="일" class="int" maxlength="2">
						<label for="dd" class="1b1"></label>
					</span>
				</div>
				<div></div>


			</div>
		</div>
		<div id="birthcheck" class = "check"></div>
		
		<div class="join_row">
				<h3 class="join_title">
					<label for="phone">핸드폰 번호</label>
				</h3>
				<span class="ps_box box_right_space">
					<input type="text" id="phone" name="phone" title="핸드폰 번호" class="int" maxlength="40">
				</span>
				<div id="phonecheck" class ="check"></div>
			</div>
			
		<!--  -->
		
		<div class="join_row">
				<h3 class="join_title">
					<label for="address">주소</label>
				</h3>
				<span class="ps_box box_right_space">
					<input type="text" id="address" name="address" title="주소" class="int" maxlength="40">
				</span>
				<div id="addresscheck" class ="check"></div>
			</div>
			
		<!--  -->
		<div class="join_row join_email">
			<h3 class="join_title">
				<label for="email">
				이메일 인증
				</label>
			</h3>
			<span class="ps_box box_right_space email ">
				<input type="email" id="email" name="email" maxlength="100" placeholder="이메일 입력" aria-label="이메일 입력" class="int">
			</span>
			<div id="emailcheck" class = "check"></div>
			
		</div>
	
		<div>
				<input type="submit" id="btnJoin" class="btn_type" value="Join">
			</div>
		
		

	</div>
			</div>

		</div>
	</div>
	
</form>
<%@include file="../temp/footer.jsp" %>
</body>
</html>