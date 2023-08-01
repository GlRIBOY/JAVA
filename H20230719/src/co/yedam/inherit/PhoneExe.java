package co.yedam.inherit;

public class PhoneExe {

	public static void main(String[] args) {
		CellPhone cellPhone = new CellPhone();
		cellPhone.setModel("Galaxy S10");
		cellPhone.setColor("White");
		cellPhone.powerOn();
		cellPhone.sendMessage();
		cellPhone.powerOff();
		cellPhone.receiveMessage();
		System.out.println(cellPhone.showInfo());
		
System.out.println("-----------------------------------------");	
	
		//자식클래스는 부모클래스의 필드, 메소드, 생성자를 물려받음
		DmbCellPhone dmbPhone = new DmbCellPhone();
		dmbPhone.setModel("Galaxy DMB");
		dmbPhone.setColor("Yellow");
		dmbPhone.powerOn();
		dmbPhone.sendMessage();
		dmbPhone.receiveMessage();
		dmbPhone.turnOn();
		dmbPhone.changeChannel(10);
		dmbPhone.turnOff();
		dmbPhone.powerOff();
		System.out.println(dmbPhone.showInfo());

System.out.println("-----------------------------------------");

		//부모클래스의 변수에 자식클래스의 변수를 대입
		CellPhone parent = new DmbCellPhone("DMB S22", "white", 10); //promotion(형변환(?)이 일어난다
		//parent.turnOn();//자식클래스의 필드, 메소드 사용불가
		System.out.println(parent.getModel());
		
		DmbCellPhone child = null;
		
		if(parent instanceof DmbCellPhone) {
		child = (DmbCellPhone) parent;//casting
		child.turnOn();
		}
		
		//부모클래스의 변수를 자식변수로 casting할 경우 체크를 해야함
		if(cellPhone instanceof DmbCellPhone) {
		child = (DmbCellPhone) cellPhone;
		child.turnOn();
		}

	}

}
