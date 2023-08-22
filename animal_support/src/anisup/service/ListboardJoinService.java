package anisup.service;

import java.util.List;

import anisup.model.Listboard;
import anisup.model.ListboardMember;

public interface ListboardJoinService {
	public ListboardMember getListboardJoinItem(ListboardMember listboard) throws Exception;
	
	public List<ListboardMember> getListboardJoinList(ListboardMember listboard) throws Exception;
	
	public List<ListboardMember> selectListboardJoinList2(ListboardMember listboard) throws Exception;
	
	public List<ListboardMember> selectListboardJoinList3(ListboardMember listboard) throws Exception;
	
	public List<ListboardMember> selectListboardJoinList4(ListboardMember listboard) throws Exception;

	
	/**
	 * 전체 게시물 수 조회
	 * @param listboard
	 * @return int
	 * @throws Exception
	 */
	public int selectListboardJoinCount(ListboardMember listboard) throws Exception;
	
	public int selectListboardJoinCount2(ListboardMember listboard) throws Exception;
	
	public int selectListboardJoinCount3(ListboardMember listboard) throws Exception;
	
	public int selectListboardJoinCount4(ListboardMember listboard) throws Exception;
	
	/**
	 * 조회수를 1 증가시킨다.
	 * @param listboard
	 * @throws Exception
	 */
	public void updateListboardHit(ListboardMember listboard) throws Exception;
	
	/**
	 * 자신의 게시물인지 검사한다.
	 * @param listboard
	 * @return
	 * @throws Exception
	 */
	public int selectListboardCountByMno(ListboardMember listboard) throws Exception;
	
	/**
	 * 게시물을 삭제
	 * @param listboard
	 * @throws Exception
	 */
	public void deleteListboard(ListboardMember listboard) throws Exception;
}
