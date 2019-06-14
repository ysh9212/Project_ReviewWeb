<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자페이지 입니다</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<style type="text/css">
.header{
	width: 100%;
	border: 0;
	height: 60px;
	border-bottom: 3px solid silver;
	vertical-align: middle;
	text-align: center;
	background-color: #007294;
	margin-top: 0;

}
.left{
	padding:10px 0px 10px 10px;
	border-right: solid 3px silver;
	text-decoration: none;
	width: 15%;
}
ul.leftmenu{
	list-style: none;
	margin: 0;
	padding: 0;
}
li{
display: list-item;
}
.tit{
	font-weight: bold;
	padding-left: 18px;
	margin-bottom: 5px;
	text-align: left;
}
ul.leftmenu ol{
	padding-left: 25px;
}
li.menu{
	padding: 0;
	margin: 2px 0px 2px 0px;
	text-align: left;
}
li.menu a{
	color: gray;
}
.leftmenu a:link{
	text-decoration: none;
}
</style>

</head>
<body>
<!--헤더  -->
<div class ="header">
<h1>관리자 페이지 입니다</h1>
</div>

<!--바디  -->
<div>
	
		
			<div class="left">
				<ul class="leftmenu">
					<li>
						<div class="tit">
							<a href="#">처음으로</a>
						</div>
					</li>
					<li><!--SHOP 관리  -->
						<div class="tit">SHOP 관리</div>
						<ol class="leftmenu"><!--여기안에 세부메뉴 존재  -->
							<li class="menu"><!--한개의 세부메뉴 단위  -->
								<a href="#">SHOP상품 관리</a>
							</li>
							<li class="menu"><!--한개의 세부메뉴 단위  -->
								<a href="#">SHOP상품 후기 관리</a>
							</li>
							<li class="menu"><!--한개의 세부메뉴 단위  -->
								<a href="${pageContext.request.contextPath }/admin/shop/notice/noticeList">SHOP 공지사항 관리</a>
							</li>
							<li class="menu"><!--한개의 세부메뉴 단위  -->
								<a href="#">SHOP QNA관리</a>
							</li>
							<li class="menu"><!--한개의 세부메뉴 단위  -->
								<a href="#">SHOP 자주묻는 질문 관리</a>
							</li>
						</ol><!--세부메뉴 끝  -->
					</li><!--SHOP 관리 끝  -->
					
					<li><!--REVIEW 관리  -->
						<div class="tit">REVIEW 관리</div>
						<ol class="leftmenu"><!--여기안에 세부메뉴 존재  -->
							<li class="menu"><!--한개의 세부메뉴 단위  -->
								<a href="#">1</a>
							</li>
							<li class="menu"><!--한개의 세부메뉴 단위  -->
								<a href="#">1</a>
							</li>
							<li class="menu"><!--한개의 세부메뉴 단위  -->
								<a href="#">1</a>
							</li>
							<li class="menu"><!--한개의 세부메뉴 단위  -->
								<a href="#">1</a>
							</li>
							<li class="menu"><!--한개의 세부메뉴 단위  -->
								<a href="#">1</a>
							</li>
						</ol><!--세부메뉴 끝  -->
					</li><!--review 관리 끝  -->
					
					<li><!--NEWS 관리  -->
						<div class="tit">NEWS 관리</div>
						<ol class="leftmenu"><!--여기안에 세부메뉴 존재  -->
							<li class="menu"><!--한개의 세부메뉴 단위  -->
								<a href="#">1</a>
							</li>
							<li class="menu"><!--한개의 세부메뉴 단위  -->
								<a href="#">1</a>
							</li>
							<li class="menu"><!--한개의 세부메뉴 단위  -->
								<a href="#">1</a>
							</li>
							<li class="menu"><!--한개의 세부메뉴 단위  -->
								<a href="#">1</a>
							</li>
							<li class="menu"><!--한개의 세부메뉴 단위  -->
								<a href="#">1</a>
							</li>
						</ol><!--세부메뉴 끝  -->
					</li><!--NEWS 관리 끝  -->
					
					<li><!--Community 관리  -->
						<div class="tit">Community 관리</div>
						<ol class="leftmenu"><!--여기안에 세부메뉴 존재  -->
							<li class="menu"><!--한개의 세부메뉴 단위  -->
								<a href="#">1</a>
							</li>
							<li class="menu"><!--한개의 세부메뉴 단위  -->
								<a href="#">1</a>
							</li>
							<li class="menu"><!--한개의 세부메뉴 단위  -->
								<a href="#">1</a>
							</li>
							<li class="menu"><!--한개의 세부메뉴 단위  -->
								<a href="#">1</a>
							</li>
							<li class="menu"><!--한개의 세부메뉴 단위  -->
								<a href="#">1</a>
							</li>
						</ol><!--세부메뉴 끝  -->
					</li><!--Community 관리 끝  -->
					
					<li><!--EVENT 관리  -->
						<div class="tit">EVENT 관리</div>
						<ol class="leftmenu"><!--여기안에 세부메뉴 존재  -->
							<li class="menu"><!--한개의 세부메뉴 단위  -->
								<a href="#">1</a>
							</li>
							<li class="menu"><!--한개의 세부메뉴 단위  -->
								<a href="#">1</a>
							</li>
							<li class="menu"><!--한개의 세부메뉴 단위  -->
								<a href="#">1</a>
							</li>
							<li class="menu"><!--한개의 세부메뉴 단위  -->
								<a href="#">1</a>
							</li>
							<li class="menu"><!--한개의 세부메뉴 단위  -->
								<a href="#">1</a>
							</li>
						</ol><!--세부메뉴 끝  -->
					</li><!--EVENT 관리 끝  -->
					
					<li><!--멤버 관리  -->
						<div class="tit">회원 관리</div>
						<ol class="leftmenu"><!--여기안에 세부메뉴 존재  -->
							<li class="menu"><!--한개의 세부메뉴 단위  -->
								<a href="#">1</a>
							</li>
							<li class="menu"><!--한개의 세부메뉴 단위  -->
								<a href="#">1</a>
							</li>
							<li class="menu"><!--한개의 세부메뉴 단위  -->
								<a href="#">1</a>
							</li>
							<li class="menu"><!--한개의 세부메뉴 단위  -->
								<a href="#">1</a>
							</li>
							<li class="menu"><!--한개의 세부메뉴 단위  -->
								<a href="#">1</a>
							</li>
						</ol><!--세부메뉴 끝  -->
					</li><!--회원 관리 끝  -->
				</ul>
	</div>	
</div>

</body>
</html>