<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!doctype html>
<html>
<head>
<%@ include file="/WEB-INF/inc/admin/admin_head.jsp"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/pagination.css" />
<!-- JavaScript -->
<script
	src="${pageContext.request.contextPath}/assets/js/admin/ad_mem_list.js"></script>

<!-- css -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assets/css/admin/ad_noti.css" />
<script type="text/javascript">
	$(function() {
		$("#all_check").change(function() {
			var is_check = $(this).is(":checked");

			$(".ckselect_check").prop("checked", is_check);
		});
	});
</script>
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
		<%@ include file="/WEB-INF/inc/admin/admin_topbar.jsp"%>
		<!-- 내용 시작 -->
		<br> <br>
		<section>
			<h2 class="noti">Q & A</h2>
			<hr>
			<form method="get" action="${pageContext.request.contextPath}/admin/listboard/info/admin_qna_list.do">
			<label for="sc"><h4>검 색 어</h4></label>
			<input type="text" name="text" id="sc" placeholder="  내용을 입력하세요." value="${text}" /> <br>
			<label for="mem_kind"><h4>등 록 일</h4></label> 
			<input type="date" name="wdate1" id="sc1" value="${wdate1}" /><span>&nbsp; - &nbsp;</span>
			<input type="date" name="wdate2" id="sc2" value="${wdate2}" />
			<input type="submit" id="sbtn" value="검 색" style="margin-left: 10px;" />
			</form>
			<hr>
			<form action="${pageContext.request.contextPath}/admin/listboard/info/admin_qna_delete.do" method="post">
			<table class="table">
				<thead>
					<tr>
						<th class="text-center"><input type="checkbox" id="all_check"
							value="Y" /></th>
						<th class="text-center">번호</th>
						<th class="text-center">제목</th>
						<th class="text-center">등록일</th>
						<th class="text-center">조회</th>
						<th class="text-center">수정</th>
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
									<td class="text-center"><c:url var="readUrl"
											value="/listboard/list_read.do">
											<c:param name="listcate" value="${listboard.listcate}" />
											<c:param name="listno" value="${listboard.listno}" />
										</c:url> <a href="${readUrl}" class="btn btn-primary" id="mbtn"
										style="color: white">답 변</a></td>
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

			<%@ include file="/WEB-INF/inc/admin/qna_bottom.jsp"%>
			</form>
		</section>
		<!-- 내용 끝 -->
	</div>
	<%@ include file="/WEB-INF/inc/admin/admin_footer.jsp"%>
</body>
</html>