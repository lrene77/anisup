package anisup.controller.listboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import anisup.dao.MyBatisConnectionFactory;
import anisup.model.Comment;
import anisup.model.Member;
import anisup.service.CommentService;
import anisup.service.impl.CommentServiceImpl;
import helper.BaseController;
import helper.WebHelper;

/**
 * Servlet implementation class ListCommentDelete
 */
@WebServlet("/listboard/list_comment_delete.do")
public class ListCommentDelete extends BaseController {
	private static final long serialVersionUID = 3172039339609808282L;
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
		
		Member loginInfo = (Member) web.getSession("loginInfo");
		if(loginInfo != null) {
			comment.setMno(loginInfo.getMno());
		}
		
		/** (4) 게시물 일련번호를 사용한 데이터 조회 */	
		// 회원번호가 일치하는 게시물 수 조회하기
		int commentCount = 0; 
		try {
			commentCount = commentService.selectCommentCountByMemberId(comment);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		/** (5) 자신의 글에 대한 요청인지에 대한 여부를 view에 전달 */
		boolean myComment = commentCount > 0;
		logger.debug("myComment = " + myComment);
		request.setAttribute("myComment", myComment);
		
		// 상태유지를 위하여 게시글 일련번호를 View에 전달한다.
		request.setAttribute("commentId", commentId);
		
		return "listboard/list_comment_delete";
	}

}
