<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!doctype html>
<html>
<head>
<%@ include file="/WEB-INF/inc/admin/admin_head.jsp"%>
<link rel="stylesheet" type="text/css" href="../../assets/css/admin/ad_sup_list.css" />

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/pagination.css"/>
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
		<br>
		<br>
		<!-- 내용 시작 -->
		<section>
			<h2 class="noti">후원관리</h2>
			<hr>
			<form method="post" action="${pageContext.request.contextPath}/admin/sup/admin_sup_search.do">
				<label for="mem_kind"><h4>상 &nbsp;&nbsp;&nbsp;태</h4></label>
				<div class="mem_kind">			
					<c:if test="${radio == null || radio == '전체'}">
						<label><input type="radio" name="kind" value="전체" checked />전 체</label>
						<label><input type="radio" name="kind" value="대기" /> 대 기</label>
						<label><input type="radio" name="kind" value="진행" /> 진 행</label>
						<label><input type="radio" name="kind" value="종료" /> 종 료</label>
						<label><input type="radio" name="kind" value="거절" /> 거 절</label>
					</c:if>
					<c:if test="${radio == '대기'}">
						<label><input type="radio" name="kind" value="전체" /> 전 체</label>
						<label><input type="radio" name="kind" value="대기" checked />대 기</label>
						<label><input type="radio" name="kind" value="진행" /> 진 행</label>
						<label><input type="radio" name="kind" value="종료" /> 종 료</label>
						<label><input type="radio" name="kind" value="거절" /> 거 절</label>
					</c:if>
					<c:if test="${radio == '진행'}">
						<label><input type="radio" name="kind" value="전체" /> 전 체</label>
						<label><input type="radio" name="kind" value="대기" /> 대 기</label>
						<label><input type="radio" name="kind" value="진행" checked />진 행</label>
						<label><input type="radio" name="kind" value="종료" /> 종 료</label>
						<label><input type="radio" name="kind" value="거절" /> 거 절</label>
					</c:if>
					<c:if test="${radio == '종료'}">
						<label><input type="radio" name="kind" value="전체" /> 전 체</label>
						<label><input type="radio" name="kind" value="대기" /> 대 기</label>
						<label><input type="radio" name="kind" value="진행" /> 진 행</label>
						<label><input type="radio" name="kind" value="종료" checked />종 료</label>
						<label><input type="radio" name="kind" value="거절" /> 거 절</label>
					</c:if>
					<c:if test="${radio == '거절'}">
						<label><input type="radio" name="kind" value="전체" /> 전 체</label>
						<label><input type="radio" name="kind" value="대기" /> 대 기</label>
						<label><input type="radio" name="kind" value="진행" /> 진 행</label>
						<label><input type="radio" name="kind" value="종료" /> 종 료</label>
						<label><input type="radio" name="kind" value="거절" checked />거 절</label>
					</c:if>
				</div>
				<br> 
				<label for="mem_kind"><h4>후원기간</h4></label> 
				<c:choose>
					<c:when test="${date1 != null }">
						<input type="date" id="sc1" name="sc1" class="form-control" placeholder="  날짜을 선택하세요." value="${date1}"/>
					</c:when>
					<c:otherwise>
						<input type="date" id="sc1" name="sc1" class="form-control" placeholder="  날짜을 선택하세요." />
					</c:otherwise>
				</c:choose>
				
				<span>&nbsp; - &nbsp;</span> 
				
				<c:choose>
					<c:when test="${date2 != null }">
						<input type="date" id="sc2" name="sc2" class="form-control" placeholder="  날짜을 선택하세요." value="${date2}"/> 
					</c:when>
					<c:otherwise>
						<input type="date" id="sc2" name="sc2" class="form-control" placeholder="  날짜을 선택하세요." />
					</c:otherwise>
				</c:choose>
								
				<input type="submit" id="sbtn" value="검 색" style="margin-left: 10px;" />
			</form>
			
			<hr>
			
			<table class="table">
				<tr>
					<th class="text-center"><input type="checkbox" id="all_check"
						value="Y" /></th>
					<th class="text-center">번호</th>
					<th class="text-center">프로젝트 주제</th>
					<th class="text-center">진행기간 / 남은일 수</th>
					<th class="text-center">현재 모금액</th>
					<th class="text-center">목표 금액</th>
					<th class="text-center">진행률</th>
					<th class="text-center">구분</th>
					<th class="text-center">상태</th>
					<th class="text-center">승인</th>
				</tr>

				<!-- 조회된 글이 있는 경우 시작 -->
				<c:choose>
					<c:when test="${fn:length(supmemberList) > 0}">
						<c:forEach var="sup" items="${supmemberList}">
							<!-- 게시물  시작-->
							<tr id="all">
								<td class="text-center"><input type="checkbox" id="ckselect1" class="ckselect_check" value="${sup.supno}"/></td>
								<td class="text-center">${sup.supno}</td>
								<c:url var="readUrl" value="/sup/sup_read.do">
									<c:param name="supno" value="${sup.supno}" />
								</c:url>									
								<td class="text-center"><a id="thumb_a" href="${readUrl}" style="text-decoration: none; color: black;">	${sup.suptitle}</a></td>									
								<td class="text-center">${sup.supstart} ~ ${sup.supend} / ${sup.supDays}-day</td>
								<td class="text-center">${sup.supnow}</td>
								<td class="text-center">${sup.supprice}</td>
								<td class="text-center">${sup.suping} %</td>
								<c:if test="${sup.mtype == 'm'}">
									<td class="text-center">개인</td>
								</c:if>								
								<c:if test="${sup.mtype == 's'}">
									<td class="text-center">보호소</td>
								</c:if>								
								<td class="text-center">${sup.supstat}</td>
								<c:choose>
									<c:when test="${sup.supstat == '대기'}">
										<c:url var="okReadUrl" value="/admin/sup/admin_ok_sup.do">
											<c:param name="supno" value="${sup.supno}" />										
										</c:url>
										<td colspan="2" class="text-center"><a class="btn btn-primary" id="gbtn" href="${okReadUrl}">승인</a> 
										
										<c:url var="rejecReadUrl" value="/admin/sup/mail_form.do">
											<c:param name="supno" value="${sup.supno}" />										
										</c:url>
										<a href="${rejecReadUrl}" class="btn btn-primary" id="rbtn">거절</a>
									</c:when>
									<c:otherwise>
										<td colspan="2" class="text-center"><span> - &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - </span>
									</c:otherwise>
								</c:choose>									
							</tr>
							<!-- 게시물  끝-->							
						</c:forEach>
					
					</c:when>
				</c:choose>				
			</table>
			
			<!-- 페이지번호 (상태표시) -->
			<%@ include file="/WEB-INF/inc/admin_sup_list_bottom.jsp"%>			
		</section>
		<!-- 내용 끝 -->
	</div>
	</div>
	<%@ include file="/WEB-INF/inc/admin/admin_footer.jsp"%>
</body>
</html>