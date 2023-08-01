package co.yedam.abstracts;

public class SmartPhone extends Phone{
	
	//Phone에는 기본생성자가 없어 이렇게 생성자를 만들어야함
	public SmartPhone(String owner) {
		super(owner);
	}
	@Override
	public void powerOn() {
		System.out.println("스마트폰을 켭니다");
	}
	
	@Override
	public void powerOff() {
		System.out.println("스마트폰을 끕니다");
	}
	
	public void internetSearch() {
		System.out.println("검색기능");
	}
}
