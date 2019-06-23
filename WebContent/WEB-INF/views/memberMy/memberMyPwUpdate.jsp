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
<jsp:include page="./memberMyCommon/css.jsp"/>
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
		
		$('#cur_pw').blur(function(){
			var cur_pw = document.getElementById('cur_pw').value;
			
			var xhttp;
			if(window.XMLHttpRequest){
				xhttp = new XMLHttpRequest();
			}else {
				xhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
			
			xhttp.open("POST","../memberMy/pwCheck?cur_pw="+cur_pw, true);
			xhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			
			xhttp.send();
			
			xhttp.onreadystatechange = function(){
				if(this.readyState == 4 && this.status == 200){
					if(this.responseText.trim()=='1'){
					$('#result').html("현재 pw와 일치");
					$("#result").css("color","blue");
					} else{
						$('#result').html("현재 pw와 불일치");
						$("#result").css("color","red");
						$("#cur_pw").val("").focus();
			
					}
				}
			}			
		});
		
		
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
				if (pswd1.value == pwd1.value) {
					document.getElementById('pwdoverlap').style.color = "blue";
					pwdoverlap.innerHTML = '비밀번호가 일치합니다';
				} else if(pswd2.value ==''){
					document.getElementById('pwdoverlap').style.color = "red";
					pwdoverlap.innerHTML = '필수 입력 항목입니다.';
				} 
				else if(pswd1.value != pwd1.value){
					document.getElementById('pwdoverlap').style.color = "red";
					pwdoverlap.innerHTML = '비밀번호가 일치하지 않습니다';
				}
			});
			
		$('#btnsearch').click(function(){
			var cur_pw = document.getElementById('cur_pw').value;
			var pswd1 = document.getElementById('pswd1').value;
			
			if(!cur_pw){
				alert("현재 비밀번호를 입력하세요");
				f.cur_pw.focus();
				return false;
			}
			
			if(!pswd1){
				alert("새 비밀번호를 입력하세요");
				f.pswd1.focus();
				return false;
			}
			
			location.href = "./memberMyPwUpdate.jsp";
		});
		
		
		
	});
	
	

</script>
</head>
<body>

<%@include file = "../temp/header.jsp" %>
<div id="page-wrapper">
	<div id="main">
		<div class="container">
			<jsp:include page="./memberMyCommon/navi.jsp"/>
			<div id = "wrap">
			<form action="${pageContext.request.contextPath}/memberMy/memberMyPwUpdate" method="post">
				<h2 class="memberinfor"> 비밀번호 변경 </h2>
				<div class="search_content">
				<input type="hidden" name="id" value="${memberDTO.id}">
				<div class="search_row">
					<h3 class="search_title"><label for="cur_pw">현재 비밀번호 </label></h3>
					<span class="ps_box">
						<input type="text" id="cur_pw" class="int" name="cur_pw" title="현재 비밀번호 입력" maxlength="20" placeholder="현재 비밀번호">
					</span>
					<div id="result" class="check"></div>
				</div>
				
				<div class="search_row">
					<h3 class="search_title"><label for="pswd1">새 비밀번호 </label></h3>
					<span class="ps_box">
						<input type="password" id="pswd1" class="int" name="pswd1" title="새 비밀번호 입력" maxlength="20" placeholder="새 비밀번호">
					</span>
					<div id="pwcheck" class="check"></div>
				</div>
				<div class="search_row">
					<h3 class="search_title"><label for="pswd2">새 비밀번호 확인</label></h3>
					<span class="ps_box int_pass">
						<input type="password" id="pswd2" name="pswd2" class="int" title="새 비밀번호 확인 입력" maxlength="20" placeholder="새 비밀번호 확인">
					</span>
					<div id="pwdoverlap" class="check"></div>
				</div>
				
				<div class="btn_search">
					<div class="btn_wrap">
							<input type="submit" id="btnsearch" class="btn_type" name="btnsearch" value="비밀번호  변경">
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