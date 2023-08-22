package anisup.controller.login;

import java.io.IOException;

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
import helper.BaseController;
import helper.RegexHelper;
import helper.UploadHelper;
import helper.WebHelper;

@WebServlet("/login/shejoin_ok.do")
public class SheJoinOk extends BaseController {

	private static final long serialVersionUID = 3058071697033151958L;
	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	RegexHelper regex;
	UploadHelper upload;
	MemberService memberService;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		regex = RegexHelper.getInstance();
		upload = UploadHelper.getInstance();
		memberService = new MemberServiceImpl(sqlSession, logger);
		
		//로그인 여부 검사
		if(web.getSession("loginInfo") != null){
			sqlSession.close();
			web.redirect(web.getRootPath()+"/index.do", "이미 로그인 하셨습니다.");
			return null;
		}
		
		//파라미터 return
		String check=web.getString("agree");
		String Id = web.getString("id");
		String Pw = web.getString("pw");
		String PwRe = web.getString("pw-re");
		String name = web.getString("name");
		String email = web.getString("email");
		String tel = web.getString("tel");
		String birth = web.getString("birth");
		String phone = web.getString("phone");
		String postcode = web.getString("postcode");
		String addr1 = web.getString("address");
		String addr2 = web.getString("address1");
		String pwq = web.getString("select");
		String pwa = web.getString("answer");
		
		//로그 확인
		logger.debug("check = " + check);
		logger.debug("Id=" + Id);
		logger.debug("Pw=" + Pw);
		logger.debug("PwRe=" + PwRe);
		logger.debug("name=" + name);
		logger.debug("email=" + email);
		logger.debug("tel=" + tel);
		logger.debug("birthdate=" + birth);
		logger.debug("phone= "+phone);
		logger.debug("postcode=" + postcode);
		logger.debug("addr1=" + addr1);
		logger.debug("addr2=" + addr2);
		logger.debug("pwq= "+pwq);
		logger.debug("pwa="+pwa);
		
		//유호성검사
		if (!regex.isValue(Id)) {
			sqlSession.close();
			web.redirect(null, "아이디를 입력하세요.");
			return null;
		}

		if (!regex.isEngNum(Id)) {
			sqlSession.close();
			web.redirect(null, "아이디는 숫자와 영문의 조합으로 20자까지만 가능합니다.");
			return null;
		}

		if (Id.length() > 20) {
			sqlSession.close();
			web.redirect(null, "아이디는 숫자와 영문의 조합으로 20자까지만 가능합니다.");
			return null;
		}

		// 비밀번호 검사
		if (!regex.isValue(Pw)) {
			sqlSession.close();
			web.redirect(null, "비밀번호를 입력하세요.");
			return null;
		}

		if (!regex.isEngNum(Pw)) {
			sqlSession.close();
			web.redirect(null, "비밀번호는 숫자와 영문의 조합으로 20자까지만 가능합니다.");
			return null;
		}

		if (Pw.length() < 6 || Pw.length() > 20) {
			sqlSession.close();
			web.redirect(null, "비밀번호는 숫자와 영문의 조합으로 20자까지만 가능합니다.");
			return null;
		}

		// 비밀번호 확인
		if (!Pw.equals(PwRe)) {
			sqlSession.close();
			web.redirect(null, "비밀번호 확인이 잘못되었습니다.");
			return null;
		}

		// 이름 검사
		if (!regex.isValue(name)) {
			sqlSession.close();
			web.redirect(null, "이름을 입력하세요.");
			return null;
		}

		if (!regex.isKor(name)) {
			sqlSession.close();
			web.redirect(null, "이름은 한글만 입력 가능합니다.");
			return null;
		}

		if (name.length() < 2 || name.length() > 7) {
			sqlSession.close();
			web.redirect(null, "이름은 2~10글자 까지만 가능합니다.");
			return null;
		}

		// 이메일 검사
		if (!regex.isValue(email)) {
			sqlSession.close();
			web.redirect(null, "이메일을 입력하세요.");
			return null;
		}

		if (!regex.isEmail(email)) {
			sqlSession.close();
			web.redirect(null, "이메일의 형식이 잘못되었습니다.");
			return null;
		}

		// 연락처 검사
		if (!regex.isValue(tel)) {
			sqlSession.close();
			web.redirect(null, "연락처를 입력하세요.");
			return null;
		}

		if (!regex.isCellPhone(tel) && !regex.isTel(tel)) {
			sqlSession.close();
			web.redirect(null, "연락처의 형식이 잘못되었습니다.");
			return null;
		}

		// 생년월일 검사
		if (!regex.isValue(birth)) {
			sqlSession.close();
			web.redirect(null, "생년월일을 입력하세요.");
			return null;
		}
		//select 박스 선택값
		if(!regex.isValue(pwq)){
			sqlSession.close();
			web.redirect(null, "비밀번호 질문을 선택해 주세요.");
			return null;
		}
		//질문에 대한 입력값
		if (!regex.isValue(pwa)) {
			sqlSession.close();
			web.redirect(null, "비밀번호 질문에 대한 답을 입력해 주세요.");
			return null;
		}
		//이용약관 확인
		if(!regex.isValue(check)) {
			sqlSession.close();
			web.redirect(null, "이용약관 동의를 해주세요");
			return null;
		}
		

		//빈즈객체에 담는다.
		Member member = new Member();
		member.setId(Id);
		member.setName(name);
		member.setPw(Pw);
		member.setEmail(email);
		member.setBirth(birth);
		member.setPhone(phone);
		member.setTel(tel);
		member.setPostcode(postcode);
		member.setAddr1(addr1);
		member.setAddr2(addr2);
		member.setPwq(pwq);
		member.setPwa(pwa);
		member.setMtype("s");
		
		//db저장
		try {
			memberService.insertMember(member);
		}catch(Exception e) {
			sqlSession.close();
			web.redirect(null, e.getLocalizedMessage());
			return null;
		}
		//회원가입 완료 >> 로그인 페이지로 이동
		sqlSession.close();
		web.redirect(web.getRootPath() + "/login/login.do", "회원가입이 완료되었습니다. 로그인 해주세요.");
		
		return null;
	}

}
