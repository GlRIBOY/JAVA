package co.yedam.friend;

public class UnivFriend extends Friend {
	String univ;
	String major;
	
	public UnivFriend(String name, String phone, String univ, String major) {
		super(name, phone);
		this.univ = univ;
		this.major = major;
	}
	
	public String getUnive() {
		return univ;
	}

	public void setUnive(String univ) {
		this.univ = univ;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	public String showInfo() {
		return "이름: " + getName() + ", 연락처: " + getPhone() + ", 학교: " + univ + ", 전공: " + major;
	}
}
