$(function(){
	$("#cbtn").click(function(){
		if(confirm("삭제 하시겠습니까?")){
			location.href="${pageContext.request.contextPath}/listboard/list_delete.do?listcate=${listcate}&listno=${readListboard.listno}";
		}		
	});	
});