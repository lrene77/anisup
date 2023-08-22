package anisup.service;

import java.util.List;

import anisup.model.Req;

public interface ReqService {

	public void addReq(Req req) throws Exception;

	public List<Req> selectReqList(Req req) throws Exception;

	public Req selectReqRead(Req req) throws Exception;

	public int selectReqCount(Req req) throws Exception;
}
