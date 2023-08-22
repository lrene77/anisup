<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/inc/head.jsp"%>
<!-- bootstrap -->
<link rel="stylesheet" type="text/css" href="../assets/css/list.css" />
<link rel="stylesheet" type="text/css" href="../assets/css/small.css" />
<link rel="stylesheet" type="text/css" href="../assets/css/pagination.css" />
<link rel="stylesheet" type="text/css" href="../assets/css/mypage/mod.css" />

</head>
<body>
	<div class="container">
		<%@ include file="/WEB-INF/inc/topbar.jsp"%>
		<br id="space">
		<section>
			<h2 class="noti">후기게시판</h2>
			<small id="small1">입양후원후기게시판</small> <small id="small2"><span
				class="glyphicon glyphicon-home"></span> &gt; myPage &gt; 후기게시판</small>
			<hr>
			<!-- Table -->
			<table class="table">
				<thead>
					<tr>
						<th class="text-center">No.</th>
						<th class="text-center">제목</th>
						<th class="text-center">작성일</th>
						<th class="text-center">조회</th>
						<th class="text-center">카테고리</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="5" class="text-center" style="line-height: 100px;">
							조회된 글이 없습니다.
						</td>
					</tr>
				</tbody>
			</table>
			<!-- 페이지 번호-->
			<div class="page_numer" align="center">
				<ul class="pagination">
					<li class="disabled"><a href="#">&laquo;</a></li>
					<li class="active"><span>1<span class="sr-only"></span></span></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#">&raquo;</a></li>
				</ul>
			</div>
			<!--검색 셀렉트-->
			<div class="box1" align="center">
				<select id="select">
					<option>제목</option>
					<option>제목+내용</option>
					<option>작성자</option>
					<option>글쓴이</option>
				</select>
				<!--검색 내용-->
				<input type="text" id="text1">
				<button class="glyphicon glyphicon-search btn btn-default"
					id="search">검색
				</button>
			</div>
			<!--검색 영역 박스-->
		</section>
		<%@ include file="/WEB-INF/inc/footer.jsp"%>
	</div>
</body>
</html>