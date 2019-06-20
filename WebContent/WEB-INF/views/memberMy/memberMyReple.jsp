<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../assets/css/main.css" />
<jsp:include page="./memberMyCommon/css.jsp"/>

</head>
<body>

<%@include file = "../temp/header.jsp" %>
<div id="page-wrapper">
	<div id="main">
		<div class="container">
			<jsp:include page="./memberMyCommon/navi.jsp"/>
			<div id = "wrap">
			<form action="${pageContext.request.contextPath}/memberMy/memberMyReple" method="post">
				<h2 class="memberinfor"> 내 리플 보기 </h2>
				
			
			</form>
			</div>
		</div>
	</div>
</div>
<%@include file="../temp/footer.jsp" %>
</body>
</html>