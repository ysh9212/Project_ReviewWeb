<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- Header -->
<div id="header-wrapper">
	<div class="container">
		<div class="row">
			<div class="col-12">
				<header id="header">
					<h1>
						<a href="${pageContext.request.contextPath }/index.do" id="logo">GAZUA</a>
					</h1>
					<nav id="nav">
						<a href="${pageContext.request.contextPath }/index.do" class="current-page-item">HOME</a> 
						<a href="#">REVIEW</a> 
						<a href="${pageContext.request.contextPath}/community/communityList">COMMUNITY</a>
						<a href="${pageContext.request.contextPath}/news/newsList">NEWS</a> 
						<a href="${pageContext.request.contextPath }/shop/shopList">SHOP</a>
						<div class="dropdown-content">
							<a href="${pageContext.request.contextPath }/shop/notice/noticeList">공지사항</a>
							<a href="${pageContext.request.contextPath }/shop/qna/qnaList">QnA</a>
							<a href="${pageContext.request.contextPath }/shop/mqna/mqnaList">자주 묻는 질문</a>
						</div>
					</nav>
						
			</div>

				</header>
			</div>
		</div>
	</div>
</div>