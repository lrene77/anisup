package anisup.service;


import java.util.List;

import anisup.model.ReqJoin;

public interface ReqJoinService {
	
	public ReqJoin myJoinReq(ReqJoin reqJoin) throws Exception;

	// 보호소 마이페이지 입양신청서 내용 목록
	public List<ReqJoin> sheMyReqList(ReqJoin reqJoin) throws Exception;
	
	
	public ReqJoin selectReqRead(ReqJoin reqJoin) throws Exception;
}
