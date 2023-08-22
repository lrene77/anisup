<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!doctype html>
<html>
<head>
<%@ include file="/WEB-INF/inc/head.jsp"%>
<!-- 공통 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assets/css/common.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assets/css/btn.css">

<!-- read -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assets/css/info/com.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assets/css/grid.css" />

<!-- sweetalert -->
<!-- sweet alert -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/plugins/sweetalert/sweetalert.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/plugins/sweetalert/sweetalert.min.js"></script>

<!-- read.js -->
<!-- <script src="${pageContext.request.contextPath}/assets/js/info/list_read.js"></script> -->

<!-- list_read.css -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/info/list_read.css">
</head>
<body>
	<div class="container">
		<%@ include file="/WEB-INF/inc/topbar.jsp"%>
		<br id="space">
		<section>
			<h2 class="noti">${listName}</h2>
			<small id="small1">AS의 ${smallName1} 올라오는 게시판입니다.</small> <small
				id="small2"><span class="glyphicon glyphicon-home"></span>
				&gt; ${smallName2} &gt; ${listName} &gt; 글 작성</small>
			<hr>
			<!-- Table -->
			<input type="hidden" name="listcate" value="${listcate}">
			<table class="table" id="com_table1">
				<tr>
					<td colspan="2"><b>[${listName}]
							${readListboard.listtitle}</b></td>
					<td id="noti_category" class="a"><b>${listName}</b></td>
				</tr>
				<tr>
					<td><b>${readListboard.id}</b></td>
					<td id="date22"><b>${readListboard.wdate}</b></td>
					<td class="a"><b>${readListboard.hit}</b></td>
				</tr>
				<c:if test="${fileList != null}">
					<tr>
						<td colspan="3"><b>첨부파일</b> <c:forEach var="file"
								items="${fileList}">
								<c:url var="downloadUrl" value="/download.do">
									<c:param name="file" value="${file.file_dir}/${file.file_name}" />
									<c:param name="origin" value="file.originName" />
								</c:url>
								<a href="${downloadUrl}" class="btn btn-link btn-xs">${file.origin_name}</a>
							</c:forEach></td>
					</tr>
					<tr>
						<td colspan="3" height="500"><c:forEach var="file"
								items="${fileList}">
								<c:if
									test="${fn:substringBefore(file.content_type, '/') == 'image'}">
									<c:url var="downloadUrl" value="/download.do">
										<c:param name="file"
											value="${file.file_dir}/${file.file_name}" />
									</c:url>
									<p>
										<img src="${downloadUrl}" class="img-responsive"
											style="margin: auto" />
									</p>
								</c:if>
							</c:forEach> ${readListboard.listcont}</td>
					</tr>
				</c:if>
			</table>
			<form id="comment_form" method="post"
				action="${pageContext.request.contextPath}/listboard/list_comment_insert.do">
				<!-- 글 번호 상태 유지 -->
				<input type='hidden' name='listno' value='${readListboard.listno}' />
				<!-- 작성자,비밀번호,이메일은 로그인하지 않은 경우만 입력한다. -->
				<c:choose>
					<c:when test="${loginInfo == null }">
						<table class="table" id="com_table2">
							<tr>
								<td colspan="2" id="com"><textarea name='content'
										id="content" disabled="disabled">로그인한 회원만 입력가능합니다.</textarea>
								</td>
								<td id="com">
									<button type="submit" class="btn btn-primary" id="comm_ok"
										disabled="disabled">등&nbsp;&nbsp;록</button>
								</td>
							</tr>
						</table>
					</c:when>
					<c:otherwise>
						<table class="table" id="com_table2">
							<tr>
								<td colspan="2" id="com"><textarea name='content'
										id="content"></textarea></td>
								<td id="com">
									<button type="submit" class="btn btn-primary" id="comm_ok">등&nbsp;&nbsp;록</button>
								</td>
							</tr>
						</table>
					</c:otherwise>
				</c:choose>
				<!-- 내용입력, 저장버튼 -->
			</form>

			<div id="comcom">
				<!-- 덧글 리스트 -->
				<ul class="media-list" id="comment_list">
				</ul>
			</div>

			<div id="btn-sec">
				<c:choose>
					<c:when test="${readListboard.mno == loginInfo.mno}">
						<button class="btn btn-primary " id="ubtn"
							onclick="location.href='${pageContext.request.contextPath}/listboard/list_edit.do?listcate=${listcate}&listno=${readListboard.listno}'"
							style="margin-bottom: 20px;">수 정</button>
						<button class="btn btn-primary " id="cbtn"
							onclick="location.href='${pageContext.request.contextPath}/listboard/list_delete.do?listcate=${listcate}&listno=${readListboard.listno}'"
							style="margin-bottom: 20px;">삭 제</button>
						<button class="btn btn-info " id="lbtn"
							onclick="location.href='${pageContext.request.contextPath}/listboard/list_list.do?listcate=${listcate}'";>
							<span class="glyphicon glyphicon-list"> 목 록</span>
						</button>
					</c:when>
					<c:otherwise>
						<button class="btn btn-info " id="lbtn"
							onclick="location.href='${pageContext.request.contextPath}/listboard/list_list.do?listcate=${listcate}'";>
							<span class="glyphicon glyphicon-list"> 목 록</span>
						</button>
					</c:otherwise>
				</c:choose>
			</div>
		</section>
		<%@ include file="/WEB-INF/inc/footer.jsp"%>
	</div>
	<!-- 덧글 항목에 대한 템플릿 참조 -->
	<script id="tmpl_comment_item" type="text/x-handlebars-template">
    <li class="media" style='border-top: 1px solid #ccc; padding-top: 15px' id="comment_{{id}}">
        <div class="media-body" style='display: block;'>
            <h4 class="media-heading clearfix">
                <!-- 작성자,작성일시 -->
                <div class='pull-left'>
                    {{writerName}}
                    <small>
						{{regDate}}
                    </small>
                </div>
               <!-- 수정,삭제 버튼 -->
                <div class='pull-right'>
                    <a href='${pageContext.request.contextPath}/listboard/list_comment_edit.do?comment_id={{id}}' data-toggle="modal" data-target="#comment_edit_modal" class='btn btn-info btn-xs'>
                        <i class='glyphicon glyphicon-refresh'></i>
                    </a>
                    <a href='${pageContext.request.contextPath}/listboard/list_comment_delete.do?comment_id={{id}}' data-toggle="modal" data-target="#comment_delete_modal" class='btn btn-danger btn-xs'>
                        <i class='glyphicon glyphicon-remove-circle'></i>
                    </a>
                </div>
            </h4>
            <!-- 내용 -->
            <p>{{{content}}}</p>
        </div>
    </li>
</script>

<!-- 덧글 삭제시 사용될 Modal -->
<div class="modal fade" id="comment_delete_modal">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">

    </div>
  </div>
</div>

<!-- 덧글 수정시 사용될 Modal -->
<div class="modal fade" id="comment_edit_modal">
  <div class="modal-dialog">
    <div class="modal-content">

    </div>
  </div>
</div>

	<script type="text/javascript">
		$(function() {
			/** 페이지가 열리면서 동작하도록 이벤트 정의 없이 Ajax요청 */
			$.get("${pageContext.request.contextPath}/listboard/list_comment_list.do", {
				listno: "${readListboard.listno}"
			}, function(json) {
				if (json.rt != "OK") {
					alert(json.rt);
					return false;
				}
				
				// 템플릿 HTML을 로드한다.
				var template = Handlebars.compile($("#tmpl_comment_item").html());
				
				// JSON에 포함된 '&lt;br/&gt;'을 검색에서 <br/>로 변경함.
				// --> 정규표현식 /~~~/g는 문자열 전체의 의미.
				for (var i=0; i<json.item.length; i++) {
					json.item[i].content 
						= json.item[i].content.replace(/&lt;br\/&gt;/g, "<br/>");
					
					// 덧글 아이템 항목 하나를 템플릿과 결합한다.
					var html = template(json.item[i]);
					// 결합된 결과를 덧글 목록에 추가한다.
					$("#comment_list").append(html);
				}
			});
			
			/** 덧글 작성 폼의 submit 이벤트 Ajax 구현 */
			// <form>요소의 method, action속성과 <input>태그를
			// Ajax요청으로 자동 구성한다.
			$("#comment_form").ajaxForm(function(json) {
				// json은 API에서 표시하는 전체 데이터
				if (json.rt != "OK") {
					alert(json.rt);
					return false;
				}

				// 줄 바꿈에 대한 처리
				// --> 정규표현식 /~~~/g는 문자열 전체의 의미.
				// --> JSON에 포함된 '&lt;br/&gt;'을 검색에서 <br/>로 변경함.
				json.item.content = json.item.content.replace(
						/&lt;br\/&gt;/g, "<br/>");

				// 템플릿 HTML을 로드한다.
				var template = Handlebars.compile($(
						"#tmpl_comment_item").html());
				// JSON에 포함된 작성 결과 데이터를 템플릿에 결합한다.
				var html = template(json.item);
				// 결합된 결과를 덧글 목록에 추가한다.
				$("#comment_list").append(html);
				// 폼 태그의 입력값을 초기화 하기 위해서 reset이벤트를 강제로 호출
				$("#comment_form").trigger('reset');
			});
			
			/** 모든 모달창의 캐시 방지 처리 */
			$('.modal').on('hidden.bs.modal', function (e) {
				// 모달창 내의 내용을 강제로 지움.
	    		$(this).removeData('bs.modal');
			});
			
			/** 동적으로 로드된 폼 안에서의 submit 이벤트 */
			$(document).on('submit', "#comment_delete_form", function(e) {
				e.preventDefault();

				// AjaxForm 플러그인의 강제 호출
				$(this).ajaxSubmit(function(json) {
					if (json.rt != "OK") {
						alert(json.rt);
						return false;
					}
					
					alert("삭제되었습니다.");
					// modal 강제로 닫기
					$("#comment_delete_modal").modal('hide');
					
					// JSON 결과에 포함된 덧글일련번호를 사용하여 삭제할 <li>의 id값을 찾는다.
					var comment_id = json.commentId;
					$("#comment_" + comment_id).remove();
				});
			});
			
			/** 동적으로 로드된 폼 안에서의 submit 이벤트 */
			$(document).on('submit', "#comment_edit_form", function(e) {
				e.preventDefault();
				
				// AjaxForm 플러그인의 강제 호출
				$(this).ajaxSubmit(function(json) {
					if (json.rt != "OK") {
						alert(json.rt);
						return false;
					}
					
					// 줄 바꿈에 대한 처리
					// --> 정규표현식 /~~~/g는 문자열 전체의 의미.
					// --> JSON에 포함된 '&lt;br/&gt;'을 검색에서 <br/>로 변경함.
					json.item.content = json.item.content.replace(/&lt;br\/&gt;/g, "<br/>");
					
					// 템플릿 HTML을 로드한다.
					var template = Handlebars.compile($("#tmpl_comment_item").html());
					// JSON에 포함된 작성 결과 데이터를 템플릿에 결합한다.
					var html = template(json.item);
					// 결합된 결과를 기존의 덧글 항목과 교체한다.
					$("#comment_" + json.item.id).replaceWith(html);
					
					// 덧글 수정 모달 강제로 닫기
					$("#comment_edit_modal").modal('hide');
				});
			});
		});
	</script>
</body>
</html>