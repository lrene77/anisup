package anisup.controller.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.BaseController;

@WebServlet("/login/login.do")
public class Login extends BaseController {

	private static final long serialVersionUID = 2599627613669652284L;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "login/login";
	}

}
