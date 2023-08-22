package anisup.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import anisup.model.Give;
import anisup.model.Sup;
import anisup.service.SupGiveService;

public class SupGiveServiceImpl implements SupGiveService {

	Logger logger;
	SqlSession sqlSession;
	
	public SupGiveServiceImpl(SqlSession sqlSession, Logger logger) {
		this.sqlSession = sqlSession;
		this.logger = logger;
	}
	
	@Override
	public void addSupGive(Give give) throws NullPointerException, Exception {
		try {
			int result = sqlSession.insert("GiveMapper.addGive", give);
			if(result == 0)
				throw new NullPointerException();
		}catch(NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("저장된 게시물이 없습니다.");
		}catch (Exception e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			System.out.println(e.getMessage());
			throw new Exception("기부 정보 등록에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}		
	}

	@Override
	public Give selectGiveItem(Give give) throws NullPointerException, Exception {
		Give result = null;
		try {
			result = sqlSession.selectOne("GiveMapper.selectGiveItem", give);
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

}
