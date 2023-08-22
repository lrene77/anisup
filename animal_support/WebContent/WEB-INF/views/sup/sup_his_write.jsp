<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/inc/head.jsp"%>

<!-- 후원 내역 스타일 시트 -->
<link rel="stylesheet" type="text/css"
	href="../assets/css/sup_his_write.css">

<!-- sup_his_write.js -->
<script src="../assets/js/sup/sup_his_write.js"></script>
<!-- sup_his_write.css -->
<link rel="stylesheet" type="text/css"
	href="../assets/css/sup/sup_his_write.css">

<!-- summernote -->
<link rel="stylesheet" type="text/css"
	href="plugins/summernote/summernote.css">
<script src="plugins/summernote/summernote.js"></script>

<!-- summer note korean language pack -->
<script src="plugins/summernote/lang/summernote-ko-KR.js"></script>

<link rel="stylesheet" type="text/css" href="../assets/css/small.css" />

<link rel="stylesheet" type="text/css" href="../assets/css/btn.css">
</head>
<body>
	<div class="container">
		<%@ include file="/WEB-INF/inc/topbar.jsp"%>
		<!-- 내용 시작 -->
		<br id="space">
		<section>
			<h2>후원내역</h2>
			<small>모금 완료된 프로젝트 금액 사용처 표시 페이지 입니다.</small> <small id="small2"><span
				class="glyphicon glyphicon-home"></span> &gt; 후원 &gt; 프로젝트 후원 &gt;
				후원내역 </small>
			<hr />

			<c:url var="readUrl" value="/sup/sup_his_write_ok.do">
				<c:param name="supNo" value="${supNo}" />
			</c:url>
			<form role="form" action="${readUrl}" method="post">
				<!-- Table 시작-->
				<table class="table">
					<tr>
						<td><label for="title">후원 주제</label> <input type="text"
							name="title" id="title" class="form-control"
							placeholder="${supTitle}" disabled></td>
					</tr>
					<tr>
						<td><label for="title">모금 금액</label> <input type="text"
							name="money" id="money" class="form-control"
							placeholder="${supnow}" disabled></td>
					</tr>
					<tr>
						<td><label for="file_add">사용 내역</label></td>
					</tr>
					<tr>
						<td id="noti_com">
							<div class="form-group">
								<div>
									<textarea name="writing" id="writing" class="summernote" /></textarea>
								</div>
							</div>
						</td>
					</tr>
				</table>
				<!-- Table 끝-->
				
				<input type="hidden" name="supno" value="${supNo}" />

				<div id="btn-sec">
					<button class="btn btn-primary" id="cbtn"
						onclick="location.href='sup_ing.html'">취소</button>
					<input type="submit" class="btn btn-primary" id="obtn">
				</div>
			</form>
		</section>
		<!-- 내용 끝 -->
		<%@ include file="/WEB-INF/inc/footer.jsp"%>
	</div>
</body>
</html>