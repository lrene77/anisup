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
import anisup.model.Member;
import anisup.service.AniService;
import anisup.service.impl.AniServiceImpl;
import helper.BaseController;
import helper.PageHelper;
import helper.WebHelper;

/**
 * Servlet implementation class AdAniList
 */
@WebServlet("/admin/ani/admin_ani_search.do")
public class AdminAniSearch extends BaseController {
	private static final long serialVersionUID = 1L;

	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	AniService aniService;
	PageHelper pageHelper;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		aniService = new AniServiceImpl(sqlSession, logger);
		pageHelper = PageHelper.getInstance();

		/** (2) 관리자정보 가져오기 */
		Member loginInfo = (Member) web.getSession("loginInfo");
		request.setAttribute("loginInfo", loginInfo);
		int aniId = web.getInt("ani_id");

		/** (3) 조회할 정보에 대한 Beans 생성 */
		Ani ani = new Ani();
		int totalCount = 0;

		/** (4) 게시글 목록 조회 */
		List<Ani> aniList = null;

		/*
		 * String[] checkBox = web.getStringArray("checkbox");
		 * 
		 * for (String a : checkBox) { logger.debug("배열>>>>>>>>>>>" + a); }
		 * logger.debug("kk>>>>>" + checkBox);
		 */

		// 검색 텍스트 가져오기
		String keyword = web.getString("keyword");

		// 드롭다운 가져오기
		String select = web.getString("select");
		if (select.equals("title")) {
			ani.setAnititle(keyword);
		} else if (select.equals("id")) {
			ani.setId(keyword);
		} else if (select.equals("all")){
			ani.setAnititle(keyword);
			ani.setId(keyword);
		}
		
		// 날짜 가져오기
		String sc1 = web.getString("sc1");
		String sc2 = web.getString("sc2");
		
		if(sc1 != null && sc2 != null){
			ani.setWdate(sc1);
			ani.setWdate2(sc2);
		} else if (sc1 != null && sc2 == null){
			ani.setWdate(sc1);
		} else if (sc1 == null && sc2 != null){
			ani.setWdate2(sc2);
		}
		
		// 라디오 버튼 가져오기
		String radio = web.getString("kind");
		if(!radio.equals("전체")){
			ani.setAnistat(radio);
		}
		
		int page = web.getInt("page", 1);

		try {
			// 전체 게시물 수
			totalCount = aniService.selectAniCount(ani);
			// 나머지 페이지 번호 계산하기
			// --> 현재 페이지, 전체 게시물 수, 한 페이지의 목록 수, 그룹갯수
			pageHelper.pageProcess(page, totalCount, 12, 5);

			ani.setLimitStart(pageHelper.getLimitStart());
			ani.setListCount(pageHelper.getListCount());

			aniList = aniService.selectAniSearch(ani);

		} catch (Exception e) {
			sqlSession.close();
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}

		// 페이지 번호 계산 결과를 View에 전달
		request.setAttribute("pageHelper", pageHelper);
		request.setAttribute("keyword", keyword);
		request.setAttribute("radio", radio);
		request.setAttribute("sc1", sc1);
		request.setAttribute("sc2", sc2);
		request.setAttribute("aniList", aniList);

		return "admin/ani/admin_ani_list";
	}

}
