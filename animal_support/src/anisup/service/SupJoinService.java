package anisup.service;

import java.util.List;

import anisup.model.Listboard;
import anisup.model.SupJoin;
import anisup.model.SupMember;

public interface SupJoinService {
	/**
	 * 후원 관리자 다중행 조회
	 * @param supmember
	 * @return
	 * @throws Exception
	 */
	public List<SupMember> selectSupMemberList(SupMember supmember) throws Exception;
	
	/**
	 * 전체 게시물 수 조회
	 * @param sup
	 * @return
	 * @throws Exception
	 */
	public int selectSupMemberCount(SupMember supmember) throws Exception; 
	
	/**
	 * 후원 대기글 승인시 supstat 진행으로 업데이트한다
	 * @param supmember
	 * @throws Exception
	 */
	public void updateSup(SupMember supmember) throws Exception;
	
	// myPage 
	public List<SupJoin> mySelectSupList(SupJoin supjoin) throws NullPointerException, Exception;

	// 마이페이지 조인 리스트 후원내역 일반
	public List<SupJoin> myGiveJoinList(SupJoin supjoin) throws NullPointerException, Exception;
	
	// 마이페이지 보소호 후원내역 조인 sup,give
	public List<SupJoin> myJoinSheSupList(SupJoin supjoin) throws NullPointerException, Exception;
	
	public int selectSupCount(SupJoin supJoin) throws Exception; 
	
}
