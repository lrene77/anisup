package anisup.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import anisup.model.Sup;
import anisup.service.SupService;

public class SupServiceImpl implements SupService{

	Logger logger;
	SqlSession sqlSession;
	
	public SupServiceImpl(SqlSession sqlSession, Logger logger) {
		this.sqlSession = sqlSession;
		this.logger = logger;
	}
	
	@Override
	public void addSup(Sup sup) throws NullPointerException, Exception {
		try {
			int result = sqlSession.insert("SupMapper.addSup", sup);
			if(result == 0)
				throw new NullPointerException();
		}catch(NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("저장된 게시물이 없습니다.");
		}catch (Exception e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			System.out.println(e.getMessage());
			throw new Exception("게시물 정보 등록에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}		
	}

	@Override
	public List<Sup> selectSupList(Sup sup) throws Exception {
		List<Sup> result = null;
		try {
			result = sqlSession.selectList("SupMapper.selectSupList", sup);
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
	public int selectSupCount() throws Exception {
		int result = 0;
		try {
			// 게시물 수가 0건인 경우도 있으므로 
			// 결과값이 0인 경우에 대한 예외를 발생시키지않는다.
			result = sqlSession.selectOne("SupMapper.selectSupCount", null);
		}catch(Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("게시물 수 조회에 실패했습니다.");
		}
		
		return result;
	}

	@Override
	public Sup selectSupItem(Sup sup) throws Exception {
		Sup result = null;
		try {
			result = sqlSession.selectOne("SupMapper.selectSupItem", sup);
			if(result == null) {
				throw new NullPointerException();
			}
		}catch(NullPointerException e) {
			throw new Exception("조회된 글이 없습니다.");
		}catch(Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("글 조회에 실패했습니다.");
		}
		
		return result;
	}

	@Override
	public void updateSupBySupDays(Sup sup) throws Exception {
		try {
			int result = sqlSession.update("SupMapper.editSupBySupNow", sup);
			if(result == 0) {
				throw new NullPointerException();
			}
		}catch(NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("존재하지 않는 게시물에 대한 요청입니다.");
		}catch(Exception e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("업데이트에 실패했습니다.");
		}finally {
			sqlSession.commit();
		}
		
	}	

	@Override
	public void editSupBill(Sup sup) throws Exception {
		// TODO Auto-generated method stub
		try{
			sqlSession.update("SupMapper.editSupBill", sup);
		} catch(Exception e){
			sqlSession.rollback();
			throw new Exception("업데이트 실패");
		} finally {
			sqlSession.commit();
		}
	}

	@Override
	public void updateSupBySupStat(Sup sup) throws Exception {
		try {
			int result = sqlSession.update("SupMapper.editSupBySupStat", sup);
			if(result == 0) {
				throw new NullPointerException();
			}
		}catch(NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("존재하지 않는 게시물에 대한 요청입니다.");
		}catch(Exception e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("업데이트에 실패했습니다.");
		}finally {
			sqlSession.commit();
		}		
	}

}
