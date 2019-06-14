<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- Header -->
<div id="header-wrapper">
	<div class="container">
		<div class="row">
			<div class="col-12">

				<header id="header">
					<h1>
						<a href="${pageContext.request.contextPath }/index.do" id="logo">UDK</a>
					</h1>
					<nav id="nav">
						<a href="${pageContext.request.contextPath }/index.do" class="current-page-item">HOME</a> 
						<a href="#">REVIEW</a> 
						<a href="#">NEWS</a> 
						<a href="#">COMMUNITY</a>
						<div class="dropdown">
						<a href="${pageContext.request.contextPath }/shop/shopList">SHOP</a>
						<div class="dropdown-content">
							<a href="${pageContext.request.contextPath }/shop/shopList">상품</a>
							<a href="${pageContext.request.contextPath }/shop/notice/noticeList">공지사항</a>
							<a href="${pageContext.request.contextPath }/shop/qna/qnaList">QnA</a>
							<a href="${pageContext.request.contextPath }/shop/mqna/mqnaList">자주 묻는 질문</a>
						</div>
						
						</div>
						<a href="#">EVENT</a>
						<a href="#">LOGIN</a>
						<a href="#">JOIN</a>
					</nav>
				</header>

			</div>
		</div>
	</div>
</div>