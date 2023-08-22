package anisup.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import anisup.model.Listboard;
import anisup.service.ListboardService;

public class ListboardServiceImpl implements ListboardService{
	Logger logger;
	SqlSession sqlSession;
	public ListboardServiceImpl(SqlSession sqlSession, Logger logger) {
		this.sqlSession = sqlSession;
		this.logger = logger;
	} 
	@Override
	public void addListboard(Listboard listboard) throws Exception {
		// TODO Auto-generated method stub
		try {
			int result = sqlSession.insert("ListboardMapper.addListboard", listboard);
			if(result == 0) {
				throw new NullPointerException();
			}
		}catch(NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("저장된 게시물이 없습니다.");
		}catch(Exception e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("게시물 정보 등록에 실패했습니다.");
		}finally {
			sqlSession.commit();
		}
	}

	@Override
	public Listboard selectListboardItem(Listboard listboard) throws Exception {
		// TODO Auto-generated method stub
		Listboard result = null;
		
		try {
			result = sqlSession.selectOne("ListboardMapper.selectListboardItem", listboard);
			if(result == null) {
				throw new NullPointerException();
			}
		}catch(NullPointerException e) {
			throw new Exception("조회된 게시물이 없습니다.");
		}catch(Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("게시물 조회에 실패했습니다.");
		}
		
		return result;
	}

	@Override
	public void updateListboardHit(Listboard listboard) throws Exception {
		// TODO Auto-generated method stub
		try {
			int result = sqlSession.update("ListboardMapper.updateListboardHit", listboard);
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
	public List<Listboard> selectListboardList2(Listboard listboard) throws Exception {
		// TODO Auto-generated method stub
		List<Listboard> result = null;
		
		try {
			result = sqlSession.selectList("ListboardMapper.selectListboardList2", listboard);
			if(result == null) {
				throw new NullPointerException();
			}
		}catch(NullPointerException e) {
			throw new Exception("조회된 글 목록이 없습니다.");
		}catch(Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("글 목록 조회에 실패했습니다.");
		}
		
		return result;
	}

	@Override
	public int selectListboardCount(Listboard listboard) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;
		
		try {
			result = sqlSession.selectOne("ListboardMapper.selectListboardCount", listboard);
		}catch(Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("게시물 수 조회에 실패했습니다.");
		}
		
		return result;
	}

	@Override
	public void updateListboard(Listboard listboard) throws Exception {
		// TODO Auto-generated method stub
		try {
			int result = sqlSession.update("ListboardMapper.updateListboard", listboard);
			if(result == 0) {
				throw new NullPointerException();
			}
		}catch(NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("존재하지 않는 게시물에 대한 요청입니다.");
		}catch(Exception e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("게시물 수정에 실패했습니다.");
		}finally {
			sqlSession.commit();
		}
	}

}
