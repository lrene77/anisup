package anisup.controller.mypage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import anisup.dao.MyBatisConnectionFactory;
import anisup.model.Member;
import anisup.model.SupJoin;
import anisup.service.SupJoinService;
import anisup.service.impl.SupJoinServiceImpl;
import helper.BaseController;
import helper.WebHelper;

@WebServlet("/mypage/mem_sup_list.do")
public class MemSupList extends BaseController {
	private static final long serialVersionUID = 1775757591254138120L;
	
	/** 사용할 객체 **/
	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	SupJoinService supJoinService;
	

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/** 사용할 객체 생성 **/
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		supJoinService = new SupJoinServiceImpl(sqlSession,logger);
		
		SupJoin supJoin = new SupJoin();
		List<SupJoin> supList = null;
		
		//로그인 여부 검사
		Member loginInfo = (Member) web.getSession("loginInfo");
		// 로그인 중이라면 이 페이지를 동작시켜서는 안된다.
		if (loginInfo == null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/index.do", "로그인 후에 이용 가능합니다.");
			return null;
		}
		
		try {
			supList = supJoinService.myGiveJoinList(supJoin);
		}catch(Exception e) {
			web.redirect(null,e.getLocalizedMessage());
			return null;
		}finally {
			sqlSession.close();
		}

		loginInfo.getName();
		
		request.setAttribute("supList",supList);
		
		return "mypage/mem_sup_list";
	}
       

}
