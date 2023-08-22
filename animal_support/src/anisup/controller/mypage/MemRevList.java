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

import anisup.controller.listboard.LISTCommon;
import anisup.dao.MyBatisConnectionFactory;
import anisup.model.Listboard;
import anisup.model.Member;
import anisup.service.ListboardService;
import anisup.service.impl.ListboardServiceImpl;
import helper.BaseController;
import helper.PageHelper;
import helper.WebHelper;

@WebServlet("/mypage/mem_rev_list.do")
public class MemRevList extends BaseController {
	private static final long serialVersionUID = 2398423430536520211L;
	
	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	LISTCommon list;
	ListboardService lbs;
	PageHelper pageHelper;
	
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		list = LISTCommon.getInstance();
		lbs = new ListboardServiceImpl(sqlSession,logger);
		pageHelper = PageHelper.getInstance();

		//로그인 여부 검사
		Member loginInfo = (Member) web.getSession("loginInfo");
		// 로그인 중이라면 이 페이지를 동작시켜서는 안된다.
		if (loginInfo == null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/index.do", "로그인 후에 이용 가능합니다.");
			return null;
		}	
		
		
		Listboard listboard = new Listboard();
		List<Listboard> boardList = null;
		
		String listcate = web.getString("listcate");
		request.setAttribute("listcate", listcate);
		
		try {
			String listName = list.getListName(listcate);
			request.setAttribute("listName", listName);
			String smallName1 = list.getSmallName1(listcate);
			request.setAttribute("smallName1", smallName1);
			String smallName2 = list.getSmallName2(listcate);
			request.setAttribute("smallName2", smallName2);
		}catch(Exception e) {
			sqlSession.close();
			web.redirect(null, e.getLocalizedMessage());
			return null;
		}		
		
		try {
			boardList = lbs.selectListboardList(listboard);
		} catch(Exception e) {
			web.redirect(null,e.getLocalizedMessage());
			return null;
		}finally {
			sqlSession.close();
		}

		request.setAttribute("boardList",boardList);
		return "mypage/mem_rev_list";
	}
}
