package anisup.admin.controller;

import helper.BaseController;
import helper.WebHelper;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import anisup.model.Member;

@WebServlet("/admin/admin_loginout.do")
public class AdminLoginOut extends BaseController {

	private static final long serialVersionUID = 305190873758707577L;
	WebHelper web;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		web=WebHelper.getInstance(request, response);
		
		Member loginInfo=(Member) web.getSession("loginInfo");
		
		if(loginInfo == null){
			web.redirect(web.getRootPath()+"/admin/admin_index.do", "로그인 후에 이용 가능합니다.");
			return null;
		}
		
		//로그아웃
		web.removeAllSession();
		web.redirect(web.getRootPath()+"/admin/admin_index.do", "관리자님 퇴근하세요");
		
		return null;
	}

}
