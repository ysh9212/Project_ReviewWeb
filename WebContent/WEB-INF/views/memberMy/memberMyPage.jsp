<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>전체 마이 페이지</title>
<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath }/images/Teamlogo.ico" />
<link rel="stylesheet" href="../assets/css/main.css" />
<jsp:include page="./memberMyCommon/css.jsp"/>
<style type="text/css">
.btn_type{
    display: block;
    width: 15%;
    padding: 6px 0px;
    font-size: 5px;
    font-weight: 700;
    text-align: center;
    cursor: pointer;
    box-sizing: border-box;
    color: #fff;
    background-color: #007294;
    margin-right: 5px;
    float: left;
    }

.btn11{
	margin-top : 50px;
}
.memberinfor_label{
	margin: 60px;
}
.memberinfor_label{
	margin-top: 5px;
	padding: 10px;
}


.btn_type{
	float: right;
}

.label{
	margin-top: 15px;
}
</style>

</head>
<body>

<%@include file = "../temp/header.jsp" %>
<form action="${pageContext.request.contextPath}/memberMy/memberMyPage" method="post">
<div id="page-wrapper">
	<div id="main">
		<div class="container">
		<jsp:include page="./memberMyCommon/navi.jsp"/>
		<div id = "wrap">
			<h2 class="memberinfor">회원정보</h2>
				<div class="memberinfor_label">
					<div class="label">
					<label>아이디:${memberDTO.id}</label>
					</div>
					<div class="label">
					<label>닉네임:${memberDTO.nickname }</label>
					</div>
					<div class="label">
					<label>이름:${memberDTO.name }</label>
					</div>
					<div class="label">
					<label>생년월일:${memberDTO.birth }</label>
					</div>
					<div class="label">
					<label>핸드폰 번호:${memberDTO.phone }</label>
					</div>
					<div class="label">
					<label>주소:${memberDTO.address }</label>
					</div>
					<div class="label">
					<label>이메일:${memberDTO.email}</label>
					</div>
				</div>
				
				<div class="btn11">
					<a href="${pageContext.request.contextPath}/memberMy/memberMyDelete"><input type="button" id="btnJoin" class="btn_type btn" value="탈퇴"></a>
					<a href="${pageContext.request.contextPath}/memberMy/memberMyPwUpdate"><input type="button" id="btnJoin" class="btn_type btn" value="비밀번호 변경"></a>
					<a href="${pageContext.request.contextPath}/memberMy/memberMyUpdate"><input type="button" id="btnJoin" class="btn_type btn" value="회원정보 변경"></a>
				</div>
			
				</div>
			</div>
		</div>
	</div>
</form>
<%@include file="../temp/footer.jsp" %>
</body>
</html>