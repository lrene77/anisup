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
import anisup.model.Member;
import anisup.service.SupGiveService;
import anisup.service.impl.SupGiveServiceImpl;
import helper.BaseController;
import helper.UploadHelper;
import helper.WebHelper;

/**
 * Servlet implementation class SupGiveComplete
 */
@WebServlet("/sup/sup_give_complete.do")
public class SupGiveComplete extends BaseController {

	private static final long serialVersionUID = 4706991162277361946L;

	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	UploadHelper upload;
	SupGiveService supGiveService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		upload = UploadHelper.getInstance();
		supGiveService = new SupGiveServiceImpl(sqlSession, logger);
		
		String name = null;
		// 로그인된 세션 정보 받아오기
		Member loginInfo = (Member) web.getSession("loginInfo");
		if(loginInfo != null) {
			name = loginInfo.getName();
		}
		
		int giveno = web.getInt("giveno");
		String suptitle = web.getString("suptitle");
		
		Give give = new Give();
		give.setGiveno(giveno);
		
		Give item = null;
		
		try {
			item = supGiveService.selectGiveItem(give);
		}catch(Exception e) {
			sqlSession.close();
			web.redirect(null, e.getLocalizedMessage());
		}
		
		request.setAttribute("name", name);
		request.setAttribute("suptitle", suptitle);
		request.setAttribute("item", item);
		
		return "sup/sup_give_complete";
	}
	
}
