<%@page import="javax.websocket.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자페이지 입니다</title>
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<c:import url="../../../assets/css/admincss.jsp"/>
<c:import url="../temp/bootstrap.jsp" />
<script type="text/javascript">
 	 $(function() {
	var test = '${sessionScope.session}';
	if(!test){
		location.href="${pageContext.request.contextPath}/admin/adminLogin";
	}
	
	}); 


</script>
</head>
<body>
<c:import url="../temp/adminsetting.jsp"/>

</body>
</html>