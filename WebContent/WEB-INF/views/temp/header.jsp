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
						<a href="${pageContext.request.contextPath }/index.do" id="logo">GAZUA</a>
					</h1>
					<nav id="nav">
						<a href="${pageContext.request.contextPath }/index.do" class="current-page-item">HOME</a> 
						<a href="#">REVIEW</a> 
						<a href="#">NEWS</a> 
						<a href="#">COMMUNITY</a>
						<a href="${pageContext.request.contextPath }/shop/shopList">SHOP</a>
						<a href="#">EVENT</a>
						<% MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");%>
						<% if(memberDTO != null){ %>
						<a class="nav-link" href="${pageContext.request.contextPath}/member/memberLogout">Logout</a>
						<a class="nav-link" href="${pageContext.request.contextPath}/memberMy/memberMyPage">MyPage</a>
					
						<%}else { %>
						<a class="mav-link" href="${pageContext.request.contextPath}/member/memberLogin">Login</a>
						<a class="nav-link" href="${pageContext.request.contextPath}/member/memberCheck">Join</a>
						
						<%} %>
						
					</nav>
				</header>

			</div>
		</div>
	</div>
</div>