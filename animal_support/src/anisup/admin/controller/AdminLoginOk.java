package anisup.admin.controller;

import helper.BaseController;
import helper.WebHelper;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import anisup.dao.MyBatisConnectionFactory;
import anisup.model.Member;
import anisup.service.MemberService;
import anisup.service.impl.MemberServiceImpl;

@WebServlet("/admin/admin_login_ok.do")
public class AdminLoginOk extends BaseController {
	
	private static final long serialVersionUID = -5676995841393659002L;
	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	MemberService memberService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		logger=LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession=MyBatisConnectionFactory.getSqlSession();
		web=WebHelper.getInstance(request, response);
		memberService=new MemberServiceImpl(sqlSession, logger);
		
		//로그인 여부
		if(web.getSession("loginInfo") != null){
			sqlSession.close();
			web.redirect(web.getRootPath()+"/admin/admin_index.do", "이미 로그인 하셨습니다.");
			return null;
		}
		
		String adminId=web.getString("admin-id");
		String adminPw=web.getString("admin-pw");
		
		logger.debug("adminId= " + adminId);
		logger.debug("adminPw= " + adminPw);
		
		if(adminId == null || adminPw == null){
			sqlSession.close();
			web.redirect(null, "아이디나 비밀번호가 없습니다.");
			return null;
		}

//		if(adminId != "admin"){
//			sqlSession.close();
//			web.redirect(null, "관리자가 아닙니다 저리 가세요");
//			return null;
//		}
				
		Member member = new Member();
		member.setId(adminId);
		member.setPw(adminPw);
		
		Member loginInfo = null;
		
		try{
			loginInfo=memberService.selectLoginInfo(member);			
		}catch(Exception e){
			sqlSession.close();
			web.redirect(null, e.getLocalizedMessage());
			return null;
		}
		
		web.setSession("loginInfo", loginInfo);
		
		String movePage=request.getHeader("referer");
		movePage=web.getRootPath()+"/admin/member/admin_mem_list.do";
		
		sqlSession.close();
		web.redirect(movePage, "환영합니다 관리자님");
		
		
		return null;
	}
}
