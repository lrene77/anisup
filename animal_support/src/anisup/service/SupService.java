package anisup.service;

import java.util.List;

import anisup.model.Sup;

public interface SupService {
	
	/**
	 * 후원글 삽입
	 * @param sup
	 * @throws NullPointerException
	 * @throws Exception
	 */
	public void addSup(Sup sup) throws NullPointerException, Exception;
	
	/**
	 * 전체 게시물 조회
	 * @return
	 * @throws Exception
	 */
	public List<Sup> selectSupList(Sup sup) throws Exception;
	
	/**
	 * 전체 게시물 수 조회
	 * @param sup
	 * @return
	 * @throws Exception
	 */
	public int selectSupCount() throws Exception; 
	
	/**
	 * 후원글 단일행 조회
	 * @return
	 * @throws Exception
	 */
	public Sup selectSupItem(Sup sup) throws Exception;
	
	/**
	 * 후원 금액 업데이트
	 * @param sup
	 * @throws Exception
	 */
	public void updateSupBySupDays(Sup sup) throws Exception;
	
	/**
	 * 후원내역 업데이트
	 * @param sup
	 * @throws Exception
	 */
	public void editSupBill(Sup sup) throws Exception;
	
	/**
	 * 후원글 상태 거절로 업데이트
	 * @param sup
	 * @throws Exception
	 */
	public void updateSupBySupStat(Sup sup) throws Exception;
}
