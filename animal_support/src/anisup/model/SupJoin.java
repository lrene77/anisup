package anisup.model;

public class SupJoin {
	private int mno;
	private int supno;
	private String suptitle;
	private String supstart;
	private String supend;
	private int supnow;
	private int suping;
	private int supprice;
	private String supstat;
	
	// give 조인시 필요한 변수 sup + give
	private String giveprice;
	private String givedate;
	private int giveno;
	private String giveid;
	
	
	public String getSupstat() {
		return supstat;
	}
	public void setSupstat(String supstat) {
		this.supstat = supstat;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public int getSupno() {
		return supno;
	}
	public void setSupno(int supno) {
		this.supno = supno;
	}
	public String getSuptitle() {
		return suptitle;
	}
	public void setSuptitle(String suptitle) {
		this.suptitle = suptitle;
	}
	public String getSupstart() {
		return supstart;
	}
	public void setSupstart(String supstart) {
		this.supstart = supstart;
	}
	public String getSupend() {
		return supend;
	}
	public void setSupend(String supend) {
		this.supend = supend;
	}
	public int getSupnow() {
		return supnow;
	}
	public void setSupnow(int supnow) {
		this.supnow = supnow;
	}
	public int getSuping() {
		return suping;
	}
	public void setSuping(int suping) {
		this.suping = suping;
	}
	public int getSupprice() {
		return supprice;
	}
	public void setSupprice(int supprice) {
		this.supprice = supprice;
	}
	public String getGiveprice() {
		return giveprice;
	}
	public void setGiveprice(String giveprice) {
		this.giveprice = giveprice;
	}
	public String getGivedate() {
		return givedate;
	}
	public void setGivedate(String givedate) {
		this.givedate = givedate;
	}
	public int getGiveno() {
		return giveno;
	}
	public void setGiveno(int giveno) {
		this.giveno = giveno;
	}
	public String getGiveid() {
		return giveid;
	}
	public void setGiveid(String giveid) {
		this.giveid = giveid;
	}
	@Override
	public String toString() {
		return "SupJoin [mno=" + mno + ", supno=" + supno + ", suptitle=" + suptitle + ", supstart=" + supstart
				+ ", supend=" + supend + ", supnow=" + supnow + ", suping=" + suping + ", supprice=" + supprice
				+ ", supstat=" + supstat + ", giveprice=" + giveprice + ", givedate=" + givedate + ", giveno=" + giveno
				+ ", giveid=" + giveid + "]";
	}
	

	
}
