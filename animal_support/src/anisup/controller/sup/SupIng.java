package anisup.controller.sup;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.BaseController;

/**
 * Servlet implementation class SupIng
 */
@WebServlet("/sup/sup_ing.do")
public class SupIng extends BaseController {

	private static final long serialVersionUID = -3948962317513109550L;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		return "sup/sup_ing";
	}
	
}
