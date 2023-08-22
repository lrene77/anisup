<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!doctype html>
<html>
<head>
<%@ include file="/WEB-INF/inc/admin/admin_head.jsp"%>
</head>
<body>
	<div class="container">
		<%@ include file="/WEB-INF/inc/admin/admin_topbar.jsp"%>
		<!-- 내용 시작 -->
		<section>
			<!-- 로그인 폼 시작-->
			<div class="row" id="admin-login">
				<div class="col-md-3 col-sm-1"></div>
				<div class="col-md-6 col-sm-7">
					<form role="form" method="post" action="${pageContext.request.contextPath}/admin/admin_login_ok.do">
						<img src="img/sm_logo.png" alt="작은로고" align="center" />
						<div class="form-group">
							<label for="admin-id">아이디</label> <input name="admin-id" value=''
								id="admin-id" placeholder="ID를 입력해주세요" type="text"
								class="form-control" />
						</div>
						<div class="form-group">
							<label for="admin-pw">비밀번호</label> <input name="admin-pw"
								id="admin-pw" value='' placeholder="비밀번호를 입력해주세요" type="password"
								class="form-control" />
						</div>
						<div class="form-group">
							<input type="submit"
								class="btn btn-default btn-login-submit btn-block m-t-md"
								value="로그인" />
						</div>
					</form>
				</div>
				<div class="col-md-3 col-sm-3"></div>
			</div>
			<!-- 로그인 폼 끝 -->
		</section>
		<!-- 내용 끝 -->
	</div>
	<%@ include file="/WEB-INF/inc/admin/admin_footer.jsp"%>
</body>
</html>