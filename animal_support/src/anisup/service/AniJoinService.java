package anisup.service;

import java.util.List;

import anisup.model.AniJoin;

public interface AniJoinService {
	
	// 마이페이지 리스트
	public List<AniJoin> mySelectAniList(AniJoin aniJoin) throws Exception;
	
	// 마이페이지 입양내역 조인 ani,member
	public List<AniJoin> mySheSupJoinList(AniJoin aniJoin) throws Exception;
	
	// 마이페이지 페이지 
	public int selectAniCount(AniJoin aniJoin) throws Exception;
	
	// 마이페이지 리스트 페이지번호
	public List<AniJoin> selectAniList(AniJoin aniJoin) throws Exception;

}
