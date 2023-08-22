package anisup.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import anisup.model.Ani;
import anisup.model.AniJoin;
import anisup.service.AniJoinService;

public class AniJoinServiceImpl implements AniJoinService{
	
	Logger logger;
	SqlSession sqlSession;

	public AniJoinServiceImpl(SqlSession sqlSession, Logger logger) {
		this.sqlSession = sqlSession;
		this.logger = logger;
	}

	// 마이페이지 리스트
	@Override
	public List<AniJoin> mySelectAniList(AniJoin aniJoin) throws Exception {
		List<AniJoin> result = null;

		try {
			result = sqlSession.selectList("AniJoinMapper.mySelectAniList", aniJoin);
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
	// 마이페이지 조인 보호소 입양신청내역 목록
	@Override
	public List<AniJoin> mySheSupJoinList(AniJoin aniJoin) throws Exception {
		List<AniJoin> result = null;
		
		try {
			result = sqlSession.selectList("AniJoinMapper.mySheSupJoinList",aniJoin);
			if(result == null) {
				throw new NullPointerException();
			}
		} catch(NullPointerException e) {
			throw new Exception("조회된 글 목록에 없습니다.");
		} catch(Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("글 목록 조회에 실패했습니다.");
		}
		
		return result;
	}

	// 페이지 번호
	@Override
	public int selectAniCount(AniJoin aniJoin) throws Exception {
		int result = 0;

		try {
			result = sqlSession.selectOne("AniJoinMapper.selectAniCount");
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("게시물 수 조회에 실패했습니다.");
		}

		return result;
	}

	@Override
	public List<AniJoin> selectAniList(AniJoin aniJoin) throws Exception {
		List<AniJoin> result = null;

		try {
			result = sqlSession.selectList("AniJoinMapper.selectAniList", aniJoin);
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
