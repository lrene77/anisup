package anisup.controller.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.BaseController;
import helper.WebHelper;

@WebServlet("/login/id_pw_sear.do")
public class IdPwSear extends BaseController {

	private static final long serialVersionUID = -800411430444444831L;
	
	WebHelper web;
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		web=WebHelper.getInstance(request, response);
		
		if(web.getSession("loginInfo") != null){
			web.redirect(web.getRootPath()+"/index.do", "이미 로그인 하셨습니다.");
			return null;
		}
		
		return "login/id_pw_sear";
	}

}
