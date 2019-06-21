<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UDK 관리자 페이지</title>
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
	
	var file = document.getElementById('file');
	var num = 0;
	var d1=0;
	$('#add').click(function() {
	d1++;
	if (num < 1) {
/* 		file.innerHTML = file.innerHTML + '<input type="file" class="form-control" id="f1" name = "f1">'; */
	$("#addfile").append('<div id="'+d1+'"><input type="file" class="form-control" id="" name="f'+d1+'"><span title="'+d1+'" class="del">X</span></div>')
	num++;
	} else{
		alert('1개 파일까지 가능합니다');
	}
	});
	$("#addfile").on("click",".del", function(){
		//$(this).prev().remove();
		//$(this).remove();
		var v = $(this).attr('title');
		$('#'+v).remove();
		num--;
	});
	$('.fileDelete').click(function(){
		//1. XMLHttpRequest
		var id = $(this).attr("id");
		var xhttp;
		if(window.XMLHttpRequest){
			xhttp = new XMLHttpRequest();
		}else{
			xhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		
		//2. 연결정보 작성
		xhttp.open("GET","../../../productupload/fileDelete?no="+id, true);
		//3. 전송
		xhttp.send();
		//4. 결과처리
		xhttp.onreadystatechange = function(){
			if(this.readyState==4 && this.status == 200){
				if(this.responseText.trim()=='1'){
					$("#"+id).prev().remove();
					$("#"+id).remove();
				}else{
					alert('삭제 실패');
				}
			}
			
		}//4끝
		
		
	});
});
</script>
<style type="text/css">
.del{
	color: red;
	cursor: pointer;
}

</style>
</head>
<body>
<c:import url="../../../temp/adminsetting.jsp"/>
<div class="main">
SHOP ${board } 페이지
	<form id="frm" action="./productUpdate" method="post" enctype="multipart/form-data">
		<input type="hidden" name = "pno" value="${dto.pno }">
		<input type="hidden" name ="oname" value="${upload.oname }">
		<input type="hidden" name ="fname" value ="${upload.fname }">
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
			<input type="text" class="form-control" id="title" name="title" value="${dto.title }">
		</div>
		<div class="form-group">
			<div class="title">가 격</div>
			<input type="text" class="form-control" id="price" name="price" value="${dto.price }">
		</div>
		<div class="form-group">
			<div class="title">수 량</div>
			<input type="text" class="form-control" id="stock" name="stock" value="${dto.stock }">
		</div>
		<div class="form-group">
			<div class="title">상세 설명</div>
			<textarea class="form-control" rows="10" id="contents" name="contents">${dto.detail }</textarea>
		</div>
		<div class="form-group" id="addfile">
			<div class="title">이미지</div>
			<span>${upload.oname }</span>
			<span id = "${upload.no}"class="fileDelete del">X</span>
		</div>
		<div class="form-group">
				<input type="button" id="add" value="Add" class="btn btn-primary">
			</div>
		<input type="button" id = "save" class="btn" value = "수정완료">
	</form>

</div>
</body>
</html>