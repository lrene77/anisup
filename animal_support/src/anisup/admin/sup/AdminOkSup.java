package anisup.admin.sup;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import anisup.dao.MyBatisConnectionFactory;
import anisup.model.SupMember;
import anisup.service.SupJoinService;
import anisup.service.impl.SupJoinServiceImpl;
import helper.BaseController;
import helper.PageHelper;
import helper.UploadHelper;
import helper.WebHelper;

/**
 * Servlet implementation class AdminOkSup
 */
@WebServlet("/admin/sup/admin_ok_sup.do")
public class AdminOkSup extends BaseController {

	private static final long serialVersionUID = 8488949348093415412L;

	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	UploadHelper upload;
	SupJoinService supJoinService;
	PageHelper pageHelper;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		upload = UploadHelper.getInstance();
		supJoinService = new SupJoinServiceImpl(sqlSession, logger);
		pageHelper = PageHelper.getInstance();
		
		int totalCount = 0;
		List<SupMember> supmemberList = null;
		
		SupMember supmember = new SupMember();
					
		supmember.setSupno(web.getInt("supno"));
						
		// 현재 페이지 수 --> 기본값은 1페이지로 설정함
		int page = web.getInt("page", 1);
		
//		String supstat = web.getString("kind");	
//		if(!supstat.equals("전체")) {
//			supmember.setSupstat(supstat);
//		}		
//		String date1 = web.getString("sc1");
//		String date2 = web.getString("sc2");
//		supmember.setSupstart(date1);
//		supmember.setSupend(date2);
		
		try {
			supJoinService.updateSup(supmember);
			
			// 전체 게시물 수
			totalCount = supJoinService.selectSupMemberCount(supmember);

			// 나머지 페이지 번호 계산하기
			// --> 현재 페이지, 전체 게시물 수, 한 페이지의 목록 수, 그룹갯수
			pageHelper.pageProcess(page, totalCount, 12, 5);

			// 페이지 번호 계산 결과에서 Limit절에 필요한 값을 Beans에 추가
			supmember.setLimitStart(pageHelper.getLimitStart());
			supmember.setListCount(pageHelper.getListCount());

			supmemberList = supJoinService.selectSupMemberList(supmember);
			
		}catch(Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		}finally {
			sqlSession.close();
		}
		
		// 진행률 계산
		// 각각의 프로젝트 글의 D-day 계산
		if (supmemberList != null) {
			for (int i = 0; i < supmemberList.size(); i++) {
				SupMember item = supmemberList.get(i);
				
				/** 후원 D-day 계산 */
				String start = item.getSupstart();
				String end = item.getSupend();

				// D-day 계산
				try {
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					Date beginDate = formatter.parse(start);
					Date endDate = formatter.parse(end);

					// 시간차이를 시간,분,초를 곱한 값으로 나누면 하루 단위가 나옴
					long diff = endDate.getTime() - beginDate.getTime();
					long diffDays = diff / (24 * 60 * 60 * 1000);

					item.setSupDays(diffDays);
					logger.debug("날짜차이=>>>>>>>>" + diffDays);

				} catch (java.text.ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					e.printStackTrace();
				}

				/** 진행률 계산 */
				item.setSuping((int) (((float) item.getSupnow() / (float) item.getSupprice()) * 100));

			}
		}
		
		/** 조회 결과를 view에 전달 */
		request.setAttribute("supmemberList", supmemberList);
		
		// 페이지 번호 계산 결과를 View에 전달
		request.setAttribute("pageHelper", pageHelper);
		

		return "admin/sup/admin_sup_list";
	}
	
}
