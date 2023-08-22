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
import anisup.model.Member;
import anisup.model.Sup;
import anisup.service.AniService;
import anisup.service.FileService;
import anisup.service.impl.AniServiceImpl;
import anisup.service.impl.FileServiceImpl;
import helper.BaseController;
import helper.PageHelper;
import helper.UploadHelper;
import helper.WebHelper;

@WebServlet("/ani/ani_list.do")
public class AniList extends BaseController {
	private static final long serialVersionUID = -7786870605257149925L;

	/** (1) 사용하고자 하는 Helper 객체 선언 */
	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	AniService aniService;
	PageHelper pageHelper;
	UploadHelper upload;
	FileService fileService;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/** (1) 사용하고자 하는 Helper+Service 객체 생성 */
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		aniService = new AniServiceImpl(sqlSession, logger);
		pageHelper = PageHelper.getInstance();
		upload = UploadHelper.getInstance();
		fileService = new FileServiceImpl(sqlSession, logger);

		/** (2) 회원정보 가져오기 */
		Member loginInfo = (Member) web.getSession("loginInfo");
		request.setAttribute("loginInfo", loginInfo);
		
		/** (3) 조회할 정보에 대한 Beans 생성 */
		Ani ani = new Ani();

		/** (4) 게시글 목록 조회 */
		int totalCount = 0;
		List<Ani> aniList = null;

		int page = web.getInt("page", 1);

		try {
			// 전체 게시물 수
			totalCount = aniService.selectAniCount(ani);
			// 나머지 페이지 번호 계산하기
			// --> 현재 페이지, 전체 게시물 수, 한 페이지의 목록 수, 그룹갯수
			pageHelper.pageProcess(page, totalCount, 8, 5);

			ani.setLimitStart(pageHelper.getLimitStart());
			ani.setListCount(pageHelper.getListCount());

			aniList = aniService.selectAniList(ani);

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

		// 조회결과가 존재할 경우 --> 이미지 경로를 썸네일로 교체
		if (aniList != null) {
			for (int i = 0; i < aniList.size(); i++) {
				Ani item = aniList.get(i);
				String imagePath = item.getFile();
				if (imagePath != null) {
					String thumbPath = upload.createThumbnail(imagePath, 500, 400, true);
					// 글 목록 컬렉션 내의 Beans 객체가 갖는 이미지 경로를 썸네일로 변경한다.
					item.setFile(thumbPath);
					logger.debug("thumbnail create > " + item.getFile());
				}
			}
		}

		/** (5) 조회 결과를 View에 전달 */
		request.setAttribute("aniList", aniList);
		request.setAttribute("fileList", fileList);
		// 페이지 번호 계산 결과를 View에 전달
		request.setAttribute("pageHelper", pageHelper);

		// 갤러리 종류라면 View의 이름을 다르게 설정한다.
		String view = "ani/ani_list";

		return view;
	}
}
