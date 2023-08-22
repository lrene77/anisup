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
import helper.WebHelper;

@WebServlet("/mypage/she_ani_list.do")
public class SheAniList extends BaseController {
	private static final long serialVersionUID = 753355167603712345L;
	
	Logger logger;
	WebHelper web;
	SqlSession sqlSession;
	AniJoinService aniJoinService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		logger =LogManager.getFormatterLogger(request.getRequestURI());
		web = WebHelper.getInstance(request, response);
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		aniJoinService = new AniJoinServiceImpl(sqlSession,logger);
		
		//로그인 여부 검사
		Member loginInfo = (Member) web.getSession("loginInfo");
		// 로그인 중이라면 이 페이지를 동작시켜서는 안된다.
		if (loginInfo == null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/index.do", "로그인 후에 이용 가능합니다.");
			return null;
		}	
		AniJoin ani = new AniJoin();
		List<AniJoin> aniList = null;	
		
		try {
			aniList = aniJoinService.mySheSupJoinList(ani);
			} catch(Exception e) {
				web.redirect(null,e.getLocalizedMessage());
				return null;
			} finally {
				sqlSession.close();
			}
		
		

		
		request.setAttribute("aniList",aniList);		
		return "mypage/she_ani_list";
		
		
	}
       
}