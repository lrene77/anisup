<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/inc/head.jsp"%>
<!-- bootstrap -->
<link rel="stylesheet" type="text/css" href="../assets/css/list.css" />
<link rel="stylesheet" type="text/css" href="../assets/css/small.css" />

<!-- Javascript -->
<script src="../assets/js/mypage/msg.js"></script>
</head>
<body>
	<div class="container">
		<%@ include file="/WEB-INF/inc/topbar.jsp"%>
		<!-- 상단 끝 -->
		<br id="space">
		<section>
			<h2 class="noti">보호소입양신청서목록</h2>
			<small id="small1">입양신청을 확인할 수 있는 페이지입니다.</small> <small id="small2"><span
				class="glyphicon glyphicon-home"></span> &gt; myPage &gt; 입양신청목록</small>
			<hr>
			<!--테이블 시작-->
			<table class="table">
				<tr>
					<th class="text-center">No</th>
					<th class="text-center">신청서 제목</th>
					<th class="text-center">작성일</th>
					<th class="text-center">작성자</th>
					<th class="text-center">승인여부</th>
				</tr>
				<tbody>
					<c:choose>
						<c:when test="${fn:length(reqList) > 0}">
							<c:forEach var="req" items="${reqList}">
								<tr>
									<td class="text-center" id="reqno">${req.reqno}</td>
									
									<td class="text-center">
										<c:url var="readUrl" value="/mypage/she_req_ok.do">
					            			<c:param name="reqno" value="${req.reqno}" />
					            		</c:url>
					            	
					            	<a href="${readUrl}">${req.reqtitle}</a>
					            	
									</td>
									
									<td class="text-center">${req.reqdate}</td>
									<td class="text-center">${req.name}</td>
									
									<td class="text-center">
										<button id="btn1" class="btn btn-default">승인</button>
										<button id="btn2" class="btn btn-default">거절</button>
									</td>
								</tr>
								</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="5" class="text-center" style="line-height: 100px;">
									조회된 글이 없습니다.</td>
							</tr>
						</c:otherwise>
					</c:choose> 
				</tbody>
			</table>
			<!--테이블 끝-->
			<!-- btn1이 승인 btn2가 거절-->
		</section>
		<!--하단영역-->
		<%@ include file="/WEB-INF/inc/footer.jsp"%>
	</div>
</body>
</html>