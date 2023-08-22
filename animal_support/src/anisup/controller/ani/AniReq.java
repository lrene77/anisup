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
import anisup.model.Ani;
import anisup.model.Member;
import anisup.model.Req;
import anisup.service.AniService;
import anisup.service.ReqService;
import anisup.service.impl.AniServiceImpl;
import anisup.service.impl.ReqServiceImpl;
import helper.BaseController;
import helper.WebHelper;

/**
 * Servlet implementation class Ani_Det
 */
@WebServlet("/ani/ani_req.do")
public class AniReq extends BaseController {
	private static final long serialVersionUID = 1L;

	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	AniService aniService;
	ReqService reqService;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		aniService = new AniServiceImpl(sqlSession, logger);
		reqService = new ReqServiceImpl(sqlSession, logger);

		// 로그인중인 회원 정보 가져오기
		Member loginInfo = (Member) web.getSession("loginInfo");
		int aniCount = web.getInt("ani_count");
		String aniStat = web.getString("ani_stat");
		// 로그인 중이 아니라면 이 페이지를 동작시켜서는 안된다.
		if (loginInfo == null) {
			web.redirect(web.getRootPath() + "/ani/ani_list.do", "로그인 후에 이용 가능합니다.");
			return null;
		} else if (aniStat.equals("종료")) {
			web.redirect(web.getRootPath() + "/ani/ani_list.do", "이미 분양된 글입니다.");
			return null;
		} else if (!loginInfo.getMtype().equals("m")) {
			web.redirect(web.getRootPath() + "/ani/ani_list.do", "회원만 신청이 가능합니다.");
			return null;
		} else if (aniCount >= 5) {
			web.redirect(web.getRootPath() + "/ani/ani_list.do", "신청인원이 초과했습니다.");
			return null;
		}

		int aniId = web.getInt("ani_id");
		if (aniId == 0) {
			sqlSession.close();
			web.redirect(null, "글 번호가 지정되지 않았습니다.");
			return null;
		}

		Ani ani = new Ani();
		ani.setAnino(aniId);

		Req req = new Req();
		req.setMno(loginInfo.getMno());
		req.setAnino(aniId);

		Ani readAni = null;
		Req readReq = null;

		try {
			readAni = aniService.selectAniRead(ani);
			readReq = reqService.selectReqRead(req);

			if (readReq != null) {
				if (loginInfo.getMno() == readReq.getMno() && readAni.getAnino() == readReq.getAnino()) {
					sqlSession.close();
					web.redirect(null, "이미 신청한 글 입니다.");
					return null;
				}
			}

			if (loginInfo.getMno() == readAni.getMno()) {
				sqlSession.close();
				web.redirect(null, "본인 글은 신청할 수 없습니다.");
				return null;
			}
		} catch (Exception e) {
			sqlSession.close();
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}

		request.setAttribute("ani", readAni);
		request.setAttribute("req", readReq);

		return "ani/ani_req";
	}
}
