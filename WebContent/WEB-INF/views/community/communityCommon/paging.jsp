<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	
	<form action="./${board}">
		<select name="kind">
			<option value="t">제목</option>
			<option value="c">내용</option>
		</select> <input type="text" name="search">
		<button class="btn1 blue rounded">Search</button>
	</form>
	
	<ul class="pager">
		<c:if test="${pager.curBlock gt 1 }">
			<li class="previous"><a
				href="./${board}?curPage=${pager.startNum-1}&kind=${pager.search.kind}&search=${pager.search.search}">Previous</a>
			</li>
		</c:if>
		<li>
			<ul class="pagination">
				<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" step="1"
					var="i">
					<li><a
						href="./${board}?curPage=${i}&kind=${pager.search.kind}&search=${pager.search.search}">${i}</a>
					</li>
				</c:forEach>
			</ul>
		</li>

		<c:if test="${pager.curBlock lt pager.totalBlock }">
			<li class="next"><a
				href="./${board}?curPage=${pager.lastNum+1}&kind=${pager.search.kind}&search=${pager.search.search}">Next</a>
			</li>
		</c:if>
	</ul>
</div>