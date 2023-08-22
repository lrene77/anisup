package anisup.controller.listboard;

import java.io.IOException;

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
import anisup.service.CommentService;
import anisup.service.impl.CommentServiceImpl;
import helper.BaseController;
import helper.WebHelper;

/**
 * Servlet implementation class ListCommentEdit
 */
@WebServlet("/listboard/list_comment_edit.do")
public class ListCommentEdit extends BaseController {
	private static final long serialVersionUID = 8641101080282112619L;
	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	CommentService commentService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/** (2) 사용하고자 하는 Helper+Service 객체 생성 */
		// --> import org.apache.logging.log4j.LogManager;
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		// --> import study.jsp.mysite.service.impl.MemberServiceImpl;
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		commentService = new CommentServiceImpl(sqlSession, logger);
		
		/** (3) 덧글 번호 받기 */
		int commentId = web.getInt("comment_id");
		if (commentId == 0) {
			sqlSession.close();
			web.redirect(null, "덧글 번호가 없습니다.");
			return null;
		}
		
		Comment comment = new Comment();
		comment.setId(commentId);
		
		/**(4)*/
		Comment readComment = null;
		
		try {
			readComment = commentService.selectListComment(comment);
		}catch(Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		}finally {
			sqlSession.close();
		}
		
		/** (5) 읽은 데이터를 View에게 전달한다. */
		request.setAttribute("comment", readComment);
		
		return "listboard/list_comment_edit";
	}

}
