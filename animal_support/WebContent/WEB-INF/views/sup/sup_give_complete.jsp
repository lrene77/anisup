<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/inc/head.jsp"%>
</head>
<body>
<div class="container">
		<%@ include file="/WEB-INF/inc/topbar.jsp"%>
		<!-- 내용 시작 -->
			<br id="space">
			<section>
				<h2>기부완료</h2>
				<small>후원 완료 페이지 입니다.</small>
				<small id="small2"><span class="glyphicon glyphicon-home"></span> &gt; 후원 &gt; 프로젝트 후원 &gt; 기부하기 &gt; 기부완료</small>
				<hr/>

				<br/>							
				<div style="margin: 0 160px;">
					<h3>- 후원 완료 표시내용</h3>
					<div class="jumbotron" align="center">
						<h2 style="text-align: center;"><b>${name} 님,</b></h2>
						<h2>ANIMAL SUPPORT와 함께 유기견 후원자가 되어주셔서 감사합니다</h2>
					</div>

					<br/>

					<h3>- 후원신청 내역</h3>

					<div class="jumbotron" align="center">
						<p><b>
							후원 프로젝트 : [ ${suptitle} ]<br/>
							후원 금액 : ${item.giveprice} 원<br/>
							은행명 : ${item.givebank}<br/>
							계좌번호 : ${item.giveacc}<br/>							  
						</b></p>
					</div>
				</div>											
			</section>
			<!-- 내용 끝 -->
			<div class="pull-right" id="btn-sec">
				<a class="btn btn-primary" id="obtn" type="submit" href="${pageContext.request.contextPath}/sup/sup_list.do" style="width: 100px; height: 40px; margin: 0 160px; padding: 10px;">확 인</a>
			</div>
			<br/><br/><br/><br/><br/>
		<%@ include file="/WEB-INF/inc/footer.jsp"%>
	</div>
</body>
</html>
