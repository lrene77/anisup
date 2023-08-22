<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true"%>
<form id="comment_edit_form" method="post"
	action="${pageContext.request.contextPath}/listboard/list_comment_edit_ok.do">
	<!-- 삭제 대상에 대한 상태유지 -->
	<input type="hidden" name="comment_id" value="${comment.id}" />
	<div class="modal-body">
		<!-- 자신의 글이 아닌 경우 -->
		<c:choose>
			<c:when test="${comment.mno == loginInfo.mno }">
				<!-- 덧글 내용 -->
				<div class="form-group">
					<input type="text" name="writer_name" id="writer_name" class="form-control" placeholder="작성자" value="${comment.writerName}" disabled="disabled" />
				</div>
				<div class="form-group">
					<textarea class="form-control" name="content" rows="5">${comment.content}</textarea>
				</div>
			</c:when>
			<c:otherwise>
				<p>해당 덧글 작성자만 수정할 수 있습니다.</p>
			</c:otherwise>
		</c:choose>
	</div>
	<div class="modal-footer">
		<c:choose>
			<c:when test="${comment.mno == loginInfo.mno }">
				<button type="button" class="btn btn-default" data-dismiss="modal" style="width: 100px; margin: auto;">취 소</button>
				<button type="submit" class="btn btn-info" style="width: 100px;">수 정</button>
			</c:when>
			<c:otherwise>
				<button type="button" class="btn btn-primary" data-dismiss="modal" style="width: 100px;">확 인</button>
			</c:otherwise>
		</c:choose>
	</div>
</form>