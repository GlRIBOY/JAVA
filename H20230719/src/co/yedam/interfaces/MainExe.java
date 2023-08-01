package co.yedam.interfaces;

public class MainExe {

	public static void main(String[] args) {
		Audio audio = new Audio();
		
		Television tv = new Television();

		
		//인터페이스
		RemoteCon rc = tv;
		rc.turnOn();
		rc.turnOff();
		
		rc = audio;
		rc.turnOn();
		rc.turnOff();

	}

}
