package anisup.controller.mypage;

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
import anisup.model.AniJoin;
import anisup.model.Member;
import anisup.service.AniJoinService;
import anisup.service.impl.AniJoinServiceImpl;
import helper.BaseController;
import helper.PageHelper;
import helper.WebHelper;

@WebServlet("/mypage/mem_ani_list.do")
public class MemAniList extends BaseController {
	private static final long serialVersionUID = 2757910291406340946L;

	/** (1) 사용하고자 하는 Helper 객체 선언 */
	// --> import org.apache.logging.log4j.Logger;
	Logger logger;
	// --> import org.apache.ibatis.session.SqlSession;
	SqlSession sqlSession;
	// --> import study.jsp.helper.WebHelper;
	WebHelper web;
	// --> import study.jsp.mysite.service.BbsCommentService;
	AniJoinService aniJoinService;
	
	PageHelper pageHelper;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/** (2) 사용하고자 하는 Helper+Service 객체 생성 */
		// --> import org.apache.logging.log4j.LogManager;
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		// --> import study.jsp.mysite.service.impl.MemberServiceImpl;
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		// --> import study.jsp.mysite.service.impl.BbsDocumentServiceImpl;
		aniJoinService = new AniJoinServiceImpl(sqlSession, logger);
		pageHelper = PageHelper.getInstance();
		
		AniJoin aniJoin = new AniJoin();
		List<AniJoin> aniList = null;
		
		
		//로그인 여부 검사
		Member loginInfo = (Member) web.getSession("loginInfo");
		// 로그인 중이라면 이 페이지를 동작시켜서는 안된다.
		if (loginInfo == null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/index.do", "로그인 후에 이용 가능합니다.");
			return null;
		}
		
		int totalCount = 0;
		int page = web.getInt("page", 1);
		
		try {
			// 전체 게시물 수
			totalCount = aniJoinService.selectAniCount(aniJoin);
			// 나머지 페이지 번호 계산하기
			// --> 현재 페이지, 전체 게시물 수, 한 페이지의 목록 수, 그룹갯수
			pageHelper.pageProcess(page, totalCount, 5, 5);
			
			aniJoin.setLimitStart(pageHelper.getLimitStart());
			aniJoin.setListCount(pageHelper.getListCount());
			
			aniList = aniJoinService.selectAniList(aniJoin);	
		
			} catch (Exception e) {
				sqlSession.close();
				web.redirect(null, e.getLocalizedMessage());
				return null;
			}	
		
		try {
			aniList = aniJoinService.mySelectAniList(aniJoin);
		}catch(Exception e) {
			web.redirect(null,e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}

		
		
		loginInfo.getName();
		request.setAttribute("aniList",aniList);
		request.setAttribute("pageHelper", pageHelper);
		
		return "mypage/mem_ani_list";
	}
}
