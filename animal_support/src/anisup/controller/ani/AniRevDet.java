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
import helper.BaseController;
import helper.WebHelper;

/**
 * Servlet implementation class Ani_Det
 */
@WebServlet("/ani/ani_rev_det.do")
public class AniRevDet extends BaseController {
	private static final long serialVersionUID = 1L;
       
	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		
		return "ani/ani_rev_det";
	}
}
