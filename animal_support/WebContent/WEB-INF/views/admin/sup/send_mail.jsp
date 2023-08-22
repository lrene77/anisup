<%@page import="helper.MailHelper"%>
<%@page import="helper.RegexHelper"%>
<%@page import="helper.WebHelper"%>
<%@page import="javax.mail.MessagingException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<%
	/** 헬퍼 객체 생성  **/
	WebHelper web = WebHelper.getInstance(request, response);
	RegexHelper regex = RegexHelper.getInstance();
	/** 사용자의 입력값 받기 **/
	String sender = web.getString("sender");
	String receiver = web.getString("receiver");
	String subject = web.getString("subject");
	String content = web.getString("content");

	
	/** 입력여부 검사후, 입력되지 않은 경우 이전 페이지로 보내기 **/
	if(!regex.isValue(sender)){
		web.redirect(null,"보내는 사람의 이메일 주소를 입력하세요.");
		return;
	}
	
	if(!regex.isEmail(sender)){
		web.redirect(null,"보배는 사람의 이메일 주소가 잘못되었습니다.");
		return;
	}
	
	// 받는 메일 주소 검사하기
	if(!regex.isValue(receiver)){
		web.redirect(null,"받는 사람의 이메일 주소를 입력하세요.");
		return;
	}
	
	if(!regex.isEmail(receiver)){
		web.redirect(null,"받는 사람의 이메일 주소가 잘못되었습니다.");
		return;
	}
	
	// 메일 제목 --> null 체크도 입력 여부를 확인할 수 있다.
	if(subject == null){
		web.redirect(null,"메일 제목을 입력하세요.");
		return;
	}
	
	// 메일 내용 --> null 체크도 입력 여부를 확인할 수 있다.
	if(content == null){
		web.redirect(null,"메일의 내용을 입력하세요.");
		return;
	}
	
	/** 메일 발송 처리 **/
	try{
		// sendMail() 메서드 선언시 throws를 정의했기 떄문에 예외처리가 요구된다
		MailHelper.getInstance().sendMail(sender,receiver,subject,content);
	} catch(MessagingException e){
		e.printStackTrace();
		web.redirect(null,"메일 발송에 실패했습니다.");
		return;
	}
	/** 결과처리 **/
	web.redirect("admin_sup_list.do","반려 메일 발송에 성공했습니다.");
%>
<!doctype html>
<html>
<head>
	<%@ include file="/WEB-INF/inc/admin/admin_head.jsp"%>
</head>
<body>
</body>
</html>