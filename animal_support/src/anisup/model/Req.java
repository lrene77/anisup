package anisup.model;

public class Req {
	private int mno;
	private int reqno;
	private String reqtitle;
	private String reqjob;
	private String reqcont;
	private String reqid;
	private String isreq;
	private String reqdate;
	private String confirmdate;
	private int anino;

	// Join
	private String id;
	private String name;
	private String email;
	private String phone;

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public int getReqno() {
		return reqno;
	}

	public void setReqno(int reqno) {
		this.reqno = reqno;
	}

	public String getReqtitle() {
		return reqtitle;
	}

	public void setReqtitle(String reqtitle) {
		this.reqtitle = reqtitle;
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

	public String getReqid() {
		return reqid;
	}

	public void setReqid(String reqid) {
		this.reqid = reqid;
	}

	public String getIsreq() {
		return isreq;
	}

	public void setIsreq(String isreq) {
		this.isreq = isreq;
	}

	public String getReqdate() {
		return reqdate;
	}

	public void setReqdate(String reqdate) {
		this.reqdate = reqdate;
	}

	public String getConfirmdate() {
		return confirmdate;
	}

	public void setConfirmdate(String confirmdate) {
		this.confirmdate = confirmdate;
	}

	public int getAnino() {
		return anino;
	}

	public void setAnino(int anino) {
		this.anino = anino;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Req [mno=" + mno + ", reqno=" + reqno + ", reqtitle=" + reqtitle + ", reqjob=" + reqjob + ", reqcont="
				+ reqcont + ", reqid=" + reqid + ", isreq=" + isreq + ", reqdate=" + reqdate + ", confirmdate="
				+ confirmdate + ", anino=" + anino + ", id=" + id + ", name=" + name + ", email=" + email + ", phone="
				+ phone + "]";
	}
}