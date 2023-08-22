package anisup.controller.ani;

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
import anisup.model.File;
import anisup.service.AniService;
import anisup.service.FileService;
import anisup.service.impl.AniServiceImpl;
import anisup.service.impl.FileServiceImpl;
import helper.BaseController;
import helper.UploadHelper;
import helper.WebHelper;

/**
 * Servlet implementation class Ani_Det
 */
@WebServlet("/ani/ani_det.do")
public class AniDet extends BaseController {
	private static final long serialVersionUID = 1L;

	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	AniService aniService;
	FileService fileService;
	UploadHelper upload;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		aniService = new AniServiceImpl(sqlSession, logger);
		fileService = new FileServiceImpl(sqlSession, logger);
		upload = UploadHelper.getInstance();
		
		int aniId = web.getInt("ani_id");
		if (aniId == 0) {
			sqlSession.close();
			web.redirect(null, "글 번호가 지정되지 않았습니다.");
			return null;
		}
		
		String aniFile = web.getString("ani_file");

		Ani ani = new Ani();
		ani.setAnino(aniId);

		Ani readAni = null;

		try {
			readAni = aniService.selectAniRead(ani);
		} catch (Exception e) {
			sqlSession.close();
			web.redirect(null, e.getLocalizedMessage());
			return null;
		}

		File file = new File();

		List<File> fileList = null;

		try {
			fileList = fileService.selectAniList(file);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		readAni.setFile(aniFile);

		/** (7) 조회 결과를 View에 전달 */
		request.setAttribute("fileList", fileList);
		request.setAttribute("ani", readAni);

		return "ani/ani_det";
	}
}
