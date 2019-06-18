<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../../../temp/bootstrap.jsp" />
<title>${board }Update</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
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
			<div class="container">
				<form action="./${board }Update" method="post" id="frm">
				<input type="hidden" name = "no" value="${dto.no }">
					<div class="form-group">
						<div class="title">Title:</div> 
						 <input type="text"	class="form-control" id="title" name="title" value="${dto.title }">
					</div>
					<div class="form-group">
						<div class="title">Writer:</div>  <input type="text"
							class="form-control" id="writer" name="writer"
							value="${dto.writer }" readonly="readonly">
					</div>
					<div class="form-group">
						<div class="title">Contents:</div> 
						<textarea class="form-control" rows="5" id="contents"
							name="contents">${dto.contents}</textarea>
					</div>
					<input type="button" id = "save" value = "update" class="btn">
				</form>
			</div>
		</div>





</body>
</html>