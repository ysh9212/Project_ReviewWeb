<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이용약관</title>
<link rel="stylesheet" href="../assets/css/main.css" />
<jsp:include page="./basicCommon/css.jsp" />
</head>
<body>
<%@include file = "../temp/header.jsp" %>
<form action="${pageContext.request.contextPath}/basic/review" id="form1" method="post">
		<div id="page-wrapper">
			<div id="main">
				<div class="container">
					<div id="wrap">
						<h2 class="titleone"> 리뷰 문의 </h2>
						<div class="textarea">
							<textarea name="message" rows="60" cols="68" readonly="readonly">
							
							
							
							
							</textarea>	


						</div>

					</div>



				</div>
			</div>
		</div>
	</form>
<%@include file="../temp/footer.jsp" %>

</body>
</html>