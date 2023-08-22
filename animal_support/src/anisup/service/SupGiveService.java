package anisup.service;

import anisup.model.Give;

public interface SupGiveService {
	
	/**
	 * 기부자 정보 삽입
	 * @param give
	 * @throws NullPointerException
	 * @throws Exception
	 */
	public void addSupGive(Give give) throws NullPointerException, Exception; 
	
	/**
	 * 기부정보 단일행 조회
	 * @param give
	 * @return
	 * @throws NullPointerException
	 * @throws Exception
	 */
	public Give selectGiveItem(Give give) throws NullPointerException, Exception;
}
