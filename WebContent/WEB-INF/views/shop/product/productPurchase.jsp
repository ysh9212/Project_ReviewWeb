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
		$("#check_module").click(function () {
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
			/*
			merchant_uid에 경우
			https://docs.iamport.kr/implementation/payment
			위에 url에 따라가시면 넣을 수 있는 방법이 있습니다.
			참고하세요.
			나중에 포스팅 해볼게요.
			*/
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
			});
	});
</script>
</head>
<body>
	<%@include file="../../temp/header.jsp"%>
	<div id="page-wrapper">
		<div id="main">
			<div class="container">
				<form action="./productPurchase" method="post">
				<input type="hidden" value="${productDTO.pno }" name="pno">
				<input type="hidden" value="${num }" name="count">
				<img alt="상품" src="${pageContext.request.contextPath }/upload/${upload.fname}" width="300" height="300">
				주문 상품 : ${productDTO.title }
				상품 번호 : ${productDTO.pno }
				주문 갯수 : ${num}
				총 가격 :	<input type ="text" name="price" value="${price }원" readonly>
				결제 방법 : 
				<select name="opt">
						<option value="카드">카드</option>
				</select>
				<div> <h1>회원정보</h1></div>
				회원 아이디<input type="text" id="id" name = "id" value="${memberDTO.id }" readonly>
				회원 이름 <input type ="text" id="name" name = "name" value="${memberDTO.name }" readonly>
				전화번호 <input type="tel" id="phone" name = "phone" value="${memberDTO.phone }">
				주소 <input type="text" id="address" name = "address" value="${memberDTO.address }">
				이메일<input type="email" id="email" name ="email" value ="${memberDTO.email }">
					<p>아임 서포트 결제 모듈 테스트 해보기</p>
					<button id="check_module" type="button">아임 서포트 결제 모듈 테스트 해보기</button>


			</form>
			</div>
		</div>
	</div>
	
	<%@include file= "../../temp/footer.jsp" %>
</body>
</html>
				
				