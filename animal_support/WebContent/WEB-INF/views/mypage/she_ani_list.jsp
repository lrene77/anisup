<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/inc/head.jsp"%>
<!-- stylesheet-->
<link rel="stylesheet" type="text/css" href="../assets/css/list.css" />
<link rel="stylesheet" type="text/css" href="../assets/css/small.css" />
<link rel="stylesheet" type="text/css" href="../assets/css/pagination.css" />
<link rel="stylesheet" type="text/css" href="../assets/css/mypage/mod.css">

<!-- Javascript -->
<script src="../assets/js/jquery.min.js"></script>
<script src="../assets/js/bootstrap.min.js"></script>
<script src="../assets/js/common.js"></script>
</head>
<body>
<div class="container">
<%@ include file="/WEB-INF/inc/topbar.jsp"%>
			<br id="space">
			<section>
				<h2 class="noti">보호소입양내역</h2>
				<small id="small1">입양신청서를 확인할 수 있습니다.</small>
				<small id="small2"><span class="glyphicon glyphicon-home"></span> &gt; myPage &gt; 입양내역</small>				
				<hr>
				<!-- Table -->
				<table class="table">
					<thead>
					
						<tr>
							<th class="text-center">No.</th>
							<th class="text-center">글 제목</th>
							<th class="text-center">작성일</th>
							<th class="text-center">작성자</th>
							<th class="text-center">신청서</th>
							<th class="text-center">신청현황</th>
							<th class="text-center">상태</th>
						</tr>
					</thead>
				<tbody>
					<c:choose>
						<c:when test="${fn:length(aniList) > 0}">
							<c:forEach var="ani" items="${aniList}">
								<tr>
									<td class="text-center">${ani.anino}</td>
								
									<td class="text-center">
										<c:url var="readUrl" value="/ani/ani_det.do">
					            			<c:param name="ani_id" value="${ani.anino}" />
					            		</c:url>
					            	
					            	<a href="${readUrl}">${ani.anititle}</a>
					            	
									</td>
									
		 							<td class="text-center">${ani.wdate}</td>
		 							<td class="text-center">${ani.name}</td>
									
									<c:url var="readUrl" value="/mypage/she_req.do">
					            		<c:param name="reqno" value="${ani.anino}" />
									</c:url>
									<td class="text-center"><a class="btn btn-default" id="btn1" href="${pageContext.request.contextPath}/mypage/she_req.do">확인</a></td>
									
									<td class="text-center">${ani.anicount}/5</td>  
									<td class="text-center">${ani.anistat}</td>  
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

				<div class="page_number" align="center">
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



				<div class="box1" align="center">
					<select  id="select">
						<option>제목</option>
						<option>제목+내용</option>
						<option>작성자</option>
						<option>글쓴이</option>
					</select>

					<input type="text" id="text1">
					<button class="glyphicon glyphicon-search btn btn-default" id="search">검색</button>
				</div>
			</section>
			
<%@ include file="/WEB-INF/inc/footer.jsp"%>
</div>
	</body>
</html>