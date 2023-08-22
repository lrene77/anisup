$(function(){
	$("#cbtn").click(function(){
		if(confirm("작성을 취소하시겠습니까?")){
			location.href="ad_noti.html";
		}					
	});

	$("#wbtn").click(function(){

		if(!$("#title").val()){
			alert("제목을 입력해주세요.");
			$("#title").focus();
			return false;
		}

		if(!$("textarea#title").val()){
			alert("내용을 입력해주세요.");
			$("textarea#title").focus();
			return false;
		}

		if(confirm("공지사항 작성을 완료하시겠습니까?")){
			alert("작성이 완료되었습니다.");
			location.href="ad_noti.html";
		}		
	});	
});
