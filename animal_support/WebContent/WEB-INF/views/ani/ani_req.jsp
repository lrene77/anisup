<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!doctype html>
<html>
<head>
<%@ include file="/WEB-INF/inc/head.jsp"%>
<link rel="stylesheet" type="text/css" href="../assets/css/small.css" />
<!-- 개인 CSS -->
<link rel="stylesheet" type="text/css"
	href="../assets/css/ani/ani_total.css">
<link rel="stylesheet" type="text/css"
	href="../assets/css/ani/ani_req.css">
<!-- 통합 JS -->
<script type="text/javascript" src="../assets/js/ani/total.js"></script>

</head>
<body>
	<div class="container">
		<%@ include file="/WEB-INF/inc/topbar.jsp"%>
		<br id="space">
		<!-- 리스트 시작 -->
		<h2 class="noti">신청서양식</h2>
		<small id="small1">AS의 입양 게시판입니다.</small> <small id="small2"><span
			class="glyphicon glyphicon-home"></span> &gt; 입양 &gt; 상세보기 &gt; 신청서
			양식</small>
		<hr>
		<section style="border: 1px solid #000;">
			<br>
			<form class="form-horizontal" method="post"
				action="${pageContext.request.contextPath}/ani/ani_req_ok.do">
				<div class="row" style="height: 400px; margin-top: 10px;">
					<p style="margin-left: 20px; color: #777; font-size: 12px;">*이름,
						번호, 주소는 수정하실수 없습니다.</p>
					<div class="col-xs-12">
						<div class="jumbotron"
							style="border: 1px solid #000;" id="myform">
							<!-- 내용입력 -->
							<div class="form-group ">
								<label for="title">제 목</label> <input type="text" name="title"
									id="title" class="form-control" placeholder="제목을 입력해 주세요" />
							</div>
							<div class="form-group ">
								<label for="name">이 름</label> <input type="text" name="name"
									id="name" class="form-control" placeholder="${loginInfo.name}"
									disabled />
							</div>
							<div class="form-group ">
								<label for="phone">번 호</label> <input type="text" name="phone"
									id="phone" class="form-control" placeholder="${loginInfo.tel}"
									disabled />
							</div>
							<div class="form-group ">
								<label for="address">주 소</label> <input type="text"
									name="address" id="address" class="form-control"
									placeholder="${loginInfo.addr1}&nbsp;${loginInfo.addr2}"
									disabled />
							</div>
							<div class="form-group ">
								<label for="job">직 업</label> <input type="text" name="job"
									id="job" class="form-control" placeholder="직업을 입력해 주세요" />
							</div>
							<div class="form-group ">
								<label for="show">내 용</label> <input type="text" name="show"
									id="show" class="form-control" placeholder="내용을 입력해 주세요" />
							</div>
						</div>
					</div>
				</div>
				<!-- 내용 리스트 -->
				<div class="col-xs-12">
					<!-- <h2 style="color: red" align="center">주의사항</h2> -->
					<div class="row jumbotron"
						style="border: 1px solid #000; font: 18px bold;">
						<b>* 주의사항</b><br> <br> &nbsp;1. 동물 입양 시, 보호소와 분양하시는분의
						신분을 꼭 확인해주시기 바랍니다.<br> &nbsp;2. 분양받으신 동물은 상업용, SNS광고 등에 사용하실
						수 없습니다.<br> &nbsp;3. 개인사정으로 동물을 키우실 수 없을경우 분양받으신 보호소로 연락
						바랍니다.
					</div>
				</div>
				<!-- 내용 리스트 종료 -->

				<input type="hidden" name="ani_id" value="${ani.anino}" />

				<!-- 글쓰기 버튼 -->
				<div align="center">
					<a style="text-decoration: none;"><button
							type="submit" class="btn btn-default btn-lg" id="btn_write">신청하기</button></a>
				</div>
			</form>
		</section>
		<!-- 리스트 종료 -->
		<%@ include file="/WEB-INF/inc/footer.jsp"%>
	</div>
</body>
</html>