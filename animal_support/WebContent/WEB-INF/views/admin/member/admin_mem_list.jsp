<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!doctype html>
<html>
<head>
<%@ include file="/WEB-INF/inc/admin/admin_head.jsp"%>

<!-- javaScript -->
<script
	src="${pageContext.request.contextPath}/assets/js/admin/ad_mem_list.js"></script>
<script
	src="${pageContext.request.contextPath}/assets/js/admin/admin_checked.js"></script>

<!-- css -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assets/css/admin/ad_mem_list.css" />
</head>
<body>
	<div class="container">
		<%@ include file="/WEB-INF/inc/admin/admin_topbar.jsp"%>
		<!-- 내용 시작 -->
		<br /> <br />
		<section>
			<h2 class="noti">회원관리</h2>
			<hr>
			<label for="search_word"><h4>검 색 어</h4></label> <select
				id="search_word">
				<option>-- 선택 --</option>
				<option>아이디</option>
				<option>이 름</option>
				<option>분 류</option>
			</select> <input type="text" id="sc" placeholder="  내용을 입력하세요." /> <br>
			<label for="mem_kind"><h4>회원구분</h4></label>
			<div class="mem_kind">
				<label><input type="radio" name="kind" value="개인" /> 개 인</label> <label><input
					type="radio" name="kind" value="개인" /> 보 호 소</label>
			</div>
			<input type="button" id="sbtn" value="검 색" />
			<hr>
			<table class="table">
				<tr>
					<th class="text-center"><input type="checkbox" id="all_check"
						value="Y" /></th>
					<th class="text-center">번호</th>
					<th class="text-center">아이디</th>
					<th class="text-center">이름</th>
					<th class="text-center">후원금액</th>
					<th class="text-center">후원건수</th>
					<th class="text-center">회원분류</th>
					<th class="text-center">정보수정</th>
				</tr>
				<c:choose>
					<c:when test="${fn:length(adminList) > 0 }">
						<c:forEach var="adminList" items="${adminList}">
							<tr>
								<td class="text-center"><input type="checkbox"
									id="ckselect1" name="ckselect1" class="ckselect_check" /></td>
								<td class="text-center">${adminList.mno}</td>
								<td class="text-center">${adminList.id}</td>
								<td class="text-center">${adminList.name}</td>
								<td class="text-center">${adminList.giveprice}</td>
								<td class="text-center"></td>
								<td class="text-center">${adminList.mtype}</td>
								<td class="text-center"><a href="${pageContext.request.contextPath}/admin/member/admin_mem_upd.do"
									class="btn btn-primary" id="mbtn">수 정</a></td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="8" class="text-center" style="line-height: 100px">
								조회된 회원이 없습니다.</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</table>

			<div class="container">
				<input type="button" class="btn btn-primary" value="삭 제" id="dbtn">
			</div>

			<div class="container" align="center">
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
		</section>
		<!-- 내용 끝 -->
	</div>
	<%@ include file="/WEB-INF/inc/admin/admin_footer.jsp"%>
</body>
</html>