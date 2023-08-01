package co.yedam.inherit;

public /* final 상속불가 */class CellPhone {
	//필드(속성)
	private String model;
	private String color;
	
	//컴파일러가 기본생성자를 자동으로 만들어줌
	public CellPhone(String model, String color) {
		this.model = model;
		this.color = color;
	}//기본생성자를 생성하면 자동으로 안만들어짐
	
	public CellPhone() {
		
	}
	
	//메소드(기능)
	public /* final 재정의 불가 */ String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void powerOn() {
		System.out.println("전원켜기");
	}
	public void powerOff() {
		System.out.println("전원끄기");
	}
	public void sendMessage() {
		System.out.println("메세지 전송");
	}
	public void receiveMessage() {
		System.out.println("메세지 수신");
	}
	public String showInfo() {
		return "모델명: " + model + ", 색상: " + color;
	}
	
}
