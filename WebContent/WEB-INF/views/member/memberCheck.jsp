<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Check</title>
<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="../assets/css/main.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
		$(function(){
			$('#checkAll').click(function(){
				var c = $(this).prop('checked');
				$('.check').prop('checked', c);
			}); 
			
			$('.check').click(function(){
				var c = true;
				$('.check').each(function(){ 
					if(!$(this).prop('checked')){
						c=false;
					}
				});
				$('#checkAll').prop('checked',c);
			});
			
			$('#join').click(function(){
				var c = $('#checkAll').prop('checked');
				if(c){
					location.href = "./memberJoin";
				}else {
					alert('약관에 동의하세요');
				}
			});
			
		});
	
</script>
<style type="text/css">
#container{
		margin: 0 auto;
    	max-width: 768px;
    	min-width: 460px;
    	
	}

#wrap{
	width: 500px;
	margin: 0 auto;
}

.btn_type{
    width: 49%;
    padding: 13px 0;
    font-size: 10px;
    font-weight: 700;
    text-align: center;
    cursor: pointer;
    box-sizing: border-box;
    color: #fff;
    
    margin-top : 20px;
    
    }
    
    .checkwrap{
    	margin-top: 10px;
    }
    
    .chb_wrap{
    	margin-top: 10px;
    }
    
    .checkbox{
    	margin-top: 10px;
    }
    
    .textarea{
    	margin-top: 10px;
    }
    
    #join_not{
    background-color: gray;
    }
    
    #join{
    background-color: #007294;
    }
</style>
</head>
<body>
<%@include file = "../temp/header.jsp" %>

<div id="page-wrapper">
	<div id="main">
		<div class="container">
			<div id = "wrap">
				<h2>약관동의</h2>
			<div class="chb_wrap">	
				<div>
					<label><input type="checkbox" id="checkAll"> 전체동의</label>
				</div>
				
				<div class="checkbox">
					<label><input type="checkbox" class="check"> 커뮤니티 이용 약관 동의</label>
				</div>
				<div class="textarea">
					<textarea name="message" rows="5" cols="68" readonly="readonly">여러분을 환영합니다.
네이버 서비스 및 제품(이하 ‘서비스’)을 이용해 주셔서 감사합니다. 본 약관은 다양한 네이버 서비스의 이용과 관련하여 네이버 서비스를 제공하는 네이버 주식회사(이하 ‘네이버’)와 이를 이용하는 네이버 서비스 회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며, 아울러 여러분의 네이버 서비스 이용에 도움이 될 수 있는 유익한 정보를 포함하고 있습니다.

네이버 서비스를 이용하시거나 네이버 서비스 회원으로 가입하실 경우 여러분은 본 약관 및 관련 운영 정책을 확인하거나 동의하게 되므로, 잠시 시간을 내시어 주의 깊게 살펴봐 주시기 바랍니다.

다양한 네이버 서비스를 즐겨보세요.</textarea>
				</div>
			</div>
				<div class="checkbox">
					<div>
						<label><input type="checkbox" class="check"> 개인정보 수집 및 이용에 대한 안내</label>
					</div>
				<div class="textarea">
				<textarea name="message" rows="5" cols="68" readonly="readonly">정보통신망법 규정에 따라 네이버에 회원가입 신청하시는 분께 수집하는 개인정보의 항목, 개인정보의 수집 및 이용목적, 개인정보의 보유 및 이용기간을 안내 드리오니 자세히 읽은 후 동의하여 주시기 바랍니다. 1. 수집하는 개인정보
이용자는 회원가입을 하지 않아도 정보 검색, 뉴스 보기 등 대부분의 네이버 서비스를 회원과 동일하게 이용할 수 있습니다. 이용자가 메일, 캘린더, 카페, 블로그 등과 같이 개인화 혹은 회원제 서비스를 이용하기 위해 회원가입을 할 경우, 네이버는 서비스 이용을 위해 필요한 최소한의 개인정보를 수집합니다.

회원가입 시점에 네이버가 이용자로부터 수집하는 개인정보는 아래와 같습니다.
- 회원 가입 시에 ‘아이디, 비밀번호, 이름, 생년월일, 성별, 가입인증 휴대전화번호’를 필수항목으로 수집합니다. 만약 이용자가 입력하는 생년월일이 만14세 미만 아동일 경우에는 법정대리인 정보(법정대리인의 이름, 생년월일, 성별, 중복가입확인정보(DI), 휴대전화번호)를 추가로 수집합니다. 그리고 선택항목으로 이메일 주소를 수집합니다.
- 단체아이디로 회원가입 시 단체아이디, 비밀번호, 단체이름, 이메일주소, 가입인증 휴대전화번호를 필수항목으로 수집합니다. 그리고 단체 대표자명을 선택항목으로 수집합니다.</textarea>
			</div>
			</div>
			<div class="checkbox">
			<div>
				<label><input type="checkbox" class="check"> 위치정보 이용약관 동의</label>
			</div>
			<div class="textarea">
			<textarea name="message" rows="5" cols="68" readonly="readonly">위치정보 이용약관에 동의하시면, 위치를 활용한 광고 정보 수신 등을 포함하는 네이버 위치기반 서비스를 이용할 수 있습니다.  제 1 조 (목적)
이 약관은 네이버 주식회사 (이하 “회사”)가 제공하는 위치정보사업 또는 위치기반서비스사업과 관련하여 회사와 개인위치정보주체와의 권리, 의무 및 책임사항, 기타 필요한 사항을 규정함을 목적으로 합니다.

제 2 조 (약관 외 준칙)
이 약관에 명시되지 않은 사항은 위치정보의 보호 및 이용 등에 관한 법률, 정보통신망 이용촉진 및 정보보호 등에 관한 법률, 전기통신기본법, 전기통신사업법 등 관계법령과 회사의 이용약관 및 개인정보처리방침, 회사가 별도로 정한 지침 등에 의합니다.</textarea>
			</div>
			</div>
			<input type="button" class="btn_type" value="동의" id="join">
			<a href="../index.do"><input type="button" class="btn_type" value="비동의" id="join_not"></a>
			</div>
		</div>
	</div>
</div>

		<%@include file="../temp/footer.jsp" %>
</body>
</html>