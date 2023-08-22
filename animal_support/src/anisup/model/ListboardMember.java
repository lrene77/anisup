package anisup.model;

public class ListboardMember extends Listboard {
	private String id;
	// 페이지 구현을 위해서 추가된 값
	private int limitStart;
	private int listCount;
	// 관리자 검색을 위한 변수
	private String wdate1;
	private String wdate2;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getWdate2() {
		return wdate2;
	}

	public void setWdate2(String wdate2) {
		this.wdate2 = wdate2;
	}

	public String getWdate1() {
		return wdate1;
	}

	public void setWdate1(String wdate1) {
		this.wdate1 = wdate1;
	}

	@Override
	public String toString() {
		return "ListboardMember [id=" + id + ", limitStart=" + limitStart + ", listCount=" + listCount + ", wdate1="
				+ wdate1 + ", wdate2=" + wdate2 + ", getIpAddress()=" + getIpAddress() + ", getListno()=" + getListno()
				+ ", getListcate()=" + getListcate() + ", getListtitle()=" + getListtitle() + ", getListcont()="
				+ getListcont() + ", getWdate()=" + getWdate() + ", getFile()=" + getFile() + ", getHit()=" + getHit()
				+ ", getMno()=" + getMno() + "]";
	}

}
