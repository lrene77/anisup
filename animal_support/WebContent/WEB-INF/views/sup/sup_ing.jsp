<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/inc/head.jsp"%>

<!-- sup_ing.css -->
<link rel="stylesheet" type="text/css" href="../assets/css/sup/sup_ing.css">

<!-- 페이지네이션 -->
<link rel="stylesheet" type="text/css" href="../assets/css/pagination.css" />

<!-- 댓글 버튼 hover -->
<link rel="stylesheet" type="text/css" href="../assets/css/btn.css">

</head>

<body>
	<div class="container">
		<%@ include file="/WEB-INF/inc/topbar.jsp"%>

		<br id="space">
		<section>
			<div class="row">
				<div class="col-md-9">
					<span id="head_title">[ 길 위의 천사들에게 희망 전달 프로젝트 ]</span> <br />
					<br />

					<div id="give_box" class="thumbnail hidden-lg hidden-md">
						<ul class="list-inline list-unstyled" style="text-align: center;">
							<li id="li_1"><h5><strong>2016.12.01 ~ 2017.01.31 까지</strong></h5></li>
							<li id="li_2"><h4><strong>D-day</strong></h4></li>
						</ul>
						<ul class="list-inline list-unstyled" style="text-align: center;">
							<li id="li_3"><strong><h4>10,000,000 원 후원</h4></strong></li>
							<li id="li_4"><strong><h4>10,000,000 원 목표</h4></strong></li>
						</ul>
						<a id="btn" href="sup_give.do" class="btn btn-primary"><strong>모금함
								기부하기</strong></a>
					</div>

					<br />
					<br />

					<ul class="nav nav-tabs nav-justified">
						<li id="tab1" class="active"><a href="#" onclick="aa()"
							data-toggle="tab">프로젝트 후원 소개</a></li>
						<li id="tab2"><a href="#" onclick="bb()" data-toggle="tab">기부
								댓글</a></li>
					</ul>

					<div id="sup1" class="in active" style="padding: 15px;">
						<div class="page-header">
							<h3>
								<strong>후원 소개</strong>
							</h3>
						</div>
						<h3>유기견에게 사랑을 주세요</h3>
						<br />
						<p>유기견에게 사랑을 주세요(이하 유사주)는 유기동물들의 안락사를 막고자 뜻이 맞는 봉사자들이 모여 단체를
							개설하였고, 2007년 비영리단체로 등록된 비영리 유기동물보호단체 입니다. 현재 강아지 70여마리와 고양이
							20여마리와 함께 경기도의 쉼터에서 생활하고 있습니다. 아이들은 모두 중성화수술과 기본검사, 병원치료등을 받고
							있으며, 입양홍보를 통해 가정으로의 입양을 도모하고 있습니다.</p>

						<br /> <br />

						<h3>열악한 환경으로 안타깝게 떠나는 생명들...</h3>
						<br />
						<p>유난히도 더웠던 올 여름, 쉼터에는 개농장에서 구조한 40여마리의 아이들이 새로 입소하였습니다. 구조 전
							생활이 굉장히 열악했던 환경탓인지 아이들은 몸과 마음을 쉽사리 열어주지 않았고, 강아지 세마리가 원인을 정확히 알 수
							없는 병으로 무지개 다리를 건너게 되었습니다. 따뜻한 봄에 새끼들과 함께 들어온 냥이 가족들도 손도 써보지 못하고
							허무하게 무지개 다리를 건너고 말았습니다. 이렇게 아픈 아이들이 넘쳐나고 치료와 진료가 시급한 아이들이 넘쳐나지만
							쉽사리 병원에 가지 못합니다.</p>

						<br /> <br />

						<h3>아직도 추운 곳에서 생활하는 아이들</h3>
						<br />
						<p>구조가 되어 실내에서 지내는 아이들이 있지만, 견사의 공간이 부족하여 몇몇의 아이들은 실외 운동장에서
							지내고 있습니다. 이 추운 겨울날 가림막에 의존하여 아이들은 찬바람과 맞서 싸우고 있습니다. 후원을 받아 공사를
							진행하려 하였으나, 추가 비용이 발생하여 공사가 진행되지 못하였고, 임시 가림막을 만들어 놓아 임시 거처만 만들어진
							상태입니다. 허나 날이 조금만 더 추워지더라도 물은 금세 꽁꽁 얼고 아이들은 추위를 견디지 못하고 벌벌 떨고
							있습니다..</p>

						<br /> <br />

						<h3>언제나 부족한 현실, 하지만 포기할 수 없습니다.</h3>
						<br />
						<p>언제나 밀리는 월세, 빠듯하고 부족한 현실입니다. 그렇지만 이 아이들을 구조만 해놓고 모르는척 할 수
							없었습니다. 최대한 힘이 닿는 곳까지 아이들을 위해 저희 봉사자들은 힘을 모아 아이들을 돕겠습니다. 하지만 아직도
							많은 분들의 도움과 관심이 필요합니다. 우리 아이들이 더 아프지 않게, 더 편안하게 살아갈 수 있게 도움이
							필요합니다. 아직 1살도 채 안된 어린 강아지, 고양이와, 평생을 보호소에서 살고 있는 노견, 노묘 아이들이
							많습니다. 가정에서 만큼의 돌봄과 사랑을 받진 못하지만 그래도 줄 수 있을 만큼의 사랑을 주고 싶습니다. 길 위에
							버려진 천사같은 우리 아이들에게 따뜻한 관심과 응원 부탁드립니다.</p>

						<br /> <br />

						<!-- 캐러셀 영역 구성 -->
						<div id="carousel-generic" class="carousel slide"
							data-ride="carousel">
							<!-- 현재 위치 표시 -->
							<ol class="carousel-indicators">
								<li data-target="#carousel-generic" data-slide-to="0"
									class="active"></li>
								<li data-target="#carousel-generic" data-slide-to="1"></li>
								<li data-target="#carousel-generic" data-slide-to="2"></li>
							</ol>

							<!-- 내용 영역 시작 -->
							<div class="carousel-inner">
								<!-- 항목 (1) -->
								<div class="item active">
									<img src="img/slide1.jpg" alt="슬라이더(1)">
								</div>

								<!-- 항목 (2) -->
								<div class="item">
									<img src="img/slide2.jpg" alt="슬라이더(2)">
								</div>

								<!-- 항목 (3) -->
								<div class="item">
									<img src="img/slide3.jpg" alt="슬라이더(3)">
								</div>
							</div>
							<!-- // 내용영역 끝 -->

							<!-- 이동 버튼 -->
							<a class="left carousel-control" href="#carousel-generic"
								data-slide="prev"> <span class="icon-prev"></span>
							</a> <a class="right carousel-control" href="#carousel-generic"
								data-slide="next"> <span class="icon-next"></span>
							</a>
						</div>
						<!-- 캐러셀 영역 끝 -->
					</div>

					<div id="give" style="display: inline;">
						<div class="page-header">
							<h3>
								<strong>후원 내역</strong>
							</h3>
						</div>
						<div class="well well-lg" style>
							피부병 치료비: 300,000 원<br />골절 치료비: 1,000,000 원<br />위암 수술비:
							3,000,000 원<br />다리 수술비: 3,000,000 원<br />심장 수술비 : 2,700,000 원<br />----------------------------------<br />총
							지불 금액: 10,000,000 원
						</div>
						<abbr title="후원 완료시 작성버튼 활성화 됩니다."><button type="button"
								class="btn btn-info pull-right" id="btn_write"
								onclick="location.href='sup_his_write.do'"; >작&nbsp;&nbsp;성</button></abbr>

					</div>

					<br /> <br />

					<!-- 댓글 리스트 시작 -->
					<div id="write1" class="tab-pane">
						<div class="page-header">
							<h3>
								<strong>기부 댓글</strong>
							</h3>
						</div>

						<!-- 댓글 입력 박스 및 댓글 등록버튼 시작 -->
						<!-- 	<table class="table">								
								<tr>
									<td colspan="2" id="noti_com">
										<textarea id="com_content"></textarea>
									</td>
									<td id="noti_com">
										<button class="btn btn-primary" id="com_ok">등&nbsp;&nbsp;록</button>
									</td>
								</tr>
							</table> -->
						<!-- 댓글 입력 박스 및 댓글 등록버튼 끝 -->

						<ul class="row">
							<li class="col-md-10"><textarea></textarea></li>
							<li class="col-md-2"><button type="button"
									class="btn btn-primary">등&nbsp;&nbsp;록</button></li>
						</ul>

						<br />

						<!-- 웹진 박스를 목록으로 구성하기 위한 구조 입니다. -->
						<ul class="media-list">
							<!-- 목록의 개별 항목이 웹진 박스로 구성됩니다. -->
							<li class="media"><a class="pull-left" href="#"> <img
									class="media-object" src="img/id.jpg" width="60" height="60"
									alt="Generic placeholder image">
							</a>
								<div class="media-body">
									<!-- 제목영역의 float 처리를 위한 마감제 박스 -->
									<div class="clearfix">
										<!-- 제목에 float: left 적용 - pull-left -->
										<h4 class="media-heading pull-left">
											주영아 <small>2013-11-20 13:12:32</small>
										</h4>
										<!-- 제목에 float: right 적용 - pull-right -->
										<div class="pull-right">
											<a href="#" title="수정"><i
												class="glyphicon glyphicon-edit"></i></a> <a href="#" title="삭제"><i
												class="glyphicon glyphicon-remove"></i></a>
										</div>
									</div>
									<p>Twitter Bootstrap 정말 좋은 것 같습니다. 이 전에는 힘들게 하던 작업들이 너무 간결해
										졌어요.</p>
								</div></li>
							<!-- 목록의 개별 항목이 웹진 박스로 구성됩니다. -->
							<li class="media"><a class="pull-left" href="#"> <img
									class="media-object" src="img/id.jpg" width="60" height="60"
									alt="Generic placeholder image">
							</a>
								<div class="media-body">
									<div class="clearfix">
										<h4 class="media-heading pull-left">
											이광호 <small>2013-11-20 14:11:51</small>
										</h4>
										<div class="pull-right">
											<a href="#" title="수정"><i
												class="glyphicon glyphicon-edit"></i></a> <a href="#" title="삭제"><i
												class="glyphicon glyphicon-remove"></i></a>
										</div>
									</div>
									<p>jQuery까지 내장되어 있기 때문에, jQuery와 함께 사용한 다면 더 강력한 기능을 만들 수
										있습니다. 이제 복잡한 웹 코딩을 할 필요가 없어요.</p>
								</div></li>
							<!-- 목록의 개별 항목이 웹진 박스로 구성됩니다. -->
							<li class="media"><a class="pull-left" href="#"> <img
									class="media-object" src="img/id.jpg" width="60" height="60"
									alt="Generic placeholder image">
							</a>
								<div class="media-body">
									<div class="clearfix">
										<h4 class="media-heading pull-left">
											홍길동 <small>2013-11-21 09:11:51</small>
										</h4>
										<div class="pull-right">
											<a href="#" title="수정"><i
												class="glyphicon glyphicon-edit"></i></a> <a href="#" title="삭제"><i
												class="glyphicon glyphicon-remove"></i></a>
										</div>
									</div>
									<p>그런가요? 좋은 정보 감사합니다. 한번 써 봐야 겠네요~</p>
								</div></li>
						</ul>

						<br />

						<!-- 페이지번호 (상태표시) -->
						<div align="center">
							<ul class="pagination ">
								<li class="disabled"><a href="#">&laquo;</a></li>
								<li class="active"><span>1 <span class="sr-only">(current)</span></span></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
								<li><a href="#">&raquo;</a></li>
							</ul>
						</div>

						<br />

					</div>
					<!-- 댓글 리스트 끝 -->
				</div>

				<!--  사이드 후원하기 박스 시작  -->
				<div class="col-md-3">
					<aside class="float_sidebar hidden-xs hidden-sm">
						<div style="position: absolute; top: 142px;" class="quick">
							<div class="thumbnail">
								<sapn id="sidebox">
								<div id="box">
									<h1>
										<strong>100%</strong>
									</h1>
									<!-- progress 시작 -->
									<div class="progress">
										<!-- progress-bar-success 적용 -->
										<div class="progress-bar progress-bar-success"
											role="progressbar" aria-valuenow="80" aria-valuemin="0"
											aria-valuemax="100" style="width: 80%">
											<span class="sr-only">100% Complete (success)</span>
										</div>
									</div>
									<!-- progress 끝 -->

									<ul class="list-unstyled" style="text-align: center;">
										<li id="li_1"><h5>
												<strong>2016.12.01 ~ 2017.01.31 까지</strong>
											</h5></li>
										<li id="li_2"><h2>
												<strong>D-day</strong>
											</h2></li>
										<li id="li_3"><strong><h3>10,000,000 원 후원</h3></strong></li>
										<li id="li_4"><strong><h4>10,000,000 원 목표</h4></strong></li>
									</ul>
								</div>
								</span> <a id="btn" href="sup_give.do" class="btn btn-primary"><strong>모금함
										기부하기</strong></a>
							</div>
						</div>
					</aside>
				</div>
				<!--  사이드 후원하기 박스 끝  -->
			</div>
		</section>
		<%@ include file="/WEB-INF/inc/footer.jsp"%>
	</div>


	<!-- 따라다니는 사이드바 시작 -->
	<script>
		$(function(){
		    var $win = $(window);
		    var top = $(window).scrollTop(); // 현재 스크롤바의 위치값을 반환합니다.
		     /*사용자 설정 값 시작*/
		    var speed          = 200;     // 따라다닐 속도 : "slow", "normal", or "fast" or numeric(단위:msec)
		    var easing         = 'linear'; // 따라다니는 방법 기본 두가지 linear, swing
		    var $layer         = $('.float_sidebar'); // 레이어 셀렉팅
		    var layerTopOffset = 0;   // 레이어 높이 상한선, 단위:px
		    $layer.css('position', 'relative').css('z-index', '1');
		    /*사용자 설정 값 끝*/
		     // 스크롤 바를 내린 상태에서 리프레시 했을 경우를 위해
		    if (top > 0 )
		        $win.scrollTop(layerTopOffset+top);
		    else
		        $win.scrollTop(0);
		     //스크롤이벤트가 발생하면
		    $(window).scroll(function(){
		        yPosition = $win.scrollTop() - 150; //이부분을 조정해서 화면에 보이도록 맞추세요
		        if (yPosition < 0)  {
		            yPosition = 0;
		    	}
		        $layer.animate({"top":yPosition }, {duration:speed, easing:easing, queue:false});
		    });
		});
	
		function aa(){
			$("#tab1").click(function(){
				location.href ="#sup1";
			});
		}

		function bb(){
			$("#tab2").click(function(){
				location.href ="#write1";
			});
		}		
			</script>
	<!-- 따라다니는 사이드바 끝 -->

</body>

</html>