package co.yedam.inherit;

public class DmbCellPhone extends CellPhone{
	//추가속성
	private int channel;
	
	//컴파일러가 기본생성자를 자동으로 만들어줌
	
	public DmbCellPhone() {//생성자 - 부모기본생성자를 불러옴
		super();
	}
	public DmbCellPhone(String model, String color, int channel) {
		super(model, color);
		this.channel = channel;
	}
	
	//추가메소드
	
	public void setChannel(int channel) {
		this.channel = channel;
	}
	
	public int getChannel() {
		return channel;
	}
	
	public void turnOn() {
		System.out.println("화면on");
	}
	public void turnOff() {
		System.out.println("화면off");
	}
	public void changeChannel(int channel) {
		this.channel = channel;
	}
	
	//부모클래스의 메소드 재정의
	@Override
	public void powerOn() {
		System.out.println("DMB 폰의 전원을 켭니다.");
	}
	@Override
	public void powerOff() {
		System.out.println("DMB 폰의 전원을 끕니다.");
	}
	@Override
	public String showInfo() {
		return "모델: " + getModel() + ", 색상: " + getColor() + ", 채널:" + channel;
	}
}
