package co.yedam.friend;

public class CompFriend extends Friend{
	String company;
	String dept;
	
	public CompFriend(String name, String phone, String company, String dept) {
		super(name, phone);
		this.company = company;
		this.dept = dept;
	}
	
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDeptr() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	public String showInfo() {
		return "이름: " + getName() + ", 연락처: " + getPhone() + ", 회사: " + company + ", 부서: " + dept;
	}
}
