package anisup.service;

import java.util.List;

import anisup.model.Listboard;

public interface ListboardService {
	/**
	 * 게시물을 저장
	 * @param listboard
	 * @throws Exception
	 */
	public void addListboard(Listboard listboard) throws Exception;
	
	/**
	 * 하나의게시물을 읽어들인다.
	 * @param listboard
	 * @return
	 * @throws Exception
	 */
	public Listboard selectListboardItem(Listboard listboard) throws Exception;
	
	/**
	 * 게시글 목록 조회
	 * @param listboard
	 * @return
	 * @throws Exception
	 */
	public List<Listboard> selectListboardList2(Listboard listboard) throws Exception;
	
	/**
	 * 조회수를 1증가시킨다.
	 * @param listboard
	 * @throws Exception
	 */
	public void updateListboardHit(Listboard listboard) throws Exception;
	
	/**
	 * 전체 게시물 수 조회
	 * @param listboard
	 * @return int
	 * @throws Exception
	 */
	public int selectListboardCount(Listboard listboard) throws Exception;
	
	/**
	 * 게시물을 수정한다.
	 * @param listboard
	 * @throws Exception
	 */
	public void updateListboard(Listboard listboard) throws Exception;
}
