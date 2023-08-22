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
 * Servlet implementation class ListCommentEditOk
 */
@WebServlet("/listboard/list_comment_edit_ok.do")
public class ListCommentEditOk extends BaseController {
	private static final long serialVersionUID = -3703657329179672080L;
	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	CommentService commentService;
	RegexHelper regex;

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
		regex = RegexHelper.getInstance();

		/** (3) 파라미터 받기 */
		int commentId = web.getInt("comment_id");
		String writerName = web.getString("writer_name");
		String content = web.getString("content");
		String ipAddress = web.getClientIP();
		int mno = 0;

		logger.debug("comment_id=" + commentId);
		logger.debug("writer_name=" + writerName);
		logger.debug("content=" + content);
		logger.debug("ipAddress=" + ipAddress);
		logger.debug("mno=" + mno);

		/** (4) 로그인 한 경우 자신의 글이라면 입력하지 않은 정보를 세션 데이터로 대체한다. */
		// 소유권 검사 정보
		boolean myComment = false;

		Member loginInfo = (Member) web.getSession("loginInfo");
		if (loginInfo != null) {
			try {
				// 소유권 판정을 위하여 사용하는 임시 객체
				Comment temp = new Comment();
				temp.setId(commentId);
				temp.setMno(loginInfo.getMno());
				if (commentService.selectCommentCountByMemberId(temp) > 0) {
					// 소유권을 의미하는 변수 변경
					myComment = true;
					// 입력되지 않은 정보들 갱신
					writerName = loginInfo.getName();
					mno = loginInfo.getMno();
				}
			} catch (Exception e) {
				sqlSession.close();
				web.printJsonRt(e.getLocalizedMessage());
				return null;
			}
		}
		// 전달된 파라미터는 로그로 확인한다.
		logger.debug("commentId=" + commentId);
		logger.debug("writer_name=" + writerName);
		logger.debug("content=" + content);
		logger.debug("ipAddress=" + ipAddress);
		logger.debug("mno=" + mno);

		/** (5) 입력 받은 파라미터에 대한 유효성 검사 */
		if (commentId == 0) {
			sqlSession.close();
			web.printJsonRt("덧글 번호가 없습니다.");
			return null;
		}

		if (!regex.isValue(content)) {
			sqlSession.close();
			web.printJsonRt("내용을 입력하세요.");
			return null;
		}

		Comment comment = new Comment();
		comment.setId(commentId);
		comment.setwriterName(writerName);
		comment.setContent(content);
		comment.setIpAddress(ipAddress);
		comment.setMno(mno);
		logger.debug(comment.toString());

		/** (7) 게시물 변경을 위한 Service 기능을 호출 */
		Comment item = null;
		try {
			commentService.updateComment(comment);
			item = commentService.selectListComment(comment);
		} catch (Exception e) {
			web.printJsonRt(e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}

		/** (8) 처리 결과를 JSON으로 출력하기 */
		// 줄바꿈이나 HTML특수문자에 대한 처리
		item.setwriterName(web.convertHtmlTag(item.getwriterName()));
		item.setContent(web.convertHtmlTag(item.getContent()));

		// --> import java.util.HashMap;
		// --> import java.util.Map;
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("rt", "OK");
		data.put("item", item);

		// --> import com.fasterxml.jackson.databind.ObjectMapper;
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getWriter(), data);
		
		return null;
	}

}
