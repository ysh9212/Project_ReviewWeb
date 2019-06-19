<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--헤더  -->
<div class ="header">
관리자 페이지 입니다
<a href="${pageContext.request.contextPath }/index.do" class="adminhome">나의 홈페이지 가기</a>
</div>

<!--바디  -->

<div class="left">
	<ul class="leftmenu">
		<li>
			<div class="tit">
				<a href="${pageContext.request.contextPath }/admin.do">처음으로</a>
			</div>
		</li>
		<li><!--SHOP 관리  -->
			<div class="tit">SHOP 관리</div>
			<ol class="leftmenu"><!--여기안에 세부메뉴 존재  -->
				<li class="menu"><!--한개의 세부메뉴 단위  -->
					<a href="${pageContext.request.contextPath }/admin/shop/product/productList">상품 관리</a>
				</li>
				<li class="menu"><!--한개의 세부메뉴 단위  -->
					<a href="#">상품 후기 관리</a>
				</li>
				<li class="menu"><!--한개의 세부메뉴 단위  -->
					<a href="${pageContext.request.contextPath }/admin/shop/notice/noticeList">공지사항 관리</a>
				</li>
				<li class="menu"><!--한개의 세부메뉴 단위  -->
					<a href="${pageContext.request.contextPath }/admin/shop/qna/qnaList">QNA관리</a>
				</li>
				<li class="menu"><!--한개의 세부메뉴 단위  -->
					<a href="${pageContext.request.contextPath }/admin/shop/mqna/mqnaList">자주묻는 질문 관리</a>
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
