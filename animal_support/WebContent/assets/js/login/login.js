$(function(){
	$(".btn-login-submit").click(function(){
		if(!$("input[name='userId']").val()){
			alert("아이디를 입력해주세요");
			$("input[name='userId']").focus();
			return false;
		}

		if (!$.trim($("input[name='userId']").val()).match("^[a-zA-Z0-9]*$")){
		  alert("아이디는 영문과 숫자만 가능합니다.");
		  $("input[name='userId']").val("").focus();
		  return false;
		}

		if ($.trim($("input[name='userId']").val()).match("^[0-9]*$")){
		  alert("아이디는 숫자로만 이루어질 수 없습니다.");
		  $("input[name='userId']").val("").focus();
		  return false;
		}

		if(!$("input[name='userPw']").val()){
			alert("비밀번호를 입력해주세요");
			$("input[name='userPw']").focus();
			return false;
		}

		if (!$.trim($("input[name='userPw']").val()).match(/^(?=.*\d)(?=.*[A-z])[A-z0-9]{6,20}$/)){
		  alert("비밀번호 숫자와 영문을 섞어 6~20자 이하로 입력하세요!");
		  $("input[name='userPw']").val("").focus();
		  return false;
		}
		var id = $("input[name='userId']").val();
		var pw = $("input[name='userPw']").val();

		return false;
	});
});