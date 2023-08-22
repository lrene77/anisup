package anisup.admin.sup;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import anisup.dao.MyBatisConnectionFactory;
import anisup.model.Sup;
import anisup.service.SupService;
import anisup.service.impl.SupServiceImpl;
import helper.BaseController;
import helper.PageHelper;
import helper.UploadHelper;
import helper.WebHelper;

@WebServlet("/admin/sup/send_mail.do")
public class SendMail extends BaseController {
	
	private static final long serialVersionUID = -7685949313734122569L;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		return "admin/sup/send_mail";
	}

}
