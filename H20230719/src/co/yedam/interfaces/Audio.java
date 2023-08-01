package co.yedam.interfaces;

//RemoteCon 인터페이스 구현 클래스
public class Audio implements/*인터페이스 구현*/ RemoteCon{
	double freq;
	
	public Audio() {
		
	}
	
	public void setFreq(double freq) {
		this.freq = freq;
	}

	@Override
	public void turnOn() {
		System.out.println("오디오 전원킨다");
	}

	@Override
	public void turnOff() {
		System.out.println("오디오 전원킨다");
	}
	
}
