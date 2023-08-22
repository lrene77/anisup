// <!-- 메뉴바 hover 적용 -->
$(function(){
	$(".dropdown").hover(function(){
		$(this).addClass("open");
	}, function(){
		$(this).removeClass("open");
	});
});