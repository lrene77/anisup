<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true"%>
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
			<a class="navbar-brand"
				href="${pageContext.request.contextPath}/admin/member/admin_mem_list.do"
				id="logotxt">ANIMAL SUPPORT</a>
		</div>
		<c:if test="${loginInfo.mtype=='a'}">
			<div class="collapse navbar-collapse" id="gnb">
				<ul class="nav navbar-nav">
					<!-- 드롭다운 시작 -->
					<li><a
						href="${pageContext.request.contextPath}/admin/member/admin_mem_list.do">회
							원</a></li>
					<li><a
						href="${pageContext.request.contextPath}/admin/sup/admin_sup_list.do">후
							원</a></li>
					<li><a
						href="${pageContext.request.contextPath}/admin/ani/admin_ani_list.do">입
							양</a></li>
					<li><a
						href="${pageContext.request.contextPath}/admin/listboard/rev/admin_rev_list.do">후
							기</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">활 동</a>
						<ul class="dropdown-menu">
							<li><a
								href="${pageContext.request.contextPath}//admin/listboard/info/admin_info_list.do">공지사항</a></li>
							<li><a
								href="${pageContext.request.contextPath}/admin/listboard/ad_noti/ad_qna.do">Q&amp;A</a></li>
						</ul></li>
				</ul>

				<ul class="nav navbar-nav navbar-right" id="logout">
					<li><a
						href="${pageContext.request.contextPath}/admin/admin_loginout.do">로
							그 아 웃</a></li>
				</ul>

			</div>
		</c:if>
		<!-- 메뉴 끝 -->
	</nav>
	<!-- 메뉴바 끝 -->
</header>
<!-- 상단 끝 -->