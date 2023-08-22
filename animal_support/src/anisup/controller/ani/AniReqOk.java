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
import anisup.service.impl.ReqServiceImpl;
import anisup.service.impl.AniServiceImpl;
import helper.BaseController;
import helper.RegexHelper;
import helper.WebHelper;

/**
 * Servlet implementation class Ani_Det
 */
@WebServlet("/ani/ani_req_ok.do")
public class AniReqOk extends BaseController {
	private static final long serialVersionUID = 1L;

	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	RegexHelper regex;
	AniService aniService;
	ReqService reqService;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		regex = RegexHelper.getInstance();
		aniService = new AniServiceImpl(sqlSession, logger);
		reqService = new ReqServiceImpl(sqlSession, logger);

		int aniId = web.getInt("ani_id");
		if (aniId == 0) {
			sqlSession.close();
			web.redirect(null, "글 번호가 지정되지 않았습니다.");
			return null;
		}

		Ani ani = new Ani();
		ani.setAnino(aniId);

		// 로그인중인 회원 정보 가져오기
		Member loginInfo = (Member) web.getSession("loginInfo");

		String reqTitle = web.getString("title");
		String reqJob = web.getString("job");
		String reqCont = web.getString("show");
		String memberName = loginInfo.getName();
		String memberTel = loginInfo.getTel();
		String memberAddr = loginInfo.getAddr1() + loginInfo.getAddr2();
		String isReq = "X";
		int memberId = loginInfo.getMno();
		
		// 전달된 파라미터는 로그로 확인한다.
		logger.debug("title=" + reqTitle);
		logger.debug("name=" + memberName);
		logger.debug("tel=" + memberTel);
		logger.debug("addr=" + memberAddr);
		logger.debug("job=" + reqJob);
		logger.debug("cont=" + reqCont);
		logger.debug("memberId=" + memberId);

		/** (7) 입력 받은 파라미터에 대한 유효성 검사 */
		if (!regex.isValue(reqTitle)) {
			sqlSession.close();
			web.redirect(null, "글 제목을 입력하세요.");
			return null;
		}

		if (!regex.isValue(reqJob)) {
			sqlSession.close();
			web.redirect(null, "직업을 입력하세요.");
			return null;
		}

		if (!regex.isValue(reqCont)) {
			sqlSession.close();
			web.redirect(null, "소개을 입력하세요.");
			return null;
		}

		/** (8) 입력 받은 파라미터를 Beans로 묶기 */
		Req req = new Req();
		req.setMno(loginInfo.getMno());
		req.setAnino(aniId);
		req.setReqtitle(reqTitle);
		req.setReqjob(reqJob);
		req.setReqcont(reqCont);
		req.setIsreq(isReq);
		
		logger.debug("req >> " + req.toString());

		/** (9) Service를 통한 게시물 저장 */
		try {
			// 신청글 저장
			reqService.addReq(req);
			
			// 신청인원 +1
			aniService.editAniCount(ani);
		} catch (Exception e) {
			sqlSession.close();
			web.redirect(null, e.getLocalizedMessage());
			return null;
		}

		// 읽어들일 게시물을 식별하기 위한 게시물 일련번호값을 전달해야 한다.
		String url = "%s/ani/ani_list.do";
		url = String.format(url, web.getRootPath());
		web.redirect(url, "신청이 완료되었습니다.");
		return null;
	}
}
