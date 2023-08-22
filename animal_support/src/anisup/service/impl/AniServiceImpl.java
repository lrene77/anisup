package anisup.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import anisup.model.Ani;
import anisup.service.AniService;

public class AniServiceImpl implements AniService {

	Logger logger;
	SqlSession sqlSession;

	public AniServiceImpl(SqlSession sqlSession, Logger logger) {
		this.sqlSession = sqlSession;
		this.logger = logger;
	}

	@Override
	public void addAni(Ani ani) throws NullPointerException, Exception {
		try {
			int result = sqlSession.insert("AniMapper.addAni", ani);
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
	public List<Ani> selectAniList(Ani ani) throws Exception {
		List<Ani> result = null;

		try {
			result = sqlSession.selectList("AniMapper.selectAniList", ani);
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

	@Override
	public int selectAniCount(Ani ani) throws Exception {
		int result = 0;

		try {
			result = sqlSession.selectOne("AniMapper.selectAniCount");
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("게시물 수 조회에 실패했습니다.");
		}

		return result;
	}

	@Override
	public Ani selectAniRead(Ani ani) throws Exception {
		Ani result = null;

		try {
			result = sqlSession.selectOne("AniMapper.selectAniRead", ani);
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

	@Override
	public void editAniCount(Ani ani) throws Exception {
		try {
			int result = sqlSession.update("AniMapper.editAniCount", ani);
			if (result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("수정된 값이 없습니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("에러");
		} finally {
			sqlSession.commit();
		}
	}
	
	@Override
	public void editAniStat(Ani ani) throws Exception {
		try {
			int result = sqlSession.update("AniMapper.editAniStat", ani);
			if (result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("수정된 값이 없습니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("에러");
		} finally {
			sqlSession.commit();
		}
	}

	@Override
	public List<Ani> selectAniListJoinMember(Ani ani) throws Exception {
		List<Ani> result = null;

		try {
			result = sqlSession.selectList("AniMapper.selectAniListJoinMember", ani);
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

	@Override
	public List<Ani> selectAniSearch(Ani ani) throws Exception {
		List<Ani> result = null;

		try {
			result = sqlSession.selectList("AniMapper.selectAniSearch", ani);
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
