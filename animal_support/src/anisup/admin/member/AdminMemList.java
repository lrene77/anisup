package anisup.admin.member;

import helper.BaseController;
import helper.WebHelper;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import anisup.dao.MyBatisConnectionFactory;
import anisup.model.Member;
import anisup.service.MemberService;
import anisup.service.impl.MemberServiceImpl;

@WebServlet("/admin/member/admin_mem_list.do")
public class AdminMemList extends BaseController {	

	private static final long serialVersionUID = -3253001916534638479L;
	
	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	MemberService memberService;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		logger=LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession=MyBatisConnectionFactory.getSqlSession();
		web=WebHelper.getInstance(request, response);
		memberService=new MemberServiceImpl(sqlSession, logger);
		
		int mno = web.getInt("mno");
		request.setAttribute("mno", mno);
		
		Member member = new Member();
		member.setMno(mno);
		
		List<Member> adminList = null;
		
		try{
			adminList=memberService.selectAdmin(member);
		}catch(Exception e){
			web.redirect(null, e.getLocalizedMessage());
			return null;
		}finally {
			sqlSession.close();
		}
				
		request.setAttribute("adminList", adminList);
		
		return "admin/member/admin_mem_list";
	}
}
