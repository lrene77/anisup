$(function(){
	$(".btn-login-submit").click(function(){
		if(!$("input[name='adminId']").val()){
			alert("아이디를 입력해주세요");
			$("input[name='adminId']").focus();
			return false;
		}

		if (!$.trim($("input[name='adminId']").val()).match("^[a-zA-Z0-9]*$")){
		  alert("아이디는 영문과 숫자만 가능합니다.");
		  $("input[name='adminId']").val("").focus();
		  return false;
		}

		if ($.trim($("input[name='adminId']").val()).match("^[0-9]*$")){
		  alert("아이디는 숫자로만 이루어질 수 없습니다.");
		  $("input[name='adminId']").val("").focus();
		  return false;
		}

		if(!$("input[name='adminPw']").val()){
			alert("비밀번호를 입력해주세요");
			$("input[name='adminPw']").focus();
			return false;
		}

		if (!$.trim($("input[name='adminPw']").val()).match(/^(?=.*\d)(?=.*[A-z])[A-z0-9]{6,20}$/)){
		  alert("비밀번호 숫자와 영문을 섞어 6~20자 이하로 입력하세요!");
		  $("input[name='adminPw']").val("").focus();
		  return false;
		}
		var id = $("input[name='adminId']").val();
		var pw = $("input[name='adminPw']").val();

		return false;
	});
});