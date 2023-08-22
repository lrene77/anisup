package anisup.controller.listboard;

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
import anisup.model.ListboardMember;
import anisup.service.ListboardJoinService;
import anisup.service.ListboardService;
import anisup.service.impl.ListboardJoinServiceImpl;
import anisup.service.impl.ListboardServiceImpl;
import helper.BaseController;
import helper.PageHelper;
import helper.WebHelper;

/**
 * Servlet implementation class Listboard
 */
@WebServlet("/listboard/list_list.do")
public class Listboards extends BaseController {
	private static final long serialVersionUID = -3187163451770342756L;
	Logger logger;
	SqlSession sqlSession;
	
	WebHelper web;
	LISTCommon list;
	
	ListboardJoinService listboardJoinService;
	PageHelper pageHelper;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		
		web = WebHelper.getInstance(request, response);
		list = LISTCommon.getInstance();
		
		listboardJoinService = new ListboardJoinServiceImpl(sqlSession, logger);
		pageHelper = PageHelper.getInstance();
		
		/**(3)*/
		String listcate = web.getString("listcate");
		request.setAttribute("listcate", listcate);
		
		/**(4)*/
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
		
		/**(5)*/
		String text = web.getString("text");
		
		ListboardMember listboard = new ListboardMember();
		listboard.setListcate(listcate);
		
		int page = web.getInt("page", 1);
		
		listboard.setListtitle(text);
		listboard.setListcont(text);
		
		/**(6)*/
		int totalCount = 0;
		List<ListboardMember> listboardList = null;
		try {
			totalCount = listboardJoinService.selectListboardJoinCount(listboard);
			
			pageHelper.pageProcess(page, totalCount, 15, 5);
			
			listboard.setLimitStart(pageHelper.getLimitStart());
			listboard.setListCount(pageHelper.getListCount());
			
			listboardList = listboardJoinService.getListboardJoinList(listboard);
		}catch(Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		}finally {
			sqlSession.close();
		}
		
		/**(7)*/
//		logger.debug("listboard=" + listboard.toString());
		request.setAttribute("listboardList", listboardList);
		request.setAttribute("text", text);
		request.setAttribute("pageHelper", pageHelper);
		
		return "listboard/listboard";
	}

}
