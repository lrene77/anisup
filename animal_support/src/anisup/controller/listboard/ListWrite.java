package anisup.controller.listboard;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import anisup.model.Member;
import helper.BaseController;
import helper.WebHelper;
/**
 * Servlet implementation class ListWrite
 */
@WebServlet("/listboard/list_write.do")
public class ListWrite extends BaseController {
	private static final long serialVersionUID = -6851639740764880073L;
	/** (1) 사용하고자 하는 Helper 객체 선언 */
	// --> import study.jsp.helper.WebHelper;
	WebHelper web;
	LISTCommon list;
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/** (2) 사용하고자 하는 Helper+Service 객체 생성 */
		web = WebHelper.getInstance(request, response);
		list = LISTCommon.getInstance();
		/** (3) 게시판 카테고리 값을 받아서 View에 전달 */
		String listcate = web.getString("listcate");
		request.setAttribute("listcate", listcate);
		
		/** (4) 존재하는 게시판인지 판별하기 */
		try {
			String listName = list.getListName(listcate);
			request.setAttribute("listName", listName);
			String smallName1 = list.getSmallName1(listcate);
			request.setAttribute("smallName1", smallName1);
			String smallName2 = list.getSmallName2(listcate);
			request.setAttribute("smallName2", smallName2);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		}
		
		Member loginInfo = (Member) web.getSession("loginInfo");
		if(loginInfo == null) {
			web.redirect(null, "관리자가 아닙니다.");
			return null;
		}
		
		logger.debug("id>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + loginInfo.getId());
		if(!loginInfo.getId().equals("admin")) {
			web.redirect(null, "관리자가 아닙니다.");
			return null;
		}
		return "listboard/list_write";
	}
}