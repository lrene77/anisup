package anisup.service;

import java.util.List;

import anisup.model.Comment;

public interface CommentService {
	/**
	 * 덧글을 저장한다.
	 * @param comment
	 * @throws Exception
	 */
	public void addListComment(Comment comment) throws Exception;
	
	/**
	 * 하나의 덧글을 읽어들인다.
	 * @param comment
	 * @return
	 * @throws Exception
	 */
	public Comment selectListComment(Comment comment) throws Exception;
	
	/**
	 * 하나의 게시물에 속한 모든 덧글 목록을 조회
	 * @param comment
	 * @return
	 * @throws Exception
	 */
	public List<Comment> selectListCommentList(Comment comment) throws Exception;
	
	/**
	 * 자신의 덧글인지 검사
	 * @param comment
	 * @return
	 * @throws Exception
	 */
	public int selectCommentCountByMemberId(Comment comment) throws Exception;
	
	/**
	 * 덧글을 삭제
	 * @param comment
	 * @throws Exception
	 */
	public void deleteComment(Comment comment) throws Exception;
	
	/**
	 * 덧글을 수정
	 * @param comment
	 * @throws Exception
	 */
	public void updateComment(Comment comment) throws Exception;
	
	/**
	 * listboard 특정 게시뭉에 속한 모든 덧글을 삭제
	 * @param comment
	 * @throws Exception
	 */
	public void deleteListCommentAll(Comment comment) throws Exception;
}
