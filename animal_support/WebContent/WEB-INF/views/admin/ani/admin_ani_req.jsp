<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/inc/admin/admin_head.jsp"%>
<!-- 공통 스타일 시트 -->
<link rel="stylesheet" type="text/css"
	href="../../assets/css/admin_common.css" />
<link rel="stylesheet" type="text/css"
	href="../../assets/css/admin/ad_sup_ret.css" />
<link rel="stylesheet" type="text/css"
	href="../../assets/css/admin/ad_btn.css" />
<!-- summernote -->
<link rel="stylesheet" type="text/css"
	href="../../plugins/summernote/summernote.css">
<script src="../../plugins/summernote/summernote.js"></script>
<!-- summer note korean language pack -->
<script src="../../plugins/summernote/lang/summernote-ko-KR.js"></script>
<!-- sup_write.js -->
<script src="../../assets/js/sup/sup_write.js"></script>

</head>
<body>
	<div class="container">
		<%@ include file="/WEB-INF/inc/admin/admin_topbar.jsp"%>
		<!-- 상단 끝 -->
		<br> <br>
		<!-- 내용 시작 -->
		<section>
			<h2>입양관리</h2>
			<small style="font-weight: bold">상세보기 &gt; 신청서</small>
			<hr>

			<!-- Table -->
			<table class="table">
				<c:forEach var="req" items="${reqRead}">
					<tr>
						<td><label for="title">제 &nbsp;&nbsp;목</label> <input
							type="text" name="title" id="title" class="form-control"
							disabled="" style="background-color: #eee"
							value="${req.reqtitle}"></td>
					</tr>
					<tr>
						<td><label for="name">이 &nbsp;&nbsp;름</label> <input
							type="text" name="name" id="name" class="form-control"
							disabled="" style="background-color: #eee" value="${req.name}"></td>
					</tr>
					<tr>
						<td><label for="phone">번 &nbsp;&nbsp;호</label> <input
							type="text" name="phone" id="phone" class="form-control"
							disabled="" style="background-color: #eee" value="${req.phone}"></td>
					</tr>
					<tr>
						<td><label for="mail">이메일</label> <input type="text"
							name="mail" id="mail" class="form-control" disabled=""
							style="background-color: #eee" value="${req.email}"></td>
					</tr>
					<tr>
						<td><label for="job">직 &nbsp;&nbsp;업</label> <input
							type="text" name="job" id="job" class="form-control" disabled=""
							style="background-color: #eee" value="${req.reqjob}"></td>
					</tr>
					<tr>
						<td id="noti_com">
							<div class="form-group">
								<div>
									<textarea name="text" id="text" disabled="disabled"
										style="background-color: #eee; resize: none; width: 1000px; height: 400px;"/>${req.reqcont}</textarea>
								</div>
							</div>
						</td>
					</tr>
				</c:forEach>
			</table>
		</section>
		<!-- 내용 끝 -->
	</div>
	<!-- 하단 시작 -->
	<%@ include file="/WEB-INF/inc/admin/admin_footer.jsp"%>
	<!-- 하단 끝 -->
</body>
</html>