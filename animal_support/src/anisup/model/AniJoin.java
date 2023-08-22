package anisup.model;

public class AniJoin {
	private int anino;
	private String anititle;
	private String wdate;
	private int anicount;
	private String anistat;
	private int mno;
	
	// member name
	private String name;
	
	// 페이지 구현을 위해서 추가된 값
	private int limitStart;
	private int listCount;	

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

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
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

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "AniJoin [anino=" + anino + ", anititle=" + anititle + ", wdate=" + wdate + ", anicount=" + anicount
				+ ", anistat=" + anistat + ", mno=" + mno + ", name=" + name + ", limitStart=" + limitStart
				+ ", listCount=" + listCount + "]";
	}
	
}
