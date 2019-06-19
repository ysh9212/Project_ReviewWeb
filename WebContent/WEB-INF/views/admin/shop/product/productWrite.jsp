<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 추가</title>
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<script type="text/javascript" src="../../../se2/js/HuskyEZCreator.js" charset="utf-8"></script>
<c:import url="../../../../../assets/css/admincss.jsp"/>
<c:import url="../../../temp/bootstrap.jsp" />
</head>
<body>
<c:import url="../../../temp/adminsetting.jsp"/>
<div class="main">
SHOP ${board } 페이지
	<form id="frm" action="./${board }Write" method="post">
		<div class="form-group">
			<div class="title">색상</div>
			<input type="text" class="form-control" id="product_color" name="product_color">
		</div>
		<div class="form-group">
			<div class="title">사이즈</div>
			<input type="text" class="form-control" id="product_size" name="product_size">
		</div>
		<div class="form-group">
			<div class="title">재고</div>
			<input type="text" class="form-control" id="product_stock" name="product_stock">
		</div>
		<div class="form-group">
			<div class="title">가격</div>
			<input type="text" class="form-control" id="product_price" name="product_price">
		</div>
	</form>

</div>
</body>
</html>