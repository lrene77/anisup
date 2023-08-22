package anisup.controller.login;

import helper.BaseController;
import helper.Util;
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

@WebServlet("/login/pwsear.do")
public class PwSear extends BaseController {

	private static final long serialVersionUID = -1963917965797295349L;

	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	Util util;
	MemberService memberService;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		util = Util.getInstance();
		memberService = new MemberServiceImpl(sqlSession, logger);

		// 아이디,비밀번호 질문, 비밀번호 힌트, 파라미터 받기
		String Id = web.getString("sear-id");
		String Pwq = web.getString("sear-que");
		String Pwa = web.getString("sear-ans");

		logger.debug("Id= " + Id);
		logger.debug("Pwq = " + Pwq);
		logger.debug("Pwa = >>> 여기까지 되니 " + Pwa);

		if (Id == null || Pwq == null || Pwa == null) {
			sqlSession.close();
			web.redirect(null, "빈칸이 있으면 조회가 불가능 합니다.");
			return null;
		}
		
		// 임시 비밀번호 받기
		String newPassword = Util.getInstance().getRandomPassword();

		Member member = new Member();
		member.setId(Id);
		member.setPwa(Pwa);
		member.setPwq(Pwq);
		member.setPw(newPassword);

		try {
			memberService.updateMemberPassword(member);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}

		web.redirect(web.getRootPath() + "/login/login.do", "회원님의 임시비밀번호는 "+ member.getPw() +"입니다.");
		return null;
	}
}
