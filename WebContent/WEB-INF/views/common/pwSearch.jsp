<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../assets/css/main.css" />
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
</style>
<%
	String name = request.getParameter("name");
	String pw = request.getParameter("pw");
%>
</head>
<body>
<%@include file = "../temp/header.jsp" %>
<div id="page-wrapper">
	<div id="main">
		<div class="container">
			<div id = "wrap">
			
			${pwsearch.name}님의 패스워드는 ${pwsearch.pw} 입니다.
			 
			
			</div>
		</div>
	</div>
</div>
<%@include file="../temp/footer.jsp" %>
</body>
</html>