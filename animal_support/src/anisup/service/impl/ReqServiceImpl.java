package anisup.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import anisup.model.Req;
import anisup.service.ReqService;

public class ReqServiceImpl implements ReqService {

	SqlSession sqlSession;
	Logger logger;

	public ReqServiceImpl(SqlSession sqlSession, Logger logger) {
		this.sqlSession = sqlSession;
		this.logger = logger;
	}

	@Override
	public void addReq(Req req) throws Exception {
		try {
			int result = sqlSession.insert("ReqMapper.addReq", req);
			if (result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("추가된 값이 없습니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("에러");
		} finally {
			sqlSession.commit();
		}
	}

	@Override
	public List<Req> selectReqList(Req req) throws Exception {
		List<Req> result = null;

		try {
			result = sqlSession.selectList("ReqMapper.selectReqList", req);
			if (result == null) {
				return result;
			}
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("에러");
		}

		return result;
	}

	@Override
	public Req selectReqRead(Req req) throws Exception {
		Req result = null;

		try {
			result = sqlSession.selectOne("ReqMapper.selectReqRead", req);
			if (result == null) {
				return result;
			}
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("에러");
		}

		return result;
	}

	@Override
	public int selectReqCount(Req req) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
}
