package anisup.model;

public class ReqJoin {

	private String reqtitle;
	private String name;
	private String tel;
	private String addr1;
	private String reqjob;
	private String reqcont;
	
	// 보호소 입양 신청서 목록 조인 위해 추가된 변수
	private int reqno;
	private String reqdate;
	
	
	public String getReqtitle() {
		return reqtitle;
	}
	public void setReqtitle(String reqtitle) {
		this.reqtitle = reqtitle;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getReqjob() {
		return reqjob;
	}
	public void setReqjob(String reqjob) {
		this.reqjob = reqjob;
	}
	public String getReqcont() {
		return reqcont;
	}
	public void setReqcont(String reqcont) {
		this.reqcont = reqcont;
	}
	public int getReqno() {
		return reqno;
	}
	public void setReqno(int reqno) {
		this.reqno = reqno;
	}
	public String getReqdate() {
		return reqdate;
	}
	public void setReqdate(String reqdate) {
		this.reqdate = reqdate;
	}
	
	@Override
	public String toString() {
		return "ReqJoin [reqtitle=" + reqtitle + ", name=" + name + ", tel=" + tel + ", addr1=" + addr1 + ", reqjob="
				+ reqjob + ", reqcont=" + reqcont + ", reqno=" + reqno + ", reqdate=" + reqdate + "]";
	}
}
