$(function(){
		
//	$("form[name='join']").submit(function(){
	$("#obtn").click(function(){
		if(!$("#give_money").val()){
			alert("금액을 입력해주세요.");
			$("#give_money").focus();
			return false;
		}
		
		if($("select[name='bank'] > option:selected").index() < 1){
			alert("은행을 선택해주세요.");
			$("select[name='bank']").focus();
			return false;
		}
		
		if(!$("#give_name").val()){
			alert("예금주를 입력해주세요.");
			$("#give_name").focus();
			return false;
		}

		if(!$("#juminnum").val()){
			alert("계좌번호를 입력해주세요.");
			$("#juminnum").focus();
			return false;
		}			
		
		if(confirm("후원을 완료하시겠습니까?")){
			location.href="#give-modal";
		}	
	});
	
});