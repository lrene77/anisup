<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!doctype html>
<html>
<head>
<%@ include file="/WEB-INF/inc/head.jsp"%>
<link rel="stylesheet" type="text/css" href="../assets/css/info/com.css" />
		<link rel="stylesheet" type="text/css" href="../assets/css/small.css" />
		<link rel="stylesheet" type="text/css" href="../assets/css/grid.css" />
		<link rel="stylesheet" type="text/css" href="../assets/css/btn.css" />
		<!-- 개인 스타일 시트 -->
		<link rel="stylesheet" type="text/css" href="../assets/css/ani/ani_total.css">
		<!-- 통합 JS -->
		<script type="text/javascript" src="../assets/js/ani/total.js"></script>
</head>
<body>
	<div class="container">
		<%@ include file="/WEB-INF/inc/topbar.jsp"%>
		<br id="space">
			<!-- 내용 시작 -->
			<section>
				<h2 class="noti">입양후기상세보기</h2>
					<small id="small1">AS의 입양후기 게시판입니다.</small>
					<small id="small2"><span class="glyphicon glyphicon-home"></span> &gt; 입양 후기 &gt; 상세 정보</small>
					<hr>
				<!-- Table -->
				<table class="table" id="com_table1">
					<tr>
						<td colspan="2"><b>입양후기 글 제목</b></td>
						<td id="noti_category" class="a"><b>입양후기</b></td>
					</tr>		
					<tr>
						<tr>
						<td><b>Admin</b></td>
						<td id="date22"><b>2017-01-01</b></td>
						<td class="a"><b>380</b></td>
					</tr>
					<tr>
						<td colspan="3" height="500">입양후기 글 내용을 가져옵니다.</td>
					</tr>
				</table>
				<table class="table" id="com_table2">
					<tr>
						<td colspan="2" id="com">
							<textarea id="com_content"></textarea>
						</td>
						<td id="com">
							<button class="btn btn-primary" id="com_ok">등&nbsp;&nbsp;록</button>
						</td>
					</tr>
				</table>

				<div class="comment">
					<!-- 웹진 박스를 목록으로 구성하기 위한 구조 입니다. -->
					<ul class="media-list">
						<!-- 목록의 개별 항목이 웹진 박스로 구성됩니다. -->

					</ul>
				</div>

				<div id="btn-sec">
					<button class="btn btn-primary " id="cbtn" onclick="location.href='ani_rev.do'">취 소</button>
					<button class="btn btn-primary " id="obtn" onclick="location.href='ani_rev_upd.do'">수 정</button>
				</div>
			</section>
		<!-- 리스트 종료 -->
		<%@ include file="/WEB-INF/inc/footer.jsp"%>
	</div>
</body>
</html>