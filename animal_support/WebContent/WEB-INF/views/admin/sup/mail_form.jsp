<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!doctype html>
<html>
<head>
	<%@ include file="/WEB-INF/inc/admin/admin_head.jsp"%>
	
	<!-- summernote -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/plugins/summernote/summernote.css">
	<script src="${pageContext.request.contextPath}/plugins/summernote/summernote.js"></script>
	
	<!-- summer note korean language pack -->
	<script src="${pageContext.request.contextPath}/plugins/summernote/lang/summernote-ko-KR.js"></script>
	
	<link rel="stylesheet" type="text/css" href="../assets/css/btn.css">
	
	<script type="text/javascript">
		$(function() {
		   $(".summernote").summernote({
		      height: 300,          // 기본 높이값
		      minHeight: null,      // 최소 높이값(null은 제한 없음)
		      maxHeight: null,      // 최대 높이값(null은 제한 없음)
		      focus: true,          // 페이지가 열릴때 포커스를 지정함
		      lang: 'ko-KR'         // 한국어 지정(기본값은 en-US)
		    });
		});
	</script>
</head>
<body>
	<div class="container">
		<%@ include file="/WEB-INF/inc/admin/admin_topbar.jsp"%>
		<br>
		<br>
		<!-- 제목 -->
		<h2 class="noti">후원글 거절사유 작성</h2>		
		<hr>
		<!-- 제목 -->
		<br/>
		<!--  메일 폼 영역 시작  -->
		<form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/admin/sup/send_mail.do">
			
			<div class="form-group">
				<label class="col-md-3 control-label" for="sender"><h4>보내는주소</h4></label>
				<div class="col-md-6">
					<input type="text" name="sender" id="sender" class="form-control" placeholder="보내는 분의 이메일 주소를 입력하세요"/>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-md-3 control-label" for="receiver"><h4>받는주소</h4></label>
				<div class="col-md-6">
					<input type="text" name="receiver" id="receiver" class="form-control" placeholder="받는 분의 이메일 주소를 입력하세요."/>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-md-3 control-label" for="subject"><h4>메일 제목</h4></label>
				<div class="col-md-6">
					<input type="text" name="subject" id="subject" class="form-control" placeholder="이메일의 제목을 입력하세요."/>
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-3 control-label" for="content"><h4>내용입력</h4></label>
				<div class="col-md-6">
					<textarea name="content" id="content" class="summernote"></textarea>
				</div>				
			</div>
			

			<div class="col-sm-10 col-sm-offset-2 text-right">
				<input type="reset" id="cbtn" class="btn btn-info" value="다시작성"/>
				<input type="submit" id="cbtn" class="btn btn-primary" style="margin-right: 210px;" value="메일보내기"/>
			</div>
		</form>	
		<br/>
		<br/>	
		<br/>
		<br/>
		<br/>
		<br/>	
		<br/>
		<br/>		
	</div>
	<%@ include file="/WEB-INF/inc/admin/admin_footer.jsp"%>
</body>
</html>