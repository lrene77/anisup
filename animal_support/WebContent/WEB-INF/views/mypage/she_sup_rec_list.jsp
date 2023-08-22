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
<link rel="stylesheet" type="text/css" href="../assets/css/pagination.css" />
<link rel="stylesheet" type="text/css" href="../assets/css/mypage/mod.css" />

<!-- Javascript -->
<script src="../assets/js/mypage/msg.js"></script>
</head>
<body>
<body>
 	<div class="container">
		<%@ include file="/WEB-INF/inc/topbar.jsp"%>
		<!-- 상단 끝 -->
		<br id="space">
		<section>
			<h2 class="noti">보호소모집내역</h2>
			<small id="small1">(보호소)모집내역을 볼수 있습니다.</small> <small id="small2"><span
				class="glyphicon glyphicon-home"></span> &gt; myPage &gt; 모집내역</small>
			<hr />
			<!-- Table -->
			<table class="table">
				<thead>
					<tr>
						<th class="text-center">No.</th>
						<th class="text-center">프로젝트 주제</th>
						<th class="text-center">진행기간</th>
						<th class="text-center">현재모금액</th>
						<th class="text-center">목표금액</th>
						<th class="text-center">진행률</th>
						<th class="text-center">진행상태</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${fn:length(supList) > 0}">
							<c:forEach var="sup" items="${supList}">
								<tr>
									<td class="text-center">${sup.supno}</td>
									
									<td class="text-center">
										<c:url var="readUrl" value="/sup/sup_read.do">
					            			<c:param name="supno" value="${sup.supno}" />
					            		</c:url>
					            	<a href="${readUrl}">${sup.suptitle}</a>
									</td>		
																
									<td class="text-center">${sup.supstart}~${ sup.supend }</td>
									<td class="text-center">${sup.supnow}</td>
									<td class="text-center">${sup.supprice }</td>
									<td class="text-center">${sup.suping }%</td>
									<td class="text-center">${sup.supstat }</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="7" class="text-center" style="line-height: 100px;">
									조회된 글이 없습니다.</td>
							</tr>
						</c:otherwise>
					</c:choose> 
		   		 </tbody>
			</table>

			<div class="box1" align="center">
				<ul class="pagination">
					<li class="disabled"><a href="#">&laquo;</a></li>
					<li class="active"><span>1<span class="sr-only"></span></span></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#">&raquo;</a></li>
				</ul>
			</div>


			<div class="box2" align="center">
				<select id="select">
					<option>제목</option>
					<option>제목+내용</option>
					<option>작성자</option>
					<option>글쓴이</option>
				</select> <input type="text" id="text1">
				<button class="glyphicon glyphicon-search btn btn-default"
					id="search">검색</button>
			</div>
		</section>
		<%@ include file="/WEB-INF/inc/footer.jsp"%>
	</div> 
</html>