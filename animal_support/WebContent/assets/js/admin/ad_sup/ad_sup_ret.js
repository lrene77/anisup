$(function() {
   $('.summernote').summernote({
      height: 500,          // 기본 높이값
      minHeight: null,      // 최소 높이값(null은 제한 없음)
      maxHeight: null,      // 최대 높이값(null은 제한 없음)
      focus: true,          // 페이지가 열릴때 포커스를 지정함
      lang: 'ko-KR'         // 한국어 지정(기본값은 en-US)
    });
});

$(function(){
	$("#cbtn").click(function(){
		if(confirm("사유 작성을 취소하시겠습니까?")){
			location.href="ad_sup_list.html";
		}					
	});

	$("#sendbtn").click(function(){
		alert("사유가 전달되었습니다.");
		location.href="ad_sup_list.html";
	}); 	
});
