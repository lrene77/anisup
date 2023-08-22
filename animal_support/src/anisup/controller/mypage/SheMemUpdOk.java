package anisup.controller.mypage;

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
import helper.WebHelper;

@WebServlet("/mypage/she_mem_upd_ok.do")
public class SheMemUpdOk extends BaseController {
	private static final long serialVersionUID = 4972967343964287133L;
	
	/**helper + service 객체 선언*/
	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	RegexHelper regex;
	MemberService memberService;	

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		regex = RegexHelper.getInstance();
		memberService = new MemberServiceImpl(sqlSession, logger);	
		
		//로그인 여부 검사
		Member loginInfo = (Member) web.getSession("loginInfo");
		// 로그인 중이라면 이 페이지를 동작시켜서는 안된다.
		if (loginInfo == null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/index.do", "로그인 후에 이용 가능합니다.");
			return null;
		}	
		
		//파라미터 return
		String name = web.getString("she-name");
		String id = web.getString("she-id");
		String Pw = web.getString("she-pw");
		String email = web.getString("she_eamil");
		String tel = web.getString("she-tel");
		String birth = web.getString("she-birthdate");
		String phone = web.getString("she_phone");
		String postcode = web.getString("postcode");
		String addr1 = web.getString("address");
		String addr2 = web.getString("address1");
		String pwq = web.getString("she-re");
		String pwa = web.getString("she-answer");
		
		String newUserPw = web.getString("she-user-pw");
		String newUserPwRe = web.getString("she-user-pw-re");
		
		//로그 확인
		logger.debug("Id=" + id);
		logger.debug("name=" + name);
		logger.debug("Pw=" + Pw);
		logger.debug("email=" + email);
		logger.debug("tel=" + tel);
		logger.debug("birthdate=" + birth);
		logger.debug("phone= "+phone);
		logger.debug("postcode=" + postcode);
		logger.debug("addr1=" + addr1);
		logger.debug("addr2=" + addr2);
		logger.debug("pwq= "+pwq);
		logger.debug("pwa="+pwa);
		
		logger.debug("newUserPw="+newUserPw);
		logger.debug("PwRe=" + newUserPwRe);

		//유호성검사
		/** (5) 입력값의 유효성 검사 (아이디 검사 수행안함) */
		// 현재 비밀번호 검사
		if (!regex.isValue(Pw)) {
			sqlSession.close();
			web.redirect(null, "현재 비밀번호를 입력하세요.");
			return null;
		}
		
		// 신규 비밀번호 검사
		// --> 신규 비밀번호가 입력된 경우는 변경으로 간주하고, 입력하지 않은 경우는
		//     변경하지 않도록 처리한다. 그러므로 입력된 경우만 검사해야 한다.
		if (regex.isValue(newUserPw)) {
			if (!regex.isEngNum(newUserPw) || newUserPw.length() > 20) {
				sqlSession.close();
				web.redirect(null, "새로운 비밀번호는 숫자와 영문의 조합으로 20자까지만 가능합니다.");
				return null;
			}
			
	
			// 비밀번호 확인
		if (!newUserPw.equals(newUserPwRe)) {
			sqlSession.close();
			web.redirect(null, "비밀번호 확인이 잘못되었습니다.");
			return null;
			}
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
		if (!regex.isValue(phone)) {
			sqlSession.close();
			web.redirect(null, "연락처를 입력하세요.");
			return null;
		}

		if (!regex.isCellPhone(phone) && !regex.isTel(phone)) {
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
		
		Member member = new Member();
		member.setId(loginInfo.getId());
		member.setPwq(loginInfo.getPwq());
		
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
		
		// 변경할 신규 비밀번호
		member.setNewUserPw(newUserPw);
		
//		Member editInfo = null;
		try {
			memberService.myUpdateMember(member);
//			editInfo = memberService.selectMember(member);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}		

		// 세션을 갱신한다.
		web.removeSession("loginInfo");

		/** (11) 수정이 완료되었으므로 다시 수정페이지로 이동 */
		web.redirect(web.getRootPath() + "/index.do", "회원정보가 수정되었습니다.");
		
		
		return null;
	}

}
