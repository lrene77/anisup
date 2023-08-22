package anisup.controller.login;

import helper.BaseController;
import helper.WebHelper;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import anisup.model.Member;

@WebServlet("/login/logout.do")
public class Logout extends BaseController {

	private static final long serialVersionUID = -4978642613901640280L;

	WebHelper web;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		web=WebHelper.getInstance(request, response);
		
		Member loginInfo=(Member) web.getSession("loginInfo");
		
		if(loginInfo == null){
			web.redirect(web.getRootPath()+"/index.do", "로그인 후에 이용 가능합니다.");
			return null;
		}
		
		//로그아웃
		web.removeAllSession();
		web.redirect(web.getRootPath()+"/index.do", "ANIMAL SUPPORT에서 나중에 또 만나요 후원자님.");
		
		return null;
	}

}
