package anisup.model;

public class Sup {
	private int supno;
	private String suptitle;
	private String supcont;
	private String supstart;
	private String supend;
	private int supprice;
	private int supnow;
	private String supstat;
	private int suping;
	private String supbill;
	private String supacname;
	private String supbank;
	private String supacc;
	private String wdate;
	private int mno;
	private long supDays;
	
	// 페이지 구현을 위해서 추가된 값
	private int limitStart;
	private int listCount;
	
	// 갤러리 구현을 위해서 추가된 값
	private String imagePath;

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

	public String getSupcont() {
		return supcont;
	}

	public void setSupcont(String supcont) {
		this.supcont = supcont;
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

	public int getSupprice() {
		return supprice;
	}

	public void setSupprice(int supprice) {
		this.supprice = supprice;
	}

	public int getSupnow() {
		return supnow;
	}

	public void setSupnow(int supnow) {
		this.supnow = supnow;
	}

	public String getSupstat() {
		return supstat;
	}

	public void setSupstat(String supstat) {
		this.supstat = supstat;
	}

	public int getSuping() {
		return suping;
	}

	public void setSuping(int suping) {
		this.suping = suping;
	}

	public String getSupbill() {
		return supbill;
	}

	public void setSupbill(String supbill) {
		this.supbill = supbill;
	}

	public String getSupacname() {
		return supacname;
	}

	public void setSupacname(String supacname) {
		this.supacname = supacname;
	}

	public String getSupbank() {
		return supbank;
	}

	public void setSupbank(String supbank) {
		this.supbank = supbank;
	}

	public String getSupacc() {
		return supacc;
	}

	public void setSupacc(String supacc) {
		this.supacc = supacc;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public long getSupDays() {
		return supDays;
	}

	public void setSupDays(long supDays) {
		this.supDays = supDays;
	}

	public int getLimitStart() {
		return limitStart;
	}

	public void setLimitStart(int limitStart) {
		this.limitStart = limitStart;
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "Sup [supno=" + supno + ", suptitle=" + suptitle + ", supcont=" + supcont + ", supstart=" + supstart
				+ ", supend=" + supend + ", supprice=" + supprice + ", supnow=" + supnow + ", supstat=" + supstat
				+ ", suping=" + suping + ", supbill=" + supbill + ", supacname=" + supacname + ", supbank=" + supbank
				+ ", supacc=" + supacc + ", wdate=" + wdate + ", mno=" + mno + ", supDays=" + supDays + ", limitStart="
				+ limitStart + ", listCount=" + listCount + ", imagePath=" + imagePath + "]";
	}
	
}