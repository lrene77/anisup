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
			$("#collapseOne").addClass("in").attr("style", "height : auto");
			$("#collapseTwo").removeClass("in").attr("style", "height : 0px");
			alert("후원 주제를 입력해주세요.");
			$("#title").focus();
			return false;
		}
		
		if(!$("#start_date").val()){
			$("#collapseOne").addClass("in").attr("style", "height : auto");
			$("#collapseTwo").removeClass("in").attr("style", "height : 0px");
			alert("후원 시작일을 입력해주세요.");
			$("#start_date").focus();
			return false;
		}
		
		if(!$("#end_date").val()){
			$("#collapseOne").addClass("in").attr("style", "height : auto");
			$("#collapseTwo").removeClass("in").attr("style", "height : 0px");
			alert("후원 종료일을 입력해주세요.");
			$("#end_date").focus();
			return false;
		}

		if(!$("#money").val()){
			$("#collapseOne").addClass("in").attr("style", "height : auto");
			$("#collapseTwo").removeClass("in").attr("style", "height : 0px");
			alert("목표 금액을 입력해주세요.");
			$("#money").focus();
			return false;
		}

		if($("select[name='bank'] > option:selected").index() < 1){
			$("#collapseTwo").addClass("in").attr("style", "height : auto");
			$("#collapseOne").removeClass("in").attr("style", "height : 0px");
			alert("은행을 선택해주세요.");
			$("select[name='bank']").focus();
			return false;
		}

		if(!$("#account").val()){
			//href="#collapseTwo";
			$("#collapseTwo").addClass("in").attr("style", "height : auto");
			$("#collapseOne").removeClass("in").attr("style", "height : 0px");
			alert("계좌번호를 입력해주세요.");
			$("#account").focus();
			return false;
		}

		if(!$("#give_name").val()){
			$("#collapseTwo").addClass("in").attr("style", "height : auto");
			$("#collapseOne").removeClass("in").attr("style", "height : 0px");
			alert("예금자를 입력해주세요.");
			$("#give_name").focus();
			return false;
		}

		if(confirm("후원 글작성을 완료하시겠습니까?")){
			location.href="sup.html";
		}		
	});	
});