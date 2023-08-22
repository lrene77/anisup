<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true"%>
<form id="comment_delete_form" method="post"
	action="${pageContext.request.contextPath}/listboard/list_comment_delete_ok.do">
	<input type="hidden" name="comment_id" value="${commentId}" />
	<div class="modal-body">
		<c:choose>
			<c:when test="${myComment == true}">
				<!-- 자신의 글에 대한 삭제 -->
				<p>정말 이 덧글을 삭제하시겠습니까?</p>
			</c:when>
			<c:otherwise>
				<!-- 자신의 글이 아닌 경우 -->
				<p>해당 덧글 작성자만 삭제할 수 있습니다.</p>
			</c:otherwise>
		</c:choose>
	</div>
	<div class="modal-footer">
		<c:choose>
			<c:when test="${myComment == true}">
				<button type="button" class="btn btn-default" data-dismiss="modal" style="width: 100px; margin: auto;">취 소</button>
				<button type="submit" class="btn btn-danger" style="width: 100px;">삭 제</button>
			</c:when>
			<c:otherwise>
				<button type="button" class="btn btn-primary" data-dismiss="modal" style="width: 100px;">확 인</button>
			</c:otherwise>
		</c:choose>
	</div>
</form>