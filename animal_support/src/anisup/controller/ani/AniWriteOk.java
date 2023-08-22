package anisup.controller.ani;

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
import anisup.model.Ani;
import anisup.model.File;
import anisup.model.Member;
import anisup.service.AniService;
import anisup.service.FileService;
import anisup.service.impl.AniServiceImpl;
import anisup.service.impl.FileServiceImpl;
import helper.BaseController;
import helper.FileInfo;
import helper.RegexHelper;
import helper.UploadHelper;
import helper.WebHelper;

@WebServlet("/ani/ani_write_ok.do")
public class AniWriteOk extends BaseController {
	private static final long serialVersionUID = -4235503297285050472L;

	/** (1) 사용하고자 하는 Helper 객체 선언 */
	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	UploadHelper upload;
	RegexHelper regex;
	FileService fileService;
	AniService aniService;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/** (2) 사용하고자 하는 Helper+Service 객체 생성 */
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		upload = UploadHelper.getInstance();
		regex = RegexHelper.getInstance();
		fileService = new FileServiceImpl(sqlSession, logger);
		aniService = new AniServiceImpl(sqlSession, logger);

		/** (3) 파일이 포함된 POST 파라미터 받기 */
		try {
			upload.multipartRequest(request);
		} catch (Exception e) {
			sqlSession.close();
			web.redirect(null, "multipart 데이터가 아닙니다.");
			return null;
		}

		/** (4) UploadHelper에서 텍스트 형식의 값을 추출 */
		Map<String, String> paramMap = upload.getParamMap();
		
		String title = paramMap.get("title");
		String fileAdd = paramMap.get("file_add");
		String aniName = paramMap.get("ani_name");
		String aniGender = paramMap.get("ani_gender");
		String aniAge = paramMap.get("ani_age");
		String text = paramMap.get("text");
		int memberId = 0;

		// 로그인 한 경우, 회원 일련번호를 세션정보로 대체
		Member loginInfo = (Member) web.getSession("loginInfo");
		if (loginInfo != null) {
			memberId = loginInfo.getMno();
		}

		// 전달된 파라미터는 로그로 확인한다.
		logger.debug("title=" + title);
		logger.debug("file_add=" + fileAdd);
		logger.debug("ani_name=" + aniName);
		logger.debug("ani_gender=" + aniGender);
		logger.debug("ani_age=" + aniAge);
		logger.debug("text=" + text);
		logger.debug("memberId=" + memberId);

		/** (7) 입력 받은 파라미터에 대한 유효성 검사 */
		if (!regex.isValue(title)) {
			sqlSession.close();
			web.redirect(null, "글 제목을 입력하세요.");
			return null;
		}

		if (!regex.isValue(aniName)) {
			sqlSession.close();
			web.redirect(null, "동물 이름을 입력하세요.");
			return null;
		}

		if (!regex.isValue(aniGender)) {
			sqlSession.close();
			web.redirect(null, "동물 성별을 입력하세요.");
			return null;
		}
		if (!(aniGender.equals("X") || aniGender.equals("Y"))) {
			sqlSession.close();
			web.redirect(null, "동물 성별 형식이 잘못됬습니다.");
			return null;
		}

		if (!regex.isValue(aniAge)) {
			sqlSession.close();
			web.redirect(null, "동물 나이를 입력하세요.");
			return null;
		}
		if (!regex.isNum(aniAge)) {
			sqlSession.close();
			web.redirect(null, "동물 나이는 숫자로만 입력해주세요.");
			return null;
		}
		
		if (!regex.isValue(text)) {
			sqlSession.close();
			web.redirect(null, "내용을 입력하세요.");
			return null;
		}

		/** (8) 입력 받은 파라미터를 Beans로 묶기 */
		Ani ani = new Ani();
		ani.setMno(memberId);
		ani.setAnititle(title);
		ani.setAniname(aniName);
		ani.setAnigender(aniGender);
		ani.setAniage(Integer.parseInt(aniAge));
		ani.setAnicont(text);
		ani.setAnicount(0);
		ani.setAnistat("대기");
		
		logger.debug("ani >> " + ani.toString());

		/** (9) Service를 통한 게시물 저장 */
		try {
			aniService.addAni(ani);
		} catch (Exception e) {
			sqlSession.close();
			web.redirect(null, e.getLocalizedMessage());
			return null;
		}

		/** (10) 첨부파일 목록 처리 */
		// 업로드 된 파일 목록
		// --> import study.jsp.helper.FileInfo;
		List<FileInfo> fileList = upload.getFileList();
		
		try {
			for(int i = 0; i < fileList.size(); i++) {
				FileInfo info = fileList.get(i);
				
				File file = new File();
				
				file.setAnino(ani.getAnino());
				
				// 데이터 복사
				file.setOrigin_name(info.getOrginName());
				file.setFile_dir(info.getFileDir());
				file.setFile_name(info.getFileName());
				file.setContent_type(info.getContentType());
				file.setFile_size(info.getFileSize());
				
				fileService.addAniFile(file);
			}
		}catch(Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		}finally {
			sqlSession.close();
		}
		
		// 읽어들일 게시물을 식별하기 위한 게시물 일련번호값을 전달해야 한다.
		String url = "%s/ani/ani_list.do";
		url = String.format(url, web.getRootPath());
		web.redirect(url, "글 작성이 완료되었습니다.");
		return null;
	}

}
