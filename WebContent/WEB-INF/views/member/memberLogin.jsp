<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<title>login</title>
	<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath }/images/Teamlogo.ico" />
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<script type="text/javascript" src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js" charset="utf-8"></script>
	<link rel="stylesheet" href="../assets/css/main.css" />
<style type="text/css">
html{color: -internal-root-color;}

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
    
    .login_title{
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
	#btnLogin1 {
		width : 100%;
	}
	
.btn_type2{

    width: 25%;
    padding: 4px 0;
    font-size: 10px;
    font-weight: 700;
    text-align: center;
    cursor: pointer;
    box-sizing: border-box;
    color: #fff;
    background-color: #007294;
    margin-top : 10px;
    margin-right : 8px;
	float : right;
    }
    
    .btn_wrap2{
    	margin: right;
    }
    
    .remember{
    	margin-top: 13px;
    }
    
    #naverIdLogin{
    	margin-top: 13px;
    }
</style>

</head>
<body>
<%@include file = "../temp/header.jsp" %>
	<form method="post" action="./memberLogin">
		<div id="page-wrapper">
			<div id="main">
				<div class="container">
					<div id="wrap">


						<div class="login_content">
							<div class="login_row">
								<h3 class="login_title">
									<label for="id">아이디</label>
								</h3>
								<span class="ps_box"> <input type="text" id="id"
									class="int" name="id" value="${cookie.check.value}"
									title="아이디 입력" maxlength="20" placeholder="아이디를 입력하세요">
								</span>
							</div>
							<div class="login_row">
								<h3 class="login_title">
									<label for="pswd1">비밀번호</label>
								</h3>
								<span class="ps_box int_pass"> <input type="password"
									id="pw" name="pw" class="int" title="비밀번호 입력" maxlength="20"
									placeholder="비밀번호를 입력하세요">
								</span>
							</div>

							<div class="btn_login">
								<div class="btn_wrap">
									<input type="submit" id=" btn btnLogin1" class="btn_type"
										value="로그인">

								</div>
							</div>

						</div>


						
			
	<div class="btn_wrap2">
		<label><input type="checkbox" name="check" value="1" class="remember"> Remember me</label>
		<a href="${pageContext.request.contextPath}/member/memberSearchPw"><button type="button" id="btnLogin3" class="btn_type2"><span>비밀번호 찾기</span></button></a>
		<a href="${pageContext.request.contextPath}/member/memberSearchId"><button type="button" id="btnLogin2" class="btn_type2"><span>아이디 찾기</span></button></a>
	<!-- 네이버API -->
<div id="naverIdLogin"></div>  <!-- 버튼이 들어갈 위치 선언. ID는 반드시 지정된 값으로 설정하여야 합니다.-->

<script type="text/javascript">
	var naverLogin = new naver.LoginWithNaverId(
		{
			clientId: "kTnlKKclm8WeI7PFn3Dr",
			callbackUrl: "http://127.0.0.1/Project_ReviewWeb/member/memberNaverCallback.jsp",
			isPopup: false, /* 팝업을 통한 연동처리 여부 */
			loginButton: {color: "green", type: 3, height: 40} /* 로그인 버튼의 타입을 지정 */
		}
	);
	
   /* 설정정보를 초기화하고 연동을 준비 */
	naverLogin.init();
</script>
		
	</div>
	</div>
	</div>
	</div>
	

		</div>
	</form>

	<%@include file="../temp/footer.jsp" %>


		<!-- Scripts -->
			<script src="./assets/js/jquery.min.js"></script>
			<script src="./assets/js/browser.min.js"></script>
			<script src="./assets/js/breakpoints.min.js"></script>
			<script src="./assets/js/util.js"></script>
			<script src="./assets/js/main.js"></script>

</body>
</html>