package anisup.controller.sup;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import anisup.dao.MyBatisConnectionFactory;
import anisup.model.Member;
import helper.BaseController;
import helper.WebHelper;

/**
 * Servlet implementation class SupWrite
 */
@WebServlet("/sup/sup_write.do")
public class SupWrite extends BaseController {

	private static final long serialVersionUID = 3503073861555125563L;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		return "sup/sup_write";
	}
	
}
