package anisup.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import anisup.model.Listboard;
import anisup.model.ListboardMember;
import anisup.service.ListboardJoinService;

public class ListboardJoinServiceImpl implements ListboardJoinService {
	Logger logger;
	SqlSession sqlSession;

	public ListboardJoinServiceImpl(SqlSession sqlSession, Logger logger) {
		this.sqlSession = sqlSession;
		this.logger = logger;
	}

	@Override
	public ListboardMember getListboardJoinItem(ListboardMember listboard) throws Exception {
		// TODO Auto-generated method stub
		ListboardMember result = null;

		try {
			result = sqlSession.selectOne("ListboardJoinMapper.selectListboardJoinItem", listboard);
			if (result == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("조회된 데이터가 없습니다.");
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("데이터 조회에 실패했습니다.");
		}

		return result;
	}

	@Override
	public List<ListboardMember> getListboardJoinList(ListboardMember listboard) throws Exception {
		// TODO Auto-generated method stub
		List<ListboardMember> result = null;

		try {
			result = sqlSession.selectList("ListboardJoinMapper.selectListboardJoinList", listboard);
			if (result == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("조회된 글 목록이 없습니다.");
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("글 목록 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public int selectListboardJoinCount(ListboardMember listboard) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;

		try {
			result = sqlSession.selectOne("ListboardJoinMapper.selectListboardJoinCount", listboard);
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("게시물 수 조회에 실패했습니다.");
		}

		return result;
	}

	@Override
	public int selectListboardJoinCount2(ListboardMember listboard) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;

		try {
			result = sqlSession.selectOne("ListboardJoinMapper.selectListboardJoinCount2", listboard);
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("게시물 수 조회에 실패했습니다.");
		}

		return result;
	}
	
	@Override
	public int selectListboardJoinCount3(ListboardMember listboard) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;

		try {
			result = sqlSession.selectOne("ListboardJoinMapper.selectListboardJoinCount3", listboard);
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("게시물 수 조회에 실패했습니다.");
		}

		return result;
	}

	@Override
	public int selectListboardJoinCount4(ListboardMember listboard) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;

		try {
			result = sqlSession.selectOne("ListboardJoinMapper.selectListboardJoinCount4", listboard);
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("게시물 수 조회에 실패했습니다.");
		}

		return result;
	}

	
	@Override
	public void updateListboardHit(ListboardMember listboard) throws Exception {
		// TODO Auto-generated method stub
		try {
			int result = sqlSession.update("ListboardJoinMapper.updateListboardHit", listboard);
			if (result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("존재하지 않는 게시물에 대한 요청입니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("조회수 갱신에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
	}

	@Override
	public int selectListboardCountByMno(ListboardMember listboard) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;

		try {
			result = sqlSession.selectOne("ListboardJoinMapper.selectListboardCountByMno", listboard);
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("게시물 수 조회에 실패했습니다.");
		}

		return result;
	}

	@Override
	public void deleteListboard(ListboardMember listboard) throws Exception {
		// TODO Auto-generated method stub
		try {
			int result = sqlSession.delete("ListboardJoinMapper.deleteListboard", listboard);
			if (result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("존재하지 않는 게시물에 대한 요청입니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("게시물 삭제에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
	}

	@Override
	public List<ListboardMember> selectListboardJoinList2(ListboardMember listboard) throws Exception {
		// TODO Auto-generated method stub
		List<ListboardMember> result = null;

		try {
			result = sqlSession.selectList("ListboardJoinMapper.selectListboardJoinList2", listboard);
			if (result == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("조회된 글 목록이 없습니다.");
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("글 목록 조회에 실패했습니다.");
		}

		return result;
	}

	@Override
	public List<ListboardMember> selectListboardJoinList3(ListboardMember listboard) throws Exception {
		// TODO Auto-generated method stub
		List<ListboardMember> result = null;

		try {
			result = sqlSession.selectList("ListboardJoinMapper.selectListboardJoinList3", listboard);
			if (result == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("조회된 글 목록이 없습니다.");
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("글 목록 조회에 실패했습니다.");
		}

		return result;
	}

	@Override
	public List<ListboardMember> selectListboardJoinList4(ListboardMember listboard) throws Exception {
		// TODO Auto-generated method stub
		List<ListboardMember> result = null;

		try {
			result = sqlSession.selectList("ListboardJoinMapper.selectListboardJoinList4", listboard);
			if (result == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("조회된 글 목록이 없습니다.");
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("글 목록 조회에 실패했습니다.");
		}

		return result;
	}
}
