<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!doctype html>
<html>
<head>
<%@ include file="/WEB-INF/inc/head.jsp"%>
<!-- id_pw_sear -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assets/css/login/id_pw_sear.css">
</head>
<body>
	<div class="container">
		<%@ include file="/WEB-INF/inc/topbar.jsp"%>
		<section>
			<div class="col-md-2"></div>
			<div class="col-md-10">	
				<form class="form-horizontal" id="sear-form" action="${pageContext.request.contextPath}/login/idsear.do">
					<h3>아이디 찾기</h3>
					<small>이름(보호소명)과 생년월일이 일치해야 아이디를 찾을 수 있습니다.</small>
					<small class="pull-right"><span class="glyphicon glyphicon-home"> &gt; ID 찾기</span></small>
					<hr />
					<!-- 이름 -->
					<div class="form-group">
						<label for="sear-name" class="col-md-2">이름(보호소 명)</label>
						<div class="col-md-6">
							<input type="text" name="sear-name" id="sear-name"
								class="form-control" placeholder="이름(보호소 명)을 입력해 주세요" />
						</div>
					</div>
					<!-- 생년월일 -->
					<div class="form-group">
						<label for="sear-birth" class="col-md-2">생년월일</label>
						<div class="col-md-6">
							<input type="date" name="sear-birth" id="sear-birth"
								class="form-control" placeholder="yyyy-mm-dd" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-offset-6 col-md-7">
							<button type="submit" class="btn btn-success" id="sear-btn">
								<span class="glyphicon glyphicon-search">&nbsp;아이디찾기</span><i
									class="spaceLeft"></i>
							</button>
						</div>
					</div>
				</form>
				<form class="form-horizontal" id="sear-from" action="${pageContext.request.contextPath}/login/pwsear.do">
					<h3>비밀번호 찾기</h3>
					<small>아이디와 질문에 대한 답변이 일치해야 비밀번호를 찾을 수 있습니다.</small>
					<small class="pull-right"><span class="glyphicon glyphicon-home"> &gt; PW 찾기</span></small>
					<hr />
					<!-- 아이디 -->
					<div class="form-group">
						<label for="sear-id" class="col-md-2">아이디</label>
						<div class="col-md-6">
							<input type="text" name="sear-id" id="sear-id"
								class="form-control" placeholder="이름(보호소 명)을 입력해 주세요" />
						</div>
					</div>
					<!-- 비밀번호 힌트 -->
					<div class="form-group">
						<label for="sear-que" class="col-md-2 control-label" id="sear-que">*질문</label>
						<div class="col-md-6">
							<select class="form-control" id="sear-que" name="sear-que">
								<option>---------선택해주세요-----------</option>
								<option value="1">보물 1호는?</option>
								<option value="2">제일 좋아하는 음식은?</option>
								<option value="3">제일 좋아하는 노래는?</option>
								<option value="4">취미는 무엇입니까?</option>
							</select>
						</div>
					</div>
					<!-- 힌트 답 -->
					<div class="form-group">
						<label for="sear-ans" class="col-md-2">*답변</label>
						<div class="col-md-6">
							<input type="text" name="sear-ans" id="sear-ans"
								class="form-control" placeholder="선택하신 질문에 대한 답을 입력해주세요" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-8">
							<button type="submit" class="btn btn-success" id="pw-sear-btn">
								<span class="glyphicon glyphicon-search">&nbsp;비밀번호찾기</span><i
									class="spaceLeft"></i>
							</button>
						</div>
					</div>
				</form>
			</div>
		</section>
		<%@ include file="/WEB-INF/inc/footer.jsp"%>
	</div>
</body>
</html>