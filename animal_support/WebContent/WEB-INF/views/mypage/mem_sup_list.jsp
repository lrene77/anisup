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
<link rel="stylesheet" type="text/css" href="../assets/css/mypage/mod.css" />
</head>
<body>
	<div class="container">
		<%@ include file="/WEB-INF/inc/topbar.jsp"%>
		<!-- 내용 시작 -->
		<br id="space">
		<section>
			<h2 class="noti">후원내역</h2>
			<small>후원 내역을 보여주는 페이지 입니다.</small> <small id="small2"><span
				class="glyphicon glyphicon-home"></span> &gt; myPage &gt; 후원내역</small>
			<hr />
			<!-- Table -->
			<table class="table">
				<tr>
					<th class="text-center">No.</th>
					<th class="text-center">프로젝트 주제</th>
					<th class="text-center">작성자</th>
					<th class="text-center">후원일</th>
					<th class="text-center">후원금액</th>
				</tr>

				<tbody>
					<c:choose>
						<c:when test="${fn:length(supList) > 0}">
							<c:forEach var="sup" items="${supList}">
								<tr>
									<td class="text-center">${sup.giveno}</td>
									
									<td class="text-center">
										<c:url var="readUrl" value="/sup/sup_read.do">
					            			<c:param name="supno" value="${sup.supno}" />
					            		</c:url>
					            	<a href="${readUrl}">${sup.suptitle}</a>
									</td>
									
									<td class="text-center">${loginInfo.name}</td>
									<td class="text-center">${sup.givedate}</td>
									<td class="text-center">${sup.giveprice}</td>
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
				<!-- 	<tr>
							<td class="text-center">1</td>
							<td><a href="#" id="ok">[아이들을 도와주세요]</a></td>
							<td class="text-center">홍길동</td>
							<td class="text-center">2017.11.12</td>
							<td class="text-center">10,000</td>
						</tr>

						<tr>
							<td class="text-center">2</td>
							<td><a href="#" id="ok">[강아지 도와주실분 구해요]</a></td>
							<td class="text-center">홍길동</td>
							<td class="text-center">2017.11.12</td>
							<td class="text-center">10,000</td>
						</tr>

						<tr>
							<td class="text-center">3</td>
							<td><a href="#" id="ok">[강아지가 불상해요]</a></td>
							<td class="text-center">홍길동</td>
							<td class="text-center">2017.11.14</td>
							<td class="text-center">10,000</td>
						</tr>

						<tr>
							<td class="text-center">4</td>
							<td><a href="#" id="ok">[조금만 도와주세요]</a></td>
							<td class="text-center">홍길동</td>
							<td class="text-center">2017.11.15</td>
							<td class="text-center">10,000</td>
						</tr>

						<tr>
							<td class="text-center">5</td>
							<td><a href="#" id="ok">[아이들을 도와주세요]</a></td>
							<td class="text-center">홍길동</td>
							<td class="text-center">2017.11.18</td>
							<td class="text-center">100,000</td>
						</tr>	

						<tr>
							<td class="text-center">6</td>
							<td><a href="#" id="ok">[아이들을 도와주세요]</a></td>
							<td class="text-center">홍길동</td>
							<td class="text-center">2017.11.20</td>
							<td class="text-center">10,000</td>
						</tr>						
						<tr>
							<td class="text-center">7</td>
							<td><a href="#" id="ok">[모두에게 힘이될수 있도록]</a></td>
							<td class="text-center">홍길동</td>
							<td class="text-center">2017.11.31</td>
							<td class="text-center">10,000</td>
						</tr>	 -->
			</table>

			<div id="box1" align="center">
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

<!-- 			<label class="pull-right" id="give">후원 금액:<span>100,000</span></label> -->
		</section>
		<%@ include file="/WEB-INF/inc/footer.jsp"%>
	</div>
</body>
</html>