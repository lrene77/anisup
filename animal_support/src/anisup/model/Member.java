package anisup.model;

public class Member {
	private int mno;
	private String id;
	private String name;
	private String pw;
	private String email;
	private String birth;
	private String phone;
	private String tel;
	private String postcode;
	private String addr1;
	private String addr2;
	private String pwq;
	private String pwa;
	private String mtype;
	private String newUserPw;
	private String giveprice;

	public String getGiveprice() {
		return giveprice;
	}

	public void setGiveprice(String giveprice) {
		this.giveprice = giveprice;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
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

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getPwq() {
		return pwq;
	}

	public void setPwq(String pwq) {
		this.pwq = pwq;
	}

	public String getPwa() {
		return pwa;
	}

	public void setPwa(String pwa) {
		this.pwa = pwa;
	}

	public String getMtype() {
		return mtype;
	}

	public void setMtype(String mtype) {
		this.mtype = mtype;
	}

	public String getNewUserPw() {
		return newUserPw;
	}

	public void setNewUserPw(String newUserPw) {
		this.newUserPw = newUserPw;
	}

	@Override
	public String toString() {
		return "Member [mno=" + mno + ", id=" + id + ", name=" + name + ", pw=" + pw + ", email=" + email + ", birth="
				+ birth + ", phone=" + phone + ", tel=" + tel + ", postcode=" + postcode + ", addr1=" + addr1
				+ ", addr2=" + addr2 + ", pwq=" + pwq + ", pwa=" + pwa + ", mtype=" + mtype + ", newUserPw=" + newUserPw
				+ ", giveprice=" + giveprice + "]";
	}
	
	

}