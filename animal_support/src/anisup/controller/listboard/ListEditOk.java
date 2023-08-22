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
 * Servlet implementation class ListEditOk
 */
@WebServlet("/listboard/list_edit_ok.do")
public class ListEditOk extends BaseController {
	private static final long serialVersionUID = -5441883335217891773L;
	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	LISTCommon list;
	UploadHelper upload;
	ListboardService listboardService;
	FileService fileService;
	RegexHelper regex;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**(2)*/
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		list = LISTCommon.getInstance();
		upload = UploadHelper.getInstance();
		listboardService = new ListboardServiceImpl(sqlSession, logger);
		fileService = new FileServiceImpl(sqlSession, logger);
		regex = RegexHelper.getInstance();
		
		/**(3)*/
		try {
			upload.multipartRequest(request);
		}catch(Exception e) {
			sqlSession.close();
			web.redirect(null, "multipart 데이터가 아닙니다.");
			return null;
		}
		
		/**(4)*/
		Map<String, String> paramMap = upload.getParamMap();
		
		int listno = 0;
		try {
			listno = Integer.parseInt(paramMap.get("listno"));
		}catch(NumberFormatException e) {
			sqlSession.close();
			web.redirect(null, "글번호가 올바르지 않습니다.");
			return null;
		}
		
		String listcate = paramMap.get("listcate");
		String listtitle = paramMap.get("title");
		String listcont = paramMap.get("content");
		String ipAddress = web.getClientIP();
		int mno = 0;
		
		/**(5)*/
		request.setAttribute("listcate", listcate);
		
		/**(6)*/
		try {
			String listName = list.getListName(listcate);
			request.setAttribute("listName", listName);
		}catch(Exception e) {
			sqlSession.close();
			web.redirect(null, e.getLocalizedMessage());
			return null;
		}
		
		/**(7)*/
		Member loginInfo = (Member) web.getSession("loginInfo");
		if(loginInfo != null){
			mno = loginInfo.getMno();
		}
		
		logger.debug("listno>>>>>>>>>>>>>>>" + listno);
		logger.debug("listcate=" + listcate);
		logger.debug("listtitle=" + listtitle);
		logger.debug("listcont=" + listcont);
		logger.debug("ipAddress=" + ipAddress);
		logger.debug("mno=" + mno);
		
		/**(8)*/
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
		
		/**(9)*/
		Listboard listboard = new Listboard();
		listboard.setListno(listno);
		listboard.setListcate(listcate);
		listboard.setListtitle(listtitle);
		listboard.setListcont(listcont);
		listboard.setIpAddress(ipAddress);
		listboard.setMno(mno);
		logger.debug("listboard >> " + listboard.toString());
		
		/**(10)*/
		try {
			listboardService.updateListboard(listboard);
		}catch(Exception e) {
			sqlSession.close();
			web.redirect(null, e.getLocalizedMessage());
			return null;
		}
		
		/**(11)*/
		String delFile = paramMap.get("del_file");
		
		if(delFile != null) {
			String[] delFileList = delFile.split(",");
			
			for(int i = 0; i < delFileList.length; i++) {
				try {
					File file = new File();
					file.setId(Integer.parseInt(delFileList[i]));
					
					File item = fileService.selectFile(file);
					upload.removeFile(item.getFile_dir() + "/" + item.getFile_name());
					
					fileService.deleteFile(file);
				}catch(Exception e) {
					sqlSession.close();
					web.redirect(null, e.getLocalizedMessage());
					return null;
				}
			}
		}
		
		/**(12)*/
		List<FileInfo> fileInfoList = upload.getFileList();
		
		for(int i=0; i<fileInfoList.size(); i++) {
			FileInfo info = fileInfoList.get(i);
			
			File file = new File();
			
			file.setOrigin_name(info.getOrginName());
			file.setFile_dir(info.getFileDir());
			file.setFile_name(info.getFileName());
			file.setContent_type(info.getContentType());
			file.setFile_size(info.getFileSize());
			
			file.setListno(listno);
			
			try {
				fileService.addListFile(file);
			}catch(Exception e) {
				sqlSession.close();
				web.redirect(null, e.getLocalizedMessage());
				return null;
			}
		}
		
		/**(13)*/
		sqlSession.close();
		
		String url = "%s/listboard/list_read.do?listcate=%s&listno=%d";
		url = String.format(url, web.getRootPath(), listcate, listno);
		web.redirect(url, "수정되었습니다.");
		
		return null;
	}

}
