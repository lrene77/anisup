package anisup.controller.login;

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

@WebServlet("/login/idsear.do")
public class IdSear extends BaseController {

	private static final long serialVersionUID = 1455109197402719018L;
	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	MemberService memberSerivce;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		memberSerivce = new MemberServiceImpl(sqlSession, logger);

		// 아이디와 생년월일을 받아온다
		String searName = web.getString("sear-name");
		String birth = web.getString("sear-birth");

		logger.debug("searName= " + searName);
		logger.debug("birth= " + birth);

		if (searName == null || birth == null) {
			sqlSession.close();
			web.redirect(null, "빈칸이 있으면 조회가 불가능 합니다.");
			return null;
		}
				
		Member member = new Member();
		member.setName(searName);
		member.setBirth(birth);
		
		try {
			member = memberSerivce.selectIdSear(member);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}


		web.redirect(web.getRootPath() + "/login/login.do", "회원님의 ID는" + member.getId() + "입니다.");
		return null;
	}

}
