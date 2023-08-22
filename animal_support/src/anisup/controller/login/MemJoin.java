package anisup.controller.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.BaseController;
import helper.WebHelper;

@WebServlet("/login/memjoin.do")
public class MemJoin extends BaseController {

	private static final long serialVersionUID = -5750094256490262454L;
	
	WebHelper web;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		web=WebHelper.getInstance(request, response);
		
		//로그인 여부 검사
		if(web.getSession("loginInfo") != null) {
			web.redirect(web.getRootPath() + "/index.do", "이미 로그인 하셨습니다.");
			return null;
		}
		return "login/memjoin";
	}

}
