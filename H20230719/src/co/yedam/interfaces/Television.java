package co.yedam.interfaces;

//RemoteCon 인터페이스 구현 클래스
public class Television implements RemoteCon{

	int channel;
	
	public Television() {
		
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}
	@Override
	public void turnOn() {
		System.out.println("티비 전원킨다");
	}

	@Override
	public void turnOff() {
		System.out.println("티비 전원킨다");
	}

}
