package anisup.controller.listboard;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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
import anisup.model.Member;
import anisup.service.FileService;
import anisup.service.ListboardService;
import anisup.service.impl.FileServiceImpl;
import anisup.service.impl.ListboardServiceImpl;
import helper.BaseController;
import helper.FileInfo;
import helper.RegexHelper;
import helper.UploadHelper;
import helper.WebHelper;

/**
 * Servlet implementation class ListWriteOk
 */
@WebServlet("/listboard/list_write_ok.do")
public class ListWriteOk extends BaseController {
	private static final long serialVersionUID = 747661687092823862L;
	WebHelper web;
	LISTCommon list;
	SqlSession sqlSession;
	Logger logger;
	UploadHelper upload;
	RegexHelper regex;
	ListboardService listboardService;
	FileService fileService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		web = WebHelper.getInstance(request, response);
		list = LISTCommon.getInstance();
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		upload = UploadHelper.getInstance();
		regex = RegexHelper.getInstance();
		listboardService = new ListboardServiceImpl(sqlSession, logger);
		fileService = new FileServiceImpl(sqlSession, logger);
		
		/** 파일이 포함된 POST 파라미터 받기 */
		try {
			upload.multipartRequest(request);
		} catch (Exception e) {
			sqlSession.close();
			web.redirect(null, "multipart 데이터가 아닙니다.");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
		
		/** UploadHelper에서 텍스트 형식의 값을 추출 */
		Map<String, String> paramMap = upload.getParamMap();
		String listcate = paramMap.get("listcate");
		String listtitle = paramMap.get("title");
		String listcont = paramMap.get("content");
		String ipAddress = web.getClientIP();
		int mno = 0;
		
		Member loginInfo = (Member) web.getSession("loginInfo");
		if(loginInfo != null){
			mno = loginInfo.getMno();
		}
		
		
		// 전달된 파라미터는 로그로 확인
		logger.debug("listcate=" + listcate);
		logger.debug("listtitle=" + listtitle);
		logger.debug("listcont=" + listcont);
		logger.debug("ipAddress=" + ipAddress);
		logger.debug("mno=" + mno);
		
		/** 게시판 카테고리 값을 받아서 View에 전달 */
//		String listcate = web.getString("listcate");
		request.setAttribute("listcate", listcate);
		
		/** 존재하는 게시판인지 판별 */
		try {
			String listName = list.getListName(listcate);
			request.setAttribute("listName", listName);
		}catch(Exception e) {
			sqlSession.close();
			web.redirect(null, e.getLocalizedMessage());
			return null;
		}
		
		if(!regex.isValue(listtitle)) {
			sqlSession.close();
			web.redirect(null, "제목을 입력하세요.");
			return null;
		}
		
		if(!regex.isValue(listcont)) {
			sqlSession.close();
			web.redirect(null, "내용을 입력해주세요.");
			return null;
		}
		
		/** 입력 받은 파라미터를 Beans로 묶기 */
		Listboard listboard = new Listboard();
		listboard.setListcate(listcate);
		listboard.setListtitle(listtitle);
		listboard.setListcont(listcont);
		listboard.setIpAddress(ipAddress);
		listboard.setMno(mno);
		logger.debug("listboard >> " + listboard.toString());
		
		/** (9) service를 통한 게시물 저장 */
		try {
//			for(int i=1; i<=15; i++) {
//				listboard.setListtitle(listtitle + "(" + i + ")");
				listboardService.addListboard(listboard);
//			}
		}catch(Exception e) {
			sqlSession.close();
			web.redirect(null, e.getLocalizedMessage());
			return null;
		}
		
		/** 첨부파일 목록 처리 */
		List<FileInfo> fileList = upload.getFileList();
		
		try {
			for(int i = 0; i < fileList.size(); i++) {
				FileInfo info = fileList.get(i);
				
				File file = new File();
				
				file.setListno(listboard.getListno());
				
				// 데이터 복사
				file.setOrigin_name(info.getOrginName());
				file.setFile_dir(info.getFileDir());
				file.setFile_name(info.getFileName());
				file.setContent_type(info.getContentType());
				file.setFile_size(info.getFileSize());
				
				fileService.addListFile(file);
			}
		}catch(Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		}finally {
			sqlSession.close();
		}
		
		/** 저장 완료 후 읽기 페이지로 이동하기 */
		String url = "%s/listboard/list_read.do?listcate=%s&listno=%d";
		url = String.format(url, web.getRootPath(), listboard.getListcate(), listboard.getListno());
		web.redirect(url, null);
		
		return null;
	}

}
