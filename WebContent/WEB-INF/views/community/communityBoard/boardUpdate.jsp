<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글수정</title>
<c:import url="../../temp/bootstrap.jsp" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<script type="text/javascript" src="../../se2/js/HuskyEZCreator.js" charset="utf-8"></script>
<link rel="stylesheet" href="../../assets/css/main.css" />
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
	    fOnAppLoad : function(){
	        //기존 저장된 내용의 text 내용을 에디터상에 뿌려주고자 할때 사용
	        oEditors.getById["contents"].exec("PASTE_HTML", ["contents"]);
	    },
	    fCreator: "createSEditor2"
	}); //텍스트 폼 바꿈 스마트에디터
	
	//저장버튼 클릭시 form 전송
	$("#save").click(function(){
	    oEditors.getById["contents"].exec("UPDATE_CONTENTS_FIELD", ["contents"]);
	    $("#frm").submit();
	    alert("수정이 완료되었습니다.")
	});    
});

</script>
</head>
<body>
	<%@include file="../../temp/header.jsp"%>
	<div class="page-wrapper">
		<div id="main">
			<div class="container">
			<form id ="frm"action="./${board}Update" method="post">
			<input type="hidden" name = "no" value="${dto.no}">
			<div class="form-group">
				<label for="title">Title:</label> 
				<input type="text" class="form-control" id="title" name = "title" value="${dto.title}">
			</div>
			<div class="form-group">
				<label for="writer">Writer:</label> 
				<input type="text" class="form-control" id="writer" name="writer" value="${dto.writer}">
			</div>
			<div class="form-group">
				<label for="contents">Contents:</label>
				<textarea class="form-control" rows="5" id="contents" name="contents">${dto.contents}</textarea>
			</div>
				<input type="button" id = "save" class="btn btn-danger" value = "write">
			</form>
			</div>
		</div>
	</div>
	<%@include file="../../temp/footer.jsp"%>
	<%@include file="../../temp/activeweb.jsp"%>
</body>
</html>