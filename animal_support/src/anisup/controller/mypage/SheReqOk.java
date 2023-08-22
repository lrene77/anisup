package anisup.controller.mypage;

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
import anisup.model.ReqJoin;
import anisup.service.ReqJoinService;
import anisup.service.impl.ReqJoinServiceImpl;
import helper.BaseController;
import helper.WebHelper;

@WebServlet("/mypage/she_req_ok.do")
public class SheReqOk extends BaseController {
	private static final long serialVersionUID = 175469422068820574L;
	
	/** 사용할 객체 **/
	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	ReqJoinService reqJoinService;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/** 사용할 객체 **/
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		reqJoinService = new ReqJoinServiceImpl(sqlSession,logger);
		
		ReqJoin reqJoin = new ReqJoin();
		ReqJoin req = null;

		int reqno = web.getInt("reqno");
		if(reqno == 0) {
			sqlSession.close();
			web.redirect(null,"신청서 번호가 없습니다.");
			return null;
		}
		
		reqJoin.setReqno(reqno);
		
		
		//로그인 여부 검사
		Member loginInfo = (Member) web.getSession("loginInfo");
		// 로그인 중이라면 이 페이지를 동작시켜서는 안된다.
		if (loginInfo == null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/index.do", "로그인 후에 이용 가능합니다.");
			return null;
		}
		
		
		try {
			req = reqJoinService.selectReqRead(reqJoin);
		} catch (Exception e) {
			sqlSession.close();
			web.redirect(null, e.getLocalizedMessage());
			return null;
		}finally {
			sqlSession.close();
		}
		
		request.setAttribute("req",req);
		request.setAttribute("reqno",reqno);
		return "mypage/she_req_ok";
	}
}
