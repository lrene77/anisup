<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/inc/head.jsp"%>

<!-- sup.css -->
<link rel="stylesheet" type="text/css" href="../assets/css/sup/sup.css" />
<link rel="stylesheet" type="text/css" href="../assets/css/small.css" />
<link rel="stylesheet" type="text/css" href="../assets/css/list.css" />
<link rel="stylesheet" type="text/css" href="../assets/css/btn.css">
<link rel="stylesheet" type="text/css" href="../assets/css/pagination.css" />

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/pagination.css"/>
<style type="text/css">
.pagination>.active>a, .pagination>.active>span, .pagination>.active>a:hover, .pagination>.active>span:hover, .pagination>.active>a:focus, .pagination>.active>span:focus {
    z-index: 2;
    color: #fff;
    background-color: #005E75;
    border-color: #005E75;
    cursor: default;
    border-radius: 10px;
}
</style>
</head>
<body>
	<div class="container">
		<%@ include file="/WEB-INF/inc/topbar.jsp"%>
		<!-- 내용 시작 -->
		<br id="space">
		<section>
			<h2>후원</h2>
			<small>후원에 참여하실 수 있는 게시판입니다.</small> <small id="small2"><span
				class="glyphicon glyphicon-home"></span> &gt; 후원 </small>
			<hr />

			<!-- 진행 / 종료 / 모두 -->
			<ul class="nav nav-tabs">
				<li class="active"><a href="#all" data-toggle="tab">모두</a></li>
				<li><a href="#ing" data-toggle="tab">진행</a></li>
				<li><a href="#end" data-toggle="tab">종료</a></li>
			</ul>
			<br />

			<div class="tab-content">
				<!-- all 내용  시작 -->
				<div class="tab-pane fade in active" id="all">
						<div class="row" align="center">
							<!-- 조회된 글이 있는 경우 시작 -->
							<c:choose>
								<c:when test="${fn:length(supList) > 0}">
									<c:forEach var="sup" items="${supList}">
										<c:if test="${sup.supstat == '진행' || sup.supstat == '종료'}">
											<!-- 게시물  시작-->
											<div class="col-xs-12 col-sm-6 col-md-3">
												<div class="thumbnail">
													<c:url var="readUrl" value="/sup/sup_read.do">
														<c:param name="supno" value="${sup.supno}" />
													</c:url>
													<!-- 링크 + 썸네일 -->
													<a id="thumb_a" href="${readUrl}" style="text-decoration: none; color: black;">	
														<c:choose>
															<c:when test="${sup.imagePath != null}">
																<c:url var="downloadUrl" value="/download.do">
																	<c:param name="file" value="${sup.imagePath}" />
																</c:url>
																<img src="${downloadUrl}" class="img-responsive" />
															</c:when>
															<c:otherwise>
																<img src="${pageContext.request.contextPath}/img/no_image.jpg" class="img-responsive" />
															</c:otherwise>
														</c:choose>	
														<!-- 제목 + badge -->	
														<div id="title">
															<span id="badge_ing" class="badge pull-left">${sup.supDays}일 남음</span>
															<h4><b>[${sup.suptitle}]</b></h4>
														</div>	
														<!-- progressbar -->																								
														<div class="progress">
															<div class="progress-bar progress-bar-success"
																role="progressbar" aria-valuenow="40" aria-valuemin="0"
																aria-valuemax="100" style="width: ${sup.suping}%">
																<span class="sr-only">${sup.suping}% Complete (success)</span>
															</div>
														</div> 	
														<!-- 모금액 + % -->	
														<div class="clearfix">
															<div class="pull-left"><h4><strong>&nbsp;&nbsp;${sup.supnow} 원</strong></h4></div>
															<div class="pull-right"><h4 style="color: #cc3d3d"><strong>${sup.suping} %&nbsp;&nbsp;</strong></h4></div>
														</div>		
													</a>							
												</div>
											</div>
											<!-- 게시물  끝 -->
										</c:if>
									</c:forEach>								
								</c:when>
								<c:otherwise>
									<div class="col-md-12">
										<br/>
										<p class="text-center">조회된 후원글이 없습니다.</p>
										<br/>
									</div>
								</c:otherwise>
							</c:choose>
						</div>
											
					<!-- 페이지번호 (상태표시) -->
					<%@ include file="/WEB-INF/inc/sup_list_bottom.jsp"%>
				</div>
				<!-- all 내용 끝 -->
				
				<!-- ing 내용 시작 -->
				<div class="tab-pane fade" id="ing">
					<div class="row" align="center">
						<!-- 조회된 글이 있는 경우 시작 -->
						<c:choose>
							<c:when test="${fn:length(supList) > 0}">
								<c:forEach var="sup" items="${supList}">
									<c:if test="${sup.supstat == '진행'}">
										<!-- 게시물  시작-->
										<div class="col-xs-12 col-sm-6 col-md-3">
											<div class="thumbnail">
												<c:url var="readUrl" value="/sup/sup_read.do">
													<c:param name="supno" value="${sup.supno}" />
												</c:url>
												<!-- 링크 + 썸네일 -->
												<a id="thumb_a" href="${readUrl}"
													style="text-decoration: none; color: black;"> <c:choose>
														<c:when test="${sup.imagePath != null}">
															<c:url var="downloadUrl" value="/download.do">
																<c:param name="file" value="${sup.imagePath}" />
															</c:url>
															<img src="${downloadUrl}" class="img-responsive" />
														</c:when>
														<c:otherwise>
															<img
																src="${pageContext.request.contextPath}/img/no_image.jpg"
																class="img-responsive" />
														</c:otherwise>
													</c:choose> <!-- 제목 + badge -->
													<div id="title">
														<span id="badge_ing" class="badge pull-left">${sup.supDays}일
															남음</span>
														<h4>
															<b>[${sup.suptitle}]</b>
														</h4>
													</div> <!-- progressbar -->
													<div class="progress">
														<div class="progress-bar progress-bar-success"
															role="progressbar" aria-valuenow="40" aria-valuemin="0"
															aria-valuemax="100" style="width: ${sup.suping}%">
															<span class="sr-only">${sup.suping}% Complete
																(success)</span>
														</div>
													</div> <!-- 모금액 + % -->
													<div class="clearfix">
														<div class="pull-left">
															<h4>
																<strong>&nbsp;&nbsp;${sup.supnow} 원</strong>
															</h4>
														</div>
														<div class="pull-right">
															<h4 style="color: #cc3d3d">
																<strong>${sup.suping} %&nbsp;&nbsp;</strong>
															</h4>
														</div>
													</div>
												</a>
											</div>
										</div>
										<!-- 게시물  끝 -->
									</c:if>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<div class="col-md-12">
									<br/>
									<p class="text-center">진행중인 후원이 없습니다.</p>
									<br/>
								</div>
							</c:otherwise>
						</c:choose>
					</div>
						
					<!-- 페이지번호 (상태표시) -->
					<%@ include file="/WEB-INF/inc/sup_list_bottom.jsp"%>
				</div>
				<!-- ing 내용  끝 -->
				
				<!-- end 내용 시작 -->
				<div class="tab-pane fade" id="end">
					<div class="row" align="center">
						<!-- 조회된 글이 있는 경우 시작 -->
						<c:choose>
							<c:when test="${fn:length(supList) > 0}">
								<c:forEach var="sup" items="${supList}">
									<c:if test="${sup.supstat == '종료'}">						
										<!-- 게시물  시작-->
										<div class="col-xs-12 col-sm-6 col-md-3">
											<div class="thumbnail">
												<c:url var="readUrl" value="/sup/sup_read.do">
													<c:param name="supno" value="${sup.supno}" />
												</c:url>
												<!-- 링크 + 썸네일 -->
												<a id="thumb_a" href="${readUrl}"
													style="text-decoration: none; color: black;"> <c:choose>
														<c:when test="${sup.imagePath != null}">
															<c:url var="downloadUrl" value="/download.do">
																<c:param name="file" value="${sup.imagePath}" />
															</c:url>
															<img src="${downloadUrl}" class="img-responsive" />
														</c:when>
														<c:otherwise>
															<img
																src="${pageContext.request.contextPath}/img/no_image.jpg"
																class="img-responsive" />
														</c:otherwise>
													</c:choose> <!-- 제목 + badge -->
													<div id="title">
														<span id="badge_ing" class="badge pull-left">${sup.supDays}일
															남음</span>
														<h4>
															<b>[${sup.suptitle}]</b>
														</h4>
													</div> <!-- progressbar -->
													<div class="progress">
														<div class="progress-bar progress-bar-success"
															role="progressbar" aria-valuenow="40" aria-valuemin="0"
															aria-valuemax="100" style="width: ${sup.suping}%">
															<span class="sr-only">${sup.suping}% Complete
																(success)</span>
														</div>
													</div> <!-- 모금액 + % -->
													<div class="clearfix">
														<div class="pull-left">
															<h4>
																<strong>&nbsp;&nbsp;${sup.supnow} 원</strong>
															</h4>
														</div>
														<div class="pull-right">
															<h4 style="color: #cc3d3d">
																<strong>${sup.suping} %&nbsp;&nbsp;</strong>
															</h4>
														</div>
													</div>
												</a>
											</div>
										</div>
										<!-- 게시물  끝 -->
									</c:if>
								</c:forEach>
							</c:when>
							<c:otherwise>			
								<div class="col-md-12">
									<br/>
									<p class="text-center">종료된 후원이 없습니다.</p>
									<br/>
								</div>
							</c:otherwise>
						</c:choose>
					</div>
					
					<!-- 페이지번호 (상태표시) -->
					<%@ include file="/WEB-INF/inc/sup_list_bottom.jsp"%>
				</div>
			</div>
			<!-- end 내용  끝 -->
			
			<br />
			<br />
			<br />
						
		</section>
		<!-- 내용 끝 -->
		
		<br/><br/>
		
		<%@ include file="/WEB-INF/inc/footer.jsp"%>
	</div>
</body>
</html>