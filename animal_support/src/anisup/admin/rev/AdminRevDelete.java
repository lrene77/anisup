package anisup.admin.rev;

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
 * Servlet implementation class AdminRevDelete
 */
@WebServlet("/admin/listboard/rev/admin_rev_delete.do")
public class AdminRevDelete extends BaseController {
	private static final long serialVersionUID = 759267631902495573L;
	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
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
		upload = UploadHelper.getInstance();
		listboardJoinService = new ListboardJoinServiceImpl(sqlSession, logger);
		commentService = new CommentServiceImpl(sqlSession, logger);
		fileService = new FileServiceImpl(sqlSession, logger);
		
		String[] checkBox = web.getStringArray("checkbox");
		ListboardMember listboard = new ListboardMember();
		File file = new File();
		Comment comment = new Comment();
		List<File> fileList = null;
		
		if(checkBox == null) {
			sqlSession.close();
			web.redirect(null, "삭제할 게시물을 선택해주세요.");
			return null;
		}
		for(String a : checkBox) {
			logger.debug("checkbox >>>>>>>>>>>>>>>" + a);
			
			int b = Integer.parseInt(a);
			listboard.setListno(b);
			
			file.setListno(b);
			
			comment.setListno(b);
			
			/**(7)*/
			try {
				fileList = fileService.selectListFileList(file);
				fileService.deleteListFileAll(file);
				commentService.deleteListCommentAll(comment);
				listboardJoinService.deleteListboard(listboard);
			}catch(Exception e) {
				sqlSession.close();
				web.redirect(null, e.getLocalizedMessage());
				return null;
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
		}
		sqlSession.close();
		
		/**(9)*/
		String url = "%s/admin/listboard/rev/admin_rev_list.do";
		url = String.format(url, web.getRootPath());
		
		web.redirect(url, "삭제되었습니다.");
		
		return null;
	}

}
