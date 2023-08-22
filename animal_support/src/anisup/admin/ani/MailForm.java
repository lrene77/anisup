package anisup.admin.ani;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import anisup.dao.MyBatisConnectionFactory;
import anisup.model.Ani;
import anisup.service.AniService;
import anisup.service.impl.AniServiceImpl;
import helper.BaseController;
import helper.PageHelper;
import helper.UploadHelper;
import helper.WebHelper;

@WebServlet("/admin/ani/mail_form.do")
public class MailForm extends BaseController {
	private static final long serialVersionUID = -167150771354314395L;

	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	UploadHelper upload;
	AniService aniService;
	PageHelper pageHelper;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		upload = UploadHelper.getInstance();
		aniService = new AniServiceImpl(sqlSession, logger);
		pageHelper = PageHelper.getInstance();
		
		int anino = web.getInt("ani_id");
		
		Ani ani = new Ani();
		ani.setAnino(anino);
		ani.setAnistat("거절");
		
		try {
			aniService.editAniStat(ani);
		}catch(Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		}finally {
			sqlSession.close();
		}
		
		
		return "admin/ani/mail_form";
	}

}
