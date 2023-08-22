<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/inc/admin/admin_head.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assets/css/admin/ad_ani_det.css">
</head>
<body>
	<div class="container">
		<%@ include file="/WEB-INF/inc/admin/admin_topbar.jsp"%>
		<!-- 상단 끝 -->
		<br> <br>
		<!-- 내용 시작 -->
		<section style="min-height: 500px;">
			<h2 class="noti">입양관리</h2>
			<small style="font-weight: bold">상세보기</small>
			
			<hr>
			<table class="table">

				<tr>
					<th class="text-center"><input type="checkbox" id="all_check"
						value="Y" /></th>
					<th class="text-center">번호</th>
					<th class="text-center">신청서 제목</th>
					<th class="text-center">아이디</th>
					<th class="text-center">작성일</th>
					<th class="text-center">내용보기</th>
				</tr>

				<!-- 게시물 하나 시작 -->
				<c:choose>
					<c:when test="${fn:length(reqRead) > 0}">
						<c:forEach var="req" items="${reqRead}">
							<tr>
								<td class="text-center"><input type="checkbox"
									id="ckselect1" class="ckselect_check" /></td>
								<td class="text-center">${req.reqno}</td>
								<td class="text-center">${req.reqtitle}</td>
								<td class="text-center">${req.id}</td>
								<td class="text-center">${req.reqdate}</td>
								<c:url var="readUrl" value="/admin/ani/admin_ani_req.do">
									<c:param name="ani_id" value="${req.anino}" />
								</c:url>
								<td class="text-center"><a href="${readUrl}"
									class="btn btn-primary" id="detbtn">내용보기</a></td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="6">
								<div class="text-center" style="line-height: 100px;">신청 글이
									없습니다.</div>
							</td>
						</tr>
					</c:otherwise>
				</c:choose>
				<!-- 게시물 하나 끝 -->
			</table>
		</section>
		<!-- 내용 끝 -->

		<br /> <br /> <br />

		<!-- 하단 시작 -->
		<%@ include file="/WEB-INF/inc/admin/admin_footer.jsp"%>
	</div>
</body>
</html>