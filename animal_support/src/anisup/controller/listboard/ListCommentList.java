package anisup.controller.listboard;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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
import anisup.service.CommentService;
import anisup.service.impl.CommentServiceImpl;
import helper.BaseController;
import helper.WebHelper;

/**
 * Servlet implementation class ListCommentList
 */
@WebServlet("/listboard/list_comment_list.do")
public class ListCommentList extends BaseController {
	private static final long serialVersionUID = 8292516087113142433L;
	// --> import org.apache.logging.log4j.Logger;
	Logger logger;
	// --> import org.apache.ibatis.session.SqlSession;
	SqlSession sqlSession;
	// --> import study.jsp.helper.WebHelper;
	WebHelper web;

	CommentService commentService;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		commentService = new CommentServiceImpl(sqlSession, logger);

		/** (3) 파라미터 받기 */
		int listno = web.getInt("listno");
		logger.debug("listno=" + listno);

		/** (4) 입력 받은 파라미터에 대한 유효성 검사 */
		// 덧글이 소속될 게시물의 일련번호
		if (listno == 0) {
			sqlSession.close();
			web.printJsonRt("게시물 일련번호가 없습니다.");
			return null;
		}

		/** (5) 입력 받은 파라미터를 Beans로 묶기 */
		Comment comment = new Comment();
		comment.setListno(listno);

		/** (6) Service를 통한 덧글 목록 조회 */
		List<Comment> item = null;
		try {
			item = commentService.selectListCommentList(comment);
		} catch (Exception e) {
			web.printJsonRt(e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}

		/** (7) 처리 결과를 JSON으로 출력하기 */
		// 줄바꿈이나 HTML특수문자에 대한 처리
		for (int i = 0; i < item.size(); i++) {
			Comment temp = item.get(i);
			temp.setwriterName(web.convertHtmlTag(temp.getwriterName()));
			temp.setContent(web.convertHtmlTag(temp.getContent()));
		}

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
