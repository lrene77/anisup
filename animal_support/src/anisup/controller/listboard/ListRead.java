package anisup.controller.listboard;

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
import anisup.model.File;
import anisup.model.Listboard;
import anisup.model.ListboardMember;
import anisup.model.Member;
import anisup.service.FileService;
import anisup.service.ListboardJoinService;
import anisup.service.ListboardService;
import anisup.service.impl.FileServiceImpl;
import anisup.service.impl.ListboardJoinServiceImpl;
import anisup.service.impl.ListboardServiceImpl;
import helper.BaseController;
import helper.WebHelper;

/**
 * Servlet implementation class ListRead
 */
@WebServlet("/listboard/list_read.do")
public class ListRead extends BaseController {
	private static final long serialVersionUID = 6428199008893203524L;
	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	LISTCommon list;
	ListboardService listboardService;
	ListboardJoinService listboardJoinService;
	FileService fileService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		
		web = WebHelper.getInstance(request, response);
		list = LISTCommon.getInstance();
		
		listboardService = new ListboardServiceImpl(sqlSession, logger);
		listboardJoinService = new ListboardJoinServiceImpl(sqlSession, logger);
		fileService = new FileServiceImpl(sqlSession, logger);
		
		/** (3) 게시판 카테고리 값을 받아서 View에 전달 */
		String listcate = web.getString("listcate");
		request.setAttribute("listcate", listcate);
		
		/** (4) 존재하는 게시판인지 판별하기 */
		try {
			String listName = list.getListName(listcate);
			request.setAttribute("listName", listName);
			String smallName1 = list.getSmallName1(listcate);
			request.setAttribute("smallName1", smallName1);
			String smallName2 = list.getSmallName2(listcate);
			request.setAttribute("smallName2", smallName2);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		}
		
		/** (5) */
		int listno = web.getInt("listno");
		logger.debug("listno=" + listno);
		
		if(listno == 0) {
			web.redirect(null, "글 번호가 지정되지 않았습니다.");
			sqlSession.close();
			return null;
		}
		
//		Listboard listboard = new Listboard();
//		listboard.setListno(listno);
//		listboard.setListcate(listcate);
		
		File file = new File();
		file.setListno(listno);
		
		ListboardMember listmem = new ListboardMember();
		listmem.setListno(listno);
		listmem.setListcate(listcate);
		
		Listboard listboard = new Listboard();
		listboard.setListno(listno);
		listboard.setListcate(listcate);
		
		ListboardMember readListboard = null;
		
		Member loginInfo = (Member) web.getSession("loginInfo");
		if(loginInfo != null) {
			listboard.setMno(loginInfo.getMno());
		}
		
		List<File> fileList = null;
		String cookieKey = "listboard_" + listcate + "_" + listno;
		String cookieVar = web.getCookie(cookieKey);
		
		try {
			if(cookieVar == null) {
				listboardJoinService.updateListboardHit(listmem);
				web.setCookie(cookieKey, "Y", 60 * 60 * 24);
			}
			readListboard = listboardJoinService.getListboardJoinItem(listmem);
			fileList = fileService.selectListFileList(file);
		}catch(Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		}finally {
			sqlSession.close();
		}
		
		request.setAttribute("loginInfo", loginInfo);
		request.setAttribute("readListboard", readListboard);
		request.setAttribute("fileList", fileList);
		
		return "listboard/list_read";
	}

}
