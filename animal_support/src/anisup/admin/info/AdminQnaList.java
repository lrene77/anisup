package anisup.admin.info;

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
import anisup.model.Member;
import anisup.service.ListboardJoinService;
import anisup.service.impl.ListboardJoinServiceImpl;
import helper.BaseController;
import helper.PageHelper;
import helper.WebHelper;

/**
 * Servlet implementation class AdminQnaList
 */
@WebServlet("/admin/listboard/info/admin_qna_list.do")
public class AdminQnaList extends BaseController {
	private static final long serialVersionUID = -6809307248829144684L;
	Logger logger;
	SqlSession sqlSession;

	WebHelper web;
	ListboardJoinService listboardJoinService;
	PageHelper pageHelper;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MyBatisConnectionFactory.getSqlSession();

		web = WebHelper.getInstance(request, response);
		listboardJoinService = new ListboardJoinServiceImpl(sqlSession, logger);
		pageHelper = PageHelper.getInstance();
		
		String text = web.getString("text");
		String wdate1 = web.getString("wdate1");
		String wdate2 = web.getString("wdate2");
		
		ListboardMember listboard = new ListboardMember();
		int page = web.getInt("page", 1);

		listboard.setListtitle(text);
		listboard.setWdate1(wdate1);
		listboard.setWdate2(wdate2);
		int totalCount = 0;
		List<ListboardMember> listboardList = null;
		try {
			totalCount = listboardJoinService.selectListboardJoinCount3(listboard);
			pageHelper.pageProcess(page, totalCount, 15, 5);
			
			listboard.setLimitStart(pageHelper.getLimitStart());
			listboard.setListCount(pageHelper.getListCount());
			
			listboardList = listboardJoinService.selectListboardJoinList4(listboard);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		request.setAttribute("listboardList", listboardList);
		request.setAttribute("text", text);
		request.setAttribute("wdate1", wdate1);
		request.setAttribute("wdate2", wdate2);
		request.setAttribute("pageHelper", pageHelper);
		
		return "admin/listboard/info/admin_qna_list";
	}

}
