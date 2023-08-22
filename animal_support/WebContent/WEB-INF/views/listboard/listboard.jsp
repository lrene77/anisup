<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!doctype html>
<html>
<head>
<%@ include file="/WEB-INF/inc/head.jsp"%>
<!-- listboard 공통 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assets/css/list.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assets/css/btn.css">

<!-- noti -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assets/css/info/list.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assets/css/info/noti.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/pagination.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assets/css/info/listboard.css" />
</head>
<body>
	<div class="container">
		<%@ include file="/WEB-INF/inc/topbar.jsp"%>
		<br id="space">
		<section>
			<h2 class="noti">${listName}</h2>
			<small id="small1">AS의 ${smallName1} 올라오는 게시판입니다.</small> <small
				id="small2"><span class="glyphicon glyphicon-home"></span>
				&gt; ${smallName2} &gt; ${listName}</small>
			<hr>
			<!-- Table -->
			<table class="table">
				<thead>
					<tr>
						<th class="text-center">번호</th>
						<th class="text-center">글 제목</th>
						<th class="text-center">작성자</th>
						<th class="text-center">작성일</th>
						<th class="text-center">조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${fn:length(listboardList) > 0}">
							<c:forEach var="listboard" items="${listboardList}">
								<tr>
									<td class="text-center">${listboard.listno}</td>
									<td>
										<c:url var="readUrl" value="/listboard/list_read.do">
											<c:param name="listcate" value="${listboard.listcate}" />
											<c:param name="listno" value="${listboard.listno}" />
										</c:url>
										<a id="acolor" href="${readUrl}">${listboard.listtitle}</a>
									</td>
									<td class="text-center">${listboard.id}</td>
									<td class="text-center">${listboard.wdate}</td>
									<td class="text-center">${listboard.hit}</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td id="listnone" colspan="5" class="text-center"
									style="line-height: 100px;">조회된 글이 없습니다.</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
			<%@ include file="/WEB-INF/inc/list_bottom.jsp"%>
		</section>
		<%@ include file="/WEB-INF/inc/footer.jsp"%>
	</div>
</body>
</html>