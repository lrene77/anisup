package anisup.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import anisup.model.Comment;
import anisup.service.CommentService;

public class CommentServiceImpl implements CommentService{
	Logger logger;
	SqlSession sqlSession;
	public CommentServiceImpl(SqlSession sqlSession, Logger logger) {
		this.sqlSession = sqlSession;
		this.logger = logger;
	}
	
	@Override
	public void addListComment(Comment comment) throws Exception {
		// TODO Auto-generated method stub
		try {
			int result = sqlSession.insert("CommentMapper.addListComment", comment);
			if(result == 0) {
				throw new NullPointerException();
			}
		}catch(NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("저장된 덧글이 없습니다.");
		}catch(Exception e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("덧글 등록에 실패했습니다.");
		}finally {
			sqlSession.commit();
		}
	}

	@Override
	public Comment selectListComment(Comment comment) throws Exception {
		// TODO Auto-generated method stub
		Comment result = null;
		
		try {
			result = sqlSession.selectOne("CommentMapper.selectListComment", comment);
			if(result == null) {
				throw new NullPointerException();
			}
		}catch(NullPointerException e) {
			throw new Exception("조회된 덧글이 없습니다.");
		}catch(Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("덧글 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public List<Comment> selectListCommentList(Comment comment) throws Exception {
		// TODO Auto-generated method stub
		List<Comment> result = null;
		
		try {
			result = sqlSession.selectList("CommentMapper.selectListCommentList", comment);
			if(result == null) {
				throw new NullPointerException();
			}
		}catch(NullPointerException e) {
			throw new Exception("조회된 덧글이 없습니다.");
		}catch(Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("덧글 목록 조회에 실패했습니다.");
		}
		
		return result;
	}

	@Override
	public int selectCommentCountByMemberId(Comment comment) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;
		
		try {
			result = sqlSession.selectOne("CommentMapper.selectCommentCountByMemberId", comment);
		}catch(Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("덧글 수 조회에 실패했습니다.");
		}
		
		return result;
	}

	@Override
	public void deleteComment(Comment comment) throws Exception {
		// TODO Auto-generated method stub
		try {
			int result = sqlSession.delete("CommentMapper.deleteComment", comment);
			if(result == 0) {
				throw new NullPointerException();
			}
		}catch(NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("존재하지 않는 덧글에 대한 요청입니다.");
		}catch(Exception e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("덧글 삭제에 실패했습니다.");
		}finally {
			sqlSession.commit();
		}
	}

	@Override
	public void updateComment(Comment comment) throws Exception {
		// TODO Auto-generated method stub
		try {
			int result = sqlSession.update("CommentMapper.updateComment", comment);
			if(result == 0) {
				throw new NullPointerException();
			}
		}catch(NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("존재하지 않는 덧글에 대한 요청입니다.");
		}catch(Exception e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("덧글 수정에 실패했습니다.");
		}finally {
			sqlSession.commit();
		}
	}

	@Override
	public void deleteListCommentAll(Comment comment) throws Exception {
		// TODO Auto-generated method stub
		try {
			sqlSession.delete("CommentMapper.deleteListCommentAll", comment);
		}catch(Exception e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("덧글 삭제에 실패했습니다.");
		}finally {
			sqlSession.commit();
		}
	}

}
