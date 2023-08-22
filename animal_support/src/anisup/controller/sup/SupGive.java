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
import anisup.model.Give;
import anisup.model.Sup;
import anisup.service.SupService;
import anisup.service.impl.SupServiceImpl;
import helper.BaseController;
import helper.UploadHelper;
import helper.WebHelper;

/**
 * Servlet implementation class SupGive
 */
@WebServlet("/sup/sup_give.do")
public class SupGive extends BaseController {

	private static final long serialVersionUID = 2723228386375220825L;

	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	UploadHelper upload;
	SupService supService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		upload = UploadHelper.getInstance();	
		supService = new SupServiceImpl(sqlSession, logger);
		
		int supno = web.getInt("supno");
		Sup sup = new Sup();
		sup.setSupno(supno);
		
		Give give = new Give();
		give.setSupno(supno);
		
		Sup item = null;
		try {
			item = supService.selectSupItem(sup);
		}catch (Exception e) {
			sqlSession.close();
			web.redirect(null, e.getLocalizedMessage());
		}
		
		request.setAttribute("item", item);
		
		return "sup/sup_give";
	}
}
