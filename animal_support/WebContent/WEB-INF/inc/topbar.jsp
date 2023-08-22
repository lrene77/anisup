<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true"%>
<p class="hidden-xs" id="logo">
	<a href="${pageContext.request.contextPath}/index.do ">
	<img src="${pageContext.request.contextPath}/img/logo.png" alt="logo" /></a>
</p>
<header>
	<!-- 메뉴바 시작-->
	<nav class="navbar navbar-default" id="top-menu-all" role="navigation">
		<!-- 로고 -->
		<div class="navbar-header">
			<!-- 반응형 메뉴 구현 기능 시작 -->
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#gnb">
				<span class="sr-only">메뉴</span> <span class="icon-bar"></span>
				<span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<!-- 반응형 메뉴 구현 기능 끝 -->
			<a class="navbar-brand" href="${pageContext.request.contextPath}/index.do " id="logotxt">ANIMAL SUPPORT</a>
		</div>
		<div class="collapse navbar-collapse" id="gnb">
			<ul class="nav navbar-nav">
				<!-- 드롭다운 시작 -->
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" id="top-menu" data-toggle="dropdown">후 원</a>
					<ul class="dropdown-menu">
						<li><a href="${pageContext.request.contextPath}/sup/sup_list.do">프로젝트 후원</a></li>
						<li><a href="${pageContext.request.contextPath}/listboard/list_list.do?listcate=s">후원 후기</a></li>
					</ul>
				</li>
				<li class="dropdown"><a href="#" class="dropdown-toggle" id="top-menu" data-toggle="dropdown">입 양</a>
					<ul class="dropdown-menu">
						<li><a href="${pageContext.request.contextPath}/ani/ani_list.do">입양</a></li>
						<li><a href="${pageContext.request.contextPath}/listboard/list_list.do?listcate=a">입양 후기</a></li>
						<li><a href="${pageContext.request.contextPath}/ani/map.do">보호소 지도</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" id="top-menu" data-toggle="dropdown">활 동</a>
					<ul class="dropdown-menu">
						<li><a href="${pageContext.request.contextPath}/info/info.do">활동</a></li>
						<li><a href="${pageContext.request.contextPath}/listboard/list_list.do?listcate=n">공지사항</a></li>
						<li><a href="${pageContext.request.contextPath}/listboard/list_list.do?listcate=q">Q&amp;A</a></li>
					</ul>
				</li>
				<c:choose>
					<c:when test="${loginInfo==null}">
						<li class="dropdown">
						<a href="${pageContext.request.contextPath}/login/login.do" id="top-menu">로 그 인</a></li>
					</c:when>
					<c:when test="${loginInfo.mtype=='m'}">
						<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" id="top-menu"><b>${loginInfo.name}</b>님</a>
							<ul class="dropdown-menu">
								<li><a href="${pageContext.request.contextPath}/mypage/mem_upd.do">회원정보</a></li>
								<li><a href="${pageContext.request.contextPath}/mypage/mem_rev_list.do">내가쓴글</a></li>
								<li><a href="${pageContext.request.contextPath}/mypage/mem_sup_rec_list.do">모집내역</a></li>
								<li><a href="${pageContext.request.contextPath}/mypage/mem_sup_list.do">후원내역</a></li>
								<li><a href="${pageContext.request.contextPath}/mypage/mem_ani_list.do">입양내역</a></li>
								<li><a href="${pageContext.request.contextPath}/login/logout.do">로그아웃</a></li>
							</ul>
						</li>
					</c:when>
					<c:otherwise>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" id="she-name" style="padding:15px 20px"><b>${loginInfo.name}</b>님</a>
							<ul class="dropdown-menu">
								<li><a href="${pageContext.request.contextPath}/mypage/she_mem_upd.do">회원정보</a></li>
								<li><a href="${pageContext.request.contextPath}/mypage/she_rec_list.do">내가쓴글</a></li>
								<li><a href="${pageContext.request.contextPath}/mypage/she_ani_list.do">모집내역</a></li>
								<li><a href="${pageContext.request.contextPath}/mypage/she_sup_list.do">후원내역</a></li>
								<li><a href="${pageContext.request.contextPath}/mypage/she_ani_list.do">입양내역</a></li>
								<li><a href="${pageContext.request.contextPath}/login/logout.do">로그아웃</a></li>
							</ul>
						</li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
		<!-- 메뉴 끝 -->
	</nav>
	<!-- 메뉴바 끝 -->
</header>