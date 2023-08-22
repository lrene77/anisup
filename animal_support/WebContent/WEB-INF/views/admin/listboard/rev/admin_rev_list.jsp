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
	href="${pageContext.request.contextPath}/assets/css/admin/ad_rev.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/pagination.css" />
<style type="text/css">
.table th:first-child {
	width: 5%;
}

.table th:nth-child(2) {
	width: 10%;
}

.table th:nth-child(3) {
	width: 45%;
}

.table th:nth-child(4) {
	width: 15%;
}

.table th:nth-child(5) {
	width: 10%;
}

.table th:last-child {
	width: 15%;
}
.pagination>.active>a, .pagination>.active>span, .pagination>.active>a:hover, .pagination>.active>span:hover, .pagination>.active>a:focus, .pagination>.active>span:focus {
    z-index: 2;
    color: #fff;
    background-color: #005E75;
    border-color: #005E75;
    cursor: default;
    border-radius: 10px;
}
</style>
<script type="text/javascript">
$(function(){
	$("#all_check").change(function(){
		var is_check = $(this).is(":checked");

		$(".ckselect_check").prop("checked", is_check);
	});
});
</script>
</head>
<body>
	<div class="container">
		<%@ include file="/WEB-INF/inc/admin/admin_topbar.jsp"%>
		<!-- 상단 끝 -->
		<br> <br>
		<!-- 내용 시작 -->
		<section>
			<h2 class="noti">후기관리</h2>
			<hr>
			<form method="get" action="${pageContext.request.contextPath}/admin/listboard/rev/admin_rev_list.do">
			<label for="sc"><h4>검 색 어</h4></label>
			<input type="text" name="text" id="sc" placeholder="  제목을 입력하세요." value="${text}" /> <br>
			<label for="mem_kind"><h4>등 록 일</h4></label>
			<input type="date" name="wdate1" id="sc1" value="${wdate1}" /><span>&nbsp; - &nbsp;</span>
			<input type="date" name="wdate2" id="sc2" value="${wdate2}" /> <br /> <label
				for="mem_kind"><h4>후기구분</h4></label>
			<div class="mem_kind">
				<label><input type="radio" name="kind" value="ani" /> 입 양</label> <label><input
					type="radio" name="kind" value="sup" /> 후 원</label>
			</div>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
				type="submit" id="sbtn" value="검 색" /> <br>
			</form>
			<hr>
			<form action="${pageContext.request.contextPath}/admin/listboard/rev/admin_rev_delete.do" method="post">
			<table class="table">
				<thead>
					<tr>
						<th class="text-center"><input type="checkbox" id="all_check"
							value="Y" /></th>
						<th class="text-center">번호</th>
						<th class="text-center">제목</th>
						<th class="text-center">등록일</th>
						<th class="text-center">조회</th>
						<th class="text-center">카테고리</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
					<c:when test="${fn:length(listboardList) > 0}">
						<c:forEach var="listboard" items="${listboardList}">
							<tr>
								<td class="text-center"><input type="checkbox"
										id="ckselect1" name="checkbox" value="${listboard.listno}" class="ckselect_check" /></td>
								<td class="text-center">${listboard.listno}</td>
								<td><c:url var="readUrl" value="/listboard/list_read.do">
										<c:param name="listcate" value="${listboard.listcate}" />
										<c:param name="listno" value="${listboard.listno}" />
									</c:url> <a id="acolor" href="${readUrl}">${listboard.listtitle}</a></td>
								<td class="text-center">${listboard.wdate}</td>
								<td class="text-center">${listboard.hit}</td>
								<c:choose>
									<c:when test="${listboard.listcate == 's'}">
										<td class="text-center">후원</td>
									</c:when>
									<c:otherwise>
										<td class="text-center">입양</td>
									</c:otherwise>
								</c:choose>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td id="listnone" colspan="6" class="text-center"
								style="line-height: 100px;">조회된 글이 없습니다.</td>
						</tr>
					</c:otherwise>
				</c:choose>
				</tbody>
			</table>

			<%@ include file="/WEB-INF/inc/admin/rev_bottom.jsp"%>
			</form>
		</section>
		<!-- 내용 끝 -->
	</div>
	<%@ include file="/WEB-INF/inc/admin/admin_footer.jsp"%>
</body>
</html>