<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!doctype html>
<html>
<head>
<%@ include file="/WEB-INF/inc/head.jsp"%>
<link rel="stylesheet" type="text/css" href="../assets/css/small.css" />
<!-- 개인 CSS -->
<link rel="stylesheet" type="text/css"
	href="../assets/css/ani/ani_total.css">
<link rel="stylesheet" type="text/css"
	href="../assets/css/ani/ani_det.css">

<!-- 통합 JS -->
<script type="text/javascript" src="../assets/js/ani/total.js"></script>
</head>
<body>
	<div class="container">
		<%@ include file="/WEB-INF/inc/topbar.jsp"%>
		<br id="space">
		<!-- 리스트 시작 -->
		<div class="content">
			<h2 class="noti">동물상세정보</h2>
			<small id="small1">AS의 입양 게시판입니다.</small> <small id="small2"><span
				class="glyphicon glyphicon-home"></span> &gt; 입양 &gt; 상세정보</small>
			<hr>
			<section style="margin-top: 10px; border: 1px solid #000;">
				<div class="row">
					<div class="col-xs-12"
						style="width: 720px; border-bottom: 1px solid #000; margin-bottom: 20px; padding-top: 5px; padding-bottom: 5px;">
						<a href="ani_det.html" style="text-decoration: none; color: #000;">[${ani.anistat}]
							${ani.anititle} [ ${ani.anicount} / 5 ]</a>
					</div>
					<div class="col-sm-6 col-xs-12">
						<div class="thumbnail">
							<c:choose>
								<c:when test="${ani.file != null}">
									<c:url var="downloadUrl" value="/download.do">
										<c:param name="file" value="${ani.file}" />
									</c:url>
									<img src="${downloadUrl}" class="img-responsive" />
								</c:when>
								<c:otherwise>
									<img src="${pageContext.request.contextPath}/img/no_image.jpg"
										class="img-responsive" />
								</c:otherwise>
							</c:choose>
						</div>
					</div>
					<div class="col-sm-6 col-xs-12">
						<table class="table">
							<h4 style="text-align: center">보호소 상세 설명</h4>
							<thead>
								<tr>
									<th class="text-center">보호소 명</th>
									<td class="text-center">${ani.name}</td>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th class="text-center">연락처</th>
									<td class="text-center">${ani.phone}</td>
								</tr>
								<tr>
									<th class="text-center">동물 이름</th>
									<td class="text-center">${ani.aniname}</td>
								</tr>
								<tr>
									<th class="text-center">동물 성별</th>
									<td class="text-center"><c:if
											test="${ani.anigender == 'X'}">
											수컷
										</c:if> <c:if test="${ani.anigender == 'Y'}">
											암컷
										</c:if></td>
								</tr>
								<tr>
									<th class="text-center">동물 나이</th>
									<td class="text-center">${ani.aniage}</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<!-- 내용 리스트 -->
				<div class="col-sm-12">
					<h4>동물 설명</h4>
					<div class="row jumbotron"
						style="border: 1px solid #000; min-height: 370px;">${ani.anicont}</div>
				</div>
				<!-- 내용 리스트 종료 -->

				<c:url var="readUrl" value="/ani/ani_req.do">
					<c:param name="ani_id" value="${ani.anino}" />
					<c:param name="ani_count" value="${ani.anicount}" />
					<c:param name="ani_stat" value="${ani.anistat}" />
				</c:url>

				<!-- 글쓰기 버튼 -->
				<div align="center">
					<a style="text-decoration: none;"><button type="button"
							class="btn btn-default btn-lg" id="btn_write"
							onclick="location.href='${readUrl}'">신청하기</button></a>
				</div>
			</section>
		</div>
		<!-- 리스트 종료 -->
		<%@ include file="/WEB-INF/inc/footer.jsp"%>
	</div>
</body>
</html>