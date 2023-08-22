package anisup.admin.member;

import helper.BaseController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/member/admin_mem_upd.do")
public class AdminMemUpd extends BaseController {

	private static final long serialVersionUID = -1996635238983547130L;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		return "admin/member/admin_mem_upd";
	}
}
