<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!-- 검색폼 + 글 쓰기 버튼 시작 -->
<div class="clearfix">
	<!-- 검색 폼 -->
	<!-- 공지사항은 글작성버튼이 없다. -->
	<c:choose>
		<c:when test="${loginInfo != null}">
			<c:if test="${listcate != 'n'}">
				<!-- 글 쓰기 버튼 -->
				<div class="pull-right">
					<a
						href="${pageContext.request.contextPath}/listboard/list_write.do?listcate=${listcate}"
						class="btn btn-primary"> <i class="glyphicon glyphicon-pencil"></i>
						글쓰기
					</a>
				</div>
			</c:if>
		</c:when>
		<c:otherwise>
			<div class="pull-right">
				<p>글 작성은 로그인 후에 이용 가능합니다.</p>
			</div>
		</c:otherwise>
	</c:choose>
</div>
<!--// 검색폼 + 글 쓰기 버튼 --> 
<div class="clearfix">
	<div class="container" align="center">
		<form method="get" action="${pageContext.request.contextPath}/listboard/list_list.do" style="width: 300px">
			<input type="hidden" name="listcate" value="${listcate}" />
			<div class="input-group">
				<input type="text" name="text" id="text" class="form-control" placeholder="제목, 내용 검색" value="${text}" />
				<span class="input-group-btn">
					<button class="btn btn-default" type="submit" id="search">
						<i class="glyphicon glyphicon-search">검색</i>
					</button>
				</span>
			</div>
		</form>
	</div>
</div>
<!-- 페이지 번호 시작 -->
<nav class="text-center">
	<ul class="pagination">
		<!-- 이전 그룹으로 이동 -->
		<c:choose>
			<c:when test="${pageHelper.prevPage > 0}">
				<!-- 이전 그룹에 대한 페이지 번호가 존재한다면? -->
				<!-- 이전 그룹으로 이동하기 위한 url을 생성해서 "prevUrl"에 저장 -->
				<c:url var="prevUrl" value="/listboard/list_list.do">
					<c:param name="listcate" value="${listcate}"></c:param>
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
		<c:forEach var="i" begin="${pageHelper.startPage}" end="${pageHelper.endPage}" step="1">
			<!-- 각 페이지 번호로 이동할 수 있는 url을 생성하여 page_rul에 저장 -->
			<c:url var="pageUrl" value="/listboard/list_list.do">
				<c:param name="listcate" value="${listcate}"></c:param>
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
				<c:url var="nextUrl" value="/listboard/list_list.do">
					<c:param name="listcate" value="${listcate}"></c:param>
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