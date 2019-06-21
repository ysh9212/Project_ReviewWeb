<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<tbody>
	<c:forEach items="${commentsList}" var="dto">
		<tr>
			<td width=50>${dto.cnum}</td>
			<td width=100>${dto.writer}</td>
			<td id = "c${dto.cnum}" width=900>${dto.contents}</td>
			<td width=100>${dto.reg_date}</td>
			<td width=35 height=50><button title="${dto.cnum}" class="update">수정</button></td>
			<td width=35 height=50><button id="${dto.cnum}" class="delete">삭제</button></td>
		</tr>
	</c:forEach>
</tbody>
<!--  
		<c:if test="${'test' eq dto.writer}">
		<td><button data-toggle="modal" title="${dto.cnum}" class="update" data-target="#myModal">Update</button> <button class="del" id="${dto.cnum}">Delete</button> </td>
		</c:if>
-->
