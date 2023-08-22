<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!doctype html>
<html>
<head>
<%@ include file="/WEB-INF/inc/head.jsp"%>
</head>
<body>
	<div class="container">
		<%@ include file="/WEB-INF/inc/topbar.jsp"%>
		<br id="space">
		<section>
			<h2 style="display: inline-block">회원탈퇴</h2>
			<small id="small">진행 중인 후원이 없을 경우에만 탈퇴가 가능합니다.</small>
			<hr />
			<div class="row" style="padding-top: 60px;">
				<div class="col-md-6 col-md-offset-3">
					<h4>
						<b>탈퇴를 위해서는 비밀번호를 입력해 주세요.</b>
					</h4>

					<!-- 비밀번호 입력 폼 시작 -->
					<form name="delform" method="post"
						action="${pageContext.request.contextPath}/login/out_ok.do">
						<div class="form-group">
							<input type="password" name="user_pw" class="form-control" />
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-primary btn-block">
								회원탈퇴</button>
						</div>
					</form>
					<!--// 비밀번호 입력 폼 끝 -->

				</div>
			</div>
		</section>
		<%@ include file="/WEB-INF/inc/footer.jsp"%>
	</div>
</body>
</html>