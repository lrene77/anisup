package anisup.controller.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.BaseController;

@WebServlet("/mypage/she_rec_list.do")
public class SheRecList extends BaseController {
	private static final long serialVersionUID = -3793581880364145501L;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "mypage/she_rec_list";
	}
}
