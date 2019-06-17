<%@page import="com.project.member.MemberDTO"%>
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
						<a href="${pageContext.request.contextPath }/review/reviewList">REVIEW</a> 
						<a href="${pageContext.request.contextPath}/news/newsList">NEWS</a> 
						<div class="dropdown">
							<a href="${pageContext.request.contextPath }/community/communityList">COMMUNITY</a>
							<div class="dropdown-content">
								<a href="${pageContext.request.contextPath }/community/notice/communityNotice">공지사항</a>
								<a href="${pageContext.request.contextPath }/community/board/communityBoard">자유게시판</a>
								<a href="${pageContext.request.contextPath }/community/review/communityReview">사용자리뷰</a>
								<a href="${pageContext.request.contextPath }/community/used/communityUsed">중고장터</a>
								<a href="${pageContext.request.contextPath }/community/qna/communityQna">QnA</a>
								<a href="${pageContext.request.contextPath }/community/bug/communityBug">버그리포트</a>
							</div>
						</div>
						<div class="dropdown">
						<a href="${pageContext.request.contextPath }/shop/shopList">SHOP</a>
						<div class="dropdown-content">
							<a href="${pageContext.request.contextPath }/shop/shopList">상품</a>
							<a href="${pageContext.request.contextPath }/shop/notice/noticeList">공지사항</a>
							<a href="${pageContext.request.contextPath }/shop/qna/qnaList">QnA</a>
							<a href="${pageContext.request.contextPath }/shop/mqna/mqnaList">자주 묻는 질문</a>
						</div>
						<a href="${pageContext.request.contextPath}/event/eventList">EVENT</a>
							</div>
						<% MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");%>
						<% if(memberDTO != null){ %>
						<a class="nav-link" href="${pageContext.request.contextPath}/member/memberLogout">Logout</a>
						<a class="nav-link" href="${pageContext.request.contextPath}/member/memberMypage">Mypage</a>
					
						<%}else { %>
						<a class="mav-link" href="${pageContext.request.contextPath}/member/memberLogin">Login</a>
						<a class="nav-link" href="${pageContext.request.contextPath}/member/memberCheck">Join</a>
						
						<%} %>
						</div>

					</nav>

				</header>

			</div>
		</div>
	</div>
</div>
