<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!doctype html>
<html>
<head>
<%@ include file="/WEB-INF/inc/head.jsp"%>
<script type="text/javascript">
	$(function() {
		$("div").removeClass("note-resizebar");
		$('.summernote').summernote({
			height : 400, // 기본 높이값
			minHeight : null, // 최소 높이값(null은 제한 없음)
			maxHeight : null, // 최대 높이값(null은 제한 없음)
			focus : true, // 페이지가 열릴때 포커스를 지정함
			lang : 'ko-KR' // 한국어 지정(기본값은 en-US)
		});
	});
</script>
<script type="text/javascript">
	$(function() {
		/* 입력형식 검출 */
		$("#obtn").click(function() {

			if (!$("input[name='title']").val()) {
				alert("제목을 입력해주세요.");
				$("input[name='title']").focus();
				return false;
			}
			/* if($(".note-editable p").val() == null){
				alert("소개를 입력해주세요.");
				$(".note-editable p").focus();
				return false;
			} */

			/* 입력값 저장 */
			var title = $("input[name='title']").val();
			/* var text = $("input[name='text']").val(); */

			/* 입력값 조립 */
			var result = "<ul>";
			result += "<li>제목 : " + title + "</li>";
			/* result += "<li>소개 : " + text + "</li>"; */
			result += "</ul>";

			/* 입력값 출력 */
			/* $("body").html(result); */

			/* return false; */
			alert("글 수정이 완료되었습니다.");
			location.href = "ani_rev_det.do";
		});
	});
</script>

<style type="text/css">
.form-group {
	margin-bottom: -20px;
}

.table tr:last-child td {
	padding: 0;
}
</style>

<link rel="stylesheet" type="text/css" href="../assets/css/small.css" />
<!-- 개인 스타일 시트 -->
<link rel="stylesheet" type="text/css"
	href="../assets/css/ani/ani_total.css">
<link rel="stylesheet" type="text/css"
	href="../assets/css/ani/ani_rev_upd.css">
<link rel="stylesheet" type="text/css" href="../assets/css/btn.css" />

<!-- include summernote css/js-->
<link href="../plugins/summernote/summernote.css" rel="stylesheet">
<script src="../plugins/summernote/summernote.js"></script>
<!-- summer note korean language pack -->
<script src="../plugins/summernote/lang/summernote-ko-KR.js"></script>

<!-- 통합 JS -->
<script type="text/javascript" src="../assets/js/ani/total.js"></script>
</head>
<body>
	<div class="container">
		<%@ include file="/WEB-INF/inc/topbar.jsp"%>
		<br id="space">
		<!-- 내용 시작 -->
		<section>
			<h2 class="noti">입양후기수정</h2>
			<small id="small1">AS의 입양후기 게시판입니다.</small> <small id="small2"><span
				class="glyphicon glyphicon-home"></span> &gt; 입양 후기 &gt; 상세 정보 &gt;
				정보 수정</small>
			<hr>
			<!-- Table -->
			<table class="table">
				<tr>
					<td><label for="title">제&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목
							&nbsp;&nbsp;</label> <input style="display: inline-block; width: 85%;"
						type="text" value="나는짱" name="title" id="title"
						class="form-control" placeholder="제목을 입력해주세요."></td>
				</tr>
				<tr>
					<td><label for="file_add">파 일 첨 부 &nbsp;&nbsp;</label> <input
						style="display: inline-block; width: 85%;" type="file"
						name="file_add" id="file_add" class="form-control" /></td>
				</tr>
				<tr>
					<td>
						<form class="form-horizontal">
							<div class="form-group">
								<div class="col-sm-12">
									<textarea name="content" id="content" class="summernote"></textarea>
								</div>
							</div>
						</form>
					</td>
				</tr>
			</table>

			<div id="btn-sec">
				<button class="btn btn-primary " id="cbtn"
					onclick="location.href='ani_rev_det.html'">취 소</button>
				<button class="btn btn-primary " id="obtn">확 인</button>
			</div>
		</section>
		<!-- 리스트 종료 -->
		<%@ include file="/WEB-INF/inc/footer.jsp"%>
	</div>
</body>
</html>