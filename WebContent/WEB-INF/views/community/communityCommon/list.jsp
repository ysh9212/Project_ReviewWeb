<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach items="${list}" var="dto">
	<tr>
		<td>${dto.cnum}</td>
		<td>${dto.writer}</td>
		<td>${dto.contents}</td>
		<td>${dto.reg_date}</td>
<%-- 		<c:if test="${'test' eq dto.writer}">
		<td><button data-toggle="modal" title="${dto.cnum}" class="update" data-target="#myModal">Update</button> <button class="del" id="${dto.cnum}">Delete</button> </td>
		</c:if> --%>
		<td><button>Update</button><button>Delete</button></td>
	</tr>
</c:forEach>
