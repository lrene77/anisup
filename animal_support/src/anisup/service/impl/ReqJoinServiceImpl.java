package anisup.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import anisup.model.Ani;
import anisup.model.ReqJoin;
import anisup.model.Sup;
import anisup.service.ReqJoinService;

public class ReqJoinServiceImpl implements ReqJoinService{
	SqlSession sqlSession;
	Logger logger;
	
	public ReqJoinServiceImpl(SqlSession sqlSession,Logger logger) {
		this.sqlSession = sqlSession;
		this.logger = logger;
	}

	@Override
	public ReqJoin myJoinReq(ReqJoin reqJoin) throws Exception {
		ReqJoin req = null;
		try {
			req = sqlSession.selectOne("ReqJoinMapper.myJoinReq", reqJoin);

			// 중복된 데이터가 존재한다면?
			if (req == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("신청이업습니다.");
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("신청결과 실패.");
		}
		return req;
	}
	
	// 보호소 마이페이지 입양신청서 목록 리스트
	@Override
	public List<ReqJoin> sheMyReqList(ReqJoin reqJoin) throws Exception {
		List<ReqJoin> list = null;
		try {
			list = sqlSession.selectList("ReqJoinMapper.sheMyReqList", reqJoin);
			if(list == null)
				throw new NullPointerException();
		}catch(NullPointerException e) {
			throw new Exception("조회된 글 목록에 없습니다.");
		} catch(Exception e){
			logger.error(e.getLocalizedMessage());
			throw new Exception("글 목록 조회에 실패했습니다.");
		}
		return list;
	}

	@Override
	public ReqJoin selectReqRead(ReqJoin reqJoin) throws Exception {
		ReqJoin result = null;

		try {
			result = sqlSession.selectOne("ReqJoinMapper.selectReqRead", reqJoin);
			if (result == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("조회된 글 목록에 없습니다.");
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("글 목록 조회에 실패했습니다.");
		}
		return result;
	}
}
