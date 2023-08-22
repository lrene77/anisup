package anisup.controller.sup;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import anisup.dao.MyBatisConnectionFactory;
import anisup.model.Give;
import anisup.model.Member;
import anisup.model.Sup;
import anisup.service.SupGiveService;
import anisup.service.SupService;
import anisup.service.impl.SupGiveServiceImpl;
import anisup.service.impl.SupServiceImpl;
import helper.BaseController;
import helper.PageHelper;
import helper.RegexHelper;
import helper.UploadHelper;
import helper.WebHelper;

/**
 * Servlet implementation class SupGiveOk
 */
@WebServlet("/sup/sup_give_ok.do")
public class SupGiveOk extends BaseController {

	private static final long serialVersionUID = -1259687986184580071L;

	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	UploadHelper upload;
	SupGiveService supGiveService;
	PageHelper pageHelper;
	RegexHelper regex;	
	SupService supService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		upload = UploadHelper.getInstance();
		supGiveService = new SupGiveServiceImpl(sqlSession, logger);
		pageHelper = PageHelper.getInstance();
		regex = RegexHelper.getInstance();
		supService = new SupServiceImpl(sqlSession, logger);				
		
		/** (3) 파일이 포함된 POST 파라미터 받기 */
		try {
			upload.multipartRequest(request);
		} catch (Exception e) {
			sqlSession.close();
			web.redirect(null, "multipart 데이터가 아닙니다.");
			return null;
		}
		
		// UploadHelper에서 텍스트 형식의 파라미터를 분류한 Map을 리턴받아서 값을 추출한다.
		Map<String, String> paramMap = upload.getParamMap();
		int supno = web.getInt("supno");	
		String suptitle = web.getString("suptitle");
		String giveprice = paramMap.get("giveprice");
		String givebank = paramMap.get("givebank");
		String giveacname = paramMap.get("giveacname");
		String giveacc = paramMap.get("giveacc");		
		String giveId = null;
		
		// 로그인된 세션 정보 받아오기
		Member loginInfo = (Member) web.getSession("loginInfo");
		if(loginInfo != null) {
			giveId = loginInfo.getId();
		}
		
		logger.debug("supno=" + supno);
		logger.debug("giveprice=" + giveprice);
		logger.debug("givebank=" + givebank);
		logger.debug("giveacname=" + giveacname);
		logger.debug("giveacc=" + giveacc);
		logger.debug("giveId=" + giveId);
		
		/** 입력값의 유효성 검사  */
		// 후원금액 입력 & 숫자 검사
		if (!regex.isValue(giveprice)) {
			sqlSession.close();
			web.redirect(null, "후원금액을 입력하세요.");
			return null;
		}
		if (!regex.isNum(giveprice)) {
			sqlSession.close();
			web.redirect(null, "후원금액은 숫자로 입력하세요.");
			return null;
		}
		
		// 은행 선택 검사
		if (!regex.isValue(givebank)) {
			sqlSession.close();
			web.redirect(null, "은행을 선택해주세요.");
			return null;
		}

		// 입금자명은 한글 검사
		if (!regex.isValue(giveacname)) {
			sqlSession.close();
			web.redirect(null, "예금자명을 입력하세요.");
			return null;
		}
		if (!regex.isKor(giveacname)) {
			sqlSession.close();
			web.redirect(null, "입금자명은 한글로 입력하세요.");
			return null;
		}

		// 계좌번호 입력 & 숫자 검사
		if (!regex.isValue(giveacc)) {
			sqlSession.close();
			web.redirect(null, "계좌를 입력하세요.");
			return null;
		}
		if (!regex.isNum(giveacc)) {
			sqlSession.close();
			web.redirect(null, "계좌번호는 숫자만 입력하세요.");
			return null;
		}

		/** 전달받은 파라미터를 Beans 객체에 담는다. */
		Give give = new Give();
		give.setSupno(supno);
		give.setGiveprice(Integer.parseInt(giveprice));
		give.setGivebank(givebank);
		give.setGiveacname(giveacname);
		give.setGiveacc(giveacc);
		give.setGiveid(giveId);
					
		Sup sup = new Sup();
		sup.setSupno(supno);
		
		logger.debug(give.toString());
		
		Sup supItem = null;
		
		/** Service를 통한 데이터베이스 저장 처리 */
		try {
			supGiveService.addSupGive(give);
			supItem = supService.selectSupItem(sup);
		} catch (Exception e) {
			sqlSession.close();
			web.redirect(null, e.getLocalizedMessage());
		}
		
		/** 기부금액 더하기 */
		supItem.setSupnow(supItem.getSupnow() + give.getGiveprice());
		supItem.setSupno(supno);
		
		try {
			supService.updateSupBySupDays(supItem);
		} catch (Exception e) {
			sqlSession.close();
			web.redirect(null, e.getLocalizedMessage());
		}
		
		String url = "%s/sup/sup_give_complete.do?giveno=%d&suptitle=%s";
		url = String.format(url, web.getRootPath(), give.getGiveno(), suptitle);
		
		/** 저장 완료 후 후원리스트 페이지로 이동하기 */
		web.redirect(url, "기부가 완료 되었습니다.");
		
		return null;
	}
	
}
