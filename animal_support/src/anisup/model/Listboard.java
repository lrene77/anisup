package anisup.model;

public class Listboard {
	private int listno;
	private String listcate;
	private String listtitle;
	private String listcont;
	private String wdate;
	private String file;
	private int hit;
	private int mno;
	private String ipAddress;
	
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public int getListno() {
		return listno;
	}
	public void setListno(int listno) {
		this.listno = listno;
	}
	public String getListcate() {
		return listcate;
	}
	public void setListcate(String listcate) {
		this.listcate = listcate;
	}
	public String getListtitle() {
		return listtitle;
	}
	public void setListtitle(String listtitle) {
		this.listtitle = listtitle;
	}
	public String getListcont() {
		return listcont;
	}
	public void setListcont(String listcont) {
		this.listcont = listcont;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int listcount) {
		this.hit = listcount;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	@Override
	public String toString() {
		return "Listboard [listno=" + listno + ", listcate=" + listcate + ", listtitle=" + listtitle + ", listcont="
				+ listcont + ", wdate=" + wdate + ", file=" + file + ", hit=" + hit + ", mno=" + mno + ", ipAddress="
				+ ipAddress + "]";
	}
	
}