<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!doctype html>
<html>
<head>
<%@ include file="/WEB-INF/inc/head.jsp"%>
<!-- join -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assets/css/login/join.css">
<script src="${pageContext.request.contextPath}/assets/js/login/join.js"></script>
</head>
<body>
	<div class="container">
		<%@ include file="/WEB-INF/inc/topbar.jsp"%>
		<section>
			<h2>보호소 회원 가입</h2>
			<small id="small1">*표시 된 부분은 필수 입력사항입니다.</small><small id="small2"><span
				class="glyphicon glyphicon-home"> &gt; 보호소 회원 가입</span></small>
			<hr />
			<!-- 가입폼 시작 -->
			<div id="use">
				<p>
					제 1 장 총 칙<br /> 제 1 조 목적<br /> 본 약관은 서비스 이용자가 주식회사 카카오(이하 “회사”라
					합니다)가 제공하는 온라인상의 인터넷 서비스(이하 “서비스”라고 하며, 접속 가능한 유∙무선 단말기의 종류와는 상관없이
					이용 가능한 “회사”가 제공하는 모든 “서비스”를 의미합니다. 이하 같습니다)에 회원으로 가입하고 이를 이용함에 있어
					회사와 회원(본 약관에 동의하고 회원등록을 완료한 서비스 이용자를 말합니다. 이하 “회원”이라고 합니다)의 권리•의무 및
					책임사항을 규정함을 목적으로 합니다. 제 2 조 (약관의 명시, 효력 및 개정)<br /> ①<br /> 회사는 이
					약관의 내용을 회원이 쉽게 알 수 있도록 서비스 초기 화면에 게시합니다.<br /> ②<br /> 회사는 온라인
					디지털콘텐츠산업 발전법, 전자상거래 등에서의 소비자보호에 관한 법률, 약관의 규제에 관한 법률, 소비자기본법 등 관련법을
					위배하지 않는 범위에서 이 약관을 개정할 수 있습니다.<br /> ③<br /> 회사가 약관을 개정할 경우에는
					기존약관과 개정약관 및 개정약관의 적용일자와 개정사유를 명시하여 현행약관과 함께 그 적용일자 일십오(15)일 전부터
					적용일 이후 상당한 기간 동안, 개정 내용이 회원에게 불리한 경우에는 그 적용일자 삼십(30)일 전부터 적용일 이후
					상당한 기간 동안 각각 이를 서비스 홈페이지에 공지하고 기존 회원에게는 회사가 부여한 이메일 주소로 개정약관을 발송하여
					고지합니다.<br /> ④<br /> 회사가 전항에 따라 회원에게 통지하면서 공지∙고지일로부터 개정약관 시행일 7일
					후까지 거부의사를 표시하지 아니하면 승인한 것으로 본다는 뜻을 명확하게 고지하였음에도 의사표시가 없는 경우에는 변경된
					약관을 승인한 것으로 봅니다. 회원이 개정약관에 동의하지 않을 경우 회원은 제17조 제1항의 규정에 따라 이용계약을
					해지할 수 있습니다.<br />
				</p>
			</div>
			<!-- 회원가입 폼 시작 -->
			<div class="col-md-12">
				<form class="form-horizontal" method="post"
					action="${pageContext.request.contextPath}/login/shejoin_ok.do"	id="join">
					<p id="use-check">
						<input type="checkbox" name="agree" value="위의 약관에 동의합니다.">위의
						약관에 동의합니다.<br /> <span id="result"></span>
					</p>
					<!-- 이름 -->
					<div class="form-group ">
						<label for="name" class="col-sm-3 control-label">*보호소명</label>
						<div class="col-sm-6">
							<input type="text" name="name" id="name"
								class="form-control" placeholder="이름을 입력해 주세요" />
						</div>
					</div>
					<!-- 아이디 -->
					<div class="form-group">
						<label class="col-sm-3 control-label" for="id">*아이디</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" name="id" id="id"
								placeholder="아이디를 입력해주세요" /> <span class="input-group-btn">
							</span>
						</div>
					</div>
					<!--비밀번호-->
					<div class="form-group ">
						<label for="pw" class="col-sm-3 control-label">*비밀번호</label>
						<div class="col-sm-6">
							<input type="password" name="pw" id="pw"
								class="form-control" placeholder="비밀번호는 6자리 이상 입력해 주세요" />
						</div>
					</div>
					<!--비밀번호-->
					<div class="form-group ">
						<label for="pw-re" class="col-sm-3 control-label">*비밀번호
							확인</label>
						<div class="col-sm-6">
							<input type="password" name="pw-re" id="pw-re"
								class="form-control" placeholder="비밀번호는 6자리 이상 입력해 주세요" />
						</div>
					</div>
					<!--이메일-->
					<div class="form-group ">
						<label for="email" class="col-sm-3 control-label">*이메일</label>
						<div class="col-sm-6">
							<input type="email" name="email" id="email"
								class="form-control" placeholder="@포함하여 이메일을 입력해주세요" />
						</div>
					</div>
					<!-- 생년월일 -->
					<div class="form-group">
						<label for="birth" class="col-sm-3 control-label">*생년월일</label>
						<div class="col-sm-6">
							<input type="date" name="birth" id="birth"
								class="form-control" placeholder="yyyy-mm-dd" />
						</div>
					</div>
					<!-- 휴대전화 -->
					<div class="form-group">
						<label for="phone" class="col-sm-3 control-label">*휴대전화</label>
						<div class="col-sm-6">
							<input type="tel" name="phone" id="phone"
								class="form-control" placeholder="'-'을 제외 하고 입력해주세요" />
						</div>
					</div>
					<!-- 전화번호 -->
					<div class="form-group">
						<label for="tel" class="col-sm-3 control-label">*전화번호</label>
						<div class="col-sm-6">
							<input type="tel" name="tel" id="tel"
								class="form-control" placeholder="'-'을 제외 하고 입력해주세요" />
						</div>
					</div>
					<!-- 주소검색 -->
					<div class="form-group">
						<label class="col-sm-3 control-label" for="postcode">*주소</label>
						<div class="col-sm-6">
							<div class="input-group">
								<input type="text" name="postcode" id="postcode"
									class="form-control" placeholder="우편번호를 검색해주세요" /> <span
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
								class="form-control" placeholder="주소를 입력해주세요" />
						</div>
						<div class="col-sm-3">
							<input type="text" name="address1" id="address1"
								class="form-control" placeholder="주소를 입력해주세요" />
						</div>
					</div>
					<!-- 비밀번호 힌트 -->
					<div class="form-group">
						<label for="select" class="col-sm-3 control-label"
							id="join-que">*질문</label>
						<div class="col-sm-6">
							<select class="form-control" name="select" id="select">
								<option>---------선택해주세요-----------</option>
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
							<input type="text" name="answer" id="answer"
								class="form-control" placeholder="선택하신 질문에 대한 답을 입력해주세요" />
						</div>
					</div>
					<!-- 완료버튼 -->
					<div class="form-group" id="ok-button">
						<div class="col-sm-12">
							<button class="btn btn-primary" id="join" type="submit">
								<span class="glyphicon glyphicon-ok">&nbsp;회원가입</span><i
									class="spaceLeft"></i>
							</button>
							<button class="btn btn-danger" type="button" id="join-remove"
								onclick="history.back();">
								<span class="glyphicon glyphicon-remove"></span>&nbsp;가입취소<i
									class="spaceLeft"></i>
							</button>
						</div>
					</div>
				</form>
				<!-- 가입폼 끝 -->
			</div>
		</section>
		<%@ include file="/WEB-INF/inc/footer.jsp"%>
	</div>
</body>
</html>