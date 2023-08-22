<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!doctype html>
<html>
<head>
<%@ include file="/WEB-INF/inc/head.jsp"%>
<!-- 공통 스타일 시트 -->
<link rel="stylesheet" type="text/css"
	href="../assets/css/ani/ani_total.css">
<link rel="stylesheet" type="text/css" href="../assets/css/small.css" />
<link rel="stylesheet" type="text/css" href="../assets/css/list.css">
<link rel="stylesheet" type="text/css" href="../assets/css/btn.css" />
<link rel="stylesheet" type="text/css"
	href="../assets/css/pagination.css" />
<!-- 통합 JS -->
<script type="text/javascript" src="../assets/js/ani/total.js"></script>
</head>
<body>
	<div class="container">
		<%@ include file="/WEB-INF/inc/topbar.jsp"%>
		<br id="space">
			<!-- 내용 시작 -->
			<section>
				<h2 class="noti">입양후기</h2>
					<small id="small1">AS의 입양 게시판입니다.</small>
					<small id="small2"><span class="glyphicon glyphicon-home"></span> &gt; 입양 후기</small>
					<hr>
				<!-- Table -->
				<table class="table">
						<tr>
							<th class="text-center">번호</th>
							<th class="text-center">글 제목</th>
							<th class="text-center">작성자</th>
							<th class="text-center">작성일</th>
							<th class="text-center">조회</th>
						</tr>

						<tr>
							<td class="text-center">10</td>
							<td><a href="${pageContext.request.contextPath}/ani/ani_rev_det.do" id="ok">얼마전에 강아지 입양하는 후언글</a></td>
							<td class="text-center">13/10/01~13/10/15</td>
							<td class="text-center">10</td>
							<td class="text-center"><span class="btn"><a href="#" id="ok">확인</a></span></td>
						</tr>

						<tr>
							<td class="text-center">9</td>
							<td><a href="#" id="ok">제가 입양을 햇으니 글을 써봅니다</a></td>
							<td class="text-center">13/10/01~13/10/15</td>
							<td class="text-center">10</td>
							<td class="text-center"><span class="btn"><a href="#" id="ok">확인</a></span></td>
						</tr>

						<tr>
							<td class="text-center">8</td>
							<td><a href="#" id="ok">제가 입양후기 적으면 남들도 볼려나</a></td>
							<td class="text-center">13/10/01~13/10/15</td>
							<td class="text-center">10</td>
							<td class="text-center"><span class="btn"><a href="#" id="ok">확인</a></span></td>
						</tr>

						<tr>
							<td class="text-center">7</td>
							<td><a href="#" id="ok">후기를 쓸수 있다는데 써줘야지 그럼그럼</a></td>
							<td class="text-center">13/10/01~13/10/15</td>
							<td class="text-center">10</td>
							<td class="text-center"><span class="btn"><a href="#" id="ok">확인</a></span></td>
						</tr>

						<tr>
							<td class="text-center">6</td>
							<td><a href="#" id="ok">후기 참 많이쓴다 진짜</a> </td>
							<td class="text-center">13/10/01~13/10/15</td>
							<td class="text-center">10</td>
							<td class="text-center"><span class="btn"><a href="#" id="ok">확인</a></span></td>
						</tr>	

						<tr>
							<td class="text-center">5</td>
							<td><a href="#" id="ok">내가 입양을 또 한번 해보네 소름</a></td>
							<td class="text-center">13/10/01~13/10/15</td>
							<td class="text-center">10</td>
							<td class="text-center"><span class="btn"><a href="#" id="ok">확인</a></span></td>
						</tr>						
						<tr>
							<td class="text-center">4</td>
							<td><a href="#" id="ok">님들 입양하세요 착한일해야 복받아요</a></td>
							<td class="text-center">13/10/01~13/10/15</td>
							<td class="text-center">10</td>
							<td class="text-center"><span class="btn"><a href="#" id="ok">확인</a></span></td>
						</tr>	
						<tr>
							<td class="text-center">3</td>
							<td><a href="#" id="ok">님들 입양하세요 착한일해야 복받아요</a></td>
							<td class="text-center">13/10/01~13/10/15</td>
							<td class="text-center">10</td>
							<td class="text-center"><span class="btn"><a href="#" id="ok">확인</a></span></td>
						</tr>	
						<tr>
							<td class="text-center">2</td>
							<td><a href="#" id="ok">님들 입양하세요 착한일해야 복받아요</a></td>
							<td class="text-center">13/10/01~13/10/15</td>
							<td class="text-center">10</td>
							<td class="text-center"><span class="btn"><a href="#" id="ok">확인</a></span></td>
						</tr>	
						<tr>
							<td class="text-center">1</td>
							<td><a href="#" id="ok">님들 입양하세요 착한일해야 복받아요</a></td>
							<td class="text-center">13/10/01~13/10/15</td>
							<td class="text-center">10</td>
							<td class="text-center"><span class="btn"><a href="#" id="ok">확인</a></span></td>
						</tr>	
				</table>

				<div class="container" align="right">
					<button id="wbtn" class="btn btn-primary " onclick="location.href='ani_rev_write.do'";><span class="glyphicon glyphicon-pencil">글 작성</span></button>
				</div>
				<div class="container" align="center">
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


				<div class="container" align="center">
					<select  id="select">
						<option>제목</option>
						<option>제목+내용</option>
						<option>작성자</option>
						<option>글쓴이</option>
					</select>

					<input type="text" id="text" >
					<button class="glyphicon glyphicon-search btn btn-default" id="search">검색</button>
				</div>
			</section>
			<!-- 내용 끝 -->
		<%@ include file="/WEB-INF/inc/footer.jsp"%>
	</div>
</body>
</html>