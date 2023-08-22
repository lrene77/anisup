<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/inc/head.jsp"%>
<!-- bootstrap -->
<link rel="stylesheet" type="text/css" href="../assets/css/small.css">
<link rel="stylesheet" type="text/css" href="../assets/css/btn.css" />
<link rel="stylesheet" type="text/css" href="../assets/css/mypage/mod.css" />

<!-- 우편번호 javascript -->
<script src="../assets/js/addressAPI.js"></script>
<script src="../assets/js/address.js"></script>
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>

<!-- sweet alert -->
<link rel="stylesheet" href="../plugins/sweetalert/sweetalert.css" />
<script src="../plugins/sweetalert/sweetalert.min.js"></script>
</head>
<body>
	<div class="container">
		<%@ include file="/WEB-INF/inc/topbar.jsp"%>
		<br id="space">
		<section>
			<h2 class="noti">개인정보수정</h2>
			<small id="small1">개인정보를 수정할 수 있습니다.</small> <small id="small2"><span
				class="glyphicon glyphicon-home"></span> &gt; myPage &gt; 개인정보수정</small>
			<hr />
			<div class="col-md-12">
				<form class="form-horizontal" id="myform" action="${pageContext.request.contextPath}/mypage/mem_upd_ok.do">
					<!-- 이름 -->
					<div class="form-group ">
						<label for="mem-name" class="col-sm-3 control-label">*이름</label>
						<div class="col-sm-6">
							<input type="text" class="form-control span" name="mem-name" id="mem-name" value="${ loginInfo.name }" readonly />
						</div>
					</div>
					<!-- 아이디 -->
					<div class="form-group">
						<label for="mem-id" class="col-sm-3 control-label">*아아디</label>
						<div class="col-sm-6">
							<input type="text" class="form-control span" name="mem-id" id="mem-id" value="${ loginInfo.id }" readonly />
						</div>
					</div>
					<!--비밀번호-->
					<div class="form-group ">
						<label for="mem-pw" class="col-sm-3 control-label">*현재 비밀번호</label>
						<div class="col-sm-6">
							<input type="password" name="mem-pw" id="mem-pw"
								class="form-control" placeholder="비밀번호는 6자리 이상 입력해 주세요" />
						</div>
					</div>
					<!--비밀번호-->
					<div class="form-group ">
						<label for="new-user-pw" class="col-sm-3 control-label">*변경하실 비밀번호
						</label>
						<div class="col-sm-6">
							<input type="password" name="new-user-pw" id="new-user-pw"
								class="form-control" placeholder="비밀번호는 6자리 이상 입력해 주세요" />
						</div>
					</div>
					<div class="form-group ">
						<label for="new-user-pw-re" class="col-sm-3 control-label">*변경하실 비밀번호
							확인</label>
						<div class="col-sm-6">
							<input type="password" name="new-user-pw-re" id="new-user-pw-re"
								class="form-control" placeholder="비밀번호는 6자리 이상 입력해 주세요" />
						</div>
					</div>					
					<!--이메일-->
					<div class="form-group ">
						<label for="mem-eamil" class="col-sm-3 control-label">*이메일</label>
						<div class="col-sm-6">
							<input type="text" name="mem-eamil" id="mem-eamil"
								class="form-control" value="${ loginInfo.email }"/>
						</div>
					</div>
					<!-- 생년월일 -->
					<div class="form-group">
						<label for="mem-birthdate" class="col-sm-3 control-label">*생년월일</label>
						<div class="col-sm-6">
							<input type="date" name="mem-birthdate" id="mem-birthdate"
								class="form-control" value="${ loginInfo.birth }" />
						</div>
					</div>
					<!-- 휴대전화 -->
					<div class="form-group">
						<label for="mem-phone" class="col-sm-3 control-label">*휴대전화</label>
						<div class="col-sm-6">
							<input type="tel" name="mem-phone" id="mem-phone"
								class="form-control" value="${ loginInfo.phone }"/>
						</div>
					</div>
					<!-- 전화번호 -->
					<div class="form-group">
						<label for="mem-tel" class="col-sm-3 control-label">*전화번호</label>
						<div class="col-sm-6">
							<input type="tel" name="mem-tel" id="mem-tel"
								class="form-control" value="${ loginInfo.tel }"/>
						</div>
					</div>
					<!-- 주소검색 -->
					<div class="form-group">
						<label class="col-sm-3 control-label" for="postcode">*주소</label>
						<div class="col-sm-6">
							<div class="input-group">
								<input type="text" name="postcode" id="postcode"
									class="form-control" value="${ loginInfo.postcode }" /> <span
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
								class="form-control" value="${ loginInfo.addr1 }" />
						</div>
						<div class="col-sm-3">
							<input type="text" name="address1" id="address1"
								class="form-control" value="${ loginInfo.addr2 }" />
						</div>
					</div>
					<!-- 비밀번호 힌트 -->
					<div class="form-group">
						<label for="select1" class="col-sm-3 control-label" id="join-que">*질문</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="mem-re" name="mem-re" readOnly value="${loginInfo.pwq}"/>
						</div>
					</div>
					<!-- 힌트 답 -->
					<div class="form-group">
						<label for="mem-answer" class="col-sm-3 control-label">*답변</label>
						<div class="col-sm-6">
							<input type="text" name="mem-answer" id="mem-answer"
								class="form-control" value="${ loginInfo.pwa }" />
						</div>
					</div>
					<!-- 완료버튼 -->
					<div id="btn-sec">
						<button class="btn btn-primary" type="submit" id="ubtn">
							<span class="glyphicon glyphicon-ok">&nbsp;수정</span>
						</button>
						<button class="btn btn-primary" type="submit" id="cbtn" style="margin-top:20px">
							<span class="glyphicon glyphicon-ok" >&nbsp;취소</span>
						</button>
					</div>
				</form>
				<!-- 가입폼 끝 -->
			</div>
		</section>

		<%@ include file="/WEB-INF/inc/footer.jsp"%>
	</div>
</body>
</html>