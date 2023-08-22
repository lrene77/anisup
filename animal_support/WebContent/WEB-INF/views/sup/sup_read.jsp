<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/inc/head.jsp"%>

<!-- sup_ing.css -->
<link rel="stylesheet" type="text/css"
	href="../assets/css/sup/sup_ing.css">

<!-- 페이지네이션 -->
<link rel="stylesheet" type="text/css"
	href="../assets/css/pagination.css" />

<!-- 댓글 버튼 hover -->
<link rel="stylesheet" type="text/css" href="../assets/css/btn.css">

<!-- sup_ing.js -->
<script
	src="${pageContext.request.contextPath}/assets/js/sup/sup_ing.js"></script>

<style type="text/css">
/** 케러셀 영역의 전체 높이 지정 */
#carousel {
	height: 40%;
}

/** 케러셀의 각 영역 높이가 케러셀 안에서 가득 차도록 구성 */
#carousel .item, #carousel .carousel-inner {
	height: 100%;
}

/** 케러셀 이미지 */
#carousel .img {
	height: 100%;
	background-position: center center;
}
</style>

<script type="text/javascript">
	$(function() {
		$(".carousel-inner").swipe({
			swipeLeft : function() {
				$(this).parent().carousel('next');
			},
			swipeRight : function() {
				$(this).parent().carousel('prev');
			},
			threshold : 0
		});
	});
</script>
</head>

<body>
	<div class="container">
		<%@ include file="/WEB-INF/inc/topbar.jsp"%>
		<br id="space">
		<section>
			<div class="row">
				<div class="col-md-9">
					<span id="head_title">[&nbsp;${supItem.suptitle}&nbsp;]</span> <br />
					<br />
					<!-- 반응형 모금함 기부하기 박스 시작 -->
					<div id="give_box" class="thumbnail hidden-lg hidden-md">
						<ul class="list-inline list-unstyled" style="text-align: center;">
							<li id="li_1"><h5>
									<strong>${supItem.supstart} ~ ${supItem.supend} 까지</strong>
								</h5></li>
							<li id="li_2"><h4>
									<strong>${supItem.supDays}-day</strong>
								</h4></li>
						</ul>
						<ul class="list-inline list-unstyled" style="text-align: center;">
							<li id="li_3"><strong><h4>${supItem.supnow}원
										후원</h4></strong></li>
							<li id="li_4"><strong><h4>${supItem.supprice}
										원 목표</h4></strong></li>
						</ul>
						<c:url var="readUrl" value="/sup/sup_give.do">
							<c:param name="supno" value="${supItem.supno}" />
						</c:url>
						<a id="btn" href="${readUrl}" class="btn btn-primary"><strong>모금함
								기부하기</strong></a>
					</div>
					<!-- 반응형 모금함 기부하기 박스 끝 -->

					<br /> <br />

					<ul class="nav nav-tabs nav-justified">
						<li id="tab1" class="active"><a href="#" onclick="aa()"
							data-toggle="tab">프로젝트 후원 소개</a></li>
						<li id="tab2"><a href="#" onclick="bb()" data-toggle="tab">기부
								댓글</a></li>
					</ul>
					<br><br>
					<div id="progressbarMotion" class="pull-right" style="width: 85%;">
						<div style="height: 75px; width: ${supItem.suping}%;">
							<c:choose>
								<c:when test="${supItem.suping == 100}">
									<div class="pull-right">
										<img alt="종료" src="${pageContext.request.contextPath}/img/walk_move_end.gif" style="width: 80px; height: 80px;">
									</div>
								</c:when>
								<c:otherwise>
									<div class="pull-right">
										<img alt="진행" src="${pageContext.request.contextPath}/img/walk_move_ing.gif" style="width: 80px; height: 80px;">
									</div>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
					<div>
						<div class="progress pull-right"
							style="height: 30px; width: 85%;">
							<div class="progress-bar progress-bar-info" role="progressbar"
								aria-valuenow="${supItem.suping}" aria-valuemin="0"
								aria-valuemax="100" style="width: ${supItem.suping}%;">
								<span class="sr-only">60% Complete</span>
							</div>
						</div>
					</div>
					<div class="pull-right" style="height: 30px;">
						<h3 style="margin: 0; padding-right: 15px;"><strong>${supItem.suping}%</strong></h3>
					</div>
					<!-- 후원 소개 내용 시작 -->
					<br><br><br><br>
					<div id="sup1" class="in active" style="padding: 15px;">
						<br/>
						<div class="page-header">
							<h3>
								<strong>후원 소개</strong>
							</h3>
						</div>
						<div>${supItem.supcont}</div>

						<br /> <br />

						<!-- 캐러셀 영역 구성 시작 -->
						<!-- 조회된 이미지가 있는 경우 시작 -->
						<c:choose>
							<c:when test="${fn:length(fileList) > 0}">
								<!-- 케러셀 시작 -->
								<div id="carousel" class="carousel slide" data-ride="carousel">
									<!-- Indicators -->
									<ol class="carousel-indicators">
										<c:forEach var="file" items="${fileList}" varStatus="status">
											<c:set var="cls" value="" />
											<c:if test="${status.index == 0}">
												<c:set var="cls" value="active" />
											</c:if>
											<li data-target="#carousel" data-slide-to="${status.index}"
												class="${cls}"></li>
										</c:forEach>
									</ol>

									<!-- Wrapper for slides -->
									<div class="carousel-inner" role="listbox">
										<c:forEach var="file" items="${fileList}" varStatus="status">
											<c:set var="cls" value="" />
											<c:if test="${status.index == 0}">
												<c:set var="cls" value="active" />
											</c:if>

											<c:url var="image_url" value="/download.do">
												<c:param name="file" value="${file.imagePath}" />
											</c:url>

											<div class="item ${cls}">
												<img src="${image_url}" class="img-responsive" />
											</div>
										</c:forEach>
									</div>

									<!-- Controls -->
									<a class="left carousel-control" href="#carousel"
										data-slide="prev"> <span
										class="glyphicon glyphicon-chevron-left"></span>
									</a> <a class="right carousel-control" href="#carousel"
										data-slide="next"> <span
										class="glyphicon glyphicon-chevron-right"></span>
									</a>
								</div>
								<!-- 케러셀 끝 -->
							</c:when>
						</c:choose>
						<!-- 캐러셀 영역 구성 끝 -->
					</div>
					<!-- 후원 소개 내용 끝 -->

					<!-- 후원내역 시작 -->
					<div id="give" style="display: inline;">
						<div class="page-header">
							<h3>
								<strong>후원 내역</strong>
							</h3>
						</div>
						<div class="well well-lg">${supItem.supbill}</div>
						<abbr title="후원 완료시 작성버튼 활성화 됩니다."> <c:url var="giveUrl"
								value="/sup/sup_his_write.do">
								<c:param name="supno" value="${supItem.supno}" />
								<c:param name="suptitle" value="${supItem.suptitle}" />
								<c:param name="supnow" value="${supItem.supnow}" />
							</c:url>
							<button type="button" class="btn btn-info pull-right"
								id="btn_write" onclick="location.href='${giveUrl}'";>작&nbsp;&nbsp;성</button>
						</abbr>
					</div>
					<!-- 후원내역 끝 -->

					<br /> <br />

					<!-- 댓글 리스트 시작 -->
					<div id="write1" class="tab-pane">
						<div class="page-header">
							<h3>
								<strong>기부 댓글</strong>
							</h3>
						</div>
						<ul class="row">
							<li class="col-md-10"><textarea></textarea></li>
							<li class="col-md-2"><button type="button"
									class="btn btn-primary">등&nbsp;&nbsp;록</button></li>
						</ul>

					</div>
					<!-- 댓글 리스트 끝 -->
				</div>
				<!--  사이드 후원하기 박스 시작  -->
				<div class="col-md-3">
					<aside class="float_sidebar hidden-xs hidden-sm">
						<div style="position: absolute; top: 142px;" class="quick">
							<div class="thumbnail">
								<sapn id="sidebox">
								<div id="box">
									<h1>
										<strong>${supItem.suping}%</strong>
									</h1>
									<!-- progress 시작 -->
									<div class="progress">
										<!-- progress-bar-success 적용 -->
										<div class="progress-bar progress-bar-success"
											role="progressbar" aria-valuenow="80" aria-valuemin="0"
											aria-valuemax="100" style="width: ${supItem.suping}%">
											<span class="sr-only">${supItem.suping}% Complete
												(success)</span>
										</div>
									</div>
									<!-- progress 끝 -->

									<ul class="list-unstyled" style="text-align: center;">
										<li id="li_1"><h5>
												<strong>${supItem.supstart} ~ ${supItem.supend} 까지</strong>
											</h5></li>
										<li id="li_2"><h2>
												<strong>${supItem.supDays}-day</strong>
											</h2></li>
										<li id="li_3"><strong><h3>${supItem.supnow}
													원 후원</h3></strong></li>
										<li id="li_4"><strong><h4>${supItem.supprice}
													원 목표</h4></strong></li>
									</ul>
								</div>
								</span> <a id="btn" href="${readUrl}" class="btn btn-primary"><strong>모금함
										기부하기</strong></a>
							</div>
						</div>
					</aside>
				</div>
				<!--  사이드 후원하기 박스 끝  -->
			</div>
		</section>
		<%@ include file="/WEB-INF/inc/footer.jsp"%>
	</div>
</body>
</html>
