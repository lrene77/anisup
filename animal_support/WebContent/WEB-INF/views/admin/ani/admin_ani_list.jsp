<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!doctype html>
<html>
<head>
<%@ include file="/WEB-INF/inc/admin/admin_head.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assets/css/admin/ad_ani_list.css">
<style type="text/css">
th:first-child {
	width: 10%;
}

th:nth-child(2) {
	width: 50%;
}

th:nth-chlid(3) {
	width: 15%;
}

th:nth-chlid(4) {
	width: 15%;
}

th:last-chlid(4) {
	width: 10%;
}

.pagination>.active>a, .pagination>.active>span, .pagination>.active>a:hover,
	.pagination>.active>span:hover, .pagination>.active>a:focus,
	.pagination>.active>span:focus {
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
		<%@ include file="/WEB-INF/inc/admin/admin_topbar.jsp"%>
		<!-- 상단 끝 -->
		<br> <br>
		<!-- 내용 시작 -->
		<section style="min-height: 500px">
			<h2 class="noti">입양관리</h2>
			<hr>
			<form method="get"
				action="${pageContext.request.contextPath}/admin/ani/admin_ani_search.do?">
				<label for="mem_kind"><h4>상 &nbsp;태</h4></label>
				<div class="mem_kind">
					<c:if test="${radio == null or radio == '전체'}">
						<label><input type="radio" name="kind" value="전체"
							checked="" /> 전 체</label>
						<label><input type="radio" name="kind" value="대기" /> 대 기</label>
						<label><input type="radio" name="kind" value="진행" /> 진 행</label>
						<label><input type="radio" name="kind" value="종료" /> 종 료</label>
						<label><input type="radio" name="kind" value="거절" /> 거 절</label>
					</c:if>
					<c:if test="${radio == '대기'}">
						<label><input type="radio" name="kind" value="전체" /> 전 체</label>
						<label><input type="radio" name="kind" value="대기"
							checked="" /> 대 기</label>
						<label><input type="radio" name="kind" value="진행" /> 진 행</label>
						<label><input type="radio" name="kind" value="종료" /> 종 료</label>
						<label><input type="radio" name="kind" value="거절" /> 거 절</label>
					</c:if>
					<c:if test="${radio == '진행'}">
						<label><input type="radio" name="kind" value="전체" /> 전 체</label>
						<label><input type="radio" name="kind" value="대기" /> 대 기</label>
						<label><input type="radio" name="kind" value="진행"
							checked="" /> 진 행</label>
						<label><input type="radio" name="kind" value="종료" /> 종 료</label>
						<label><input type="radio" name="kind" value="거절" /> 거 절</label>
					</c:if>
					<c:if test="${radio == '종료'}">
						<label><input type="radio" name="kind" value="전체" /> 전 체</label>
						<label><input type="radio" name="kind" value="대기" /> 대 기</label>
						<label><input type="radio" name="kind" value="진행" /> 진 행</label>
						<label><input type="radio" name="kind" value="종료"
							checked="" /> 종 료</label>
						<label><input type="radio" name="kind" value="거절" /> 거 절</label>
					</c:if>
					<c:if test="${radio == '거절'}">
						<label><input type="radio" name="kind" value="전체" /> 전 체</label>
						<label><input type="radio" name="kind" value="대기" /> 대 기</label>
						<label><input type="radio" name="kind" value="진행" /> 진 행</label>
						<label><input type="radio" name="kind" value="종료" /> 종 료</label>
						<label><input type="radio" name="kind" value="거절" checked="" /> 거 절</label>
					</c:if>
				</div>
				<br> <label for="mem_kind"><h4>등록일</h4></label><input
					type="date" id="sc1" class="form-control" name="sc1" value="${sc1}"
					placeholder="  날짜을 선택하세요." /> <span>&nbsp; - &nbsp;</span> <input
					type="date" id="sc2" class="form-control" name="sc2" value="${sc2}"
					placeholder="  날짜을 선택하세요." /> <br> <label for="search_word"><h4>검색어</h4>
				</label> <select id="search_word" name="select">
					<option value="all">전 체</option>
					<option value="title">제 목</option>
					<option value="id">아이디</option>
				</select> <input type="text" id="sc" name="keyword"
					placeholder="  내용을 입력하세요." value="${keyword}" />
				<button type="submit" id="sbtn">검 색</button>
			</form>
			<hr>
			<table class="table">
				<tr>
					<th class="text-center"><input type="checkbox" id="all_check"
						value="Y" /></th>
					<th class="text-center" style="width: 5%">번호</th>
					<th class="text-center">분양 글 제목</th>
					<th class="text-center">아이디</th>
					<th class="text-center" style="width: 10%">작성일</th>
					<th class="text-center">상세보기</th>
					<th class="text-center">신청인원</th>
					<th class="text-center">상태</th>
					<th colspan="2" class="text-center">승인</th>
				</tr>

				<!-- 게시물 하나 시작 -->
				<c:choose>
					<c:when test="${fn:length(aniList) > 0}">
						<form method="post"
							action="${pageContext.request.contextPath}/admin/ani/admin_ani_ret_ok.do">
							<c:forEach var="ani" items="${aniList}">
								<tr>
									<td class="text-center"><input type="checkbox"
										id="ckselect1" class="ckselect_check" name="checkbox"
										value="${ani.anino}" /></td>
									<td class="text-center">${ani.anino}</td>
									<c:url var="readUrl" value="/ani/ani_det.do">
										<c:param name="ani_id" value="${ani.anino}" />
										<c:param name="ani_file" value="${ani.file}" />
									</c:url>
									<td class="text-center"><a href="${readUrl}"
										style="text-decoration: none; color: #000;">${ani.anititle}</a></td>
									<td class="text-center">${ani.id}</td>
									<td class="text-center">${ani.wdate}</td>
									<c:url var="readUrl1" value="/admin/ani/admin_ani_det.do">
										<c:param name="ani_id" value="${ani.anino}" />
									</c:url>
									<td class="text-center"><a href="${readUrl1}"
										class="btn btn-primary" id="detbtn">상세보기</a></td>
									<td class="text-center">${ani.anicount}/5</td>
									<td class="text-center">${ani.anistat}</td>
									<c:if test="${ani.anistat == '대기'}">
										<c:url var="readUrl2" value="/admin/ani/admin_ani_ret_ok.do">
											<c:param name="ani_id" value="${ani.anino}" />
										</c:url>
										<td colspan="2" class="text-center">
										<a href="${readUrl2}" class="btn btn-primary" id="obtn">승인</a>
										<c:url var="rejecReadUrl" value="/admin/ani/mail_form.do">
											<c:param name="ani_id" value="${ani.anino}" />										
										</c:url>
										<a href="${rejecReadUrl}" class="btn btn-primary"
										id="obtn">거절</a>
										</td>
									</c:if>
									<c:if test="${ani.anistat == '진행' || ani.anistat == '종료'}">
										<td colspan="2" class="text-center">승인된 글입니다.</td>
									</c:if>
									<c:if test="${ani.anistat == '거절'}">
										<td colspan="2" class="text-center">거절된 글입니다.</td>
									</c:if>
								</tr>
							</c:forEach>
						</form>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="10">
								<div class="text-center" style="line-height: 100px;">입양 글이
									없습니다.</div>
							</td>
						</tr>
					</c:otherwise>
				</c:choose>
				<!-- 게시물 하나 끝 -->

			</table>
		</section>

		<br /> <br /> <br />
		<%@ include file="/WEB-INF/inc/admin/admin_ani_list_bottom.jsp"%>
		<br /> <br /> <br />


		<%@ include file="/WEB-INF/inc/admin/admin_footer.jsp"%>
	</div>
</body>
</html>