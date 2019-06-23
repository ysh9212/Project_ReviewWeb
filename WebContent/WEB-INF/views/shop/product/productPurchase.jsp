<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UDK</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="../../assets/css/main.css" />
<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<c:import url="../../temp/bootstrap.jsp" />
<script type="text/javascript">
	 $(function(){
		 $("#check_modules").click(function () {
				var IMP = window.IMP; 
				IMP.init('imp95286508');
				
				IMP.request_pay({
				pg: 'inicis',  //결제 방법 카카오페이 계좌입금 등 
				pay_method: 'card', //결제 수단
				merchant_uid: 'merchant_' + new Date().getTime(),
				name: '${productDTO.title}', //주문 창에서 보일 이름
				amount: 1000,  //가격
				buyer_email: document.getElementById('email').value, //구매자 정보
				buyer_name: document.getElementById('name').value,
				buyer_tel: document.getElementById('phone').value,
				buyer_addr: document.getElementById('address').value,
				m_redirect_url: 'https://www.yourdomain.com/payments/complete'
				
				}, function (rsp) {
					console.log(rsp);
					if (rsp.success) {
						var msg = '결제가 완료되었습니다.';
						msg += '고유ID : ' + rsp.imp_uid;
						msg += '상점 거래ID : ' + rsp.merchant_uid;
						msg += '결제 금액 : ' + rsp.paid_amount;
						msg += '카드 승인번호 : ' + rsp.apply_num;
					} else {
						var msg = '결제에 실패하였습니다.';
						msg += rsp.error_msg;
					}
					alert(msg);
				});
				});
	}); 
		function check_module(){
		/* $("#check_module").click(function () { */
			var IMP = window.IMP; // 생략가능
			IMP.init('imp95286508');
			
			// 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
			// i'mport 관리자 페이지 -> 내정보 -> 가맹점식별코드
			IMP.request_pay({
			pg: 'kakaopay', // version 1.1.0부터 지원.
			/*
			'inicis'
			'kakao':카카오페이,
			html5_inicis':이니시스(웹표준결제)
			'nice':나이스페이
			'jtnet':제이티넷
			'uplus':LG유플러스
			'danal':다날
			'payco':페이코
			'syrup':시럽페이
			'paypal':페이팔
			*/
			pay_method: 'card',
			/*
			'samsung':삼성페이,
			'card':신용카드,
			'trans':실시간계좌이체,
			'vbank':가상계좌,
			'phone':휴대폰소액결제
			*/
			merchant_uid: 'merchant_' + new Date().getTime(),
			name: '${productDTO.title}',
			//결제창에서 보여질 이름
			amount: 100, /*  */
			//가격
			buyer_email: document.getElementById('email').value,
			buyer_name: document.getElementById('name').value,
			buyer_tel: document.getElementById('phone').value,
			buyer_addr: document.getElementById('address').value,
			m_redirect_url: 'https://www.yourdomain.com/payments/complete'
			/*
			모바일 결제시,
			결제가 끝나고 랜딩되는 URL을 지정
			(카카오페이, 페이코, 다날의 경우는 필요없음. PC와 마찬가지로 callback함수로 결과가 떨어짐)
			*/
			}, function (rsp) {
			console.log(rsp);
			if (rsp.success) {
			var msg = '결제가 완료되었습니다.';
			msg += '고유ID : ' + rsp.imp_uid;
			msg += '상점 거래ID : ' + rsp.merchant_uid;
			msg += '결제 금액 : ' + rsp.paid_amount;
			msg += '카드 승인번호 : ' + rsp.apply_num;
			} else {
			var msg = '결제에 실패하였습니다.';
			msg += rsp.error_msg;
			}
			alert(msg);
			});
			}
	
</script>
<style type="text/css">
.purinfo{
	width: -webkit-fill-available;
	height: -webkit-fill-available;
}
.form-wrapper{
	width: 70%;
	margin: auto;
	height: -webkit-fill-available;
	margin-bottom: 50px;
}
.title1{
	color: black;
	font-size: 30px;
	font-weight: bold;
	
}
.form-control{
	margin : 10px;
}
.purimg{
	float: left;
	margin-right: 50px;
}
.meminfo{
	float: left;
	width: 100%;
}
.total{
	border: none;
}
.thumb-gallery{
	position: relative;
	float : left;
	width: 600px;
	height: 752px;
	margin-right: 50px;
}
.item-topinfo{
float: left;
width: 550px;
position: relative;
}
.con{
	width: inherit;
	color : black;
}
.pur{
	float: none;
	background: url("../../images/kakaopay.png");
}
.purwrapper{
	text-align: center;
	width : -webkit-fill-available;
	float: left;
}
.buy{
	border: solid 1px;
	background: #2e8de5;
	color : white;
	cursor: pointer;
	width : 50px;
	height: 50px;
	border-radius: 5px;
	font-weight: bold;
	
}
.buy1{
	width: 60px;
	margin : auto;
	float: left;
}
.buy2{
	width : 60px;
	margin: auto;
	float: left;
}
#kakao{
	cursor: pointer;
}
</style>
</head>
<body>
	<%@include file="../../temp/header.jsp"%>
	<div id="page-wrapper">
		<div id="main">
			<div class="container">
				<div class="form-wrapper">
					<form action="./productPurchase" method="post">
						<input type="hidden" value="${productDTO.pno }" name="pno">
						<input type="hidden" value="${num }" name="count">
						<div class="purinfo">
							<div class="purimg">
								<img alt="상품이미지" width="300px" height="300px" src="${pageContext.request.contextPath }/upload/${upload.fname}">
							</div>
							<h1 class="title1">주문 정보</h1>
							<div class="form-control">
								<label class="title">주문 상품 </label> 
								<div class="con">${productDTO.title }</div>
							</div>
							<div class="form-control">
								<label class="title">상품 번호</label>
								<div class="con">${productDTO.pno }</div>
							</div>
							<div class="form-control">
								<label class="title">주문 갯수</label>
								 <div class="con">${num} 개</div>
							</div>
							<div class="form-control">
								<label class="title">총 가격</label>
								<div><input type="text" name="price" value="${price }원" class="total" readonly>
								</div>
							</div>
							<div class="form-control">
								<label class="title">결제 방법</label>
								<select name="opt">
								<option value="카드">카드</option>
								</select>
							</div>
						
						<div class="meminfo">
							<h1 class="title1">회원정보</h1>
							<div class="form-control">
								<label class="title">회원 아이디</label>
								<div class="con">
								<input type="text" id="id" name="id" value="${memberDTO.id }" readonly>
								</div>
							</div>
							<div class="form-control">
							 	<label class="title">회원 이름</label>
								<div class="con"><input type="text" id="name" name="name" value="${memberDTO.name }" readonly> 
								</div>
							 </div>
							 <div class="form-control">
								<label class="title">전화 번호</label>
							 <input type="tel" id="phone" name="phone"	value="${memberDTO.phone }"> 
							 </div>
							 <div class="form-control">
								<label class="title">주소</label>
							 <input type="text" id="address" name="address" value="${memberDTO.address }">
							 </div>
							 <div class="form-control">
								<label class="title">이메일</label>
							<input type="email" id="email" name="email"	value="${memberDTO.email }">
							</div>
						
						</div><!-- meminfo  -->
						</div>
						<div class="purwrapper">
							<div class="buy1">
								<input id="check_modules" type="button" value="결제" class="buy">
							</div>
							<div class="buy2">
								<img width="50px" height="50px" id="kakao" alt="kakaopay" src="../../images/kakaopay.png"  onclick="check_module()">
							</div>
						</div>

					</form>
				</div>
			</div>
		</div>
	</div>
	
	<%@include file= "../../temp/footer.jsp" %>
</body>
</html>
				
				