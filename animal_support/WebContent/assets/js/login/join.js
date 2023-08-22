$(function() {
	$("input[name='agree']").change(function() {

		$("#result").html("이용약관에 동의 하셨습니다.");		
		if(!$("input[name='agree']").is(":checked")){
			$("#result").html("");
		}
	});
});