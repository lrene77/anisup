package anisup.model;

public class Comment {
	private int id;
	private String writerName;
	private String content;
	private String regDate;
	private String editDate;
	private String ipAddress;
	private int supno;
	private int listno;
	private int anino;
	private int mno;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getwriterName() {
		return writerName;
	}
	public void setwriterName(String writerName) {
		this.writerName = writerName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getEditDate() {
		return editDate;
	}
	public void setEditDate(String editDate) {
		this.editDate = editDate;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public int getSupno() {
		return supno;
	}
	public void setSupno(int supno) {
		this.supno = supno;
	}
	public int getListno() {
		return listno;
	}
	public void setListno(int listno) {
		this.listno = listno;
	}
	public int getAnino() {
		return anino;
	}
	public void setAnino(int anino) {
		this.anino = anino;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", writerName=" + writerName + ", content=" + content + ", regDate=" + regDate
				+ ", editDate=" + editDate + ", ipAddress=" + ipAddress + ", supno=" + supno + ", listno=" + listno
				+ ", anino=" + anino + ", mno=" + mno + "]";
	}
	
}
