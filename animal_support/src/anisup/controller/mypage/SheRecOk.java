package anisup.controller.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.BaseController;

@WebServlet("/mypage/she_rec_ok.do")
public class SheRecOk extends BaseController {

	private static final long serialVersionUID = 175469422068820574L;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "mypage/she_rec_ok";
	}
}
