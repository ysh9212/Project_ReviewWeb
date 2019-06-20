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
<script type="text/javascript">
var oEditors = [];
$(function() {
	nhn.husky.EZCreator.createInIFrame({
	    oAppRef: oEditors,
	    elPlaceHolder: "contents",
	    //SmartEditor2Skin.html 파일이 존재하는 경로
	    sSkinURI: "/Project_ReviewWeb/se2/SmartEditor2Skin.html",  
	    htParams : {
	        // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
	        bUseToolbar : true,             
	        // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
	        bUseVerticalResizer : true,     
	        // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
	        bUseModeChanger : true,         
	        fOnBeforeUnload : function(){
	             
	        }
	    }, 
	   
	    fCreator: "createSEditor2"
	}); //텍스트 폼 바꿈 스마트에디터
	
	//저장버튼 클릭시 form 전송
	$("#save").click(function(){
	    oEditors.getById["contents"].exec("UPDATE_CONTENTS_FIELD", []);
	    $("#frm").submit();
	});    
});
</script>
</head>
<body>
<c:import url="../../../temp/adminsetting.jsp"/>
<div class="main">
SHOP ${board } 페이지
	<form id="frm" action="./productWrite" method="post">
		<div class="form-group">
			상품 카테고리<br>
			<select name="kind">
				<option value="1">1. 데스크탑</option>
				<option value="2">2. 노트북</option>
				<option value="3">3. 휴대폰</option>
				<option value="4">4. 컴퓨터 주변기기</option>
				<option value="5">5. 휴대폰 악세사리</option>
			</select>
		</div>
		<div class="form-group">
			<div class="title">상품 명</div>
			<input type="text" class="form-control" id="title" name="title">
		</div>
		<div class="form-group">
			<div class="title">가 격</div>
			<input type="text" class="form-control" id="price" name="price">
		</div>
		<div class="form-group">
			<div class="title">수 량</div>
			<input type="text" class="form-control" id="stock" name="stock">
		</div>
		<div class="form-group">
			<div class="title">상세 설명</div>
			<textarea class="form-control" rows="10" id="contents" name="contents"></textarea>
		</div>
		<div class="form-group">
			<div class="title">이미지</div>
			<input type="file" class="form-control" id="f1" name="f1">
		</div>
		<input type="button" id = "save" class="btn" value = "write">
	</form>

</div>
</body>
</html>