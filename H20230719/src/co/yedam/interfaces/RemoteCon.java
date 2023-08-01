package co.yedam.interfaces;


//인터페이스
//생성자(X), 필드(O): 상수만 사용, 메소드: 추상메소드로 선언
public interface RemoteCon {
	final/*자동으로 붙음 생략가능*/ int CHANNEL = 10;
	
	abstract/*자동으로 붙음 생략가능*/ void turnOn();
	void turnOff();
}
