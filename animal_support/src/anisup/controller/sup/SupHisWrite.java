package anisup.controller.sup;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import anisup.dao.MyBatisConnectionFactory;
import anisup.service.SupGiveService;
import helper.BaseController;
import helper.WebHelper;

/**
 * Servlet implementation class SupHisWrite
 */
@WebServlet("/sup/sup_his_write.do")
public class SupHisWrite extends BaseController {

	private static final long serialVersionUID = -6821306651601681630L;

	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	SupGiveService supGiveService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		
		int supNo = web.getInt("supno");
		String supTitle = web.getString("suptitle");
		int supnow = web.getInt("supnow");
		
		request.setAttribute("supNo", supNo);
		request.setAttribute("supTitle", supTitle);
		request.setAttribute("supnow", supnow);
		
		return "sup/sup_his_write";
	}

}
