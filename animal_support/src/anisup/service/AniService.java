package anisup.service;

import java.util.List;

import anisup.model.Ani;

public interface AniService {

	public void addAni(Ani ani) throws Exception;
	
	public List<Ani> selectAniList(Ani ani) throws Exception;
	
	public Ani selectAniRead(Ani ani) throws Exception;
	
	public int selectAniCount(Ani ani) throws Exception;
	
	public void editAniCount(Ani ani) throws Exception;
	
	public void editAniStat(Ani ani) throws Exception;
	
	public List<Ani> selectAniListJoinMember(Ani ani) throws Exception;
	
	public List<Ani> selectAniSearch(Ani ani) throws Exception;
}
