<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!doctype html>
<html>
<head>
<%@ include file="/WEB-INF/inc/admin/admin_head.jsp"%>

<!-- javaScript -->
<script
	src="${pageContext.request.contextPath}/assets/js/admin/ad_mem_list.js"></script>
<script
	src="${pageContext.request.contextPath}/assets/js/admin/admin_checked.js"></script>

<!-- css -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assets/css/admin/ad_mem_list.css" />
</head>
<body>
	<div class="container">
		<%@ include file="/WEB-INF/inc/admin/admin_topbar.jsp"%>
		<br> <br>
		<!-- 내용 시작 -->
		<section>
			<h2>회원관리</h2>
			<small>일반회원 정보 수정</small>
			<hr>
			<div class="col-md-12">
				<form class="form-horizontal" method="post"
					action="${pageContext.request.contextPath}/admin/member/admin_mem_upd_ok.do">
					<!-- 이름 -->
					<div class="form-group ">
						<label for="name" class="col-sm-3 control-label">*이름</label>
						<div class="col-sm-6">
							<p class="form-control-static">${loginInfo.name}</p>
						</div>
					</div>
					<!-- 아이디 -->
					<div class="form-group">
						<label for="id" class="col-sm-3 control-label">*아이디</label>
						<div class="col-sm-6">
							<p class="form-control-static">${loginInfo.id}</p>
						</div>
					</div>
					<!--비밀번호-->
					<div class="form-group ">
						<label for="new-pw" class="col-sm-3 control-label">*비밀번호</label>
						<div class="col-sm-6">
							<input type="password" name="new-pw" id="new-pw"
								class="form-control" placeholder="비밀번호 수정을 원할 경우만 입력해주세요" />
						</div>
					</div>
					<!--비밀번호-->
					<div class="form-group ">
						<label for="new-pw-re" class="col-sm-3 control-label">*비밀번호
							확인</label>
						<div class="col-sm-6">
							<input type="password" name="new-pw-re" id="new-pw-re"
								class="form-control" />
						</div>
					</div>
					<!--이메일-->
					<div class="form-group ">
						<label for="eamil" class="col-sm-3 control-label">*이메일</label>
						<div class="col-sm-6">
							<input type="text" name="eamil" id="eamil" class="form-control"
								value="${loginInfo.email}" />
						</div>
					</div>
					<!-- 생년월일 -->
					<div class="form-group">
						<label for="birth" class="col-sm-3 control-label">*생년월일</label>
						<div class="col-sm-6">
							<input type="date" name="birth" id="birth" class="form-control"
								value="${loginInfo.birth }" />
						</div>
					</div>
					<!-- 휴대전화 -->
					<div class="form-group">
						<label for="phone" class="col-sm-3 control-label">*휴대전화</label>
						<div class="col-sm-6">
							<input type="tel" name="phone" id="phone" class="form-control"
								value="${loginInfo.phone }" />

						</div>
					</div>
					<!-- 전화번호 -->
					<div class="form-group">
						<label for="tel" class="col-sm-3 control-label">*전화번호</label>
						<div class="col-sm-6">
							<input type="tel" name="tel" id="tel" class="form-control"
								value="${loginInfo.tel }" />
						</div>
					</div>
					<!-- 주소검색 -->
					<div class="form-group">
						<label class="col-sm-3 control-label" for="postcode">*주소</label>
						<div class="col-sm-6">
							<div class="input-group">
								<input type="text" name="postcode" id="postcode"
									class="form-control" value="${loginInfo.postcode }" /> <span
									class="input-group-btn">
									<button type="button" class="btn btn-success" id="juso">
										<span class="glyphicon glyphicon-search">&nbsp;우편번호검색</span><i
											class="spaceLeft"></i>
									</button>
								</span>
							</div>
						</div>
					</div>
					<!-- 상세주소 -->
					<div class="form-group">
						<label for="address" class="col-sm-3 control-label">*상세주소</label>
						<div class="col-sm-3">
							<input type="text" name="address" id="address"
								class="form-control" value="${loginInfo.addr1 }" />
						</div>
						<div class="col-sm-3">
							<input type="text" name="address1" id="address1"
								class="form-control" value="${loginInfo.addr2 }" />
						</div>
					</div>
					<!-- 비밀번호 힌트 -->
					<div class="form-group">
						<label for="select" class="col-sm-3 control-label" id="join-que">*질문</label>
						<div class="col-sm-6">
							<select class="form-control" name="select" id="select">
								<option>---------선택해주세요-----------</option>
								<option value="${ loginInfo.pwq }" selected="selected">${ loginInfo.pwq }</option>
								<option value="보물 1호는?">보물 1호는?</option>
								<option value="제일 좋아하는 음식은?">제일 좋아하는 음식은?</option>
								<option value="제일 좋아하는 노래는?">제일 좋아하는 노래는?</option>
								<option value="취미는 무엇입니까?">취미는 무엇입니까?</option>
							</select>
						</div>
					</div>
					<!-- 힌트 답 -->
					<div class="form-group">
						<label for="answer" class="col-sm-3 control-label">*답변</label>
						<div class="col-sm-6">
							<input type="text" name="answer" id="answer" class="form-control"
								value="${loginInfo.pwa }" />
						</div>
					</div>
				</form>
			</div>
			<!-- 완료버튼 -->
			<div class="container">
				<div id="btn-sec">
					<button class="btn btn-primary" type="submit" id="ubtn">
						<span class="glyphicon glyphicon-ok">&nbsp;수정</span>
					</button>
					<button class="btn btn-danger" type="button" id="join-remove"
						onclick="history.back();">
						<span class="glyphicon glyphicon-remove"></span>&nbsp;수정취소<i
							class="spaceLeft"></i>
					</button>
				</div>
			</div>
		</section>
		<!-- 내용 끝 -->
	</div>
	<%@ include file="/WEB-INF/inc/admin/admin_footer.jsp"%>
</body>
</html>