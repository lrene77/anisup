package anisup.controller.login;

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
import helper.BaseController;
import helper.WebHelper;


@WebServlet("/login/login_ok.do")
public class LoginOk extends BaseController {

	private static final long serialVersionUID = -3890731156324962353L;
	
	/**helper + service 객체 선언*/
	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	MemberService memberService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**helper + service 객체 생성*/
		
		logger=LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession=MyBatisConnectionFactory.getSqlSession();
		web=WebHelper.getInstance(request, response);
		memberService=new MemberServiceImpl(sqlSession, logger);
		
		//로그인 여부
		if(web.getSession("loginInfo") != null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/index.do", "이미 로그인 하셨습니다.");
			return null;
		}
		
		String Id=web.getString("user_id");
		String Pw=web.getString("user_pw");
		String mType = null;
		
		logger.debug("Id= "+Id);
		logger.debug("Pw= "+Pw);
		
		
		if(Id == null || Pw == null) {
			sqlSession.close();
			web.redirect(null, "아이디나 비밀번호가 없습니다.");
			return null;
		}
		
		Member member = new Member();
		member.setId(Id);
		member.setPw(Pw);
		member.setMtype(mType);
		

		Member loginInfo = null;
		
		try {
			loginInfo=memberService.selectLoginInfo(member);
		}catch(Exception e) {
			sqlSession.close();
			web.redirect(null, e.getLocalizedMessage());
			return null;
		}
	
		web.setSession("loginInfo", loginInfo);
		
		String movePage=request.getHeader("referer");
		movePage =web.getRootPath()+"/index.do";
		
		sqlSession.close();
		web.redirect(movePage, null);
		return null;

	}
}
