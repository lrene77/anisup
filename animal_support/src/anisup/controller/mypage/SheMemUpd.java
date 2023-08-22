package anisup.controller.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.BaseController;
import helper.WebHelper;

/**
 * Servlet implementation class SheMemUpd
 */
@WebServlet("/mypage/she_mem_upd.do")
public class SheMemUpd extends BaseController {
	private static final long serialVersionUID = 4213279121817386201L;
	
	/** (1) 사용하고자 하는 Helper 객체 선언 **/
	WebHelper web;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/** (2) 사용하고자 하는 Helper+Service 객체 생성 **/
		web = WebHelper.getInstance(request, response);
		
		/** (3) 로그인 여부 검사 **/
		// 로그인 중이 아니라면 이 페이지를 동작시켜서는 안된다.
		if(web.getSession("loginInfo") == null) {
			web.redirect(web.getRootPath() + "/index.do","로그인하세요");
			return null;
		}
		return "mypage/she_mem_upd";
	}
}
