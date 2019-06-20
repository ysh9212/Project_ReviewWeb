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
<form action="${pageContext.request.contextPath}/memberMy/memberMyQna" method="post">
<div id="page-wrapper">
	<div id="main">
		<div class="container">
			<jsp:include page="./memberMyCommon/navi.jsp"/>
			<div id = "wrap">
				<h2 class="memberinfor"> My QnA </h2>
				
			
			</div>
		</div>
	</div>
</div>
</form>
<%@include file="../temp/footer.jsp" %>
</body>
</html>