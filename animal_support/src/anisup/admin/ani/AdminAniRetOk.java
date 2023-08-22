package anisup.admin.ani;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
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
import helper.WebHelper;

/**
 * Servlet implementation class AdAniList
 */
@WebServlet("/admin/ani/admin_ani_ret_ok.do")
public class AdminAniRetOk extends BaseController {
	private static final long serialVersionUID = 1L;

	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	AniService aniService;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		aniService = new AniServiceImpl(sqlSession, logger);

		/*String[] aniId = web.getStringArray("kk");

		for (String a : aniId) {
			logger.debug("배열>>>>>>>>>>>" + a);
		}
		logger.debug("kk>>>>>" + aniId);*/
		
		int aniId = web.getInt("ani_id");

		Ani ani = new Ani();
		ani.setAnino(aniId);
		ani.setAnistat("진행");

		try {
			aniService.editAniStat(ani);
		} catch (Exception e) {
			sqlSession.close();
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}

		// 읽어들일 게시물을 식별하기 위한 게시물 일련번호값을 전달해야 한다.
		String url = "%s/admin/ani/admin_ani_list.do";
		url = String.format(url, web.getRootPath());
		web.redirect(url, "승인이 완료되었습니다.");
		return null;
	}

}
