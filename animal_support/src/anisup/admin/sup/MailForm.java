package anisup.admin.sup;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import anisup.dao.MyBatisConnectionFactory;
import anisup.model.Sup;
import anisup.service.SupJoinService;
import anisup.service.SupService;
import anisup.service.impl.SupJoinServiceImpl;
import anisup.service.impl.SupServiceImpl;
import helper.BaseController;
import helper.PageHelper;
import helper.UploadHelper;
import helper.WebHelper;

@WebServlet("/admin/sup/mail_form.do")
public class MailForm extends BaseController {
	private static final long serialVersionUID = -167150771354314395L;

	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	UploadHelper upload;
	SupService supService;
	PageHelper pageHelper;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		upload = UploadHelper.getInstance();
		supService = new SupServiceImpl(sqlSession, logger);
		pageHelper = PageHelper.getInstance();
		
		int supno = web.getInt("supno");
		
		Sup sup = new Sup();
		sup.setSupno(supno);
		
		try {
			supService.updateSupBySupStat(sup);
		}catch(Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		}finally {
			sqlSession.close();
		}
		
		
		return "admin/sup/mail_form";
	}

}
