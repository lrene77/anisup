$(function() {
   $('.summernote').summernote({
      height: 500,          // 기본 높이값
      minHeight: null,      // 최소 높이값(null은 제한 없음)
      maxHeight: null,      // 최대 높이값(null은 제한 없음)
      focus: true,          // 페이지가 열릴때 포커스를 지정함
      lang: 'ko-KR'         // 한국어 지정(기본값은 en-US)
    });
});

// $(function(){
// 	$("#obtn").click(function(){

// 		if(!$("textarea[name='title']").val()){
// 			alert("후원내역을 입력해주세요.");
// 			$("textarea[name='title']").focus();
// 			return false;
// 		}	
		
// 	});
	
// });