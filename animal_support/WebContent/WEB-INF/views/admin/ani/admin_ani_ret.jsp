<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>ANIMAL SUPPORT</title>

<!-- 모바일 웹 페이지 설정 -->
<link rel="shortcut icon" href="../../assets/ico/favicon_1.ico" />
<link rel="apple-touch-icon-precomposed"
	href="../../assets/ico/apple-touch-icon-144-precomposed.png" />

<!-- Javascript -->
<script src="../../assets/js/jquery.min.js"></script>
<script src="../../assets/js/bootstrap.min.js"></script>
<script src="../../assets/js/common.js"></script>

<!-- bootstrap -->
<link rel="stylesheet" type="text/css"
	href="../../assets/css/bootstrap.min.css" />

<!-- 나눔고딕 웹 폰트 적용 -->
<link rel="stylesheet" type="text/css"
	href="../../assets/css/nanumfont.css" />

<!-- 반응형 웹을 지원하지 않을 경우 -->
<!-- <link rel="stylesheet" href="../../assets/css/non-responsive.css" /> -->

<!-- IE8 이하 버전 지원 -->
<!--[if lt IE 9]>
		<script type="text/javascript" src="../../assets/js/html5shiv.js"></script>
		<script type="text/javascript" src="../../assets/js/respond.min.js"></script>
		<![endif]-->

<!-- IE10 반응형 웹 버그 보완 -->
<!--[if gt IE 9]>
		<link rel="stylesheet" type="text/css" href="../../assets/css/ie10.css" />
		<script type="text/javascript" src="../../assets/js/ie10.js"></script>
		<![endif]-->

<!-- 공통 스타일 시트 -->
<link rel="stylesheet" type="text/css"
	href="../../assets/css/admin_common.css" />
<link rel="stylesheet" type="text/css"
	href="../../assets/css/admin/ad_sup_ret.css" />
<link rel="stylesheet" type="text/css"
	href="../../assets/css/admin/ad_btn.css" />
<!-- summernote -->
<link rel="stylesheet" type="text/css"
	href="../../plugins/summernote/summernote.css">
<script src="../../plugins/summernote/summernote.js"></script>
<!-- summer note korean language pack -->
<script src="../../plugins/summernote/lang/summernote-ko-KR.js"></script>
<!-- sup_write.js -->
<script src="../../assets/js/sup/sup_write.js"></script>

</head>
<body">
	<div class="container">
		<!-- 상단 시작 -->
		<header>
			<!-- 메뉴바 시작-->
			<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
				<!-- 로고 -->
				<div class="navbar-header">
					<!-- 반응형 메뉴 구현 기능 시작 -->
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#gnb">
						<span class="sr-only">메뉴</span> <span class="icon-bar"></span> <span
							class="icon-bar"></span> <span class="icon-bar"></span>
					</button>
					<!-- 반응형 메뉴 구현 기능 끝 -->
					<a class="navbar-brand" href="../admin_index.html" id="logotxt">ANIMAL
						SUPPORT</a>
				</div>
				<div class="collapse navbar-collapse" id="gnb">
					<ul class="nav navbar-nav">
						<!-- 드롭다운 시작 -->
						<li><a href="../ad_mem/ad_mem_list.html">회 원</a></li>
						<li><a href="../ad_sup/ad_sup_list.html">후 원</a></li>
						<li><a href="ad_ani_list.html">입 양</a></li>
						<li><a href="../ad_rev/ad_rev.html">후 기</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">활 동</a>
							<ul class="dropdown-menu">
								<li><a href="../ad_noti/ad_noti.html">공지사항</a></li>
								<li><a href="../ad_noti/ad_qna.html">Q&amp;A</a></li>
							</ul></li>
					</ul>
					<ul class="nav navbar-nav navbar-right" id="logout">
						<li><a href="#">로 그 아 웃</a></li>
					</ul>
				</div>
				<!-- 메뉴 끝 -->
			</nav>
			<!-- 메뉴바 끝 -->
		</header>
		<!-- 상단 끝 -->
		<br>
		<br>
		<!-- 내용 시작 -->
		<section>
			<h2>입양관리</h2>
			<small>거절 사유</small>
			<hr>

			<!-- Table -->
			<table class="table">
				<tr>
					<td><label for="title">거 절 사 유</label> <input type="text"
						name="title" id="title" class="form-control" placeholder="거절 사유">
					</td>
				</tr>
				<tr>
					<td><label for="file_add">파 일 첨 부</label> <input type="file"
						name="file_add" id="file_add" class="form-control" /></td>
				</tr>
				<tr>
					<td id="noti_com">
						<div class="form-group">
							<div>
								<textarea name="title" id="title" class="summernote" /></textarea>
							</div>
						</div>
					</td>
				</tr>
			</table>

			<div class="container">
				<div id="btn-sec2">
					<button class="btn btn-primary " id="cbtn">취 소</button>
					<button class="btn btn-primary " id="sendbtn">보 내 기</button>
				</div>
			</div>
		</section>
		<!-- 내용 끝 -->
	</div>
	<!-- 하단 시작 -->
	<%@ include file="/WEB-INF/inc/footer.jsp"%>
</body>
</html>