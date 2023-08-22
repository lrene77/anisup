<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/inc/head.jsp"%>

<!-- summernote -->
<link rel="stylesheet" type="text/css" href="plugins/summernote/summernote.css">
<script src="plugins/summernote/summernote.js"></script>

<!-- summer note korean language pack -->
<script src="plugins/summernote/lang/summernote-ko-KR.js"></script>

<!-- sup_write.js -->
<script src="../assets/js/sup/sup_write.js"></script>

<!-- sup_write.css -->
<link rel="stylesheet" type="text/css" href="../assets/css/sup/sup_write.css">

<!-- pickadate plugin 달력 -->
<link rel="stylesheet" href="../plugins/pickadate/themes/default.css" />
<link rel="stylesheet" href="../plugins/pickadate/themes/default.date.css" />
<script src="../plugins/pickadate/picker.js"></script>
<script src="../plugins/pickadate/picker.date.js"></script>
<!-- <link rel="stylesheet" type="text/css" href="../assets/css/grid.css"> -->

<link rel="stylesheet" type="text/css" href="../assets/css/small.css" />

<link rel="stylesheet" type="text/css" href="../assets/css/btn.css">

<script type="text/javascript">
$(function() {
	/** 1) 기본 사용법 */
	$("#start_date").pickadate({
		format: 'yyyy-mm-dd',
		editable: false,
		min: new Date(),
		firstday:0,
	});
	
	$("#end_date").pickadate({
		format: 'yyyy-mm-dd',
		editable: false,
		min: new Date(),
		firstday:0,
	});
	
	
	$('.calender').on('change', function() {
		if ($(this).attr('id') === 'start_date') {
			$('#end_date').pickadate('picker').set('min', $(this).val());
		}
	});
});

</script>

</head>
<body>
	<div class="container">
		<%@ include file="/WEB-INF/inc/topbar.jsp"%>
		<!-- 내용 시작 -->
		<br id="space">
		<section>
			<h2>프로젝트 글 작성</h2>
			<small>프로젝트 후원 글 작성 페이지 입니다.</small> <small id="small2"><span
				class="glyphicon glyphicon-home"></span> &gt; 후원 &gt; 후원 프로젝트 작성</small>
			<hr />
			
			<form role="form" method="post" name="SupWriteDo" enctype="multipart/form-data" 
				action="${pageContext.request.contextPath}/sup/sup_write_ok.do">
				<!-- 아코디언 영역 시작 -->
				<div class="panel-group" id="accordion">
					<!-- 항목(1) -->
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a class="accordion-toggle" data-toggle="collapse"
									data-parent="#accordion" href="#collapseOne">Step1. 후원 내용
									입력</a>
							</h4>
						</div>
						<div id="collapseOne" class="panel-collapse collapse in">
							<div class="panel-body">
								<!-- Table 시작 -->
								<table class="table">
									<tr>
										<td><label for="title">후원 주제</label> <input type="text"
											name="title" id="title" class="form-control"
											placeholder="주제를 입력해주세요."></td>
									</tr>
									<tr>
										<td><label for="start_date">후원 시작</label> <input
											type="text" id="start_date" name="start_date"
											class="form-control calender" placeholder="후원 시작일을 선택해주세요." /></td>
									</tr>
									<tr>
										<td><label for="end_date">후원 종료</label> <input
											type="text" id="end_date" name="end_date"
											class="form-control calender" placeholder="후원 종료일을 선택해주세요." /></td>
									</tr>
									<tr>
										<td><label for="money">목표 금액</label> <input type="text"
											name="money" id="money" name="money" class="form-control"
											placeholder="목표 금액을 입력해주세요."></td>
									</tr>
									<tr>
										<td><label for="file">파 일 첨 부</label> <input type="file"
											name="file" id="file" class="form-control" multiple /></td>
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
								<!-- Table 끝 -->
							</div>
						</div>
					</div>

					<!-- 항목(2) -->
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a class="accordion-toggle" data-toggle="collapse"
									data-parent="#accordion" href="#collapseTwo">Step2. 계좌 정보
									입력</a>
							</h4>
						</div>

						<div id="collapseTwo" class="panel-collapse collapse">
							<div class="panel-body">
								<!-- Table 시작 -->
								<table class="table">
									<tr>
										<td><label for="she_email" class="control-label">은&nbsp;행&nbsp;명&nbsp;</label>
											<select id="bank" name="bank" class="form-control">
												<option>선택해주세요</option>
												<option>국민은행</option>
												<option>신한은행</option>
												<option>농협은행</option>
												<option>외한은행</option>
												<option>IBK은행</option>
										</select></td>
									</tr>
									<tr>
										<td><label for="account">계좌번호</label> <input type="text"
											name="account" id="account" class="form-control"
											placeholder="계좌번호를 입력해주세요."></td>
									</tr>
									<tr>
										<td><label for="give_name">예&nbsp;금&nbsp;주&nbsp;</label>
											<input type="text" name="give_name" id="give_name"
											class="form-control" placeholder="예금주를 입력해주세요."></td>
									</tr>
								</table>
								<!-- Table 끝 -->
							</div>
						</div>
					</div>
				</div>
				<!--// 아코디언 영역 끝 -->
				<div class="form-group" id="btn-sec">
					<button class="btn btn-primary" id="cbtn" onclick="history.back()">취소</button>
					<button class="btn btn-primary" id="obtn" type="submit">확인</button>
				</div>
			</form>

		</section>
		<!-- 내용 끝 -->

		<%@ include file="/WEB-INF/inc/footer.jsp"%>
	</div>
</body>
</html>