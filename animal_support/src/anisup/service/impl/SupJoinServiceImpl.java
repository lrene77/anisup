package anisup.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import anisup.model.SupJoin;
import anisup.model.SupMember;
import anisup.service.SupJoinService;

public class SupJoinServiceImpl implements SupJoinService {

	Logger logger;
	SqlSession sqlSession;
	
	public SupJoinServiceImpl(SqlSession sqlSession, Logger logger) {
		this.sqlSession = sqlSession;
		this.logger = logger;
	}
	
	@Override
	public List<SupMember> selectSupMemberList(SupMember supmember) throws Exception {
		List<SupMember> result = null;
		try {
			result = sqlSession.selectList("SupMemberMapper.selectAdminSupList", supmember);
			if(result == null)
				throw new NullPointerException();
		}catch(NullPointerException e) {
			throw new Exception("조회된 글 목록에 없습니다.");
		} catch(Exception e){
			logger.error(e.getLocalizedMessage());
			throw new Exception("글 목록 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public int selectSupMemberCount(SupMember supmember) throws Exception {
		int result = 0;
		try {
			// 게시물 수가 0건인 경우도 있으므로 
			// 결과값이 0인 경우에 대한 예외를 발생시키지않는다.
			result = sqlSession.selectOne("SupMemberMapper.selectSupMemberCount", null);
		}catch(Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("게시물 수 조회에 실패했습니다.");
		}
		
		return result;
	}

	@Override
	public void updateSup(SupMember supmember) throws Exception {
		try {
			int result = sqlSession.update("SupMemberMapper.updateSupMember", supmember);
			if(result == 0) {
				throw new NullPointerException();
			}
		}catch(NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("존재하지 않는 게시물에 대한 요청입니다.");
		}catch(Exception e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("조회수 갱신에 실패했습니다.");
		}finally {
			sqlSession.commit();
		}
		
	}
	
	@Override
	public List<SupJoin> mySelectSupList(SupJoin supJoin) throws NullPointerException, Exception {
		List<SupJoin> list = null;
		try {
			list = sqlSession.selectList("SupJoinMapper.mySelectSupList", supJoin);
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

	// 마이페이지 멤버 후원페이지 조인
	@Override
	public List<SupJoin> myGiveJoinList(SupJoin supJoin) throws NullPointerException, Exception {
		List<SupJoin> list = null;
		try {
			list = sqlSession.selectList("SupJoinMapper.myGiveJoinList", supJoin);
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

	
	// 마이페이지 보호소 후원내역 조인문
	@Override
	public List<SupJoin> myJoinSheSupList(SupJoin supJoin) throws NullPointerException, Exception {
		List<SupJoin> list = null;
		try {
			list = sqlSession.selectList("SupJoinMapper.myJoinSheSupList",supJoin);
			if(list == null)
				throw new NullPointerException();
			} catch(NullPointerException e) {
				throw new Exception("조회된 글이없스니다.");
			} catch(Exception e) {
				logger.error(e.getLocalizedMessage());
				throw new Exception("글 목록 조회에 실패했습니다.");
			}
		return list;
	}

	@Override
	public int selectSupCount(SupJoin supJoin) throws Exception {
		int result = 0;
		try {
			// 게시물 수가 0건인 경우도 있으므로 
			// 결과값이 0인 경우에 대한 예외를 발생시키지않는다.
			result = sqlSession.selectOne("SupJoinMapper.selectSupCount", null);
		}catch(Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("게시물 수 조회에 실패했습니다.");
		}
		
		return result;
	}

}
