<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!doctype html>
<html>
<head>
<%@ include file="/WEB-INF/inc/head.jsp"%>
<!-- 공통 스타일 시트 -->
<link rel="stylesheet" type="text/css" href="../assets/css/small.css" />
<link rel="stylesheet" type="text/css" href="../assets/css/grid.css" />
<!-- 개인 스타일 시트 -->
<link rel="stylesheet" type="text/css"
	href="../assets/css/ani/ani_total.css">
<link rel="stylesheet" type="text/css"
	href="../assets/css/ani/ani_write.css">
<link rel="stylesheet" type="text/css" href="../assets/css/btn.css" />
<!-- 통합 JS -->
<script type="text/javascript" src="../assets/js/ani/total.js"></script>
<!-- summernote -->
<link rel="stylesheet" type="text/css"
	href="../plugins/summernote/summernote.css">
<script src="../plugins/summernote/summernote.js"></script>
<!-- summer note korean language pack -->
<script src="../plugins/summernote/lang/summernote-ko-KR.js"></script>
<script type="text/javascript">
	$(function() {
		$("div").removeClass("note-resizebar");
		$('.summernote').summernote({
			height : 500, // 기본 높이값
			minHeight : null, // 최소 높이값(null은 제한 없음)
			maxHeight : null, // 최대 높이값(null은 제한 없음)
			focus : true, // 페이지가 열릴때 포커스를 지정함
			lang : 'ko-KR' // 한국어 지정(기본값은 en-US)
		});
	});
</script>
</head>
<body>
	<div class="container">
		<%@ include file="/WEB-INF/inc/topbar.jsp"%>
		<br id="space">
		<!-- 내용 시작 -->
		<section>
			<form class="form-horizontal" method="post"
				enctype="multipart/form-data"
				action="${pageContext.request.contextPath}/ani/ani_write_ok.do">
				<h2 class="noti">입양글작성</h2>
				<small id="small1">AS의 입양 게시판입니다.</small> <small id="small2"><span
					class="glyphicon glyphicon-home"></span> &gt; 입양 &gt; 글 작성</small>
				<hr>
				<!-- Table -->
				<table class="table">
					<tr>
						<td colspan="3"><label for="title">제&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목
								&nbsp;&nbsp;</label> <input type="text"
							style="display: inline-block; width: 85%;" name="title"
							id="title" class="form-control" placeholder="제목을 입력해주세요."></td>
					</tr>
					<tr>
						<td colspan="3"><label for="file_add">파 일 첨 부
								&nbsp;&nbsp;</label> <input type="file"
							style="display: inline-block; width: 85%;" name="file_add"
							id="file_add" class="form-control" /></td>
					</tr>
					<tr>
						<td><label for="ani_name">동물 이름 </label> <input type="text"
							name="ani_name" id="ani_name" class="form-control"
							style="width: 60%; display: inline-block;"></td>
						<td><label for="ani_gender">동물 성별 </label> <input type="text"
							name="ani_gender" id="ani_gender" class="form-control"
							style="width: 60%; display: inline-block;" placeholder="X or Y"
							maxlength="1"></td>
						<td><label for="ani_age">동물 나이 </label> <input type="text"
							name="ani_age" id="ani_age" class="form-control"
							style="width: 60%; display: inline-block;"></td>
					</tr>
					<tr>
						<td id="noti_com" colspan="3">
							<div class="form-group"
								style="margin-bottom: -20px; margin-right: 0px; margin-left: 0px">
								<div>
									<textarea name="text" id="text" class="summernote" /></textarea>
								</div>
							</div>
						</td>
					</tr>

				</table>

				<div id="btn-sec">
					<button type="button" class="btn btn-primary " id="cbtn"
						onclick="history.back();">취 소</button>
					<button type="submit" class="btn btn-primary " id="obtn">확
						인</button>
				</div>
			</form>
		</section>
		<!-- 내용 끝 -->
		<%@ include file="/WEB-INF/inc/footer.jsp"%>
	</div>
</body>
</html>