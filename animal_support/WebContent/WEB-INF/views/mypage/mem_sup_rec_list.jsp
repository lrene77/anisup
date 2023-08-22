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
<link rel="stylesheet" type="text/css" href="../assets/css/small.css">
<link rel="stylesheet" type="text/css" href="../assets/css/list.css" />
<link rel="stylesheet" type="text/css" href="../assets/css/pagination.css" />
<link rel="stylesheet" type="text/css" href="../assets/css/mypage/mod.css" />

</head>
<body>
	<div class="container">
		<%@ include file="/WEB-INF/inc/topbar.jsp"%>
		<!-- 내용 시작 -->
		<!-- 중단 -->
		<br id="space">
		<section>
			<h2 class="noti">모집내역</h2>
			<small id="small1">(일반회원)모집내역을 볼 수 있습니다.</small> <small id="small2"><span
				class="glyphicon glyphicon-home"></span> &gt; myPage &gt; 모집내역</small>
			<hr>

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
				

<%-- 				<tbody>
					<tr>
						<td class="text-center">${supno}</td>
						<td><a href="#" id="ok">${suptitle}</a></td>
						<td class="text-center">${suptitle}</td>
						<td class="text-center">${suptitle}</td>
						<td class="text-center">${suptitle}</td>
						<td class="text-center">${suptitle}</td>
						<td class="text-center">${suptitle}</td>
					</tr>
				</tbody>
<!--  
					<tr>
						<td class="text-center">2</td>
						<td><a href="#" id="ok">제가 후원을 햇으니 글을 써봅니다</a></td>
						<td class="text-center">13/10/01~13/10/15</td>
						<td class="text-center">1,000,000,000</td>
						<td class="text-center">300,00,000</td>
						<td class="text-center">50%</td>
						<td class="text-center">종료</td>
					</tr>

					<tr>
						<td class="text-center">3</td>
						<td><a href="#" id="ok">제가 후원후기 적으면 남들도 볼려</a>나</td>
						<td class="text-center">13/10/01~13/10/15</td>
						<td class="text-center">1,000,000,000</td>
						<td class="text-center">400,00,000</td>
						<td class="text-center">0%</td>
						<td class="text-center">반려</td>
					</tr>

					<tr>
						<td class="text-center">4</td>
						<td><a href="#" id="ok">후기를 쓸수 있다는데 써줘야지 그럼그럼</a></td>
						<td class="text-center">13/10/01~13/10/15</td>
						<td class="text-center">1,000,000,000</td>
						<td class="text-center">500,00,000</td>
						<td class="text-center">50%</td>
						<td class="text-center">진행</td>
					</tr>

					<tr>
						<td class="text-center">5</td>
						<td><a href="#" id="ok">후기 참 많이쓴다 진짜</a></td>
						<td class="text-center">13/10/01~13/10/15</td>
						<td class="text-center">1,000,000,000</td>
						<td class="text-center">300,00,000</td>
						<td class="text-center">50%</td>
						<td class="text-center">종료</td>
					</tr>

					<tr>
						<td class="text-center">6</td>
						<td><a href="#" id="ok">내가 후원을 또 한번 해보네 소름</a></td>
						<td class="text-center">13/10/01~13/10/15</td>
						<td class="text-center">1,000,000,000</td>
						<td class="text-center">300,00,000</td>
						<td class="text-center">50%</td>
						<td class="text-center">종료</td>
					</tr>
					<tr>
						<td class="text-center">7</td>
						<td><a href="#" id="ok">들 후원하세요 착한일해야 복받아요</a></td>
						<td class="text-center">13/10/01~13/10/15</td>
						<td class="text-center">1,000,000,000</td>
						<td class="text-center">300,00,000</td>
						<td class="text-center">50%</td>
						<td class="text-center">진행</td>
					</tr>
				</tbody> -->
			</table> --%>


			<div class="box2" align="center">
				<select id="select" style=width:80px;>
					<option> 제목 </option>
					<option> 진행 </option>
					<option> 대기 </option>
					<option> 반려 </option>
				</select> <input type="text" id="text1">
				<button class="glyphicon glyphicon-search btn btn-default"
					id="search">검색</button>
			</div>
		</section>
 		<%@ include file="/WEB-INF/myinc/mem_sup_rec_list_bottom.jsp"%>
 		<br/><br/>		

		<%@ include file="/WEB-INF/inc/footer.jsp"%>
	</div>
</body>
</html>