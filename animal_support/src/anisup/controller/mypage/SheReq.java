package anisup.controller.mypage;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import anisup.dao.MyBatisConnectionFactory;
import anisup.model.ReqJoin;
import anisup.service.ReqJoinService;
import anisup.service.impl.ReqJoinServiceImpl;
import helper.BaseController;
import helper.WebHelper;
/** 보호소 입양 신청서 목록 리스트  >>>> 입양신청서 상세보기 페이지 이동**/
@WebServlet("/mypage/she_req.do")
public class SheReq extends BaseController {
	private static final long serialVersionUID = -4849277459408337699L;
	
	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	ReqJoinService reqJoinService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) {
	
		
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		reqJoinService = new ReqJoinServiceImpl(sqlSession,logger);
		
		// 로그인 중이 아니라면 이 페이지를 동작시켜서는 안된다.
		if(web.getSession("loginInfo") == null) {
			web.redirect(web.getRootPath() + "/index.do","로그인하세요");
			return null;
		}	
		
		ReqJoin reqJoin = new ReqJoin();
		List<ReqJoin> reqList = null;

		
		try {
			reqList = reqJoinService.sheMyReqList(reqJoin);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			sqlSession.close();
		}
		
		request.setAttribute("reqList",reqList);
		return "mypage/she_req";
	}

}
