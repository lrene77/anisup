<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!doctype html>
<html>
<head>
<%@ include file="/WEB-INF/inc/head.jsp"%>
<!-- 공통 -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/common.css">
<!-- info -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/info/info.css" />
</head>
<body>
	<div class="container">
		<%@ include file="/WEB-INF/inc/topbar.jsp"%>
		<br/>
		<br/>
		<section>
			<div id="info">
				<img alt="info" src="${pageContext.request.contextPath}/img/info.jpg">
			</div>
			<br/>
			<br/>
		</section>
		<%@ include file="/WEB-INF/inc/footer.jsp"%>
	</div>
</body>
</html>