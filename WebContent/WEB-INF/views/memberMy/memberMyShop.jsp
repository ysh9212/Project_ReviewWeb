<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑 후기</title>
<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath }/images/Teamlogo.ico" />
<link rel="stylesheet" href="../assets/css/main.css" />
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<jsp:include page="./memberMyCommon/css.jsp"/>
</head>
<body>
<%@include file="../temp/header.jsp"%>
	<form action="${pageContext.request.contextPath}/memberMy/memberMyShop" method="post">
		<div id="page-wrapper">
			<div id="main">
				<div class="container">
					<jsp:include page="./memberMyCommon/navi.jsp" />
					<div id="wrap">
						<h2 class="memberinfor">쇼핑 후기</h2>

						<div id="h_body"></div>
						<div id="body">
							<hr>
							<div class="container">
								<table class="table table-hover">
									<tr>
										<td>No</td>
										<td>Title</td>
										<td>Writer</td>
										<td>Date</td>
										<td>Hit</td>
									</tr>
								</table>
							</div>

						</div>
					</div>
				</div>
			</div>

		</div>
	</form>
	<%@include file="../temp/footer.jsp" %>
</body>
</html>