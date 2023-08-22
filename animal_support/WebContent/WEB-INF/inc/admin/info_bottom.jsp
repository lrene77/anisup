<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!-- 삭제 버튼 시작 -->
<div class="clearfix">
	<div class="container">
		<input type="submit" class="btn btn-primary" value="삭 제" id="dbtn">
		<c:url var="readUrl" value="/listboard/list_write.do?listcate=n">
		</c:url>
		<a href="${readUrl}" class="btn btn-primary" id="wbtn">작 성</a>
	</div>
</div>
<!--// 삭제 버튼 -->

<!-- 페이지 번호 시작 -->
<nav class="text-center">
	<ul class="pagination">
		<!-- 이전 그룹으로 이동 -->
		<c:choose>
			<c:when test="${pageHelper.prevPage > 0}">
				<!-- 이전 그룹에 대한 페이지 번호가 존재한다면? -->
				<!-- 이전 그룹으로 이동하기 위한 url을 생성해서 "prevUrl"에 저장 -->
				<c:url var="prevUrl" value="/admin/listboard/info/admin_info_list.do">
					<c:param name="page" value="${pageHelper.prevPage}"></c:param>
				</c:url>

				<li><a href="${prevUrl}">&laquo;</a></li>
			</c:when>

			<c:otherwise>
				<!-- 이전 그룹에 대한 페이지 번호가 존재하지 않는다면? -->
				<li class='disabled'><a href="#">&laquo;</a></li>
			</c:otherwise>
		</c:choose>

		<!-- 페이지 번호 -->
		<!-- 현재 그룹의 시작페이지~끝페이지 사이를 1씩 증가하면서 반복 -->
		<c:forEach var="i" begin="${pageHelper.startPage}"
			end="${pageHelper.endPage}" step="1">
			<!-- 각 페이지 번호로 이동할 수 있는 url을 생성하여 page_rul에 저장 -->
			<c:url var="pageUrl" value="/admin/listboard/info/admin_info_list.do">
				<c:param name="page" value="${i}"></c:param>
			</c:url>

			<!-- 반복중의 페이지 번호와 현재 위치한 페이지 번호가 같은 경우에 대한 분기 -->
			<c:choose>
				<c:when test="${pageHelper.page == i}">
					<li class='active'><a href="#">${i}</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="${pageUrl}">${i}</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<!-- 다음 그룹으로 이동 -->
		<c:choose>
			<c:when test="${pageHelper.nextPage > 0}">
				<!-- 다음 그룹에 대한 페이지 번호가 존재한다면? -->
				<!-- 다음 그룹으로 이동하기 위한 url을 생성해서 "nextUrl"에 저장 -->
				<c:url var="nextUrl" value="/admin/listboard/info/admin_info_list.do">
					<c:param name="page" value="${pageHelper.nextPage}"></c:param>
				</c:url>

				<li><a href="${nextUrl}">&raquo;</a></li>
			</c:when>

			<c:otherwise>
				<!-- 다음 그룹에 대한 페이지 번호가 존재하지 않는다면? -->
				<li class='disabled'><a href="#">&raquo;</a></li>
			</c:otherwise>
		</c:choose>
	</ul>
</nav>
<!--// 페이지 번호 끝 -->