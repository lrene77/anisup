package anisup.controller.sup;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import anisup.dao.MyBatisConnectionFactory;
import anisup.model.Sup;
import anisup.service.SupService;
import anisup.service.impl.SupServiceImpl;
import helper.BaseController;
import helper.RegexHelper;
import helper.WebHelper;

/**
 * Servlet implementation class SupHisWriteOk
 */
@WebServlet("/sup/sup_his_write_ok.do")
public class SupHisWriteOk extends BaseController {
	private static final long serialVersionUID = 1L;
       
	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	SupService supService;
	RegexHelper regex;	
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		supService = new SupServiceImpl(sqlSession, logger);
		regex = RegexHelper.getInstance();
				
		int supNo = web.getInt("supno");
		String writing = web.getString("writing");
		
		/** 입력값의 유효성 검사  */
		// 후원금액 입력 & 숫자 검사
		if (!regex.isValue(writing)) {
			sqlSession.close();
			web.redirect(null, "사용 내역을 입력하세요.");
			return null;
		}

		/** 전달받은 파라미터를 Beans 객체에 담는다. */
		Sup sup = new Sup();
		sup.setSupno(supNo);
		sup.setSupbill(writing);
		
		/** Service를 통한 데이터베이스 저장 처리 */
		try {
			// SupMapper에 Bill값 추가
			supService.editSupBill(sup);
		} catch (Exception e) {
			sqlSession.close();
			web.redirect(null, e.getLocalizedMessage());
		} finally {
			sqlSession.close();
		}
		
		/** 저장 완료 후 후원리스트 페이지로 이동하기 */
		web.redirect("sup_list.do", "작성이 완료 되었습니다.");
		
		return null;
	}
}
