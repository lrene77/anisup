package anisup.controller;

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
import anisup.model.ListboardMember;
import anisup.service.AniService;
import anisup.service.ListboardJoinService;
import anisup.service.impl.AniServiceImpl;
import anisup.service.impl.ListboardJoinServiceImpl;
import helper.BaseController;
import helper.PageHelper;
import helper.UploadHelper;
import helper.WebHelper;

@WebServlet("/index.do")
public class Index extends BaseController {
	private static final long serialVersionUID = 8215669117758608508L;

	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	ListboardJoinService listboardJoinService;
	AniService aniService;
	UploadHelper upload;
	PageHelper pageHelper;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession=MyBatisConnectionFactory.getSqlSession();
		web=WebHelper.getInstance(request, response);
		listboardJoinService=new ListboardJoinServiceImpl(sqlSession, logger);
		aniService=new AniServiceImpl(sqlSession, logger);
		upload=UploadHelper.getInstance();
		pageHelper=PageHelper.getInstance();
		
		List<ListboardMember> nList = null; //공지사항 최근 게시물
		List<ListboardMember> aList = null; //입양후기 최근 게시물
		List<ListboardMember> sList = null; //후원후기 최근 게시물
		List<Ani> aniList=null;	//입양리스트 최근 게시물

		
		try{
			nList=this.getListboardList("n", 5);
			aList=this.getListboardList("a", 5);
			sList=this.getListboardList("s", 5);
			aniList=this.getAniList("aniList", 5);
		}catch(Exception e){
			web.redirect(null, e.getLocalizedMessage());
		}
		
		List<Ani> aniMain = null;
		Ani ani = new Ani();
		int page=web.getInt("page", 1);
		int totalCount=0;
		
		try{
			totalCount=aniService.selectAniCount(ani);
			
			pageHelper.pageProcess(page, totalCount, 5, 5);
					
			ani.setLimitStart(pageHelper.getLimitStart());
			ani.setListCount(pageHelper.getListCount());
			aniMain=aniService.selectAniList(ani);
			
		}catch(Exception e){
			web.redirect(null, e.getLocalizedMessage());
		}finally {
			sqlSession.close();			
		}
		
		if(aniMain != null) {
			for(int i = 0; i < aniMain.size();i++) {
				Ani item = aniMain.get(i);
				String imagePath = item.getFile();
				if(imagePath != null){
					String thumbPath = upload.createThumbnail(imagePath, 320, 480, true);
					item.setFile(thumbPath);
					logger.debug("썸네일 가져와라 >>> " + item.getFile());
				}
			}
		}
		request.setAttribute("nList", nList);
		request.setAttribute("aList", aList);
		request.setAttribute("sList", sList);
		request.setAttribute("aniList", aniList);
		request.setAttribute("aniMain", aniMain);
		
		return "index";
		
	}

	private List<Ani> getAniList(String aniList, int aniCount) {
		List<Ani> anilist=null;
		
		Ani anifilelist = new Ani();
		
		anifilelist.setLimitStart(0);
		anifilelist.setListCount(aniCount);
		
		
		return anilist;
	}

	private List<ListboardMember> getListboardList(String listcate, int listCount) throws Exception {
		List<ListboardMember> list = null;

		ListboardMember listboardmember = new ListboardMember();

		listboardmember.setListcate(listcate);
		listboardmember.setLimitStart(0);
		listboardmember.setListCount(listCount);

		list = listboardJoinService.getListboardJoinList(listboardmember);
		return list;
	}

}