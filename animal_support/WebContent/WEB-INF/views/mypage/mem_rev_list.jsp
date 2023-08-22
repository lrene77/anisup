<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/inc/head.jsp"%>
<!-- bootstrap -->
<link rel="stylesheet" type="text/css" href="../assets/css/small.css">
<link rel="stylesheet" type="text/css" href="../assets/css/list.css" />
<link rel="stylesheet" type="text/css" href="../assets/css/pagination.css" />
</head>
<body>
	<div class="container">
		<%@ include file="/WEB-INF/inc/topbar.jsp"%>
		<br id="space">
		<section>
			<h2 class="noti">후기게시판</h2>
			<small id="small1">입양,후원게시판</small> <small id="small2"><span
				class="glyphicon glyphicon-home"></span> &gt; myPage &gt; 후기게시판</small>
			<hr />
			<!-- Table -->
			<table class="table">
				<thead>
					<tr>
						<th class="text-center">No.</th>
						<th class="text-center">글제목</th>
						<th class="text-center">작성일</th>
						<th class="text-center">조회</th>
						<th class="text-center">카테고리</th>
					</tr>
				</thead>
				
				<tbody>
					<c:choose>
						<c:when test="${fn:length(boardList) > 0}">
							<c:forEach var="bo" items="${boardList}">
								<tr>
									<td class="text-center">${bo.listno}</td>
									<td class="text-center">${bo.listtitle}</td>
									<td class="text-center">${bo.wdate}</td>
									<td class="text-center">${bo.hit}</td>
									<td class="text-center">${bo.listcate}</td>
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

				<!-- <tbody>
					<tr>
						<td class="text-center">1</td>
						<td><a href="#" id="ok">얼마전에 강아지 후원하는 후언글</a></td>
						<td class="text-center">2013.12.12</td>
						<td class="text-center">50</td>
						<td class="text-center">후원후기</td>
					</tr>

					<tr>
						<td class="text-center">2</td>
						<td><a href="#" id="ok">제가 후원을 햇으니 글을 써봅니다</a></td>
						<td class="text-center">2013.10.12</td>
						<td class="text-center">100</td>
						<td class="text-center">후원후기</td>
					</tr>

					<tr>
						<td class="text-center">3</td>
						<td><a href="#" id="ok">제가 후원후기 적으면 남들도 볼려나</a></td>
						<td class="text-center">2013.12.31</td>
						<td class="text-center">20</td>
						<td class="text-center">후원후기</td>
					</tr>

					<tr>
						<td class="text-center">4</td>
						<td><a href="#" id="ok">후기를 쓸수 있다는데 써줘야지 그럼그럼</a></td>
						<td class="text-center">2015.12.12</td>
						<td class="text-center">5</td>
						<td class="text-center">후원후기</td>
					</tr>

					<tr>
						<td class="text-center">5</td>
						<td><a href="#" id="ok">후기 참 많이쓴다 진짜 </a></td>
						<td class="text-center">2017.02.12</td>
						<td class="text-center">60</td>
						<td class="text-center">후원후기</td>
					</tr>

					<tr>
						<td class="text-center">6</td>
						<td><a href="#" id="ok">내가 후원을 또 한번 해보네 소름</a></td>
						<td class="text-center">2013.12.12</td>
						<td class="text-center">10</td>
						<td class="text-center">후원후기</td>
					</tr>
					<tr>
						<td class="text-center">7</td>
						<td><a href="#" id="ok">님들 후원하세요 착한일해야 복받아요</a></td>
						<td class="text-center">2013.12.12</td>
						<td class="text-center">10</td>
						<td class="text-center">후원후기</td>
					</tr>
				</tbody> -->
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
</body>
</html>