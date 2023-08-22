package anisup.controller.sup;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import anisup.dao.MyBatisConnectionFactory;
import anisup.model.File;
import anisup.model.Sup;
import anisup.service.FileService;
import anisup.service.SupService;
import anisup.service.impl.FileServiceImpl;
import anisup.service.impl.SupServiceImpl;
import helper.BaseController;
import helper.UploadHelper;
import helper.WebHelper;

/**
 * Servlet implementation class SupRead
 */
@WebServlet("/sup/sup_read.do")
public class SupRead extends BaseController {

	private static final long serialVersionUID = -8741329368508207014L;

	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	SupService supService;
	FileService fileService;
	UploadHelper upload;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		supService = new SupServiceImpl(sqlSession, logger);
		fileService = new FileServiceImpl(sqlSession, logger);
		upload = UploadHelper.getInstance();

		/** 글 번호 파라미터 받기 */
		int supno = web.getInt("supno");
		if (supno == 0) {
			sqlSession.close();
			web.redirect(null, "글 번호가 지정되지 않았습니다.");
			return null;
		}

		// 파라미터를 Beans로 묶기
		Sup sup = new Sup();
		sup.setSupno(supno);

		File file = new File();
		file.setSupno(supno);

		Sup supItem = null;
		List<File> fileList = null;

		try {
			supItem = supService.selectSupItem(sup);
			fileList = fileService.selectListSupList(file);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}

		// 조회결과가 존재할 경우 --> 이미지 경로를 썸네일로 교체
		if (fileList != null) {
			for (int i = 0; i < fileList.size(); i++) {
				File item = fileList.get(i);
				String imagePath = item.getImagePath();
				if (imagePath != null) {
					String thumbPath = upload.createThumbnail(imagePath, 480, 320, true);
					// 글 목록 컬렉션 내의 Beans 객체가 갖는 이미지 경로를 썸네일로 변경한다.
					item.setImagePath(thumbPath);
					logger.debug("thumbnail create > " + item.getImagePath());
				}
			}
		}

		/** 후원 D-day 계산*/
		String start = supItem.getSupstart();
		String end = supItem.getSupend();
		Date now = new Date();
		logger.debug("오늘 날짜:>>>>>>>" + now);
		
		
//		if(nowDate > start && nowDate < end) {
			try {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date beginDate = formatter.parse(start);
				Date endDate = formatter.parse(end);
				//Date nowDate = formatter.parse(now);
	
				// 시간차이를 시간,분,초를 곱한 값으로 나누면 하루 단위가 나옴
				long diff = endDate.getTime() - beginDate.getTime();
				long diffDays = diff / (24 * 60 * 60 * 1000);
	
				supItem.setSupDays(diffDays);
				logger.debug("날짜차이=>>>>>>>>" + diffDays);
	
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
//		}
			
		/** 진행률 계산 */
		supItem.setSuping((int) (((float) supItem.getSupnow() / (float) supItem.getSupprice()) * 100));

		/** 조회 결과를 view에 전달 */
		request.setAttribute("supItem", supItem);
		request.setAttribute("fileList", fileList);

		return "sup/sup_read";
	}

}
