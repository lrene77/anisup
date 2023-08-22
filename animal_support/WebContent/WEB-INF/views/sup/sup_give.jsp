<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/inc/head.jsp"%>

<!-- sup_give.js -->
<!--  <script src="../assets/js/sup/sup_give.js"></script>-->

<!-- sup_give.css -->
<link rel="stylesheet" type="text/css" href="../assets/css/sup/sup_give.css">

<link rel="stylesheet" type="text/css" href="../assets/css/small.css" />

<link rel="stylesheet" type="text/css" href="../assets/css/btn.css">

<!-- sweet alert -->
<!-- <link rel="stylesheet" href="../plugins/sweetalert/sweetalert.css" />
	<script src="../plugins/sweetalert/sweetalert.min.js"></script> -->
</head>
<body>
	<div class="container">
		<%@ include file="/WEB-INF/inc/topbar.jsp"%>
		<!-- 내용 시작 -->
			<br id="space">
			<section>
				<!-- 회원 분류modal 시작 -->
				
				<!--회원 분류 modal 끝 -->
				
				<h2>기부하기</h2>
				<small>기부자 정보 기재하는 페이지 입니다.</small>
				<small id="small2"><span class="glyphicon glyphicon-home"></span> &gt; 후원 &gt; 프로젝트 후원 &gt; 기부하기 </small>
				<hr/>

				<br/><br/>
				<c:url var="readUrl" value="/sup/sup_give_ok.do">
					<c:param name="supno" value="${item.supno}" />
					<c:param name="suptitle" value="${item.suptitle}" />
				</c:url>
				<form class="form-horizontal" roloe="form" name="give" id="give" enctype="multipart/form-data" method="post" action="${readUrl}">
					<fieldset>
						<div class="form-group">
							<label for="title" class="col-md-3 control-label">후원 주제</label>
							<div class="col-md-6">
								<input type="text" class="form-control"  name="title"placeholder="[ ${item.suptitle} ]" disabled>
								
							</div>
						</div>

						<br/>

						<div class="form-group">
							<label for="giveprice" class="col-md-3 control-label">후원 금액</label>
							<div class="col-md-6">
								<input type="text" class="form-control" name="giveprice" id="giveprice" placeholder="10,000단위로 입력하세요" >
							</div>
						</div>

						<br/>

						<div class="form-group">
							<label for="pay" class="col-md-3 control-label">결제방법</label>
							<div class="col-md-6">
								<input type="password" class="form-control" name="pay" placeholder="무통장입금" disabled>
							</div>
						</div>

						<br/>
						
						<div class="form-group">
							<label for="givebank" class="col-md-3 control-label">은행명</label>
							<div class="col-md-6">
								<select id="givebank" name="givebank" class="form-control">
									<option value="">선택해주세요</option>
									<option value="국민은행">국민은행</option>
									<option value="신한은행">신한은행</option>
									<option value="농협은행">농협은행</option>
									<option value="외한은행">외한은행</option>
									<option value="기업은행">IBK은행</option>
								</select>
							</div>
						</div>

						<br/>
						
						<div class="form-group">
							<label for="giveacname" class="col-md-3 control-label">예금주</label>
							<div class="col-md-6">
								<input type="text" class="form-control" name="giveacname" id="giveacname">
							</div>	
						</div>

						<br/>
						
						<div class="form-group">
								<label for="giveacc" class="col-md-3 control-label">계좌번호</label>
								<div class="col-md-6">
								<input type="text" class="form-control" id="giveacc" name="giveacc" placeholder="-를 뺴고 입력해주세요" >
								</div>
						</div>

						<br/>							
						<div id="btn-sec">
							<button class="btn btn-primary" id="cbtn" onclick="history.back()">취소</button>
							<button  class="btn btn-primary" id="obtn" type="submit">확인</button>
						</div>
						
					</fieldset>
				</form>
			</section>
			<!-- 내용 끝 -->
		<%@ include file="/WEB-INF/inc/footer.jsp"%>
	</div>
</body>
</html>