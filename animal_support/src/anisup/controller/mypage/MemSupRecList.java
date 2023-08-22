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
import anisup.model.Sup;
import anisup.model.SupJoin;
import anisup.service.SupJoinService;
import anisup.service.SupService;
import anisup.service.impl.SupJoinServiceImpl;
import anisup.service.impl.SupServiceImpl;
import helper.BaseController;
import helper.PageHelper;
import helper.WebHelper;

@WebServlet("/mypage/mem_sup_rec_list.do")
public class MemSupRecList extends BaseController {
	private static final long serialVersionUID = 2045244644313385626L;

	/** (1) 사용하고자 하는 Helper 객체 선언 **/
	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	SupJoinService supJoinService;
	SupService supService;
	
	PageHelper pageHelper;
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/** (2) 사용하고자 하는 Helper + Service 객체 생성 **/
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		supJoinService = new SupJoinServiceImpl(sqlSession,logger);
		supService = new SupServiceImpl(sqlSession,logger);
		pageHelper = PageHelper.getInstance();
		
		//로그인 여부 검사
		Member loginInfo = (Member) web.getSession("loginInfo");
		// 로그인 중이라면 이 페이지를 동작시켜서는 안된다.
		if (loginInfo == null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/index.do", "로그인 후에 이용 가능합니다.");
			return null;
		}
		
		Sup sup = new Sup();
		SupJoin supJoin = new SupJoin();
		List<SupJoin> supList = null;

		int totalCount = 0;
		int page = web.getInt("page", 1);
		
		try {
			// 전체 게시물 수
			totalCount = supService.selectSupCount();
			// 나머지 페이지 번호 계산하기
			// --> 현재 페이지, 전체 게시물 수, 한 페이지의 목록 수, 그룹갯수
			pageHelper.pageProcess(page, totalCount, 5, 5);
			
			sup.setLimitStart(pageHelper.getLimitStart());
			sup.setListCount(pageHelper.getListCount());
			
		
			} catch (Exception e) {
				sqlSession.close();
				web.redirect(null, e.getLocalizedMessage());
				return null;
			}
		
	
		try {
			supList = supJoinService.mySelectSupList(supJoin);
			} catch(Exception e) {
				web.redirect(null,e.getLocalizedMessage());
				return null;
			} finally {
				sqlSession.close();
			}
	
		
		
	
		request.setAttribute("supList",supList);
		request.setAttribute("pageHelper", pageHelper);
		
		
		return "/mypage/mem_sup_rec_list";

	
	
	}
}
