package anisup.admin.ani;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.BaseController;

@WebServlet("/admin/ani/send_mail.do")
public class SendMail extends BaseController {
	
	private static final long serialVersionUID = -7685949313734122569L;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		return "admin/ani/send_mail";
	}

}
