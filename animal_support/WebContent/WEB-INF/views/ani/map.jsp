<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!doctype html>
<html>
<head>
<%@ include file="/WEB-INF/inc/head.jsp"%>
<!-- 개인 CSS -->
<link rel="stylesheet" type="text/css"
	href="../assets/css/ani/ani_total.css">
<link rel="stylesheet" type="text/css" href="../assets/css/ani/map.css">
<!-- 통합 JS -->
<script type="text/javascript" src="../assets/js/ani/total.js"></script>
<!-- 개인 JS -->
<script type="text/javascript" src="../assets/js/ani/map.js"></script>

<!-- 구글 맵 스크립트 참조 -->
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAlc7IuFSW7wK1ZrBWCXVAYGT0GMxeZgpk"></script>
<!-- gmap 플러그인 참조 -->
<script src="../plugins/gmaps/gmaps.min.js"></script>
<script src="../plugins/gmaps/gmaps_helper.js"></script>
<!-- Ajax Helper -->
<link rel="stylesheet" href="../plugins/ajax/ajax_helper.css" />
<script src="../plugins/ajax/ajax_helper.js"></script>
<!-- handlebar plugin -->
<script src="../plugins/handlebars/handlebars-v4.0.5.js"></script>
</head>
<body>
	<div class="container">
		<%@ include file="/WEB-INF/inc/topbar.jsp"%>
		<br class="space">
		<!-- 리스트 시작 -->
		<section>
			<h2 class="noti">보호소지도</h2>
			<small>AS의 입양 게시판입니다.</small>
			<hr>
			<div class="row">

				<div class="col-md-7">
					<div id="gmap" style="height: 400px"></div>

				</div>

				<div class="col-md-5">
					<table class="table">
						<div class="col-md-12">
							<form id="find-form">
								<div class="input-group">
									<label for="dropdown1" style="margin-bottom: 20px;">시 /
										구 &nbsp;</label> <select type="dropdown" id="dropdown1">
										<option value="">선택하세요</option>
										<option value="서울">서울</option>
										<option value="경기">경기</option>
										<option value="부산">부산</option>
									</select> <label for="dropdown2" style="margin-bottom: 20px;"></label> <select
										type="dropdown" id="dropdown2">
										<option value="">선택하세요</option>
									</select> <span class="input-group-btn">
										<button class="btn glyphicon glyphicon-search btn btn-default"
											type="submit">검색</button>
									</span>
								</div>
							</form>
						</div>
						<script id="item_tmpl" type="text/x-handlebars-template">
		<div>
			<div class="media" style="width: 180px; height: 255px;">
				<div class="thumbnail">
					<a href="{{placeUrl}}">
						<img class="media-object" src="{{imageUrl}}">
					</a>
					<div class="caption">
						<h5 class="media-heading">{{title}}</h5>
						<ul class="list-unstyled">
							<li>주소 : {{address}}</li>
							<li>거리 : {{distance}}M 거리</li>
							<li>연락처 : <a href="tel:{{phone}}">{{phone}}</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</script>

						<script type="text/javascript">
							var map_addr = "";
							var map_title = "";
							var map_icon = "../img/marker.png";
							var map_content = "";
							var lat_value = 0;
							var lng_value = 0;

							var map = createGoogleMap("#gmap", lat_value,
									lng_value);
							GMaps
									.geolocate({
										success : function(position) {
											lat_value = position.coords.latitude;
											lng_value = position.coords.longitude;
											map.setCenter(lat_value, lng_value);

											$
													.get(
															"https://maps.googleapis.com/maps/api/geocode/json",
															{
																latlng : lat_value
																		+ ","
																		+ lng_value,
																key : "AIzaSyAlc7IuFSW7wK1ZrBWCXVAYGT0GMxeZgpk"
															},
															function(json) {
																if (json.status == 'OK') {
																	map_addr = json.results[0].formatted_address;
																	map_content = "<h4>"
																			+ map_addr
																			+ "</h4>";

																	addMapMarker(
																			map,
																			lat_value,
																			lng_value,
																			map_addr,
																			map_icon,
																			map_content);
																}
															});
										},

										error : function(error) {
											alert('위치정보 조회에 실패했습니다. : '
													+ error.message);
										},

										not_supported : function() {
											alert("Geolocation 기능을 지원하지 않는 브라우저 입니다.");
										},

										always : function() {
											console.log("처리 완료됨.");
										}
									});

							$("#find-form")
									.submit(
											function(e) {
												e.preventDefault();

												var keyword = $(
														"#dropdown2 option:selected")
														.val();

												if (!keyword) {
													alert("시 / 구 를 선택해주세요.");
													return false;
												}

												$
														.get(
																"../api/proxy.do",
																{
																	csurl : "http://apis.daum.net/local/v1/search/keyword.json",
																	apikey : 'dbb53d4653a96c9dd6214aee9935973e',
																	query : keyword,
																	location : lat_value
																			+ ","
																			+ lng_value,
																	radius : 20000,
																	image : "only"
																},
																function(json) {
																	var item = json.channel.item;

																	for (var i = 0; i < item.length; i++) {
																		var template = Handlebars
																				.compile($(
																						"#item_tmpl")
																						.html());
																		var html = template(item[i]);

																		addMapMarker(
																				map,
																				item[i].latitude,
																				item[i].longitude,
																				item[i].title,
																				'../img/marker2.png',
																				html);
																	}
																});
											});
						</script>
						<thead>
							<tr style="background-color: #eee;">
								<th class="text-center">보호소 명</th>
								<th class="text-center">전화번호</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="text-center">서울 보호소</td>
								<td class="text-center">02)555-5555</td>
							</tr>
							<tr>
								<td class="text-center">경기 보호소</td>
								<td class="text-center">031)563-5843</td>
							</tr>
							<tr>
								<td class="text-center">부산 보호소</td>
								<td class="text-center">119)517-9894</td>
							</tr>
							<tr>
								<td class="text-center">고흠 보호소</td>
								<td class="text-center">031)215-1885</td>
							</tr>

						</tbody>
					</table>
				</div>
			</div>
		</section>
		<!-- 리스트 종료 -->
		<%@ include file="/WEB-INF/inc/footer.jsp"%>
	</div>
</body>
</html>