package anisup.model;

public class Ani {
	private int anino;
	private String anititle;
	private String file;
	private String aniname;
	private String anigender;
	private int aniage;
	private String anicont;
	private int anicount;
	private String anistat;
	private String wdate;
	private String wdate2;
	private int mno;
	
	// 페이지 구현을 위해서 추가된 값
	private int limitStart;
	private int listCount;
	
	// Join
	private String id;
	private String name;
	private String phone;
	
	public int getAnino() {
		return anino;
	}
	public void setAnino(int anino) {
		this.anino = anino;
	}
	public String getAnititle() {
		return anititle;
	}
	public void setAnititle(String anititle) {
		this.anititle = anititle;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getAniname() {
		return aniname;
	}
	public void setAniname(String aniname) {
		this.aniname = aniname;
	}
	public String getAnigender() {
		return anigender;
	}
	public void setAnigender(String anigender) {
		this.anigender = anigender;
	}
	public int getAniage() {
		return aniage;
	}
	public void setAniage(int aniage) {
		this.aniage = aniage;
	}
	public String getAnicont() {
		return anicont;
	}
	public void setAnicont(String anicont) {
		this.anicont = anicont;
	}
	public int getAnicount() {
		return anicount;
	}
	public void setAnicount(int anicount) {
		this.anicount = anicount;
	}
	public String getAnistat() {
		return anistat;
	}
	public void setAnistat(String anistat) {
		this.anistat = anistat;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	public String getWdate2() {
		return wdate2;
	}
	public void setWdate2(String wdate2) {
		this.wdate2 = wdate2;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Ani [anino=" + anino + ", anititle=" + anititle + ", file=" + file + ", aniname=" + aniname
				+ ", anigender=" + anigender + ", aniage=" + aniage + ", anicont=" + anicont + ", anicount=" + anicount
				+ ", anistat=" + anistat + ", wdate=" + wdate + ", wdate2=" + wdate2 + ", mno=" + mno + ", limitStart="
				+ limitStart + ", listCount=" + listCount + ", id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}
	
}
