<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/inc/head.jsp"%>
<!-- 모바일 웹 페이지 설정 -->
<!-- bootstrap -->
<link rel="stylesheet" type="text/css" href="../assets/css/small.css">
<link rel="stylesheet" type="text/css" href="../assets/css/btn.css">
<link rel="stylesheet" type="text/css" href="../assets/css/mypage/mod.css">

<!--  페이지 이동 -->
<script src="../assets/js/mypage/msg.js"></script>

</head>
<body>
	<div class="container">
		<%@ include file="/WEB-INF/inc/topbar.jsp"%>
		<!-- 상단 끝 -->
		<!--중단 영역-->
		<br id="space">
		<section>
			<h2 class="noti">입양신청서상세보기</h2>
			<small id="small1">신청서를 확인할 수 있습니다.</small> <small id="small2"><span
				class="glyphicon glyphicon-home"></span> &gt; myPage &gt; 신청서상세보기</small>
			<hr />
			<form class="form-horizontal" role="form" id="join">
				<!-- 제목  -->
				<div class="form-group">
					<label for="my_title" class="col-md-3 control-label">제목</label>
					<div class="col-md-6">
						<input type="text" class="form-control" name="my_title"
							placeholder="강아지 잘키움" disabled>
					</div>
				</div>
				<!-- 이름  -->
				<div class="form-group">
					<label for="my_name" class="col-md-3 control-label">이름</label>
					<div class="col-md-6">
						<input type="text" class="form-control" name="my_name"
							placeholder="개장수" disabled>
					</div>
				</div>
				<!--폰 앞자리 셀렉트-->
				<div class="form-group">
					<label for="phon" class="col-md-3 control-label">휴대전화</label>
					<div class="col-md-6">
						<input type="text" class="form-control" name="my_phone">
					</div>
				</div>
				<!-- 주소 박스 -->
				<div class="form-group">
					<label for="my_juso" class="col-md-3 control-label">상세주소</label>
					<div class="col-md-6">
						<input type="text" class="form-control" name="my_juso">
					</div>
					<!-- col-md 박스  -->
				</div>
				<!-- 그룹 박스-->
				<div class="form-group">
					<label for="my_job" class="col-md-3 control-label">직업</label>
					<div class="col-md-6">
						<input type="text" class="form-control" name="my_job">
					</div>
					<!-- col-md 박스 -->
				</div>
				<!--그룹 박스 -->
				<!-- 그룹 박스-->
				<div class="form-group">
					<label for="my_info" class="col-md-3 control-label">소개</label>
					<div class="col-md-6">
						<textarea class="form-control" name="my_info" id="my_info"
							style="resize: none" id="my_info"></textarea>
					</div>
				</div>
				<!--col-md 박스-->
			</form>
			<div id="btn-sec">
				<button class="btn btn-info" id="lbtn">
					<span class="glyphicon glyphicon-list"> 목록</span>
				</button>
			</div>
		</section>
		<%@ include file="/WEB-INF/inc/footer.jsp"%>
	</div>
</body>
</html>