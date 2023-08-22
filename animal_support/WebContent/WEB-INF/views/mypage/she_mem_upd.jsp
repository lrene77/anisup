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

<script src="../plugins/validate/jquery.validate.min.js"></script>
<script src="../plugins/validate/additional-methods.min.js"></script>

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
		<!-- 상단 끝 -->
		<br id="space">
		<section>
			<h2 class="noti">보호소정보수정</h2>
			<small>회원 정보를 수정할 수 있습니다.</small> <small id="small2"><span
				class="glyphicon glyphicon-home"></span> &gt; myPage &gt; 회원정보수정</small>
			<hr />
			<form class="form-horizontal" id="myform" action="${pageContext.request.contextPath}/mypage/she_mem_upd_ok.do">
				<!-- 이름 -->
				<div class="form-group ">
					<label for="she-name" class="col-sm-3 control-label">*보호소명</label>
					<div class="col-sm-6">
						<p class="form-control-static">${ loginInfo.name }</p>
					</div>
				</div>
				<!-- 아이디 -->
				<div class="form-group">
					<label for="she-pw" class="col-sm-3 control-label">*아이디</label>
					<div class="col-sm-6">
						<p class="form-control-static">${ loginInfo.id }</p>
					</div>
				</div>
					<!--비밀번호-->
					<div class="form-group ">
						<label for="she-pw" class="col-sm-3 control-label">*현재 비밀번호</label>
						<div class="col-sm-6">
							<input type="password" name="she-pw" id="she-pw"
								class="form-control" placeholder="비밀번호는 6자리 이상 입력해 주세요" />
						</div>
					</div>
					<!--비밀번호-->
					<div class="form-group ">
						<label for="she-user-pw" class="col-sm-3 control-label">*변경하실 비밀번호
						</label>
						<div class="col-sm-6">
							<input type="password" name="she-user-pw" id="she-user-pw"
								class="form-control" placeholder="비밀번호는 6자리 이상 입력해 주세요" />
						</div>
					</div>
					<div class="form-group ">
						<label for="she-user-pw-re" class="col-sm-3 control-label">*변경하실 비밀번호
							확인</label>
						<div class="col-sm-6">
							<input type="password" name="she-user-pw-re" id="she-user-pw-re"
								class="form-control" placeholder="비밀번호는 6자리 이상 입력해 주세요" />
						</div>
					</div>
				<!--이메일-->
				<div class="form-group ">
					<label for="she-eamil" class="col-sm-3 control-label">*이메일</label>
					<div class="col-sm-6">
						<input type="text" name="she_eamil" id="she-eamil"
							class="form-control"  value="${ loginInfo.email }"/>
					</div>
				</div>
				<!-- 생년월일 -->
				<div class="form-group">
					<label for="she-birthdate" class="col-sm-3 control-label">*생년월일</label>
					<div class="col-sm-6">
						<input type="date" name="she-birthdate" id="she-birthdate"
							class="form-control" value="${ loginInfo.birth }"/>
					</div>
				</div>
				<!-- 휴대전화 -->
				<div class="form-group">
					<label for="she-phone" class="col-sm-3 control-label">*휴대전화</label>
					<div class="col-sm-6">
						<input type="tel" name="she_phone" id="she_phone"
							class="form-control" value="${ loginInfo.phone }"/>
					</div>
				</div>
				<!-- 전화번호 -->
				<div class="form-group">
					<label for="she-tel" class="col-sm-3 control-label">*보호소전화번호</label>
					<div class="col-sm-6">
						<input type="tel" name="she-tel" id="she-tel" class="form-control" 
						 value="${ loginInfo.tel }"/>
					</div>
				</div>
				<!-- 주소검색 -->
				<div class="form-group">
					<label class="col-sm-3 control-label" for="postcode">*주소</label>
					<div class="col-sm-6">
						<div class="input-group">
							<input type="text" name="postcode" id="postcode"
								class="form-control" value="${ loginInfo.postcode }"/> <span
								class="input-group-btn">
								<button type="button" class="btn btn-success" id="juso">
									<span class="glyphicon glyphicon-search">&nbsp;우편번호검색</span><i
										class="spaceLeft" ></i>
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
							class="form-control" value="${ loginInfo.addr1 }"/>
					</div>
					<div class="col-sm-3">
						<input type="text" name="address1" id="address1"
							class="form-control" value="${ loginInfo.addr2 }"/>
					</div>
				</div>
				<!-- 비밀번호 힌트 -->
				<div class="form-group">
					<label for="select1" class="col-sm-3 control-label" id="join-que">*질문</label>
					<div class="col-sm-6">
						<input type="text" value="${ loginInfo.pwq }" id="she-re" name="she-select" class="form-control"
						 readOnly/>
					</div>
				</div>
				<!-- 힌트 답 -->
				<div class="form-group">
					<label for="she-answer" class="col-sm-3 control-label">*답변</label>
					<div class="col-sm-6">
						<input type="text" name="she-answer" id="she-answer"
							class="form-control" value="${ loginInfo.pwa }"  />
					</div>
				</div>
				<!-- 완료버튼 -->
				<div id="btn-sec">
					<button class="btn btn-primary" type="submit" id="ubtn">
						<span class="glyphicon glyphicon-ok">&nbsp;수정</span>
					</button>
					<button class="btn btn-primary" type="submit" id="xbtn">
						<span class="glyphicon glyphicon-ok">&nbsp;탈퇴</span>
					</button>					
					<button class="btn btn-primary" type="submit" id="cbtn" style="margin-top:20px">
						<span class="glyphicon glyphicon-ok">&nbsp;취소</span>
					</button>
				</div>
			</form>
			<!-- 가입폼 끝 -->
		</section>
		<%@ include file="/WEB-INF/inc/footer.jsp"%>
	</div>
</body>
</html>
