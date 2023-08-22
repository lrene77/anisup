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
	$("#obtn").click(function(){

		if(!$("#title").val()){
			alert("제목을 입력해주세요.");
			$("#title").focus();
			return false;
		}		

		// if(!$("#writing").val()){
		// 	alert("예금자를 입력해주세요.");
		// 	$("#writing").focus();
		// 	return false;
		// }

		if(confirm("후원 후기 글작성을 완료하시겠습니까?")){
			location.href="sup_rev_det.html";
		}		
	});	
});