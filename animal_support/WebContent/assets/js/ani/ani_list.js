/* 메뉴바 hover 적용 */
$(function(){
	$(".dropdown").hover(function(){
		$(this).addClass("open");
	}, function(){
		$(this).removeClass("open");
	});
});

/* 이미지 hover색상변경 */
$(function(){
	$(".thumbnail").hover(function(){
		$(this).css("backgroundColor", "#eee");
	}, function(){
		$(this).css("backgroundColor", "#fff");
	});
});
/* 신청인원 색 조정 */
// $(function(){
// 	var i = $(".caption p span").html();

// 	if (i == 5) {
// 		$(".caption p span").addClass("max");
// 		$(".caption p span").css("color", "red");
// 	} else {
// 		$(".caption p span").removeClass("max");
// 		$(".caption p span").css("color", "blue");
// 	}
// });