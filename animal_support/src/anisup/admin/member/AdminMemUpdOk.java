package anisup.admin.member;

import helper.BaseController;
import helper.RegexHelper;
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

@WebServlet("/admin/member/admin_mem_upd_ok.do")
public class AdminMemUpdOk extends BaseController {

	private static final long serialVersionUID = -1996635238983547130L;
	
	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	RegexHelper regex;
	MemberService memberService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		logger=LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession=MyBatisConnectionFactory.getSqlSession();
		web=WebHelper.getInstance(request, response);
		regex=RegexHelper.getInstance();
		memberService=new MemberServiceImpl(sqlSession, logger);
		
		//로그인 여부 검사
		Member loginInfo = (Member) web.getSession("loginInfo");
		if(web.getSession("loginInfo") == null) {
			web.redirect(web.getRootPath()+"/admin/admin_index.do", "로그인 후에 이용 가능합니다.");
		}
		
		String memNewPw=web.getString("new-pw");
		String memNewPwRe=web.getString("new-pw-re");
		String email=web.getString("eamil");
		String birth=web.getString("birth");
		String phone=web.getString("phone");
		String tel=web.getString("tel");
		String postcode=web.getString("postcode");
		String addr1=web.getString("address");
		String addr2=web.getString("address1");
		String pwq=web.getString("select");
		String pwa=web.getString("answer");
		
		logger.debug("memNewPw >> " + memNewPw);
		logger.debug("memNewPwRe >> " + memNewPwRe);
		logger.debug("email >> " + email);
		logger.debug("birth >> " + birth);
		logger.debug("phone >> " + phone);
		logger.debug("tel >> " + tel);
		logger.debug("postcode >> " + postcode);
		logger.debug("addr1 >> " + addr1);
		logger.debug("addr2 >> " + addr2);
		logger.debug("pwq >> " + pwq);
		logger.debug("pwa >> " + pwa);
		
		//신규 비밀번호 검사
		if(regex.isValue(memNewPw)){
			if(memNewPw.length() > 20){
				sqlSession.close();
				web.redirect(null, "새로운 비밀번호는 20자 이내로 초기화 가능");
				return null;
			}
			if(!memNewPw.equals(memNewPwRe)){
				sqlSession.close();
				web.redirect(null, "비밀번호 확인이 잘못되었습니다.");
				return null;
			}		
			
		}//end if
		
		// 이메일 검사
		if (!regex.isValue(email)) {
			sqlSession.close();
			web.redirect(null, "이메일을 입력하세요.");
			return null;
		}

		if (!regex.isEmail(email)) {
			sqlSession.close();
			web.redirect(null, "이메일의 형식이 잘못되었습니다.");
			return null;
		}

		// 연락처 검사
		if (!regex.isValue(tel)) {
			sqlSession.close();
			web.redirect(null, "연락처를 입력하세요.");
			return null;
		}

		if (!regex.isCellPhone(tel) && !regex.isTel(tel)) {
			sqlSession.close();
			web.redirect(null, "연락처의 형식이 잘못되었습니다.");
			return null;
		}

		// 생년월일 검사
		if (!regex.isValue(birth)) {
			sqlSession.close();
			web.redirect(null, "생년월일을 입력하세요.");
			return null;
		}
		//select 박스 선택값
		if(!regex.isValue(pwq)){
			sqlSession.close();
			web.redirect(null, "비밀번호 질문을 선택해 주세요.");
			return null;
		}
		//질문에 대한 입력값
		if (!regex.isValue(pwa)) {
			sqlSession.close();
			web.redirect(null, "비밀번호 질문에 대한 답을 입력해 주세요.");
			return null;
		}
		
		return null;
	}
}
