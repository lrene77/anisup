<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
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


<style type="text/css">
#title{
text-decoration:none;
color:block;
}
</style>
</head>
<body>
	<div class="container">
		<%@ include file="/WEB-INF/inc/topbar.jsp"%>
		<br id="space">
		<section>
			<h2 class="noti">입양신청내역</h2>
			<small id="small1">신청하신 입양현황을 볼 수 있습니다</small> <small id="small2"><span
				class="glyphicon glyphicon-home"></span> &gt; myPage &gt; 입양신청내역</small>
			<hr />
			<!-- Table -->
			<table class="table">
				<thead>
					<tr>
						<th class="text-center">No.</th>
						<th class="text-center">글 제목</th>
						<th class="text-center">작성일</th>
						<th class="text-center">작성자</th>
						<th class="text-center">현황</th>
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
					            	
					            	<a href="${readUrl}" id="title">${ani.anititle}</a>
					            	
									</td>
									<td class="text-center">${ani.wdate}</td>
									<td class="text-center">${loginInfo.name}</td>
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
 		<%@ include file="/WEB-INF/myinc/mem_ani_list_bottom.jsp"%> 
		<br /> <br /> <br />		

		<%@ include file="/WEB-INF/inc/footer.jsp"%>
	</div>
</body>
</html>