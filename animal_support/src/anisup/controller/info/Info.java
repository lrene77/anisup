package anisup.controller.info;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.BaseController;

/**
 * Servlet implementation class Info
 */
@WebServlet("/info/info.do")
public class Info extends BaseController {
	private static final long serialVersionUID = -7835648172312378734L;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		return "info/info";
	}

}
