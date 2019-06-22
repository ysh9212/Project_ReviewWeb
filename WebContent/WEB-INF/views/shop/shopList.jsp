<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SHOP-세상의 모든 IT</title>
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="../assets/css/main.css" />
</head>
<body>
<%@include file = "../temp/header.jsp" %>
<div id = "page-wrapper">

	

	

		<div id="main">
			<div class="container">
				<section class="tiles">
				<c:forEach items="${list }" var="dto">
					<c:forEach items="${upload }" var="upload">
								<c:if test="${upload.pno eq dto.pno }">
							<article class="style2">
								<span class="image">
								<img src="${pageContext.request.contextPath }/upload/${upload.fname}" alt="" width="400" height="300">
								</span>
								<a href="./product/productSelect?pno=${dto.pno }">
								<h2>${dto.title }</h2>
								<div class="content">
								<p>${dto.price }원</p>
								</div>
								</a>
							</article>
								</c:if>
					</c:forEach>
					</c:forEach>

					
					
				
				</section>

			</div><!-- container -->


		</div><!--main  -->



		<%@include file= "../temp/footer.jsp" %>
</div> <!-- page-wrapper  -->

<%@include file="../temp/activeweb.jsp" %>
</body>
</html>