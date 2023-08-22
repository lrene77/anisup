package anisup.controller.sup;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import anisup.dao.MyBatisConnectionFactory;
import anisup.model.File;
import anisup.model.Member;
import anisup.model.Sup;
import anisup.service.FileService;
import anisup.service.SupService;
import anisup.service.impl.FileServiceImpl;
import anisup.service.impl.SupServiceImpl;
import helper.BaseController;
import helper.FileInfo;
import helper.RegexHelper;
import helper.UploadHelper;
import helper.WebHelper;

/**
 * Servlet implementation class SupWriteOk
 */
@WebServlet("/sup/sup_write_ok.do")
public class SupWriteOk extends BaseController {

	/** (1) 사용하고자 하는 Helper + Service 객체 선언 */
	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	UploadHelper upload;
	SupService supService;
	FileService fileService;
	RegexHelper regex;	
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/** (2) 사용하고자 하는 Helper+Service 객체 생성 */
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		upload = UploadHelper.getInstance();
		supService = new SupServiceImpl(sqlSession, logger);
		fileService = new FileServiceImpl(sqlSession, logger);
		regex = RegexHelper.getInstance();
				
		/** (3) 파일이 포함된 POST 파라미터 받기 */
		try {
			upload.multipartRequest(request);
		} catch (Exception e) {
			sqlSession.close();
			web.redirect(null, "multipart 데이터가 아닙니다.");
			return null;
		}
		
		// UploadHelper에서 텍스트 형식의 파라미터를 분류한 Map을 리턴받아서 값을 추출한다.
		Map<String, String> paramMap = upload.getParamMap();
		String suptitle = paramMap.get("title");
		String supstart = paramMap.get("start_date");
		String supend = paramMap.get("end_date");
		String supprice = paramMap.get("money");
		String supcont = paramMap.get("writing");
		String supbank = paramMap.get("bank");
		String supacc = paramMap.get("account");
		String supacname = paramMap.get("give_name");
		int memberId = 0;
		
		// 로그인된 세션 정보 받아오기
		Member loginInfo = (Member) web.getSession("loginInfo");
		if(loginInfo != null) {
			memberId = loginInfo.getMno();
		}
		
		logger.debug("suptitle=" + suptitle);
		logger.debug("supStart=" + supstart);
		logger.debug("supEnd=" + supend);
		logger.debug("supPrice=" + supprice);
		logger.debug("supCont=" + supcont);
		logger.debug("supBank=" + supbank);
		logger.debug("supAcc=" + supacc);
		logger.debug("supAcName=" + supacname);
		logger.debug("memberId=" + memberId);
		
		/** (4) 입력값의 유효성 검사 (아이디 검사 수행안함) */
		/** 유효성 테스트 일부는 JS에서 하고 있음 */
		
		// 목표금액 숫자 검사	
		if(!regex.isNum(supprice)) {
			sqlSession.close();
			web.redirect(null, "목표금액은 숫자로 입력하세요.");
			return null;
		}
		
		// 내용 입력 검사
		if (!regex.isValue(supcont)) {
			sqlSession.close();
			web.redirect(null, "내용을 입력하세요.");
			return null;
		}
				
		// 계좌번호 숫자 검사
		if(!regex.isNum(supacc)) {
			sqlSession.close();
			web.redirect(null, "계좌번호는 숫자만 입력하세요.");
			return null;
		}
				
		// 입금자명 한글 검사
		if (!regex.isKor(supacname)) {
			sqlSession.close();
			web.redirect(null, "입금자명은 한글로 입력하세요.");
			return null;
		}
		
				
		/** (6) 업로드 된 파일 정보 추출 */
		
		/** (7) 전달받은 파라미터를 Beans 객체에 담는다. */
		Sup sup = new Sup();
		sup.setSuptitle(suptitle);
		sup.setSupstart(supstart);
		sup.setSupend(supend);
		sup.setSupprice(Integer.parseInt(supprice));
		sup.setSupcont(supcont);
		sup.setSupbank(supbank);
		sup.setSupacc(supacc);
		sup.setSupacname(supacname);
		sup.setMno(memberId);
		sup.setSupstat("진행");
		
		logger.debug(sup.toString());
		
		/** (8) Service를 통한 데이터베이스 저장 처리 */
		try {
			supService.addSup(sup);
		} catch (Exception e) {
			sqlSession.close();
			web.redirect(null, e.getLocalizedMessage());
		}
		
		/** 첨부파일 목록 처리 */
		List<FileInfo> fileList = upload.getFileList();

		try {
			// 업로드 된 파일의 수 만큼 반복 처리 한다.
			for (int i = 0; i < fileList.size(); i++) {
				// 업로드 된 정보 하나 추출하여 데이터베이스에 저장하기 위한 형태로 가공해야 한다.
				FileInfo info = fileList.get(i);

				// DB에 저장하기 위한 항목 생성
				File file = new File();

				// 몇 번 게시물에 속한 파일인지 지정한다.
				file.setSupno(sup.getSupno());
				// 데이터 복사
				file.setOrigin_name(info.getOrginName());
				file.setFile_dir(info.getFileDir());
				file.setFile_name(info.getFileName());
				file.setContent_type(info.getContentType());
				file.setFile_size(info.getFileSize());
								
				// 저장처리
				fileService.addSupFile(file);
			}
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		/** (9) 저장 완료 후 후원리스트 페이지로 이동하기 */
		web.redirect("sup_list.do", "후원 프로젝트 글이 등록 되었습니다.");
		
		return null;
	}
	
}
