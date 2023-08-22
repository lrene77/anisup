package anisup.admin.ani;

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
import anisup.model.Ani;
import anisup.model.Req;
import anisup.service.ReqService;
import anisup.service.impl.ReqServiceImpl;
import helper.BaseController;
import helper.WebHelper;

/**
 * Servlet implementation class AdAniList
 */
@WebServlet("/admin/ani/admin_ani_req.do")
public class AdminAniReq extends BaseController {
	private static final long serialVersionUID = 1L;
       
	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	ReqService reqService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		reqService = new ReqServiceImpl(sqlSession, logger);
		
		int aniId = web.getInt("ani_id");
		
		Req req = new Req();
		req.setAnino(aniId);
		
		/** (1) 게시글 목록 조회 */
		List<Req> reqRead = null;

		try {
			reqRead = reqService.selectReqList(req);

		} catch (Exception e) {
			sqlSession.close();
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		request.setAttribute("reqRead", reqRead);
		
		return "admin/ani/admin_ani_req";
	}

}
