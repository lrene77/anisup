	$(function(){
		$("#dbtn").click(function(){
			alert($("input:checkbox[name=ckselect1]:checked").length + "개의 게시글을 삭제하시겠습니까?");
		});
	});
