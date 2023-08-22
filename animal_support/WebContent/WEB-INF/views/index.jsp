<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!doctype html>
<html>
<head>
<%@ include file="/WEB-INF/inc/head.jsp"%>
<!-- index -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assets/css/carousel.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assets/css/panel.css" />

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assets/css/thum_carousel.css" />
<style type="text/css">

.panel-default .panel-body tbody tr td a{
	text-overflow: ellipsis;
	overflow: hidden;
	white-space: nowrap;
}
</style>
</head>
<body>
	<div class="container">
		<%@ include file="/WEB-INF/inc/topbar.jsp"%>
		<section>
			<!-- 캐러셀 영역 구성 -->
			<div id="carousel-example-generic" class="carousel slide"
				data-ride="carousel">
				<!-- 현재 위치 표시 -->
				<ol class="carousel-indicators">
					<li data-target="#carousel-example-generic" data-slide-to="0"
						class="active"></li>
					<li data-target="#carousel-example-generic" data-slide-to="1"></li>
					<li data-target="#carousel-example-generic" data-slide-to="2"></li>
				</ol>
				<!-- 내용 영역 -->
				<div class="carousel-inner">
					<!-- 항목 (1) -->
					<div class="item active">
						<img src="${pageContext.request.contextPath}/img/slide-1.jpg"
							alt="슬라이더(1)">
					</div>

					<!-- 항목 (2) -->
					<div class="item">
						<img src="${pageContext.request.contextPath}/img/slide-2.jpg"
							alt="슬라이더(2)">
					</div>

					<!-- 항목 (3) -->
					<div class="item">
						<img src="${pageContext.request.contextPath}/img/slide-3.jpg"
							alt="슬라이더(3)">
					</div>
				</div>
				<!-- // 내용영역 구성 -->
				<!-- 이동 버튼 -->
				<a class="left carousel-control" href="#carousel-example-generic"
					data-slide="prev"> <span class="icon-prev"></span>
				</a> <a class="right carousel-control" href="#carousel-example-generic"
					data-slide="next"> <span class="icon-next"></span>
				</a>
			</div>
			<!-- 캐러셀 영역 끝 -->
			<!-- 게시판 시작 -->
			<div class="row">
				<div class="col-md-6 col-sm-6" id="board">
					<!-- 게시판1 시작 -->
					<div class="panel panel-default article-item">
						<div class="panel-heading">
							<span class="glyphicon glyphicon-hand-right">&nbsp;공 지 사 항</span>
							<a
								href="${pageContext.request.contextPath}/listboard/list_list.do?listcate=n"
								class="glyphicon glyphicon-plus pull-right"><span>더보기</span></a>
						</div>
						<div class="panel-body">
							<table class="table table-hover" align="center">
								<thead>
									<tr>
										<td id="main-num">No.</td>
										<td id="main-title">글 제 목</td>
										<td id="main-write">글 쓴 이</td>
									</tr>
								</thead>
								<tbody>
									<c:choose>
										<c:when test="${fn:length(nList) > 0}">
											<c:forEach var="listboard" items="${nList}">
												<tr>
													<td>${listboard.listno}</td>
													<td id="main-title"><a
														href="${pageContext.request.contextPath}/listboard/list_read.do?listcate=${listboard.listcate}&listno=${listboard.listno}">${listboard.listtitle}</a>

													</td>
													<td>${listboard.id}</td>
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
						</div>
					</div>
					<!-- 게시판1 끝 -->
					<!-- 게시판2 시작 -->
					<div class="panel panel-default">
						<div class="panel-heading">
							<span class="glyphicon glyphicon-hand-right">&nbsp;입 양</span> <a
								href="${pageContext.request.contextPath}/ani/ani_list.do"
								class="glyphicon glyphicon-plus pull-right"><span>더보기</span></a>
						</div>
						<div class="panel-body" id="main-img">
							<!-- 입양 캐러셀 시작 -->
							<div id="carousel" class="carousel slide" data-ride="carousel">
								<!-- indicators -->
								<ol class="carousel-indicators">
									<c:forEach var="aniMain" items="${aniMain}" varStatus="status">
										<c:set var="cls" value="" />
										<c:if test="${status.index == 0}">
											<c:set var="cls" value="active" />
										</c:if>
										<li data-target="#carousel" data-slide-to="${status.index}"
											class="${cls}"></li>
									</c:forEach>
								</ol>
								<!-- end indicators -->
								<!-- wrapper for slides -->
								<div class="carousel-inner" role="listbox" id="main-carousel">
									<c:forEach var="aniMain" items="${aniMain}" varStatus="status">
										<c:set var="cls" value="" />
										<c:if test="${status.index == 0}">
											<c:set var="cls" value="active" />
										</c:if>
										<c:url var="downloadUrl" value="/download.do">
											<c:param name="file" value="${aniMain.file}" />
										</c:url>
										<div class="item ${cls}">
											<img alt="입양1" src="${downloadUrl}" id="#main-carousel-inner"
												style="height: 240px;">
											<div class="carousel-caption">
												<p>
													<a
														href="${pageContext.request.contextPath}/ani/ani_det.do?ani_id=${aniMain.anino}">${aniMain.anititle}</a>
												</p>
											</div>
										</div>
									</c:forEach>
								</div>
								<!-- end wrapper for slides -->
								<!-- controls -->
								<a class="left carousel-control" href="#carousel"
									data-slide="prev"> <span
									class="glyphicon glyphicon-chevron-left"></span>
								</a> <a class="right carousel-control" href="#carousel"
									data-slide="next"> <span
									class="glyphicon glyphicon-chevron-right"></span>
								</a>
								<!-- end controls -->
							</div>
							<!-- 입양 캐러셀 끝 -->
						</div>
					</div>
					<!-- 게시판2 끝 -->
				</div>
				<div class="col-md-6 col-sm-6" id="board">
					<!-- 게시판1 시작 -->
					<div class="panel panel-default">
						<div class="panel-heading">
							<span class="glyphicon glyphicon-hand-right">&nbsp;후 원 후 기</span>
							<a
								href="${pageContext.request.contextPath}/listboard/list_list.do?listcate=s"
								class="glyphicon glyphicon-plus pull-right"><span>더보기</span></a>
						</div>
						<div class="panel-body">
							<table class="table table-hover">
								<thead>
									<tr>
										<td id="main-num">No.</td>
										<td id="main-title">글 제 목</td>
										<td id="main-write">글 쓴 이</td>
									</tr>
								</thead>
								<tbody>
									<c:choose>
										<c:when test="${fn:length(sList) > 0}">
											<c:forEach var="listboard" items="${sList}">
												<tr>
													<td>${listboard.listno}</td>
													<td id="main-title"><a
														href="${pageContext.request.contextPath}/listboard/list_read.do?listcate=${listboard.listcate}&listno=${listboard.listno}">${listboard.listtitle}</a>

													</td>
													<td>${listboard.id}</td>
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
						</div>
					</div>
					<!-- 게시판1 끝 -->
					<!-- 게시판2 시작 -->
					<div class="panel panel-default">
						<div class="panel-heading">
							<span class="glyphicon glyphicon-hand-right">&nbsp;입 양 후 기</span>
							<a
								href="${pageContext.request.contextPath}/listboard/list_list.do?listcate=a"
								class="glyphicon glyphicon-plus pull-right"><span>더보기</span></a>
						</div>
						<div class="panel-body">
							<table class="table table-hover">
								<thead>
									<tr>
										<td id="main-num">No.</td>
										<td id="main-title">글 제 목</td>
										<td id="main-write">글 쓴 이</td>
									</tr>
								</thead>
								<tbody>
									<c:choose>
										<c:when test="${fn:length(aList) > 0}">
											<c:forEach var="listboard" items="${aList}">
												<tr>
													<td>${listboard.listno}</td>
													<td
														style="text-overflow: ellipsis; overflow: hidden; white-space: nowrap;">
														<a
														href="${pageContext.request.contextPath}/listboard/list_read.do?listcate=${listboard.listcate}&listno=${listboard.listno}">${listboard.listtitle}</a>
													</td>
													<td>${listboard.id}</td>
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
						</div>
					</div>
					<!-- 게시판2 끝 -->
				</div>
				<!-- 게시판 끝 -->
			</div>
		</section>
		<%@ include file="/WEB-INF/inc/footer.jsp"%>
	</div>
</body>
</html>