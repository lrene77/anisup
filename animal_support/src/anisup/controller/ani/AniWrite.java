package anisup.controller.ani;

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
import helper.BaseController;
import helper.WebHelper;

/**
 * Servlet implementation class Ani_Det
 */
@WebServlet("/ani/ani_write.do")
public class AniWrite extends BaseController {
	private static final long serialVersionUID = 1L;

	Logger logger;
	SqlSession sqlSession;
	WebHelper web;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);

		// 로그인중인 회원 정보 가져오기
		Member loginInfo = (Member) web.getSession("loginInfo");
		// 로그인 중이 아니라면 이 페이지를 동작시켜서는 안된다.
		if (loginInfo == null) {
			web.redirect(web.getRootPath() + "/ani/ani_list.do", "로그인 후에 보호소 회원만 이용 가능합니다.");
			return null;
		} else if (loginInfo.getMtype().equals("m")) {
			web.redirect(web.getRootPath() + "/ani/ani_list.do", "보호소만 글 작성이 가능합니다.");
			return null;
		}

		return "ani/ani_write";
	}
}
