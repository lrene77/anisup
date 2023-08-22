package anisup.controller.listboard;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import anisup.dao.MyBatisConnectionFactory;
import anisup.model.Comment;
import anisup.model.Member;
import anisup.service.CommentService;
import anisup.service.impl.CommentServiceImpl;
import helper.BaseController;
import helper.RegexHelper;
import helper.WebHelper;

/**
 * Servlet implementation class ListCommentInsert
 */
@WebServlet("/listboard/list_comment_insert.do")
public class ListCommentInsert extends BaseController {
	private static final long serialVersionUID = -2718194574560350356L;
	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	RegexHelper regex;
	CommentService commentService;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/** (2) */
		response.setContentType("application/json");

		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		regex = RegexHelper.getInstance();
		commentService = new CommentServiceImpl(sqlSession, logger);

		/** (3) */
		int listno = web.getInt("listno");
		String writerName = null;
		String content = web.getString("content");
		String ipAddress = web.getClientIP();
		int mno = 0;

		Member loginInfo = (Member) web.getSession("loginInfo");
		if (loginInfo != null) {
			writerName = loginInfo.getId();
			mno = loginInfo.getMno();
		}

		logger.debug("listno = " + listno);
		logger.debug("writerName = " + writerName);
		logger.debug("content = " + content);
		logger.debug("ipAddress = " + ipAddress);
		logger.debug("mno = " + mno);

		/** (4) */
		if (listno == 0) {
			sqlSession.close();
			web.printJsonRt("게시물 일련번호가 없습니다.");
			return null;
		}

		if (!regex.isValue(content)) {
			sqlSession.close();
			web.printJsonRt("내용을 입력하세요.");
			return null;
		}

		/** (5) */
		Comment comment = new Comment();
		comment.setListno(listno);
		comment.setwriterName(writerName);
		comment.setContent(content);
		comment.setIpAddress(ipAddress);
		comment.setMno(mno);
		logger.debug("comment >>>>>>>>>>>" + comment.toString());

		/** (6) */
		Comment item = null;
		try {
			commentService.addListComment(comment);
			item = commentService.selectListComment(comment);
		} catch (Exception e) {
			web.printJsonRt(e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}

		/** (7) */
		// 줄바꿈이나 HTML특수문자에 대한 처리
		item.setwriterName(web.convertHtmlTag(item.getwriterName()));
		item.setContent(web.convertHtmlTag(item.getContent()));
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("rt", "OK");
		data.put("item", item);

		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getWriter(), data);

		return null;
	}

}
