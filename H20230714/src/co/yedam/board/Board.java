package co.yedam.board;

public class Board {
	
	private int brdNo;
	private String brdTitle;
	private String brdSub;
	private String brdWriter;
	
	
	public int getBrdNo() {
		return brdNo;
	}
	public void setBrdNo(int brdNo) {
		this.brdNo = brdNo;
	}
	public String getBrdTitle() {
		return brdTitle;
	}
	public void setBrdTitle(String brdTitle) {
		this.brdTitle = brdTitle;
	}
	public String getBrdSub() {
		return brdSub;
	}
	public void setBrdSub(String brdSub) {
		this.brdSub = brdSub;
	}
	public String getBrdWriter() {
		return brdWriter;
	}
	public void setBrdWriter(String brdWriter) {
		this.brdWriter = brdWriter;
	}
	public String showList() {
		return "[번호] " + " 제목 " + " <작성자>\n" + "[" + brdNo + "] " + brdTitle + " <" + brdWriter + ">";
	}
	public String showSub() {
		String subInfo = showList();
		subInfo += "\n" + brdSub;
		return subInfo;
	}



}
