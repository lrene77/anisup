<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!doctype html>
<html>
<head>
<%@ include file="/WEB-INF/inc/head.jsp"%>
<!-- 공통 -->

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assets/css/btn.css">

<!-- list_write -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/info/write.css" />

<!-- summernote -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/plugins/summernote/summernote.css">
<script src="${pageContext.request.contextPath}/plugins/summernote/summernote.js"></script>
<!-- summer note korean language pack -->
<script src="${pageContext.request.contextPath}/plugins/summernote/lang/summernote-ko-KR.js"></script>
<script type="text/javascript">
$(function() {
	   $('.summernote').summernote({
	      height: 500,          // 기본 높이값
	      minHeight: null,      // 최소 높이값(null은 제한 없음)
	      maxHeight: null,      // 최대 높이값(null은 제한 없음)
	      focus: true,          // 페이지가 열릴때 포커스를 지정함
	      lang: 'ko-KR'         // 한국어 지정(기본값은 en-US)
	    });
	});
</script>
</head>
<body>
	<div class="container">
		<%@ include file="/WEB-INF/inc/topbar.jsp"%>
		<br id="space">
		<section>
			<h2 class="noti">${listName}</h2>
			<small id="small1">AS의 ${smallName1} 올라오는 게시판입니다.</small> <small id="small2"><span
				class="glyphicon glyphicon-home"></span> &gt; ${smallName2} &gt; ${listName} &gt; 글 작성</small>
			<hr>
			<form action="${pageContext.request.contextPath}/listboard/list_write_ok.do?listcate=${listcate}" method="post" enctype="multipart/form-data">
			<input type="hidden" name="listcate" value="${listcate}">
			<!-- Table -->
			<table class="table">
				<tr>
					<td>
						<label for="title">제&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목</label>
						<input type="text" name="title" id="title" class="form-control" placeholder="제목을 입력해주세요.">
					</td>
				</tr>		
				<tr>
					<td>
						<label for="file">파 일 첨 부</label>
						<input type="file" name="file" id="file" class="form-control" multiple />
					</td>
				</tr>
				<tr>
					<td id="noti_com">
						<div class="form-group">
				            <div>
				                <textarea name="content" id="content" class="summernote"/></textarea>
				            </div>
				        </div>
					</td>
				</tr>
			</table>		
			<div id="btn-sec">
				<button class="btn btn-primary " id="cbtn" onclick="history.back();">취 소</button>
				<button type="submit" class="btn btn-primary " id="obtn">확 인</button>
			</div>
			
			</form>	
		</section>
		<%@ include file="/WEB-INF/inc/footer.jsp"%>
	</div>
</body>
</html>