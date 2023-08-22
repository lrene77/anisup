package anisup.model;

public class Give {
	private int giveno;
	private int giveprice;
	private String giveselect;
	private String giveacname;
	private String givebank;
	private String giveacc;
	private String givedate;
	private String giveid;
	private int supno;
	
	public int getGiveno() {
		return giveno;
	}
	public void setGiveno(int giveno) {
		this.giveno = giveno;
	}
	public int getGiveprice() {
		return giveprice;
	}
	public void setGiveprice(int giveprice) {
		this.giveprice = giveprice;
	}
	public String getGiveselect() {
		return giveselect;
	}
	public void setGiveselect(String giveselect) {
		this.giveselect = giveselect;
	}
	public String getGiveacname() {
		return giveacname;
	}
	public void setGiveacname(String giveacname) {
		this.giveacname = giveacname;
	}
	public String getGivebank() {
		return givebank;
	}
	public void setGivebank(String givebank) {
		this.givebank = givebank;
	}
	public String getGiveacc() {
		return giveacc;
	}
	public void setGiveacc(String giveacc) {
		this.giveacc = giveacc;
	}
	public String getGivedate() {
		return givedate;
	}
	public void setGivedate(String givedate) {
		this.givedate = givedate;
	}
	public String getGiveid() {
		return giveid;
	}
	public void setGiveid(String giveid) {
		this.giveid = giveid;
	}
	public int getSupno() {
		return supno;
	}
	public void setSupno(int supno) {
		this.supno = supno;
	}
	
	@Override
	public String toString() {
		return "Give [giveno=" + giveno + ", giveprice=" + giveprice + ", giveselect=" + giveselect + ", giveacname="
				+ giveacname + ", givebank=" + givebank + ", giveacc=" + giveacc + ", givedate=" + givedate
				+ ", giveid=" + giveid + ", supno=" + supno + "]";
	}
	
	
}