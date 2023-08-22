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
import anisup.model.Comment;
import anisup.model.File;
import anisup.model.ListboardMember;
import anisup.service.CommentService;
import anisup.service.FileService;
import anisup.service.ListboardJoinService;
import anisup.service.impl.CommentServiceImpl;
import anisup.service.impl.FileServiceImpl;
import anisup.service.impl.ListboardJoinServiceImpl;
import helper.BaseController;
import helper.UploadHelper;
import helper.WebHelper;

/**
 * Servlet implementation class ListDelete
 */
@WebServlet("/listboard/list_delete.do")
public class ListDelete extends BaseController {
	private static final long serialVersionUID = 6689661291064119089L;
	Logger logger;
	SqlSession sqlSession;
	
	WebHelper web;
	LISTCommon list;
	
	UploadHelper upload;
	ListboardJoinService listboardJoinService;
	CommentService commentService;
	FileService fileService;
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		list = LISTCommon.getInstance();
		upload = UploadHelper.getInstance();
		listboardJoinService = new ListboardJoinServiceImpl(sqlSession, logger);
		commentService = new CommentServiceImpl(sqlSession, logger);
		fileService = new FileServiceImpl(sqlSession, logger);
		
		/**(3)*/
		String listcate = web.getString("listcate");
		request.setAttribute("listcate", listcate);
		
		logger.debug("listcate>>>>>>>>>>>>>>>>" + listcate);
		/**(4)*/
		try {
			String listName = list.getListName(listcate);
			request.setAttribute("listName", listName);
		} catch (Exception e) {
			sqlSession.close();
			web.redirect(null, e.getLocalizedMessage());
			return null;
		}
		
		/**(5)*/
		int listno = web.getInt("listno");
		
		logger.debug("listno>>>>>>>>>>>>>>>>" + listno);
		
		if(listno == 0) {
			sqlSession.close();
			web.redirect(null, "글번호가 없습니다.");
			return null;
		}
		
		/**(6)*/
		ListboardMember listboard = new ListboardMember();
		listboard.setListno(listno);
		listboard.setListcate(listcate);
		
		File file = new File();
		file.setListno(listno);
		
		Comment comment = new Comment();
		comment.setListno(listno);
		
		/**(7)*/
		List<File> fileList = null;
		try {
			fileList = fileService.selectListFileList(file);
			fileService.deleteListFileAll(file);
			commentService.deleteListCommentAll(comment);
			listboardJoinService.deleteListboard(listboard);
		}catch(Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		}finally {
			sqlSession.close();
		}
		
		/**(8)*/
		if(fileList != null) {
			for(int i = 0; i < fileList.size(); i++) {
				File f = fileList.get(i);
				String filePath = f.getFile_dir() + "/" + f.getFile_name();
				logger.debug("fileremove: " + filePath);
				upload.removeFile(filePath);
			}
		}
		
		/**(9)*/
		String url = "%s/listboard/list_list.do?listcate=%s";
		url = String.format(url, web.getRootPath(), listcate);
		
		web.redirect(url, "삭제되었습니다.");
		
		return null;
	}

}
