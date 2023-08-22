<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!doctype html>
<html>
<head>
<%@ include file="/WEB-INF/inc/head.jsp"%>
<!-- login -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/login/login.css">
</head>
<body>
	<div class="container">
		<%@ include file="/WEB-INF/inc/topbar.jsp"%>
			<section>
				<!-- 회원 분류modal 시작 -->
				<div id="join-modal" class="modal fade" tabindex="-1" role="dialog" aria-lebelledby="join-modalLabel" aria-hidden="true">
					<!-- modal dialog 시작 -->
					<div class="modal-dialog">
						<!-- modal content 시작 -->
						<div class="modal-content">
							<!-- 제목 시작 -->
							<div class="modal-header">
								<!-- 닫기버튼 -->
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
								<h4 class= "modal-title" id="join-modalLabel"><span class="glyphicon glyphicon-user">&nbsp;회원의 분류를 선택해 주세요</span></h4>
							</div>
							<!-- 제목 끝 -->
								<!-- 내용영역 시작-->
								<a href="${pageContext.request.contextPath}/login/memjoin.do"><button type="button" class="btn btn-primary" align="center" id="join_button">개인 회원</button></a>
								<a href="${pageContext.request.contextPath}/login/shejoin.do"><button type="button" class="btn btn-primary" align="center" id="join_button">보호소 회원</button></a>
								<!-- 내용영역 끝 -->
								<!-- 하단 시작 -->
								<div class="modal-footer">
									<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
								</div>
								<!-- 하단 끝 -->
						</div>		
						<!-- modal content 끝 -->
					</div>
					<!-- modal dialog 끝 -->
				</div>
				<!--회원 분류 modal 끝 -->
				<!-- 로그인 폼 시작-->
				<div class="row" id="login">
					<div class="col-md-3 col-sm-1"></div>
			        <div class="col-md-6 col-sm-7">
			        		<form role="form" method="post"  name="loginDo" action="${pageContext.request.contextPath}/login/login_ok.do">
								<img src="${pageContext.request.contextPath}/login/img/sm_logo.png" alt="작은로고"/>
			            		<div class="form-group">
			                		<label for="user_id">아이디</label>
			                		<input name="user_id" id="user_id" placeholder="ID를 입력해주세요" type="text" class="form-control" />
			            		</div>
			            		<div class="form-group">
			                		<label for="user_pw">비밀번호</label>
			                		<input name="user_pw" id="user_pw" placeholder="비밀번호를 입력해주세요" type="password" class="form-control" />
			            		</div>
				            	<div class="form-group">
				            		<button type="submit" class="btn btn-default btn-login-submit btn-block m-t-md">로그인</button>
				            	</div>
				            </form>
				          	<div align="center">
								<span><a href="#join-modal" data-toggle="modal">회원가입&nbsp;</a></span>
								<span><a href="${pageContext.request.contextPath}/login/id_pw_sear.do">ID&nbsp;비밀번호 찾기</a></span>
							</div>
			            </div>
					<div class="col-md-3 col-sm-3"></div>
			    </div>
			    <!-- 로그인 폼 끝 -->
			</section>
			<!-- 내용 끝 -->
		<%@ include file="/WEB-INF/inc/footer.jsp"%>
	</div>

</body>
</html>