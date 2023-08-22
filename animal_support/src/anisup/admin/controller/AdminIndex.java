package anisup.admin.controller;

import helper.BaseController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/admin_index.do")
public class AdminIndex extends BaseController {
	
	private static final long serialVersionUID = -6850084123928846829L;
	
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		return "admin/admin_index";
	}
}
