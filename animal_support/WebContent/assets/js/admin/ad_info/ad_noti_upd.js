$(function(){
	$("#cbtn").click(function(){
		if(confirm("수정을 취소하시겠습니까?")){
			location.href="ad_noti.html";
		}					
	});

	$("#mbtn").click(function(){
		alert("수정되었습니다.");
		location.href="ad_noti.html";
	}); 	
});